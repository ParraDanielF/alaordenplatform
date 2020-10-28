package com.alaorden.co.service;

import java.util.ArrayList;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.alaorden.co.service.model.ServiceModel;

import com.alaorden.co.util.ServiceResponse;

@Service
public class ServicesService {
	
	@Autowired
	private ServicesRepository servicesRepository;
	
	@Autowired
	private ServiceResponse serviceResponse;
	
	public ServiceResponse createService(ServiceModel serviceData) {
		try {
			servicesRepository.createService(serviceData);
			serviceResponse.setCode(200);
			serviceResponse.setMessage("Service created successfully");
			return serviceResponse;
		}catch(Exception e) {
			e.printStackTrace();
		}
		
		return null;
	}
	
	public ServiceResponse readService(String serviceId) {
		try {
			ServiceModel serviceData = servicesRepository.readService(serviceId);
			serviceResponse.setCode(200);
			serviceResponse.setMessage("Service created successfully");
			serviceResponse.setPayload(serviceData);
		}catch(Exception e) {
			e.printStackTrace();
		}
		
		return null;
	}
	
	public ServiceResponse readAllServicesByCompany(String companyId) {
		try {
			ArrayList<ServiceModel> serviceData = servicesRepository.readAllServices(companyId);
			serviceResponse.setCode(200);
			serviceResponse.setMessage("Service created successfully");
			serviceResponse.setPayload(serviceData);
		}catch(Exception e) {
			e.printStackTrace();
		}
	}
	
	public ServiceResponse updateService(ServiceModel serviceData) {
		try {
			servicesRepository.updateService(serviceData);
			serviceResponse.setCode(200);
			serviceResponse.setMessage("Service updated successfully");
			return serviceResponse;
		}catch(Exception e) {
			e.printStackTrace();
		}
		
		return null;
	}
	
	public ServiceResponse deleteService(String serviceId) {
		try {
			servicesRepository.deleteService(serviceId);
			serviceResponse.setCode(200);
			serviceResponse.setMessage("Service removed successfully");
			return serviceResponse;
		}catch(Exception e) {
			e.printStackTrace();
		}
		
		return null;
	}
}
