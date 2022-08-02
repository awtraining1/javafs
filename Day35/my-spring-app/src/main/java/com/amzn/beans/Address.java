package com.amzn.beans;

import org.springframework.stereotype.Component;

@Component
public class Address {
	int doorNumber;
	
	public Address() {
		this.doorNumber = 777;
	}
	
	public Address(int doorNumber) {
		this.doorNumber= doorNumber;
	}
	
	public int getDoorNumber() {
		return doorNumber;
	}
	
}
