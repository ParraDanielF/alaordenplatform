package com.co.alaorden.service;

import com.co.alaorden.model.UserEntity;
import com.co.alaorden.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.logging.Logger;

@Component
public class UserService {
    private static Logger logger = Logger.getLogger(UserService.class.getName());

    @Autowired
    UserRepository userRepository;

    public UserEntity create (UserEntity user){
        logger.info("Se va a crear el usario " + user.toString());
        return userRepository.save(user);
    }

    public UserEntity read (String id){
        return userRepository.findById(id).get();
    }

    public UserEntity update (UserEntity user, String id){
        UserEntity tmpUser = userRepository.findById(id).get();
        tmpUser.setCity(user.getCity());
        tmpUser.setCountry(user.getCountry());
        tmpUser.setDocument(user.getDocument());
        tmpUser.setDocumentType(user.getDocumentType());
        tmpUser.setLastName(user.getLastName());
        tmpUser.setName(user.getName());
        tmpUser.setPhone(user.getPhone());
        return userRepository.save(tmpUser);
    }

    public String delete (String id){
        userRepository.deleteById(id);
        return userRepository.findById(id).get() == null ?
                "Eliminada el usuario "+ id.toString() :
                "No se elimino el usuario " + id.toString() ;
    }

}
