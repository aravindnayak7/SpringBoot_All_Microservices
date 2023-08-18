package com.rest.model;

import jakarta.persistence.Entity;
//import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Id;

@Entity
public class RegisterUser {
	@Id	
	private String email;
	private String firsname;
	private String lastname;
	private String mobilenum;
	private String password;
	private String gender;
	private int age;
	public RegisterUser() {
		super();
		// TODO Auto-generated constructor stub
	}
	public RegisterUser(String email, String firsname, String lastname, String mobilenum, String password,
			String gender, int age) {
		super();
		this.email = email;
		this.firsname = firsname;
		this.lastname = lastname;
		this.mobilenum = mobilenum;
		this.password = password;
		this.gender = gender;
		this.age = age;
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	public String getFirsname() {
		return firsname;
	}
	public void setFirsname(String firsname) {
		this.firsname = firsname;
	}
	public String getLastname() {
		return lastname;
	}
	public void setLastname(String lastname) {
		this.lastname = lastname;
	}
	public String getMobilenum() {
		return mobilenum;
	}
	public void setMobilenum(String mobilenum) {
		this.mobilenum = mobilenum;
	}
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}
	public String getGender() {
		return gender;
	}
	public void setGender(String gender) {
		this.gender = gender;
	}
	public int getAge() {
		return age;
	}
	public void setAge(int age) {
		this.age = age;
	}
	@Override
	public String toString() {
		return "RegisterUser [email=" + email + ", firsname=" + firsname + ", lastname=" + lastname + ", mobilenum="
				+ mobilenum + ", password=" + password + ", gender=" + gender + ", age=" + age + "]";
	}
	
}
