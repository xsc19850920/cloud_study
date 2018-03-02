package com.genpact.cloud.controller;

import java.util.List;
import java.util.stream.Collectors;

import org.apache.commons.collections.CollectionUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cloud.client.ServiceInstance;
import org.springframework.cloud.client.discovery.DiscoveryClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import com.netflix.appinfo.InstanceInfo;
import com.netflix.discovery.EurekaClient;

@RestController
public class ServiceProviderController {
	@Autowired
	private EurekaClient eurekaClient;

	@Autowired
	private DiscoveryClient discoveryClient;

	@GetMapping("service_url")
	public String serviceUrl() {
		InstanceInfo instance = eurekaClient.getNextServerFromEureka("SERVICE_PROVIDER", false);
		return instance.getHomePageUrl();
	}

	@GetMapping("instance")
	public List<ServiceInstance> getServiceInstance() {
		List<ServiceInstance> list = null;
		if (CollectionUtils.isNotEmpty(discoveryClient.getServices())) {
			System.out.println("The number of services : " + discoveryClient.getServices().size());
			list = discoveryClient.getServices().stream().flatMap(serviceId -> discoveryClient.getInstances(serviceId).stream()).collect(Collectors.toList());
		}
		return list;
	}
}
