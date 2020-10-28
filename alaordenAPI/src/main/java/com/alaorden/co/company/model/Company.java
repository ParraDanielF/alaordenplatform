package com.alaorden.co.company.model;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.alaorden.co.service.model.ServiceModel;
import com.alaorden.co.user.User;

@Component
public class Company {
	
	private String name;
	private String address;
	private boolean isActive;
	private String owner;
	private String segmentCode;
	private float longitude;
	private float latitude;
	private int country;
	private int city;
	
	@Autowired
	private List<User> collaborators;
	
	@Autowired
	private List<ServiceModel> services;

	public Company() {
	}

	public Company(String name, String address, boolean isActive, String owner, String segmentCode, float longitude,
			float latitude, int country, int city, List<User> collaborators, List<ServiceModel> services) {
		this.name = name;
		this.address = address;
		this.isActive = isActive;
		this.owner = owner;
		this.segmentCode = segmentCode;
		this.longitude = longitude;
		this.latitude = latitude;
		this.country = country;
		this.city = city;
		this.collaborators = collaborators;
		this.services = services;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getAddress() {
		return address;
	}

	public void setAddress(String address) {
		this.address = address;
	}

	public boolean isActive() {
		return isActive;
	}

	public void setActive(boolean isActive) {
		this.isActive = isActive;
	}

	public String getOwner() {
		return owner;
	}

	public void setOwner(String owner) {
		this.owner = owner;
	}

	public String getSegmentCode() {
		return segmentCode;
	}

	public void setSegmentCode(String segmentCode) {
		this.segmentCode = segmentCode;
	}

	public float getLongitude() {
		return longitude;
	}

	public void setLongitude(float longitude) {
		this.longitude = longitude;
	}

	public float getLatitude() {
		return latitude;
	}

	public void setLatitude(float latitude) {
		this.latitude = latitude;
	}

	public int getCountry() {
		return country;
	}

	public void setCountry(int country) {
		this.country = country;
	}

	public int getCity() {
		return city;
	}

	public void setCity(int city) {
		this.city = city;
	}

	public List<User> getCollaborators() {
		return collaborators;
	}

	public void setCollaborators(List<User> collaborators) {
		this.collaborators = collaborators;
	}

	public List<ServiceModel> getServices() {
		return services;
	}

	public void setServices(List<ServiceModel> services) {
		this.services = services;
	}
	
}
