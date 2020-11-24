package com.co.alaorden.controller;

import com.co.alaorden.model.AccountEntity;
import com.co.alaorden.model.UserEntity;
import com.co.alaorden.util.pojo.UserRegister;
import com.co.alaorden.service.AccountService;
import com.co.alaorden.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import java.util.logging.Logger;

@RestController()
@RequestMapping(value="/user")
public class UserController {
    private static Logger logger = Logger.getLogger(UserController.class.getName());

    @Autowired
    private UserService userService;
    
    @Autowired
    private AccountService accountService;

    @RequestMapping (value = "/register", method = RequestMethod.POST, produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<String> registrarUsuario(@RequestBody UserRegister registro){
        try {
            UserEntity newUser = userService.create(registro.getUser());
            logger.info(String.valueOf(newUser==null));
            AccountEntity newAccount = accountService.create(registro.getAccount());
            logger.info(String.valueOf(newAccount==null));

            if (newUser != null && newAccount != null)
                return new ResponseEntity<>("Usuario creado correctamente", HttpStatus.OK);
            else
                return new ResponseEntity<>("Error interno del servidor", HttpStatus.INTERNAL_SERVER_ERROR);
        }catch (Exception e){
            return new ResponseEntity<>("Error interno del servidor", HttpStatus.BAD_REQUEST);
        }
    }
}
