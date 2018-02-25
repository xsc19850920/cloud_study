package com.genpact.cloud.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

import com.genpact.cloud.model.SimpleUser;

@RestController
public class ClientController {
	@Autowired
	private RestTemplate restTemplate;
	
	@GetMapping("user/{id}")
	public SimpleUser findById(@PathVariable Long id){
		SimpleUser user = restTemplate.getForObject("http://localhost:9099/user/"+id, SimpleUser.class);
		return user;
	}
}
