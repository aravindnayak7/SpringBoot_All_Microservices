package com.rest;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.web.servlet.FilterRegistrationBean;
import org.springframework.context.annotation.Bean;

import com.rest.filter.JWTFilter;

@SpringBootApplication
public class HackathonMockTestApplication {

	public static void main(String[] args) {
		SpringApplication.run(HackathonMockTestApplication.class, args);
	}
//	@Bean
//	public FilterRegistrationBean jwtFilter() 
//	{
//		FilterRegistrationBean filterRegistrationBean = new FilterRegistrationBean();
//		filterRegistrationBean.setFilter(new JWTFilter());
//		filterRegistrationBean.addUrlPatterns("/api/v1/*");
//		return filterRegistrationBean;
//	}
}
