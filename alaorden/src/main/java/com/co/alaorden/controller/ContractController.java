package com.co.alaorden.controller;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.co.alaorden.model.ContractEntity;
import com.co.alaorden.model.ContractServicesEntity;
import com.co.alaorden.model.NotificationsEntity;
import com.co.alaorden.model.ServiceEntity;
import com.co.alaorden.service.ContractService;
import com.co.alaorden.service.ContractServicesService;
import com.co.alaorden.service.NotificationsService;

@RestController()
@RequestMapping(value="/contract")
public class ContractController {

	@Autowired
	ContractService contractService;
	
	@Autowired
	ContractServicesService contractServicesService;
	
	@Autowired
	NotificationsService notificationsService;
	
    @RequestMapping (value = "/create", method = RequestMethod.POST, produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<String> crearContrato(@RequestBody ContractEntity contract, @RequestBody List<ServiceEntity> servicesArray){
        try {
        	
        	/*
        	 * steps
        	 * 1. register the contract
        	 * 2. register the contract services in the contrac_service table
        	 * 3. register a new notification
        	 * */
        	contract.setState("I");
        	
        	ContractEntity newContract = contractService.create(contract);
        	try {
        	for(ServiceEntity svc : servicesArray) {
	        	ContractServicesEntity services = new ContractServicesEntity();
	        	services.setContractId(newContract.getId());
	        	services.setServiceId(svc.getId());
	        	contractServicesService.create(services);
        	}
        	}catch(Exception ex) {
        		ex.printStackTrace();
        	}
        	
        	NotificationsEntity notification = new NotificationsEntity();
        	notification.setUserId(contract.getUserId());
        	notification.setNotificationMessage("Se ha creado el contrato exitosamente");
        	
        	NotificationsEntity newNotification = notificationsService.create(notification);
            
            if (newNotification != null)
                return new ResponseEntity<>("Contrato creado correctamente", HttpStatus.OK);
            else
                return new ResponseEntity<>("Error interno del servidor", HttpStatus.INTERNAL_SERVER_ERROR);
        }catch (Exception e){
            return new ResponseEntity<>("Error interno del servidor", HttpStatus.BAD_REQUEST);
        }
    }
    
    @RequestMapping (value = "/update", method = RequestMethod.POST, produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<String> ActualizarEstadoDelContrato(@RequestBody ContractEntity contract){
        try {
        	
        	ContractEntity updatedContract = contractService.update(contract, new Integer(contract.getId()));
        	
        	NotificationsEntity notification = new NotificationsEntity();
        	notification.setUserId(contract.getUserId());
        	notification.setNotificationMessage("Se ha actualizado el contrato exitosamente al estado: " + contract.getState());
        	
        	NotificationsEntity newNotification = notificationsService.create(notification);
            
            if (newNotification != null)
                return new ResponseEntity<>("Contrato creado correctamente", HttpStatus.OK);
            else
                return new ResponseEntity<>("Error interno del servidor", HttpStatus.INTERNAL_SERVER_ERROR);
        }catch (Exception e){
            return new ResponseEntity<>("Error interno del servidor", HttpStatus.BAD_REQUEST);
        }
    }
}
