package com.falcon.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "STATUS")
public enum Status {

	SERVER_UP("SERVER_UP"),
	SERVER_DOWN("SERVER_DOWN");

	@Id
	@Column(name = "STATUS")
	private final String status;
	
	Status(String status) {
		this.status=status;
	}
	
	public String getStatus() {
		return this.status;
		
	}
	
}
