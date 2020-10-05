package com.alaorden.co.social.model;

import java.util.Date;

import org.springframework.stereotype.Component;

@Component
public class Comment {
	
	private String userId;
	private String contractId;
	private String comment;
	private Date createdAt;
	
	public Comment(String userId, String contractId, String comment, Date createdAt) {
		this.userId = userId;
		this.contractId = contractId;
		this.comment = comment;
		this.createdAt = createdAt;
	}

	public String getUserId() {
		return userId;
	}

	public void setUserId(String userId) {
		this.userId = userId;
	}

	public String getContractId() {
		return contractId;
	}

	public void setContractId(String contractId) {
		this.contractId = contractId;
	}

	public String getComment() {
		return comment;
	}

	public void setComment(String comment) {
		this.comment = comment;
	}

	public Date getCreatedAt() {
		return createdAt;
	}

	public void setCreatedAt(Date createdAt) {
		this.createdAt = createdAt;
	}
	
}
