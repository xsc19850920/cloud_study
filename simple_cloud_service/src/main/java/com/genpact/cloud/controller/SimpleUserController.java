package com.genpact.cloud.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import com.genpact.cloud.dao.SimpleUserRepository;
import com.genpact.cloud.model.SimpleUser;

@RestController
public class SimpleUserController {
	@Autowired
	private SimpleUserRepository simpleUserRepository;
	
	@GetMapping("user/{id}")
	public SimpleUser findById(@PathVariable Long id){
		return simpleUserRepository.getOne(id);
	}
}
