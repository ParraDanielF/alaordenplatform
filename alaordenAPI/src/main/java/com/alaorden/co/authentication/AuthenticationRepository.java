package com.alaorden.co.authentication;

import org.springframework.stereotype.Repository;

import com.alaorden.co.authentication.model.RecoveryData;
import com.alaorden.co.util.Session;

@Repository
public class AuthenticationRepository {
	
	public void saveUserAccountData(String userId, String email, int role, String password, int status) {
		
	}
	
	public saveUserData(String name, String document, int documentType, String lastName, int country, int city, String phone) {
		
	}
	
	public Boolean validateUserCredentials(String email, String password){
		
	}
	
	public createSession(Session sessionData) {
		
	}
	
	public readSession(String sessionId) {
		
	}
	
	public updateSession(Session sessionData) {
		
	}
	
	public void removeSession(String SessionId) {
		
	}
	
	public void saveRecoveryData(RecoveryData data) {
		
	}
	
	public RecoveryData readRecoveryData(String tokenId) {
		
	}
	
	public void removeRecoveryData(String tokenId) {
		
	}
}
