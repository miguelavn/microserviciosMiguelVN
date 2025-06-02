package com.microservicemiguelvn.gateway;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;
import org.springframework.web.bind.annotation.CrossOrigin;

@CrossOrigin(origins = "http://localhost:3000/")
@EnableDiscoveryClient
@SpringBootApplication
public class MicroserviceGatewayApplication {

	public static void main(String[] args) {
		SpringApplication.run(MicroserviceGatewayApplication.class, args);
	}

}
