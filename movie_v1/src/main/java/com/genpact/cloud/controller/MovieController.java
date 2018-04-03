package com.genpact.cloud.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

@RestController
public class MovieController {
//	@Autowired
//	private EurekaClient eurekaClient;
//	@Autowired
//	private DiscoveryClient discoveryClient;
	@Autowired
	private RestTemplate restTemplate;
	
	@GetMapping("movie/user/{id}")
	public String findById(@PathVariable("id") String id) {
		String result = restTemplate.getForObject("http://USER-V1/user/"+id, String.class);
		return result + " from  Movie"; 
	}
}
