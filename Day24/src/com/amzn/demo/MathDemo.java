package com.amzn.demo;

import java.util.Random;

public class MathDemo {
	public static void main(String[] args) {
	double a = Math.PI; 
	System.out.println( a); 
	System.out.println( Math.round(a)); 
	System.out.println( Math.abs(a)); 
	System.out.println( Math.ceil(a)); 
	System.out.println(Math.exp(0)); 
	System.out.println( Math.floor(a)); 
	System.out.println( Math.max(a,4.5)); 
	System.out.println( Math.min(a,4.5)); 
	System.out.println("Power = " + Math.pow(10,3)); 
	System.out.println( Math.sqrt(49)); 
	
	// Random number
	System.out.println(Math.random());
	
	Random random = new Random();
	random.setSeed(1000000L);
	System.out.println(random.nextInt());
	System.out.println(random.nextInt());
	
	
	}

}
