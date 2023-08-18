package com.rest.model;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Id;

@Document
public class Customer {
	@Id
	private int bookingId;
	private String firstName;
	private String password;
	private String email;
	
	public Customer() {
		
		// TODO Auto-generated constructor stub
	}
	public Customer(int bookingId, String firstName, String password, String email) {
		super();
		this.bookingId = bookingId;
		this.firstName = firstName;
		this.password = password;
		this.email = email;
	}
	public int getBookingId() {
		return bookingId;
	}
	public void setBookingId(int bookingId) {
		this.bookingId = bookingId;
	}
	public String getFirstName() {
		return firstName;
	}
	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	@Override
	public String toString() {
		return "Customer [bookingId=" + bookingId + ", firstName=" + firstName + ", password=" + password + ", email="
				+ email + "]";
	}
	
}
