package com.rest;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
//here if we remove this annotation it will not work
@SpringBootApplication
public class UserRestfulDemoApplication {

	public static void main(String[] args) {
		SpringApplication.run(UserRestfulDemoApplication.class, args);
	}

}
