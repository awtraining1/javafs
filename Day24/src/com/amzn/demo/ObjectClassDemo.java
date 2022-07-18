package com.amzn.demo;

import com.amzn.people.Farmer;

public class ObjectClassDemo {

	public static void main(String[] args) throws InterruptedException {
		System.out.println("ObjectClassDemo");
		Farmer farmer1 = new Farmer("Jack",(short)26);
		Farmer farmer2 = new Farmer("Pran",(short)46);
		Farmer farmer3 = new Farmer("Jack",(short)46);
		
		String farmerStr = farmer1.toString();
		
		// demo that SOP of any object calls its toString() method.
		System.out.println(farmer1);		
		System.out.println(farmerStr);
		
		System.out.println(farmer2);
		
		
		//// hashcode demo
		System.out.println("\n printing hashcode ");
		System.out.println(farmer1.hashCode());
		System.out.println(farmer2.hashCode());
		System.out.println(farmer3.hashCode());
		
		// equality of objects demo
		System.out.println("\n printing equality of farmers ");
		System.out.println(farmer1.equals(farmer2)); // false
		System.out.println(farmer1.equals(farmer3));// false
		System.out.println(farmer2.equals(farmer3));// false?
		
		// finalize() of objects demo
		
		System.out.println("\n finalize called for the following farmers ");
		farmer1=null;		
		farmer2=null;
		farmer3=null;	
		System.gc(); // call the garbage collector		
				
		System.out.println("\n END ");	
		
	}

}
