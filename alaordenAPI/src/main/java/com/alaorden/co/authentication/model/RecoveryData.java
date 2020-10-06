package com.alaorden.co.authentication.model;

import org.springframework.stereotype.Component;

@Component
public class RecoveryData {
	
	private String accountId;
	private String recoveryToken;
	private String expiredAt;
	
	public RecoveryData() {
	}

	public RecoveryData(String accountId, String recoveryToken, String expiredAt) {
		this.accountId = accountId;
		this.recoveryToken = recoveryToken;
		this.expiredAt = expiredAt;
	}


	public String getAccountId() {
		return accountId;
	}


	public void setAccountId(String accountId) {
		this.accountId = accountId;
	}


	public String getRecoveryToken() {
		return recoveryToken;
	}


	public void setRecoveryToken(String recoveryToken) {
		this.recoveryToken = recoveryToken;
	}


	public String getExpiredAt() {
		return expiredAt;
	}


	public void setExpiredAt(String expiredAt) {
		this.expiredAt = expiredAt;
	}
	
	
	
	
}
