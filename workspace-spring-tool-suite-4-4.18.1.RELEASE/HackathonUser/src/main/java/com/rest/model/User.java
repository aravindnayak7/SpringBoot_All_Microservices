package com.rest.model;

import org.springframework.data.annotation.Id;

import jakarta.persistence.Entity;
//import jakarta.persistence.GeneratedValue;

@Entity
public class User {
	@Id
//	@GeneratedValue
	private int bookingId;
	private String name;
	private String address;
	private String accountnumber;
	private String mobileno;
	private String password;
	public int getBookingId() {
		return bookingId;
	}
	public void setBookingId(int bookingId) {
		this.bookingId = bookingId;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getAddress() {
		return address;
	}
	public void setAddress(String address) {
		this.address = address;
	}
	public String getAccountnumber() {
		return accountnumber;
	}
	public void setAccountnumber(String accountnumber) {
		this.accountnumber = accountnumber;
	}
	public String getMobileno() {
		return mobileno;
	}
	public void setMobileno(String mobileno) {
		this.mobileno = mobileno;
	}
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}
	@Override
	public String toString() {
		return "User [bookingId=" + bookingId + ", name=" + name + ", address=" + address + ", accountnumber="
				+ accountnumber + ", mobileno=" + mobileno + ", password=" + password + "]";
	}
	
}

