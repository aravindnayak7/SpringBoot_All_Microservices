package com.rest.login;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.openfeign.EnableFeignClients;

@SpringBootApplication
@EnableFeignClients
public class LoginUserOttApplication {

	public static void main(String[] args) {
		SpringApplication.run(LoginUserOttApplication.class, args);
	}

}
