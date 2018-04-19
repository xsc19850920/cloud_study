package com.genpact.cloud.controller;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;


@RestController
public class UserController {
	private Logger LOG = LoggerFactory.getLogger(UserController.class);
	
	@GetMapping("user/{id}")
	public String findById(@PathVariable("id") String id) {
		LOG.info("userId : " + id);
		return "userId  : "+ id; 
	}
	
}
