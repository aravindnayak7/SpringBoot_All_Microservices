package com.ioc.xml.model;

public class Address {
	private int addId;
	private String city;
	private String country;
	public Address(int addId, String city, String country) {
		super();
		this.addId = addId;
		this.city = city;
		this.country = country;
	}
	public int getAddId() {
		return addId;
	}
	public void setAddId(int addId) {
		this.addId = addId;
	}
	public String getCity() {
		return city;
	}
	public void setCity(String city) {
		this.city = city;
	}
	public String getCountry() {
		return country;
	}
	public void setCountry(String country) {
		this.country = country;
	}
	@Override
	public String toString() {
		return "Address [addId=" + addId + ", city=" + city + ", country=" + country + "]";
	}
}
