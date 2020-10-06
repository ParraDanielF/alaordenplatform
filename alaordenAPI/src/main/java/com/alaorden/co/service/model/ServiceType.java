package com.alaorden.co.service.model;

import org.springframework.stereotype.Component;

@Component
public class ServiceType {

	private int serviceType;
	private String name;
	private String description;
	
	
	public ServiceType() {
	}

	public ServiceType(int serviceType, String name, String description) {
		this.serviceType = serviceType;
		this.name = name;
		this.description = description;
	}

	public int getServiceType() {
		return serviceType;
	}

	public void setServiceType(int serviceType) {
		this.serviceType = serviceType;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}
	
}
