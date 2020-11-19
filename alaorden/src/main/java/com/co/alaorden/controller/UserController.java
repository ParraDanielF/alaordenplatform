package com.co.alaorden.controller;

import com.co.alaorden.model.AccountEntity;
import com.co.alaorden.model.UserEntity;
import com.co.alaorden.model.UserRegisterEntity;
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

@RestController()
@RequestMapping(value="/user")
public class UserController {

    @Autowired
    private UserService userService;
    
    @Autowired
    private AccountService accountService;

    @RequestMapping (value = "/register", method = RequestMethod.POST, produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<String> registrarUsuario(@RequestBody UserRegisterEntity user){
        try {
            UserEntity newUser = userService.create(user);
            /** set the account data*/
            AccountEntity account = new AccountEntity();
            account.setUserId(newUser.getId());
            account.setEmail(user.getEmail());
            account.setPassword(user.getPassword());
            account.setStatus((byte) 1);
            account.setRoleId(1);
            
            AccountEntity newAccount = accountService.create(account);
            
            if (newUser != null && newAccount != null)
                return new ResponseEntity<>("Usuario creado correctamente", HttpStatus.OK);
            else
                return new ResponseEntity<>("Error interno del servidor", HttpStatus.INTERNAL_SERVER_ERROR);
        }catch (Exception e){
            return new ResponseEntity<>("Error interno del servidor", HttpStatus.BAD_REQUEST);
        }
    }
}
