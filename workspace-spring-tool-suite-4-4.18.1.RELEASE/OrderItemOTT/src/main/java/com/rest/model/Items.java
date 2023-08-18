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
	private String price;
	private String imageurl;
	public Items() {
		super();
		// TODO Auto-generated constructor stub
	}
	public Items(int productId, String category, String productname, String price, String imageurl) {
		super();
		this.productId = productId;
		this.category = category;
		this.productname = productname;
		this.price = price;
		this.imageurl = imageurl;
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
	public String getPrice() {
		return price;
	}
	public void setPrice(String price) {
		this.price = price;
	}
	public String getImageurl() {
		return imageurl;
	}
	public void setImageurl(String imageurl) {
		this.imageurl = imageurl;
	}
	@Override
	public String toString() {
		return "Items [productId=" + productId + ", category=" + category + ", productname=" + productname + ", price="
				+ price + ", imageurl=" + imageurl + "]";
	}
	
}
