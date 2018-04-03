package com.genpact.cloud.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;


@RestController
public class UserController {
	
	@GetMapping("user/{id}")
	public String findById(@PathVariable("id") String id) {
		return "userId  : "+ id; 
	}
	
}
