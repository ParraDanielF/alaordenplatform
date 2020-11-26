package com.co.alaorden.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.co.alaorden.model.ServiceEntity;
import com.co.alaorden.util.pojo.CompanyServices;
import com.co.alaorden.util.pojo.ServiceFilter;
import com.co.alaorden.service.ServiceService;

@RestController()
@RequestMapping(value="/services")
public class ServicesController {
	
	@Autowired
	ServiceService servicesService; 

    @RequestMapping (value = "/register/{companyId}", method = RequestMethod.POST, produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<String> CreateCompanyFromUser(@PathVariable("companyId") int companyId, @RequestBody CompanyServices services){
        try {
        	System.out.println("A");
        	for(ServiceEntity service : services.getServices()) {
        		service.setCompanyId(companyId);
        	}
        	
        	Boolean transactionResponse = servicesService.createMany(services.getServices());
            
            if (transactionResponse == true)
                return new ResponseEntity<>("Servicios creados correctamente", HttpStatus.OK);
            else
                return new ResponseEntity<>("Error interno del servidor", HttpStatus.INTERNAL_SERVER_ERROR);
        }catch (Exception e){
            return new ResponseEntity<>("Error interno del servidor", HttpStatus.BAD_REQUEST);
        }
    }
    
    @RequestMapping (value = "/search", method = RequestMethod.POST, produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<List<ServiceEntity>> BuscarServiciosDisponibles(@RequestBody ServiceFilter filter){
        try {
        	
        	List<ServiceEntity> transactionResponse = servicesService.searchServices(filter);
            
            if (transactionResponse != null)
                return new ResponseEntity<>(transactionResponse, HttpStatus.OK);
            else
                return new ResponseEntity<>(null, HttpStatus.INTERNAL_SERVER_ERROR);
        }catch (Exception e){
            return new ResponseEntity<>(null, HttpStatus.BAD_REQUEST);
        }
    }
}
