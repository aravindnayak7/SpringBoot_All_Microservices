package com.rest.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import java.util.*;

import com.rest.exception.EmployeeNotFoundException;
import com.rest.model.Employee;
import com.rest.service.EmployeeService;

import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.SignatureAlgorithm;
import jakarta.servlet.ServletException;

@RestController
@RequestMapping("auth/v1")
public class empAuthController {
	private Map<String,String> map= new HashMap<>();
	@Autowired
	private EmployeeService empservice;
	//creating collection object hash map 
	//hash map obj
	@GetMapping("/")
	public String serverStarted() {
		return "Authentication Server Started";
	}
	@PostMapping("/login")
	public ResponseEntity<?> doLogin(@RequestBody Employee emp){
		try {
			String jwtToken=generateToken(emp.getEmpName(), emp.getPassword());
			map.put("message", "User Successfully loggedIn");
			map.put("token",jwtToken);
			
		}catch(Exception e) {
			map.put("message",e.getMessage());
			map.put("token", null);
			return new ResponseEntity<>(map,HttpStatus.UNAUTHORIZED);
		}
		return new ResponseEntity<>(map,HttpStatus.OK);
	}
	private String generateToken(String empname, String password) throws ServletException, EmployeeNotFoundException{
		String jwtToken = "";
		if(empname == null || password==null) {
			throw new ServletException("Please send valid empname and password");
		}
		//validate user against db
		boolean flag = empservice.validateEmployee(empname, password);
		if(!flag) {
			throw new ServletException("Invalid Credentials");
		}else {
			jwtToken = Jwts.builder()
						.setSubject(empname)
						.setIssuedAt(new Date())
						.setExpiration(new Date(System.currentTimeMillis() + 3000000))
						.signWith(SignatureAlgorithm.HS256, "secret key")
						.compact();
		}
		return jwtToken;
	}
}
