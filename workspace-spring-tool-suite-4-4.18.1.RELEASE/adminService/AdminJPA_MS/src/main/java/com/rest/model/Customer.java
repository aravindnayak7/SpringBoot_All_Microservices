package com.rest.model;



import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Id;

@Entity
public class Customer {
	@Id
	@GeneratedValue
	public int roomId;
    public String details;
	public String roomName;
	public String capacity;
	public String location;
	public String price;
	public String imgurl;
	public String duration;
	public String Starttime;
	public String EndTime;
	public String numberofRooms;
	public String email;
	public String checkin;
	public int getRoomId() {
		return roomId;
	}
	public void setRoomId(int roomId) {
		this.roomId = roomId;
	}
	public String getDetails() {
		return details;
	}
	public void setDetails(String details) {
		this.details = details;
	}
	public String getRoomName() {
		return roomName;
	}
	public void setRoomName(String roomName) {
		this.roomName = roomName;
	}
	public String getCapacity() {
		return capacity;
	}
	public void setCapacity(String capacity) {
		this.capacity = capacity;
	}
	public String getLocation() {
		return location;
	}
	public void setLocation(String location) {
		this.location = location;
	}
	public String getPrice() {
		return price;
	}
	public void setPrice(String price) {
		this.price = price;
	}
	public String getImgurl() {
		return imgurl;
	}
	public void setImgurl(String imgurl) {
		this.imgurl = imgurl;
	}
	public String getDuration() {
		return duration;
	}
	public void setDuration(String duration) {
		this.duration = duration;
	}
	public String getStarttime() {
		return Starttime;
	}
	public void setStarttime(String starttime) {
		Starttime = starttime;
	}
	public String getEndTime() {
		return EndTime;
	}
	public void setEndTime(String endTime) {
		EndTime = endTime;
	}
	public String getNumberofRooms() {
		return numberofRooms;
	}
	public void setNumberofRooms(String numberofRooms) {
		this.numberofRooms = numberofRooms;
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	public String getCheckin() {
		return checkin;
	}
	public void setCheckin(String checkin) {
		this.checkin = checkin;
	}
	@Override
	public String toString() {
		return "Customer [roomId=" + roomId + ", details=" + details + ", roomName=" + roomName + ", capacity="
				+ capacity + ", location=" + location + ", price=" + price + ", imgurl=" + imgurl + ", duration="
				+ duration + ", Starttime=" + Starttime + ", EndTime=" + EndTime + ", numberofRooms=" + numberofRooms
				+ ", email=" + email + ", checkin=" + checkin + "]";
	}
	
}
