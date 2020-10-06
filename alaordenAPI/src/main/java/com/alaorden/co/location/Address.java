package com.alaorden.co.location;

import org.springframework.stereotype.Component;

@Component
public class Address {

	private int addressId;
	private String name;
	private String address;
	private boolean isTheMainAddress;
	private float longitude;
	private float latitude;
	
	public Address() {
	}

	public Address(int addressId, String name, String address, boolean isTheMainAddress) {
		this.addressId = addressId;
		this.name = name;
		this.address = address;
		this.isTheMainAddress = isTheMainAddress;
	}


	public Address(int addressId, String name, boolean isTheMainAddress, float longitude, float latitude) {
		this.addressId = addressId;
		this.name = name;
		this.isTheMainAddress = isTheMainAddress;
		this.longitude = longitude;
		this.latitude = latitude;
	}


	public int getAddressId() {
		return addressId;
	}


	public void setAddressId(int addressId) {
		this.addressId = addressId;
	}


	public String getName() {
		return name;
	}


	public void setName(String name) {
		this.name = name;
	}


	public String getAddress() {
		return address;
	}


	public void setAddress(String address) {
		this.address = address;
	}


	public boolean isTheMainAddress() {
		return isTheMainAddress;
	}


	public void setTheMainAddress(boolean isTheMainAddress) {
		this.isTheMainAddress = isTheMainAddress;
	}


	public float getLongitude() {
		return longitude;
	}


	public void setLongitude(float longitude) {
		this.longitude = longitude;
	}


	public float getLatitude() {
		return latitude;
	}


	public void setLatitude(float latitude) {
		this.latitude = latitude;
	}
	
}
