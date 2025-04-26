package com.lcwd.user.service;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.openfeign.EnableFeignClients;

@SpringBootApplication(scanBasePackages={
		"com.lcwd.user.service", "com.lcwd.user.service.entities"})
@EnableFeignClients
public class UserServiceApplication {

	public static void main (String[] args) {
		SpringApplication.run(UserServiceApplication.class, args);
	}

}
