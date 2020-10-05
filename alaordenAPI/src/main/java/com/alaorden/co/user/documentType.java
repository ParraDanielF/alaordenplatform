package com.alaorden.co.user;

import org.springframework.stereotype.Component;

@Component
public class documentType {

	private int documentTypeId;
	private String name;
	
	public documentType(int documentTypeId, String name) {
		this.documentTypeId = documentTypeId;
		this.name = name;
	}

	public int getDocumentTypeId() {
		return documentTypeId;
	}

	public void setDocumentTypeId(int documentTypeId) {
		this.documentTypeId = documentTypeId;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	
	
}
