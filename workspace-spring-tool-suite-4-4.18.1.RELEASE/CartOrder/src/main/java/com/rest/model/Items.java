package com.rest.model;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Id;

@Entity
public class Items {
	@Id
	@GeneratedValue
	private int productId;
	private String category;
	private String productname;
	private int price;
	private String imageurl;
	private String username;
	private String address;
	private String Date;
	private String state;
	private String pincode;
	private String mobilenum;
	private int quantity;
	private int total;
	public Items() {
		super();
		// TODO Auto-generated constructor stub
	}
	public Items(int productId, String category, String productname, int price, String imageurl, String username,
			String address, String date, String state, String pincode, String mobilenum, int quantity, int total) {
		super();
		this.productId = productId;
		this.category = category;
		this.productname = productname;
		this.price = price;
		this.imageurl = imageurl;
		this.username = username;
		this.address = address;
		Date = date;
		this.state = state;
		this.pincode = pincode;
		this.mobilenum = mobilenum;
		this.quantity = quantity;
		this.total = total;
	}
	public int getProductId() {
		return productId;
	}
	public void setProductId(int productId) {
		this.productId = productId;
	}
	public String getCategory() {
		return category;
	}
	public void setCategory(String category) {
		this.category = category;
	}
	public String getProductname() {
		return productname;
	}
	public void setProductname(String productname) {
		this.productname = productname;
	}
	public int getPrice() {
		return price;
	}
	public void setPrice(int price) {
		this.price = price;
	}
	public String getImageurl() {
		return imageurl;
	}
	public void setImageurl(String imageurl) {
		this.imageurl = imageurl;
	}
	public String getUsername() {
		return username;
	}
	public void setUsername(String username) {
		this.username = username;
	}
	public String getAddress() {
		return address;
	}
	public void setAddress(String address) {
		this.address = address;
	}
	public String getDate() {
		return Date;
	}
	public void setDate(String date) {
		Date = date;
	}
	public String getState() {
		return state;
	}
	public void setState(String state) {
		this.state = state;
	}
	public String getPincode() {
		return pincode;
	}
	public void setPincode(String pincode) {
		this.pincode = pincode;
	}
	public String getMobilenum() {
		return mobilenum;
	}
	public void setMobilenum(String mobilenum) {
		this.mobilenum = mobilenum;
	}
	public int getQuantity() {
		return quantity;
	}
	public void setQuantity(int quantity) {
		this.quantity = quantity;
	}
	public int getTotal() {
		return total;
	}
	public void setTotal(int total) {
		this.total = total;
	}
	@Override
	public String toString() {
		return "Items [productId=" + productId + ", category=" + category + ", productname=" + productname + ", price="
				+ price + ", imageurl=" + imageurl + ", username=" + username + ", address=" + address + ", Date="
				+ Date + ", state=" + state + ", pincode=" + pincode + ", mobilenum=" + mobilenum + ", quantity="
				+ quantity + ", total=" + total + "]";
	}
	
}
