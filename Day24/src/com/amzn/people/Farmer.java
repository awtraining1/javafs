package com.amzn.people;

import java.io.FileWriter;
import java.io.IOException;
import java.util.Date;

import com.amzn.exceptions.UnsuitableFarmerAgeException;
import com.amzn.exceptions.UnsuitableFarmerNameException;

/*
 * A class that represents Farmer
 * @Author : Ash
 */

// final keyword for class means NO ONE CAN SUBLCLASS Farmer class

public final class Farmer {
	// Attributes or instance variable (having non local scope)
	private String name;
	private short age;
	private Date dob;
	private String type;
	private String address;
	protected String region = "Agra";

	private SheepDog sheepdog;

	// class variable
	public static int totalNoOfFarmers = 0;
	public static int totalInventory = 0;

	// Constructors
	// The no-arg constructor or "default" constructor
	// This constructor will always be there even though we don't see it.
	// But we can also code it.
	public Farmer() {
		totalNoOfFarmers++;

		sheepdog = new SheepDog();
	}

	public Farmer(String name, short age) 
			throws UnsuitableFarmerAgeException,UnsuitableFarmerNameException{
		
		this();// runs the default constructor
		
		// check if age is > 15 to prevent child labour
		if(age<15) throw new UnsuitableFarmerAgeException();
		
		//check if age is < 3 chars
		if(name.trim().length()<3) 
			throw new UnsuitableFarmerNameException("Farmer name should atleast 3 chars");
		
		this.name = name;
		this.age = age;
	}

	// all-args constructor
	Farmer(String name, short age, String type, String region, String address) 
			throws UnsuitableFarmerAgeException,UnsuitableFarmerNameException
	{
		// this();// runs the default constructor and then initialize all five args

		this(name, age);// runs the 2-arg constructor above

//		this.name = name;
//		this.age = age;	
		this.type = type;
		this.region = region;
		this.address = address;
	}
	// Constructors - End

	// instance Behaviors / Actions/ Operations/ Methods

	/* Harvest return a Fruit */
	public void harvest(int howMuch) {
		System.out.println("Harvested " + howMuch + " kilos of Mango");
		sowSeed();
	};

	private void sowSeed() {
		int noOfSeeds = 10;
		System.out.println("OK, I will sow the seed of name : !" + this.name);
	};

	void waterSupply() {
		System.out.println("Inside waterSupply() ");
		System.out.println(age); // ?? 21

		int noOfSeeds = 10;
		this.age = 77;

		System.out.println(age); // ?? 77
		System.out.println(this.age); // ?? 77
	}

	void sprayFertilizer() {
		System.out.println("Inside sprayFertilizer() " + age); // ?? 77
	}

	void sellProduce(int no) {
		addToInventory(no);// call to static method. That's ok, it is allowed
	}

	// class methods
	public static void addToInventory(int quantity) {
		totalInventory = totalInventory + quantity;
	}

	void feedSheepDog() {
		sheepdog.eat();
	}

	// Getter method for name
	public String getName() {
		/// some checks
		return this.name;
	}

	// setter for name
	public void setName(Wholesaler ws, String newName) {
		//// do some checks for Wholesaler ws
		// ws.provideYourPassword()

		this.name = newName;
	}

	// Getter method for age
	public int getAge() {
		return this.age;
	}

	@Override
	public String toString() {
		return "I am a farmer with name " + name + " with age " + age;
	}

	@Override
	public int hashCode() {		
		return age;
	}

	@Override
	public boolean equals(Object farmerObj) {
		if (farmerObj instanceof Farmer == false) return false;
		
		Farmer farmer = (Farmer) farmerObj;
		
		//Client req: two farmers are equal if they have same age
		if (this.age == farmer.age && this.name.equals(farmer.getName())  )
			return true;
		else
			return false;
	}
	
	@Override
	public void finalize() throws IOException {
		System.out.println(" Ha, I am("+ this.name +") terminated..");
		FileWriter fw = new FileWriter("a.txt");
		fw.write(" Ha, I am("+ this.name +") terminated..");
		fw.close();
		
	}

}
