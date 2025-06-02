package com.microservicemiguelvn.maintenance;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;

@EnableDiscoveryClient
@SpringBootApplication
public class MicroserviceMaintenanceApplication {

	public static void main(String[] args) {
		SpringApplication.run(MicroserviceMaintenanceApplication.class, args);
	}

}
