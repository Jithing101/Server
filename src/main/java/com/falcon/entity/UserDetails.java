package com.falcon.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;


import lombok.Data;

@Entity
@Data
@Table(name = "USER_DETAILS", schema = "test")
public class UserDetails {

	@Id 
	@Column(name = "EMAIL_ID")
	String emailId;

	@Column(name = "NAME")
	String name;

	@Column(name = "ADDRESS")
	String address;

	@Column(name = "AGE")
	Integer age;

	@Column(name = "USER_PASSWORD")
	String userPassword;

	public UserDetails(String emailId, String name, String address, Integer age, String userPassword) {
		super();
		this.emailId = emailId;
		this.name = name;
		this.address = address;
		this.age = age;
		this.userPassword = userPassword;
	}

	public UserDetails() {
		super();
	}

	public String getEmailId() {
		return emailId;
	}

	public void setEmailId(String emailId) {
		this.emailId = emailId;
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

	public Integer getAge() {
		return age;
	}

	public void setAge(Integer age) {
		this.age = age;
	}

	public String getUserPassword() {
		return userPassword;
	}

	public void setUserPassword(String userPassword) {
		this.userPassword = userPassword;
	}
	
	
}
