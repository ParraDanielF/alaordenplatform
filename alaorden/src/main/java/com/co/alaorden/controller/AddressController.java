package com.co.alaorden.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.co.alaorden.model.AddressEntity;
import com.co.alaorden.service.AddressService;

@RestController()
@RequestMapping(value="/address")
public class AddressController {
	
	@Autowired
	private AddressService addressService;

    @RequestMapping (value = "/", method = RequestMethod.POST, produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<String> AnadirDireccion(@RequestBody AddressEntity address){
        try {
        	
        	AddressEntity newAddress = addressService.create(address);
            
            if (newAddress != null)
                return new ResponseEntity<>("Direccion creada correctamente", HttpStatus.OK);
            else
                return new ResponseEntity<>("Error interno del servidor", HttpStatus.INTERNAL_SERVER_ERROR);
        }catch (Exception e){
            return new ResponseEntity<>("Error interno del servidor", HttpStatus.BAD_REQUEST);
        }
    }
    
    @RequestMapping (value = "/{userId}", method = RequestMethod.GET, produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<List<AddressEntity>> listarDireccionesPorUsuario(@RequestParam() String userId){
        try {
        	
        	List<AddressEntity> addressArray = addressService.readAllByUser(userId);
            
            if (addressArray != null)
                return new ResponseEntity<>(addressArray, HttpStatus.OK);
            else
                return new ResponseEntity<>(null, HttpStatus.INTERNAL_SERVER_ERROR);
        }catch (Exception e){
            return new ResponseEntity<>(null, HttpStatus.BAD_REQUEST);
        }
    }
}
