package com.falcon.service;

import org.springframework.stereotype.Service;

import com.falcon.repository.UserDetailsRepository;

@Service 
public class UserService {

	public UserDetailsRepository userDetailsRepository;
	
	
	public void name() {
		userDetailsRepository.findAll();
	}

	
}
