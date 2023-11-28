package com.falcon.service;

import java.io.IOException;
import java.net.InetAddress;
import java.net.UnknownHostException;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import com.falcon.entity.Server;
import com.falcon.entity.Status;
import com.falcon.repository.ServerRepository;

@Service 
public class ServerService {

	@Autowired
	public ServerRepository serverRepo;	
	
	
	public Server create(Server server) {
		System.out.println("Saving new server : " +server.getName());
		server.setImageUrl(setServerImageUrl());
		return serverRepo.save(server);
	}

	public List<Server> list(int limit) {
		System.out.println("Fetching all the servers");
		return serverRepo.findAll();
	}
	

	public Server get(long id) {
		System.out.println("Fetch server by id "+id);
		return serverRepo.findById(id).get();
	}


	public Server update(Server server) {
		System.out.println("Updating the server "+server.getName());
		return serverRepo.save(server);
	}

	public Server ping(String ipAddress) throws IOException {
		System.out.println("Pinging server IP : " +ipAddress);
		List<Server> server = serverRepo.findbyIpAddress();
		  
		 Server serverObject= server.stream()
		  .filter(Obj -> Obj.getIpAddress().equals(ipAddress))
		  .findFirst().orElse(null);
		  
		  InetAddress  address = InetAddress.getByName(ipAddress);
	            System.out.println("retrieved ipaddress");
	            serverObject.setStatus(address.isReachable(1000) ? Status.SERVER_UP.toString() : Status.SERVER_DOWN.toString());
		serverRepo.save(serverObject);
		return serverObject;
	}
	
	
	public void delete(String id) {
		serverRepo.deleteById(id);
	}
	
//	------------------------------------------------
	private String setServerImageUrl() {
		String[] imageNames = {"Server1.png" , "Server2.png"};
		
		return ServletUriComponentsBuilder.fromCurrentContextPath().path("/server/image/" + imageNames[0]).toString();
	}

	

	
}
