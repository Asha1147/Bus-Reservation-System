package com.cg.Bus.bean;

public class BusBean {
	

	public String name;
	String email;
	String phoneno;
	int age;
	String gender;
	int noOfSeats;
	int seatno;
	int fare;
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	public String getPhoneno() {
		return phoneno;
	}
	public void setPhoneno(String phoneno) {
		this.phoneno = phoneno;
	}
	public int getAge() {
		return age;
	}
	public void setAge(int age) {
		this.age = age;
	}
	public String getGender() {
		return gender;
	}
	public void setGender(String gender) {
		this.gender = gender;
	}
	public int getNoOfSeats() {
		return noOfSeats;
	}
	public void setNoOfSeats(int noOfSeats) {
		this.noOfSeats = noOfSeats;
	}
	public int getSeatno() {
		return seatno;
	}
	public void setSeatno(int seatno) {
		this.seatno = seatno;
	}
	public int getFare() {
		return fare;
	}
	public void setFare(int fare) {
		this.fare = fare;
	}
	@Override
	public String toString() {
		return "BusBean [name=" + name + ", email=" + email + ", phoneno=" + phoneno + ", age=" + age + ", gender="
				+ gender + ", noOfSeats=" + noOfSeats + ", seatno=" + seatno + ", fare=" + fare + "]";
	}

	
	
	

}
