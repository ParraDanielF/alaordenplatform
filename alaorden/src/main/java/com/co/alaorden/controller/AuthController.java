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
import com.co.alaorden.model.ServiceResponse;
import com.co.alaorden.service.AccountService;

import java.util.logging.Logger;

@RestController()
@RequestMapping(value="/auth")
public class AuthController {
    private static Logger logger = Logger.getLogger(AuthController.class.getName());

    @Autowired
    private AccountService accountService;
	
    @RequestMapping (value = "/login", method = RequestMethod.POST, produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<ServiceResponse> registrarUsuario(@RequestBody AccountEntity user){
        try {
            Boolean authResponse = accountService.validateCredentials(user);
            logger.info("[RESPONSE] " + authResponse);
            ServiceResponse response = new ServiceResponse();
            
            if (authResponse) {
            	response.setMessage("{response : true}");
                return new ResponseEntity<>(response, HttpStatus.OK);
            }
            else {
            	response.setMessage("{response : false}");
                return new ResponseEntity<>(response, HttpStatus.NO_CONTENT);
            }
        }catch (Exception e){
            return new ResponseEntity<>(new ServiceResponse(), HttpStatus.BAD_REQUEST);
        }
    }
}
