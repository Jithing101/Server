package com.falcon.controller;

import java.io.IOException;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.falcon.entity.Response;
import com.falcon.entity.Server;
import com.falcon.entity.Status;
import com.falcon.entity.UserDetails;
import com.falcon.repository.UserDetailsRepository;
import com.falcon.service.ServerService;

import lombok.extern.slf4j.Slf4j;



@CrossOrigin(origins = "http://localhost:4200")
@RestController
@RequestMapping("/server")
@Slf4j
//@Api(value = "Interface to fetch rluser to catagory mapping details")
public class UserController {

	@Autowired
	public UserDetailsRepository userDetailsRepository;
	
	@Autowired
	private ServerService ServerService;
	
		
	@GetMapping("/userdetails/{emailId}/{password}")
	public boolean getUserToken(@PathVariable String emailId,@PathVariable String password) {
		List<UserDetails> groupList = new ArrayList<>();
		boolean returnMessage=false;
		groupList=	userDetailsRepository.findAll(); 
		System.out.println(emailId+"  "+password);
		for(UserDetails userDetails:groupList) {
			System.out.println(userDetails.getEmailId());
			System.out.println(userDetails.getUserPassword());
			if (userDetails.getEmailId().equals(emailId) && userDetails.getUserPassword().equals(password)) {
				returnMessage=true;
			}
		}
		System.out.println("user token controller method "+groupList.size()+"   "+returnMessage);
		return returnMessage;
	
	}
	
	@GetMapping("/list")
	public ResponseEntity<Response> getServer(){
		System.out.println(",,,,,,,,,,,,,,,,,,,,,,");
		Map<Long, Server> listMap= new HashMap<Long, Server>();
			List<Server> s = ServerService.list(30);
			for (Server s1: s) {
				listMap.put(s1.getId(), s1);
				}
		Response response =new Response();
		response.setTimeStamp(LocalDateTime.now());
		response.setData(listMap);
		response.setMessage("Servers retrieved");
		response.setStatusCode(HttpStatus.OK);
		return ResponseEntity.ok(response);
	}
	
	
	@GetMapping("/ping/{ipAddress}")
	public ResponseEntity<Response> pingServer(@PathVariable String ipAddress) throws IOException{
		System.out.println("Started........");
		Server server =ServerService.ping(ipAddress);	
			Map<Long, Server> listMap= new HashMap<Long, Server>();
				listMap.put(1L , server);
				
		Response response =new Response();
		response.setTimeStamp(LocalDateTime.now());
		response.setData(listMap);
		response.setMessage(server.getStatus().equals(Status.SERVER_UP.toString())? "Ping Success" : "Ping Failed");
		response.setStatusCode(HttpStatus.OK);
		return ResponseEntity.ok(response);
	}
	
	@PostMapping("/save")
	public ResponseEntity<Response> saveServer(@RequestBody  Server server) throws IOException{
			Map<Integer ,Server> listMap= new HashMap<Integer ,Server>();
				listMap.put(1 , ServerService.create(server));
		
		Response response =new Response();
		response.setTimeStamp(LocalDateTime.now());
//		response.setData(listMap);
		response.setMessage("Server created");
		response.setStatusCode(HttpStatus.CREATED);
		return ResponseEntity.ok(response);
	}
	
	@GetMapping("/get/{id}")
	public ResponseEntity<Response> getServer(@PathVariable("id") Long id) throws IOException{
		Server server =ServerService.get(id.longValue());
			Map<Long ,Server> listMap= new HashMap<Long ,Server>();
				listMap.put(1L , server);
				
		Response response =new Response();
		response.setTimeStamp(LocalDateTime.now());
		response.setData(listMap);
		response.setMessage("Server retrieved");
		response.setStatusCode(HttpStatus.OK);
		return ResponseEntity.ok(response);
	}

	
	@GetMapping("/delete/{id}")
	public ResponseEntity<Response> deleteServer(@PathVariable String id) throws IOException{
		ServerService.delete(id);	
		Response response =new Response();
		response.setTimeStamp(LocalDateTime.now());
//		response.setData(listMap);
		response.setMessage("Server deleted");
		response.setStatusCode(HttpStatus.OK);
		return ResponseEntity.ok(response);
	}
	
//	@GetMapping(path = "/image/{fileName}", produces = IMAGE_PNG_VALUE	)
//	public byte[] getServerImage(@PathVariable String fileName) throws IOException{
//	
//		return Files.readAllBytes(Paths.get(System.getProperty("user.home") + "Downloads/images/" +fileName)) ;
//	}

}
