package com.lcwd.service.registry;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.server.EnableEurekaServer;

@SpringBootApplication
@EnableEurekaServer

public class ServieResgistryApplication {

	public static void main(String[] args) {
		SpringApplication.run(ServieResgistryApplication.class, args);
	}

}
