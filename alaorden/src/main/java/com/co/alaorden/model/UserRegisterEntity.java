package com.co.alaorden.model;

import javax.persistence.*;

public class UserRegisterEntity{
	
	public String password;
	public String email;
	
	public UserRegisterEntity() {

	}
	
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	
	
	
}
