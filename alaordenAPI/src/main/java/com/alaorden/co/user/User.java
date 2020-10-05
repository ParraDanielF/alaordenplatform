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
}
