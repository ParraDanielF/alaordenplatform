package com.alaorden.co.payment.model;

import org.springframework.stereotype.Component;

@Component
public class PaymentType {

	private int paymentTypeId;
	private String description;
	
	public PaymentType(int paymentTypeId, String description) {
		this.paymentTypeId = paymentTypeId;
		this.description = description;
	}

	public int getPaymentTypeId() {
		return paymentTypeId;
	}

	public void setPaymentTypeId(int paymentTypeId) {
		this.paymentTypeId = paymentTypeId;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}	
	
	
	
	
}
