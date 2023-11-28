package com.falcon.entity;


import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;


@Entity
@Data
@NoArgsConstructor
//@AllArgsConstructor
@Table(name = "SERVER")
public class Server {
		
	@Id 
//	@GeneratedValue(strategy = GenerationType.AUTO)
	@Column(name = "ID")
	private long id;
	
	@Column(name = "IPADDRESS",unique = true)
//	@NotEmpty(message = "IP Address cant be empty")
	private String ipAddress;
	
	@Column(name = "NAME")
	private String name;
	
	@Column(name = "MEMORY")
	private String memory;
	
	@Column(name = "TYPE")
	private String type;
	
	@Column(name = "IMAGEURL")
	private String imageUrl;
	
	@Column(name = "STATUS")
	private String status;
	
	
public Server(Long Id, String ipAddress, String name, String memory,
			String type, String imageUrl, String status) {
		super();
		this.id = Id;
		this.ipAddress = ipAddress;
		this.name = name;
		this.memory = memory;
		this.type = type;
		this.imageUrl = imageUrl;
		this.status = status;
	}

public Server() {
	super();
}
		
	public long getId() {
		return id;
	}
	public void setId(long id) {
		this.id = id;
	}
	public String getIpAddress() {
		return ipAddress;
	}
	public void setIpAddress(String ipAddress) {
		this.ipAddress = ipAddress;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getMemory() {
		return memory;
	}
	public void setMemory(String memory) {
		this.memory = memory;
	}
	public String getType() {
		return type;
	}
	public void setType(String type) {
		this.type = type;
	}
	public String getImageUrl() {
		return imageUrl;
	}
	public void setImageUrl(String imageUrl) {
		this.imageUrl = imageUrl;
	}
	public String getStatus() {
		return status;
	}
	public void setStatus(String status) {
		this.status = status;
	}

}
