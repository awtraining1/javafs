package com.amzn.beans;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class WholeSaler {
	String name;
	int age;
	int licenceId;
	
	@Autowired
	Address address;
	
	// @Component classes should mandatorily have the no-arg constructor
	public WholeSaler() {
		
	}
	
	public WholeSaler(String name,int age, int licenceId, Address address  ) {
		this.name=name;
		this.age=age;
		this.address=address;
		this.licenceId=licenceId;
	};
	
	public Address getAddress() {
		return address;
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
	
	public int getLicenceId() {
		return licenceId;
	}
	
}
