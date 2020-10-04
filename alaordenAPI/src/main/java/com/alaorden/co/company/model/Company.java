package com.alaorden.co.company.model;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.alaorden.co.service.model.Service;
import com.alaorden.co.user.User;

@Component
public class Company {
	
	private String name;
	private String address;
	private boolean isActive;
	private String owner;
	private String segmentCode;
	private int location;
	private int country;
	
	@Autowired
	private List<User> collaborators;
	
	@Autowired
	private List<Service> services;

	
	
	public Company(String name, String address, boolean isActive, String owner, String segmentCode, int location,
			int country, List<User> collaborators, List<Service> services) {
		this.name = name;
		this.address = address;
		this.isActive = isActive;
		this.owner = owner;
		this.segmentCode = segmentCode;
		this.location = location;
		this.country = country;
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

	public List<User> getCollaborators() {
		return collaborators;
	}

	public void setCollaborators(List<User> collaborators) {
		this.collaborators = collaborators;
	}

	public List<Service> getServices() {
		return services;
	}

	public void setServices(List<Service> services) {
		this.services = services;
	}

	public int getLocation() {
		return location;
	}

	public void setLocation(int location) {
		this.location = location;
	}

	public int getCountry() {
		return country;
	}

	public void setCountry(int country) {
		this.country = country;
	}
	
	
	
}
