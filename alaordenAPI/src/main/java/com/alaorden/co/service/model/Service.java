package com.alaorden.co.service.model;

import org.springframework.stereotype.Component;

@Component
public class Service {
	
	private String serviceId;
	private String companyId;
	private String serviceType;
	private String name;
	private String description;
	private float price;
	private boolean isNegotiable;
	private float score;
	
	public Service(String serviceId, String companyId, String serviceType, String name, String description, float price,
			boolean isNegotiable, float score) {
		this.serviceId = serviceId;
		this.companyId = companyId;
		this.serviceType = serviceType;
		this.name = name;
		this.description = description;
		this.price = price;
		this.isNegotiable = isNegotiable;
		this.score = score;
	}
	
	public String getServiceId() {
		return serviceId;
	}
	public void setServiceId(String serviceId) {
		this.serviceId = serviceId;
	}
	public String getCompanyId() {
		return companyId;
	}
	public void setCompanyId(String companyId) {
		this.companyId = companyId;
	}
	public String getServiceType() {
		return serviceType;
	}
	public void setServiceType(String serviceType) {
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
	public float getPrice() {
		return price;
	}
	public void setPrice(float price) {
		this.price = price;
	}
	public boolean isNegotiable() {
		return isNegotiable;
	}
	public void setNegotiable(boolean isNegotiable) {
		this.isNegotiable = isNegotiable;
	}
	public float getScore() {
		return score;
	}
	public void setScore(float score) {
		this.score = score;
	}
	
	
	
}
