package com.rest.aspect;

import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.After;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Component;

import com.rest.model.Employee;

import ch.qos.logback.classic.Logger;

@Aspect
@Component
public class LoggingAspect {
	private static final Logger logger = LoggerFactory.getLogger(LoggingAspect.class);
	@Before(value="execustion(* com.rest.controller .EmployeeController.*(..)")//kind of expression i am creating target specific class Employee conteroller  under controller (methods with any number of parameter and args shouls be   
	public void beforeAdviceAll(JoinPoint joinpoint)
	{
		System.out.println("Before Method for All Execution "+joinpoint.getSignature());
		//add logger here 
		//this is just for displaying purpose
		logger.info("Methods executed successfully");
	}
	@Before(value="execustion(* com.rest.controller .EmployeeController.*(..) && args(eObj)")//kind of expression i am creating target specific class Employee conteroller  under controller (methods with any number of parameter and args shouls be   
	public void beforeAdvice(JoinPoint joinpoint, Employee Employeedb)
	{
		System.out.println("Before Method Execution "+joinpoint.getSignature());
		System.out.println("Creating the Employee object with following details ...");
		//add logger here 
		//this is just for displaying purpose
		logger.info("Creating the employee object with following details ...");
		logger.info("before Method execution"+joinpoint.getSignature());
		
	}
	@After(value="execustion(* com.rest.controller .EmployeeController.*(..) && args(eObj)")//kind of expression i am creating target specific class Employee conteroller  under controller (methods with any number of parameter and args shouls be   
	public void afterAdvice(JoinPoint joinpoint, Employee Employeedb)
	{
		System.out.println("After Method Execution "+joinpoint.getSignature());
		System.out.println("Creating the Employee object with following details ...");
		//add logger here 
		//this is just for displaying purpose
		logger.info("Creating the employee object with following details ...");
		logger.info("After Method execution"+joinpoint.getSignature());
		
	}
}
