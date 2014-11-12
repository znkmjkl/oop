package com.hotel.impl;

public class Person {

	private String firstName;
	private String secondName;
	private String email;
	private String address;

	public Person(String firstName, String secondName, String email, String address) {
		this.firstName = firstName;
		this.secondName = secondName;
		this.email = email;
		this.address = address;
	}
	
	public Person() { }

	public String getFirstName() {
		return firstName;
	}

	public String getSecondName() {
		return secondName;
	}

	public String getEmail() {
		return email;
	}

	public String getAddress() {
		return address;
	}

	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}

	public void setSecondName(String secondName) {
		this.secondName = secondName;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public void setAddress(String address) {
		this.address = address;
	}
}
