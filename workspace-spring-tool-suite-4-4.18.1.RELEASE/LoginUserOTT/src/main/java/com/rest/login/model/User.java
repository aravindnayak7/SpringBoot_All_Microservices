package com.rest.login.model;

public class User {
	private String email;
	private String firstname;
	private String lastname;
	private String mobilenum;
	private String password;
	private String gender;
	private int age;
	public User() {
		super();
		// TODO Auto-generated constructor stub
	}
	public User(String email, String firstname, String lastname, String mobilenum, String password, String gender,
			int age) {
		super();
		this.email = email;
		this.firstname = firstname;
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
	public String getFirstname() {
		return firstname;
	}
	public void setFirstname(String firstname) {
		this.firstname = firstname;
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
		return "User [email=" + email + ", firstname=" + firstname + ", lastname=" + lastname + ", mobilenum="
				+ mobilenum + ", password=" + password + ", gender=" + gender + ", age=" + age + "]";
	}
	
}
