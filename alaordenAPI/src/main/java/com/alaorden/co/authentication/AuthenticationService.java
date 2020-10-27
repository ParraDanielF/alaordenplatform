package com.alaorden.co.authentication;

import java.security.NoSuchAlgorithmException;
import java.util.Random;
import java.util.UUID;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.alaorden.co.authentication.model.Account;
import com.alaorden.co.authentication.model.RecoveryData;
import com.alaorden.co.util.PasswordHandler;
import com.alaorden.co.util.ServiceResponse;

@Service
public class AuthenticationService {
	
	@Autowired
	private AuthenticationRepository authRepository;
	
	@Autowired
	private ServiceResponse serviceResponse;
	
	@Autowired
	private PasswordHandler password;
	
	@Autowired
	private RecoveryData recovery;
	
	public ServiceResponse login(String email, String passWord) {
		try {
			/* validate user credentials */
			/* encrypt pass*/
			String hashedPassrod = password.generateHash(passWord);
			Boolean response = authRepository.validateUserCredentials(email, hashedPassrod);
			
			if(response == true) {
			/*build the session object (jwt)*/
			
			/*return the session object*/
			}else {
				serviceResponse.setCode(400);
				serviceResponse.setMessage("The provided credentials aren't correct");
				return serviceResponse;
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		return null;
	}
	
	public ServiceResponse logout(String sessionId) {
		try {
			/* search and delete the session register from the persistence layer*/
			authRepository.removeSession(sessionId);
			/* build and return the response*/
			serviceResponse.setCode(200);
			serviceResponse.setMessage("Session closed");
			return serviceResponse;
		}catch(Exception e) {
			e.printStackTrace();
		}
		return null;
	}
	
	public ServiceResponse generateRecoveryToken(String accountId) {
		try {
			/* generate token */
			String token = recoveryTokenBuilder(20);
			recovery.setRecoveryToken(token);
			recovery.setExpiredAt(getMilliseconds());
			recovery.setAccountId(accountId);
			/* save a new recovery data register in the persistence layer */
			authRepository.saveRecoveryData(recovery);
			/*return the token*/
			serviceResponse.setCode(200);
			serviceResponse.setMessage("token generated");
			serviceResponse.setPayload(recovery);
			return serviceResponse;
		}catch(Exception e) {
			e.printStackTrace();
		}
		return null;
	}
	
	public ServiceResponse validateRecoveryToken(String tokenId) {
		try {
			/* Search the token in the persistence layer*/
			recovery = authRepository.readRecoveryData(tokenId);
				if(recovery.getAccountId() != null) {
				Long limitDate = Long.parseLong(recovery.getExpiredAt());
				/*validate if the token is valid*/
				Long currentDate = System.currentTimeMillis();
				if(currentDate < limitDate) {
					/* Delete the recovery data in the persistence layer*/
					authRepository.removeRecoveryData(tokenId);
					/* return the response*/
					serviceResponse.setCode(200);
					serviceResponse.setMessage("The token is valid");
					
					return serviceResponse;
				}else {
					serviceResponse.setCode(400);
					serviceResponse.setMessage("The token aren't valid");
					
					return serviceResponse;
				}
			}else {
				serviceResponse.setCode(400);
				serviceResponse.setMessage("The token doesn't exists");
				
				return serviceResponse;
			}
		}catch(Exception e) {
			e.printStackTrace();
		}
		return null;
	}
	
	public ServiceResponse register(Account userData, int role){
		/* generate uuid*/
		String uuid = generateUserId();
		int userStatus = Integer.parseInt(System.getenv().get("NEW_USER_STATUS"));
		
		try {
			/* encrypt pass*/
			String newPassword = password.generateHash(userData.getPassword());
			
			authRepository.saveUserAccountData(userData.getUserId(), userData.getEmail(), role, newPassword, userStatus);
			serviceResponse.setCode(200);
			serviceResponse.setMessage("The user was saved successfully");
			
			return serviceResponse;
		}catch(Exception e) {
			e.printStackTrace();
		}
		return null;
	}
	
	
	/*************************** UTIL ****************************/
	private String recoveryTokenBuilder(int tokenLength) {
	    int leftLimit = 48; // numeral '0'
	    int rightLimit = 122; // letter 'z'
	    int targetStringLength = tokenLength;
	    Random random = new Random();
 
	    String generatedString = random.ints(leftLimit, rightLimit + 1)
	      .filter(i -> (i <= 57 || i >= 65) && (i <= 90 || i >= 97))
	      .limit(targetStringLength)
	      .collect(StringBuilder::new, StringBuilder::appendCodePoint, StringBuilder::append)
	      .toString();
 
    	System.out.println(generatedString);
    	return generatedString;
	}
		
	private String generateUserId() {
		String uuid = UUID.randomUUID().toString();
		return uuid;
	}
	
	private String getMilliseconds() {
		Long date = System.currentTimeMillis() + (1000 * 60 * 60);
		return Long.toString(date);
	}
}
