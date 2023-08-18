package com.rest.filter;

import java.io.IOException;

import org.springframework.web.filter.GenericFilterBean;

import io.jsonwebtoken.Claims;
import io.jsonwebtoken.Jwts;
import jakarta.servlet.FilterChain;
import jakarta.servlet.GenericFilter;
import jakarta.servlet.ServletException;
import jakarta.servlet.ServletRequest;
import jakarta.servlet.ServletResponse;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

public class JWTFilter extends GenericFilterBean{// i have created  a class JWT and it is extending generic filter bean 
	@Override
	//this.generic filter providing the method DO FILTER
	//do filter taking parameter to handle requests and response, Filter chain for chaining operation
	//this method can throw IOException and servlet Exception
	
	public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain) throws IOException,ServletException
	{
		
		HttpServletRequest httpRequest = (HttpServletRequest) request;//we have created object of the http servlet request
		HttpServletResponse httpResponse = (HttpServletResponse) response;//here HttpServletRequest and Response 
		String authHeader = httpRequest.getHeader("authorization");//here authHeader is a string variable and it is taking some http request,   take the value of authorization 
		//whenever u making request some extra information will be going with it
		//in the header template we have the area of authorization also
		System.out.println("AuthHeader" + authHeader);
		if(authHeader == null || !authHeader.startsWith("Bearer"))//take the value of authorization 
		{
			throw new ServletException("Missing or Invalid Authentication Header");
		}
		String jwtToken = authHeader.substring(7);//here we're creating a string variable JWT token
		//taking substring from the authentication header
		//after the 7 character
		//i'll cut 7 char and i'll take remaining value
		//that remaining value will token :)
		//after that we use JWT parser
		Claims claims = Jwts.parser().setSigningKey("secret key").parseClaimsJws(jwtToken).getBody();
		httpRequest.setAttribute("empname", claims);
		//we will take everything and assign to the claims
		//claims which containing the complete token 
		//with the userdetail 
		chain.doFilter(request, response);
		//above will the JWT filter
	}
}