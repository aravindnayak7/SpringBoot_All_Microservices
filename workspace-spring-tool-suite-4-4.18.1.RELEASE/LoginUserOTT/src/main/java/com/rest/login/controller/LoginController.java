package com.rest.login.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;

import java.util.Date;
import java.util.HashMap;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.rest.login.fienclient.ConsumerRegister;
import com.rest.login.model.User;

import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.SignatureAlgorithm;
import jakarta.servlet.ServletException;

import java.util.Map;
@RestController
@RequestMapping("auth/user")

public class LoginController {
	private Map<String,String> map = new HashMap<>();
	@Autowired
	private ConsumerRegister consumerservice; 
	@GetMapping("/")
	public String serverStarted() {
		return "Authentication Server Started";
	}
	@PostMapping("/authUser")
	public ResponseEntity<?> doLogin(@RequestBody User user){
		try {
			String jwtToken = generateToken(user);
		
			map.put("message", "User Successfully LoggedIn");
			
			map.put("token", jwtToken);
		
		} catch (Exception e) {
			map.put("message", e.getMessage());
			map.put("token", null);
			return new ResponseEntity<>(map,HttpStatus.UNAUTHORIZED);
		}
		
		return new ResponseEntity<>(map,HttpStatus.OK);
	}
	private String generateToken(User user) throws ServletException 
	{
		String jwtToken = "";
		if(user.getEmail() == null || user.getPassword() == null) {
			throw new ServletException("Please send valid username and password");
		}
	
		boolean flag = 	consumerservice.validateUserHandler(user);
		if(!flag)
			throw new ServletException("Invalid Credentials");
		else {
			jwtToken = Jwts.builder()
					        .setSubject(user.getEmail())
					        .setIssuedAt(new Date())
					        .setExpiration(new Date(System.currentTimeMillis() + 3000000))
					        .signWith(SignatureAlgorithm.HS256, "secret key")
					        .compact();
		}
		return jwtToken;
	}
}
