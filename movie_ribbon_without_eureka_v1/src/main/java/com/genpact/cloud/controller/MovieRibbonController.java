package com.genpact.cloud.controller;

import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cloud.client.ServiceInstance;
import org.springframework.cloud.client.loadbalancer.LoadBalancerClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

@RestController
public class MovieRibbonController {
	private Logger LOG = Logger.getLogger(MovieRibbonController.class);
//	@Autowired
//	private EurekaClient eurekaClient;
//	@Autowired
//	private DiscoveryClient discoveryClient;
	@Autowired
	private RestTemplate restTemplate;
	
	@Autowired
	private LoadBalancerClient loadBalancerClient;
	
	@GetMapping("movie/user/{id}")
	public String findById(@PathVariable("id") String id) {
		String result = restTemplate.getForObject("http://user-v1/user/"+id, String.class);
		return result + " from  Movie"; 
	}
	
	@GetMapping("movie/userwithouteureka/{id}")
	public String findByIdForWithOutEureka(@PathVariable("id") String id) {
		ServiceInstance user1 = loadBalancerClient.choose("user-v1");
		return String.format("%s -> %s:%s" ,user1.getServiceId(),user1.getHost() ,  user1.getPort());
	}
	
	@GetMapping("movie/test")
	public String test() {
		
		ServiceInstance user1 = loadBalancerClient.choose("user-v1");
		
		ServiceInstance user2 = loadBalancerClient.choose("user-v2");
		
		LOG.info(String.format("%s -> %s:%s" ,user1.getServiceId(),user1.getHost() ,  user1.getPort()));
		LOG.info(String.format("%s -> %s:%s" ,user2.getServiceId(),user2.getHost() ,  user2.getPort()));
		return " success"; 
	}
}
