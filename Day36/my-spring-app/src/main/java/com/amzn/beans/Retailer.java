package com.amzn.beans;

import java.time.Duration;
import java.time.Instant;

import org.springframework.stereotype.Component;

@Component
public class Retailer {
	String name;
	int age;
	int licenceId;
	
	// @Component classes should mandatorily have the no-arg constructor
	public Retailer() {	
	}
	
	public Retailer(String name,int age, int licenceId ) {
		this.name=name;
		this.age=age;
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
	
	public void PQRasasa(String s,int i) {
	}
	
	public void PQRasasa(String s) {
		//return 200;
	}
	
}
