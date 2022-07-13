package com.amzn.demo;

import java.io.FileWriter;
import java.io.IOException;
import java.util.InputMismatchException;
import java.util.Scanner;

public class ExceptionsDemo {

	public static void main(String[] args) throws IOException {
//		main1(args); // Scenario 1
//		main2(args); // Scenario 2
		// main3(args);// Scenario 3
//		main4(args);// Scenario 4
		main5(args);// Scenario 5
		
		main6(args);
	}
	
	// Scenario 6: Instead of catching the exception, 
	// let's tell that our method throws that checked exception
	public static void main6(String[] args) throws IOException{
		FileWriter fw=null;
		fw = new FileWriter("aabcx.txt");
		fw.write("Inside main5...");
		fw.close();
	}
	
	
	// Scenario 5: Working with Checked exceptions.
	// Instantiating FileWriter can throw IOException,
	// which is a checked exception.
	// Therefore compiler will warn us if we don't wrap that statement in a 
	// try catch block! OR (Scenario 6) declare your method throws exception
	public static void main5(String[] args) {
		FileWriter fw=null;
		try {
			fw = new FileWriter("aabcx.txt");
			fw.write("Inside main5...");
		} catch (IOException ex) {
			System.out.printf("\n Something went wrong! Check if the file exist and it writable  ");
			System.out.printf("\n Exception reason "+ ex.getMessage());	
		}	
		finally {
			try {
				fw.close();
			} catch (IOException e) {
				e.printStackTrace();
			}
		}		
	}
	
	// Scenario 4: try catch with OPTIONAL finally block
	// Speciality about finally is that it will always execute, 
	// whether exceptions happened or not!!
	
	public static void main4(String[] args) {
		int salary = 1000;

		Scanner scanner = new Scanner(System.in);

		System.out.printf("Input no of days:");
		int noOfdays = 0;
		int amountPerDay = 0;
		
		try {			
			noOfdays = scanner.nextInt();			
			amountPerDay = salary / noOfdays;
		} catch (InputMismatchException ex) {
			System.out.printf("\n Please input numbers only ");
			System.out.printf("\n Exception reason "+ ex.getMessage());	
			
			ex.printStackTrace();

		} catch (ArithmeticException ex) {
			System.out.printf("\n Please input positive numbers only ");
			System.out.printf("\n Exception reason "+ ex.getMessage());	
		}catch (Exception ex) {	
			System.out.printf("\n Something went wrong! Contact admin  ");
			System.out.printf("\n Exception reason "+ ex.getMessage());	
		}		
		finally {
			System.out.printf("\n Inside finally block ");
		}
		
		System.out.printf("\n amountPerDay is %s", amountPerDay);

		scanner.close();
	}

	// Scenario 3: compact form scenario 2
	// We can have a try block that has statements
	// throwing different exceptions in different lines
	// For such try we can have multiple catch blocks.
	// NOTE: If an exceptions happens in statement 1, then no lines (statements)
	// below that statement 1 will execute !
	// Control will immediately go to the appropriate catch block.
	// and exit the try block

	// RULE: If catching multiple exception types, then order them
	// such that sub class exceptions are caught first and then their super classes
	public static void main3(String[] args) {
		int salary = 1000;

		Scanner scanner = new Scanner(System.in);

		System.out.printf("Input no of days:");
		int noOfdays = 0;
		int amountPerDay = 0;
		
		try {			
			noOfdays = scanner.nextInt();			
			amountPerDay = salary / noOfdays;			
		} catch (InputMismatchException ex) {
			System.out.printf("\n Please input numbers only ");
		} catch (ArithmeticException ex) {
			System.out.printf("\n Please input positive numbers only ");
		}
		
		
		// Above can also be coded even more compactly as below
		try {			
			noOfdays = scanner.nextInt();			
			amountPerDay = salary / noOfdays;			
		} catch (InputMismatchException | ArithmeticException  ex) {
			if(ex instanceof InputMismatchException)
			System.out.printf("\n Please input numbers only ");
			else
				if(ex instanceof ArithmeticException)
					System.out.printf("\n Please input positive numbers only ");
		}

		System.out.printf("\n amountPerDay is %s", amountPerDay);

		scanner.close();

	}

	// Scenario 2: Now that we know exceptions can occur
	// let's handle those exceptions
	public static void main2(String[] args) {
		int salary = 1000;

		Scanner scanner = new Scanner(System.in);

		System.out.printf("Input no of days:");
		int noOfdays = 0;
		try {
			noOfdays = scanner.nextInt();
		} catch (InputMismatchException ex) {
			System.out.printf("\n Please input numbers only ");
		}

		int amountPerDay = 0;
		try {
			amountPerDay = salary / noOfdays;
		} catch (ArithmeticException ex) {
			System.out.printf("\n Please input positive numbers only ");
		}

		System.out.printf("\n amountPerDay is %s", amountPerDay);

		scanner.close();
	}

	@SuppressWarnings("resource")
	// Scenario 1: Try input of 31 28 0 a for
	// noOfdays in the above statement
	// What happens when you input 0?
	// What happens when you input a? or some other string abc
	public static void main1(String[] args) {
		int salary = 1000;

		Scanner scanner = new Scanner(System.in);

		System.out.printf("Input no of days. Pls enter a number :");
		int noOfdays = scanner.nextInt();

		int amountPerDay = salary / noOfdays;

		System.out.printf("\n amountPerDay is %s", amountPerDay);

		scanner.close();
	}

}
