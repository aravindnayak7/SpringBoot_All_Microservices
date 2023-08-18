package com.rest.model;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Id;
@Entity
public class User {
	@Id
	@GeneratedValue
	private int userid;
	private String userName;
	private String password;
	private String email;
	
	public User() {
		super();
		// TODO Auto-generated constructor stub
	}
	
	public User(int userid, String userName, String password, String email) {
		super();
		this.userid = userid;
		this.userName = userName;
		this.password = password;
		this.email = email;
	}

	public int getUserid() {
		return userid;
	}
	public void setUserid(int userid) {
		this.userid = userid;
	}
	public String getUserName() {
		return userName;
	}
	public void setUserName(String userName) {
		this.userName = userName;
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
		return "User [userid=" + userid + ", userName=" + userName + ", password=" + password + ", email=" + email
				+ "]";
	}
	
	
}
