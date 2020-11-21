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

import com.co.alaorden.model.CompanyCollaboratorsEntity;
import com.co.alaorden.model.CompanyEntity;
import com.co.alaorden.service.CompanyCollaboratorsService;
import com.co.alaorden.service.CompanyService;

@RestController()
@RequestMapping(value="/company")
public class CompanyController {
	
	@Autowired
	CompanyService companyService;
	
	@Autowired
	CompanyCollaboratorsService collaboratorService;
	
    @RequestMapping (value = "/create-from-user/{userId}", method = RequestMethod.POST, produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<CompanyEntity> CreateCompanyFromUser(@RequestParam() String userId, @RequestBody CompanyEntity company){
        try {
            company.setIsActive((byte) 1);
            company.setOwner(userId);
            
            
            CompanyEntity newCompany = companyService.create(company);
            
            if (newCompany != null)
                return new ResponseEntity<>(newCompany, HttpStatus.OK);
            else
                return new ResponseEntity<>(new CompanyEntity(), HttpStatus.INTERNAL_SERVER_ERROR);
        }catch (Exception e){
            return new ResponseEntity<>(new CompanyEntity(), HttpStatus.BAD_REQUEST);
        }
    }
    
    @RequestMapping (value = "/{companyId}/add/{userId}", method = RequestMethod.POST, produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<String> AddUserToACompany(@RequestParam() int companyId, @RequestParam() String userId){
        try {
            
            CompanyCollaboratorsEntity collaborator = new CompanyCollaboratorsEntity();
            collaborator.setCompanyId(companyId);
            collaborator.setUserId(userId);
            
            CompanyCollaboratorsEntity newCollaborator = collaboratorService.create(collaborator);
            if (newCollaborator != null)
                return new ResponseEntity<>("Collaborator added successfully", HttpStatus.OK);
            else
                return new ResponseEntity<>("Error interno del servidor", HttpStatus.INTERNAL_SERVER_ERROR);
        }catch (Exception e){
            return new ResponseEntity<>("Error interno del servidor", HttpStatus.BAD_REQUEST);
        }
    }
    
    @RequestMapping (value = "/list", method = RequestMethod.GET, produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<List<CompanyEntity>> read(){
        try {
        	List<CompanyEntity> companies = companyService.readAll();
            if (companies.size() > 0)
                return new ResponseEntity<>(companies, HttpStatus.OK);
            else
                return new ResponseEntity<>(null, HttpStatus.INTERNAL_SERVER_ERROR);
        }catch (Exception e){
            return new ResponseEntity<>(null, HttpStatus.BAD_REQUEST);
        }
    }
}
