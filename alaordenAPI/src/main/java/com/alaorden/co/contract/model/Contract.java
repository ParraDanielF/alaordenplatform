package com.alaorden.co.contract.model;

import java.util.Date;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.alaorden.co.service.model.ServiceModel;

@Component
public class Contract {

	private String contractId;
	private String companyId;
	private String userId;
	private int paymentTypeId;
	private Date contractDate;

	@Autowired
	private List<ServiceModel> services;

	public Contract() {
	}

	public Contract(String contractId, String companyId, String userId, int paymentTypeId, Date contractDate,
			List<ServiceModel> services) {
		this.contractId = contractId;
		this.companyId = companyId;
		this.userId = userId;
		this.paymentTypeId = paymentTypeId;
		this.contractDate = contractDate;
		this.services = services;
	}

	public String getContractId() {
		return contractId;
	}

	public void setContractId(String contractId) {
		this.contractId = contractId;
	}

	public String getCompanyId() {
		return companyId;
	}

	public void setCompanyId(String companyId) {
		this.companyId = companyId;
	}

	public String getUserId() {
		return userId;
	}

	public void setUserId(String userId) {
		this.userId = userId;
	}

	public int getPaymentTypeId() {
		return paymentTypeId;
	}

	public void setPaymentTypeId(int paymentTypeId) {
		this.paymentTypeId = paymentTypeId;
	}

	public List<ServiceModel> getServices() {
		return services;
	}

	public void setServices(List<ServiceModel> services) {
		this.services = services;
	}

	public Date getContractDate() {
		return contractDate;
	}

	public void setContractDate(Date contractDate) {
		this.contractDate = contractDate;
	}
	
	
	
}
