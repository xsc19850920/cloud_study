package com.genpact.cloud;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.server.EnableEurekaServer;

@SpringBootApplication
@EnableEurekaServer
public class SimpleCloudServiceApplication {

	public static void main(String[] args) {
		SpringApplication.run(SimpleCloudServiceApplication.class, args);
	}
}
