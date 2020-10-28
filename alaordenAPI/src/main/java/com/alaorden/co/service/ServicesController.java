package com.alaorden.co.service;

import java.util.List;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import com.alaorden.co.service.model.ServiceModel;
import com.alaorden.co.util.ServiceResponse;

@Controller
@RequestMapping("/service")
public class ServicesController {
	
	@PostMapping("/")
	public ServiceResponse createService() {
		return null;
	}
	
	@PutMapping("/")
	public ServiceResponse updateService() {
		return null;
	}
	
	@DeleteMapping("/{serviceId}")
	public ServiceResponse deleteService() {
		return null;
	}
	
	@GetMapping("/{serviceId}")
	public List<ServiceModel> getServices(@PathVariable(required = false) String serviceId) {
		return null;
	}
}
