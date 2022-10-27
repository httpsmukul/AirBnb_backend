package com.air.demo;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.core.env.Environment;

@SpringBootApplication
public class AirbnbCloneApplication {






	public static void main(String[] args) {
		SpringApplication.run(AirbnbCloneApplication.class, args);
		System.out.println("hey its working ==>");
	}

}
