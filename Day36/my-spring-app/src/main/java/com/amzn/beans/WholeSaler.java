package com.amzn.beans;

import java.time.Duration;
import java.time.Instant;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class WholeSaler {
	String name;
	int age;
	int licenceId;

	@Autowired
	Address address;

	// Account acct;

	// @Component classes should mandatorily have the no-arg constructor
	public WholeSaler() {

	}

//	@Autowired
//	public WholeSaler(Address address) {
//		this.address = address;
//	}

	public WholeSaler(String name, int age, int licenceId, Address address) {
		this.name = name;
		this.age = age;
		this.address = address;
		this.licenceId = licenceId;
	};

	public Address getAddress() {
		return this.address;
	}

	public void setAddress(Address address) {
		this.address = address;
	}

	public void setName(String name) {		
		this.name = name;
	}

	public String getName() {
		return name;
	}

	public int getAge() {
		return age;
	}
	
	public void setAge(int age) {
		this.age=age;
		throw new RuntimeException();
	}

	public int getLicenceId() {
		return licenceId;
	}

}
