package com.alaorden.co.util;

import org.springframework.stereotype.Component;

@Component
public class ServiceResponse {

	private int code;
	private String message;
	private String payload;

	public ServiceResponse(int code, String message) {
		this.code = code;
		this.message = message;
	}
	
	public ServiceResponse(int code, String message, String payload) {
		this.code = code;
		this.message = message;
		this.payload = payload;
	}

	public int getCode() {
		return code;
	}
	public void setCode(int code) {
		this.code = code;
	}
	public String getMessage() {
		return message;
	}
	public void setMessage(String message) {
		this.message = message;
	}
	public String getPayload() {
		return payload;
	}

	public void setPayload(String payload) {
		this.payload = payload;
	}
	
	
}
