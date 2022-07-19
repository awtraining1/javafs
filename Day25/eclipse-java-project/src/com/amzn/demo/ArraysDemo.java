package com.amzn.demo;

import java.util.Arrays;

import com.amzn.people.Farmer;

public class ArraysDemo {

	public static void main(String[] args) {
		// intArrayDemo();
		// stringArrayDemo();
		objectArrayDemo();
	}

	public static void intArrayDemo() {
		// demo of int array

		// if data is already there with us
		// decl and initializing the array in one statement
		int[] marks = { 1, 4, 21 };

		int[] marks1 = new int[4]; // decl only
		///
		marks1[0] = 11;
		marks1[1] = 23;
		marks1[2] = 6;
		marks1[3] = 203;

		// Access a particular element of the array
		System.out.println(marks1[2]);

		// Iterating the array
		System.out.println("a. Array iteration");
		for (int i = 0; i < marks.length; i++) {
			System.out.print("/t" + marks[i]);
		}

		System.out.println("/nb. Array iteration");
		for (int x : marks) {
			System.out.print("/t" + x);
		}

		// Just printing the contents
		System.out.println("/nc. Array contents");
		System.out.println(Arrays.toString(marks1));

	}

	public static void stringArrayDemo() {
		// if data is already there with us
		// decl and initializing the array in one statement
		String[] marks = { "Adi", "John", "Wick" };

		String[] marks1 = new String[4];
		///
		marks1[0] = "rohan";
		marks1[1] = "bilbo";
		marks1[2] = "frodo";
		marks1[3] = "Aragorn";

		// Access a particular element of the array
		System.out.println(marks1[2]);

		// Iterating t
		System.out.println("a. Array iteration");
		// Iterating the array
		System.out.println("a. Array iteration");
		for (int i = 0; i < marks.length; i++) {
			System.out.print("/t" + marks[i]);
		}

		System.out.println("/nb. Array iteration");
		for (String x : marks1) {
			System.out.print("/t" + x);
		}
	}
	
	public static void objectArrayDemo() {
		Farmer[] farmersOfAP=new Farmer[4];
 		
		farmersOfAP[0]  = new Farmer("Lokesh1", (short) 34);
		farmersOfAP[1]  = new Farmer("Lokesh2", (short) 34);
		farmersOfAP[2]  = new Farmer("Lokesh3", (short) 34);
		farmersOfAP[3]  = new Farmer("Lokesh4", (short) 34);
 		System.out.print(Arrays.toString(farmersOfAP)); //print # value i.e memory address
 		
 		// display farmer names
 		System.out.println("Farmer names");
 		for(Farmer f: farmersOfAP ) {
 			System.out.println("name=" + f.getName() + " and age="+ f.getAge());
 		}
		
	}
	

}
