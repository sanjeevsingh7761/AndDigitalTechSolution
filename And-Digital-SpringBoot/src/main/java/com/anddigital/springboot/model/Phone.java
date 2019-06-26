package com.anddigital.springboot.model;

import javax.persistence.Entity;
import javax.persistence.Id;

@Entity
public class Phone {
	@Id
	private String id;
	private String phoneNumber;
	private String simNumber;
	
	public Phone(String id, String phoneNumber, String simNumber) {
		super();
		this.id = id;
		this.phoneNumber = phoneNumber;
		this.simNumber = simNumber;
	}
	public String getId() {
		return id;
	}
	public void setId(String id) {
		this.id = id;
	}
	public String getPhoneNumber() {
		return phoneNumber;
	}
	public void setPhoneNumber(String phoneNumber) {
		this.phoneNumber = phoneNumber;
	}
	public String getSimNumber() {
		return simNumber;
	}
	public void setSimNumber(String simNumber) {
		this.simNumber = simNumber;
	}
	
	
	
	

	
	

}