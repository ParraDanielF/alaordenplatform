package com.alaorden.co.authentication.model;

import org.springframework.stereotype.Component;

@Component
public class Account {

	private String accountId;
	private String userId;
	private String email;
	private String password;
	private boolean status;
	
	public Account() {
	}

	public Account(String accountId, String userId, String email, String password, boolean status) {
		this.accountId = accountId;
		this.userId = userId;
		this.email = email;
		this.password = password;
		this.status = status;
	}


	public String getAccountId() {
		return accountId;
	}


	public void setAccountId(String accountId) {
		this.accountId = accountId;
	}


	public String getUserId() {
		return userId;
	}


	public void setUserId(String userId) {
		this.userId = userId;
	}


	public String getEmail() {
		return email;
	}


	public void setEmail(String email) {
		this.email = email;
	}


	public String getPassword() {
		return password;
	}


	public void setPassword(String password) {
		this.password = password;
	}


	public boolean isStatus() {
		return status;
	}


	public void setStatus(boolean status) {
		this.status = status;
	}
	
	
	
}
