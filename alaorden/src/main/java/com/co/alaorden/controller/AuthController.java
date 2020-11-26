package com.co.alaorden.controller;

import com.co.alaorden.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.co.alaorden.model.AccountEntity;
import com.co.alaorden.util.pojo.ServiceResponse;
import com.co.alaorden.model.UserEntity;
import com.co.alaorden.service.AccountService;

import java.util.logging.Logger;

@RestController()
@RequestMapping(value="/auth")
public class AuthController {
    private static Logger logger = Logger.getLogger(AuthController.class.getName());

    @Autowired
    private AccountService accountService;
    
    @Autowired
    private UserService userService;
	
    @RequestMapping (value = "/login", method = RequestMethod.POST, produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<UserEntity> registrarUsuario(@RequestBody AccountEntity user){
        try {
            AccountEntity authResponse = accountService.validateCredentials(user);
            
            System.out.println(authResponse.getId());
            ServiceResponse response = new ServiceResponse();
            if(authResponse.getId() != 0) {
	            /** get the user info*/
	            UserEntity userData = userService.read(authResponse.getUserId());
	            
	            if (userData != null) {
	                return new ResponseEntity<>(userData, HttpStatus.OK);
	            }
	            else {
	                return new ResponseEntity<>(new UserEntity(), HttpStatus.NO_CONTENT);
	            }
            }else {
            	return new ResponseEntity<>(new UserEntity(), HttpStatus.NO_CONTENT);
            }
        }catch (Exception e){
        	e.printStackTrace();
            return new ResponseEntity<>(new UserEntity(), HttpStatus.BAD_REQUEST);
        }
    }
}
