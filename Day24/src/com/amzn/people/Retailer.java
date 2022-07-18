package com.amzn.people;

import java.io.Serializable;
import java.util.Date;

public class Retailer implements Serializable{
	private String name;
	private short age;
	private Date dob;
	
	public Retailer(String name, short age) {
		this.name = name;
		this.age = age;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public short getAge() {
		return age;
	}

	public void setAge(short age) {
		this.age = age;
	}

	public Date getDob() {
		return dob;
	}

	public void setDob(Date dob) {
		this.dob = dob;
	}
	
	
	
}
