package com.alaorden.co.user;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.alaorden.co.location.Address;

@Component
public class User {
	
	private String userId;
	private String name;
	private String document;
	private int documentType;
	private String lastName;
	private int role;
	private int country;
	private int city;
	private String phone;
	
	@Autowired
	private List<Address> addresses;
	
	
	public User() {
	}

	public User(String userId, String name, String document, int documentType, String lastName, int role, int country,
			int city, String phone, List<Address> addresses) {
		super();
		this.userId = userId;
		this.name = name;
		this.document = document;
		this.documentType = documentType;
		this.lastName = lastName;
		this.role = role;
		this.country = country;
		this.city = city;
		this.phone = phone;
		this.addresses = addresses;
	}

	public String getUserId() {
		return userId;
	}

	public void setUserId(String userId) {
		this.userId = userId;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getDocument() {
		return document;
	}

	public void setDocument(String document) {
		this.document = document;
	}

	public int getDocumentType() {
		return documentType;
	}

	public void setDocumentType(int documentType) {
		this.documentType = documentType;
	}

	public String getLastName() {
		return lastName;
	}

	public void setLastName(String lastName) {
		this.lastName = lastName;
	}

	public int getRole() {
		return role;
	}

	public void setRole(int role) {
		this.role = role;
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

	public String getPhone() {
		return phone;
	}

	public void setPhone(String phone) {
		this.phone = phone;
	}

	public List<Address> getAddresses() {
		return addresses;
	}

	public void setAddresses(List<Address> addresses) {
		this.addresses = addresses;
	}
	
	
	
	
}
