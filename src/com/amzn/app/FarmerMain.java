package com.amzn.app;

import com.amzn.exceptions.UnsuitableFarmerAgeException;
import com.amzn.exceptions.UnsuitableFarmerNameException;
import com.amzn.fruits.Mango;
import com.amzn.fruits.exotic.AlphonsoMango;
import com.amzn.fruits.exotic.RaspuriMango;
import com.amzn.people.Farmer;
import com.amzn.people.Wholesaler;

public class FarmerMain {
	
	public static void main(String[] args) {
		// demo creating 4 farmers in the try block
		// Because Farmer 2 arg constructor is throwing 
		// checked exception UnsuitableFarmerAgeException
		mainWholeSaler(args);
		//
	}

	public static void mainWholeSaler(String[] args) {
		//System.out.println("Inside mainWholeSaler");
		Wholesaler wholesaler1 = new Wholesaler("Pradeep",987654321,"pradeep@some.com");
		
		System.out.println(wholesaler1.getYearOfLicense() );
		
		Farmer farmer1 = null, farmer2 = null, farmer3 = null, farmer4 = null;
		try {
		System.out.println("Creating farmers 1 2 3 4  in the try block ");
		 farmer4 = new Farmer("Lo", (short) 34);
		 farmer1 = new Farmer("Lokesh1", (short) -1);
		 farmer2 = new Farmer("Lokesh2", (short) 24);
		 farmer3 = new Farmer("Lokesh3", (short) 3);
		
		}catch(UnsuitableFarmerAgeException ex) {
			System.out.printf("\n Failed creating farmer %s \n",ex.getMessage());
		}catch(UnsuitableFarmerNameException ex) {
			System.out.printf("\n Failed creating farmer %s \n",ex.getMessage());
		}
		
		wholesaler1.addFarmer(farmer1);
		wholesaler1.addFarmer(farmer2);
		wholesaler1.addFarmer(farmer3);
		wholesaler1.addFarmer(farmer4);
		
		System.out.println(wholesaler1.displayMyDetails());
		
		Wholesaler wholesaler2 = new Wholesaler();
		wholesaler2.name = "ws2";
		
		
		
		///some 100 lines
		wholesaler1.name="asasa"; //FREELY
		wholesaler2.name = "qqqqqq";
	}
	
	public static void main1(String[] args) {
		Mango m1 = new Mango();

//		m1.cut();
//		m1.makeJuice();
		//m1.types();
		
		System.out.println("/n***RASPURI****");
		RaspuriMango rm1 =  new RaspuriMango();
		rm1.name="RaspuriBLR";
		
		short someNum = 100;		
		rm1.cut((byte)1); //100 will go as int and not as short
//		rm1.makeJuice();
		rm1.types();
		
		System.out.println("/n***ALPHONSO****");
		AlphonsoMango am1 =  new AlphonsoMango();
//		am1.color = "Red";
//		am1.cut();
//		am1.makeJuice();
		am1.types();
	}
	
	
	public static void mainOriginal(String[] args) {

		System.out.println("Welcome to A2Z Fruit Market");
		
		System.out.println("Total Farmers : " + Farmer.totalNoOfFarmers);
		
				
		// Demo of creating an instance of Farmer class,
		// and setting its attributes
		// and calling its methods.
		Farmer farmer1 = new Farmer();
		
		
		System.out.println("Total Farmers after creating farmer1: " + farmer1.totalNoOfFarmers);
		System.out.println("Total Farmers : " + Farmer.totalNoOfFarmers);
		
		System.out.println("Total Inventory : " + Farmer.totalInventory);
		
//		farmer1.name = "Kishore";
//		farmer1.age = 57;
//		farmer1.address = "29, 4th, Vishakapatnam";
//		farmer1.type = "Organic";
//		farmer1.region = "Coastal";
		
		System.out.println("Farmer 1 Adding 120 to inventory");
		farmer1.addToInventory(120);
		System.out.println("Total Inventory : " + Farmer.totalInventory);
		
		farmer1 = null;
//		farmer1.harvest(10);
//		farmer1.sowSeed();
//		
//		farmer1.waterSupply();
//		farmer1.sprayFertilizer();
		
		// Demo of creating an instance of Farmer class,
		// using the 2 arg constructor
		//short age1=34;
		Farmer farmer2 = new Farmer("Lokesh", (short) 34);

		System.out.println("Total Farmers after creating farmer2 : " + farmer2.totalNoOfFarmers);
		System.out.println("Total Farmers : " + Farmer.totalNoOfFarmers);
		
		System.out.println("Farmer 2 Adding 160 to inventory");
		farmer2.addToInventory(160);
		System.out.println("Total Inventory : " + Farmer.totalInventory);
		
		System.exit(0);
		farmer2.harvest(20);
//		farmer2.sowSeed();
		
		// Demo of creating an instance of Farmer class,
		// using the all-arg constructor
		// Farmer farmer3 = 

		// Demo of creating an instance of Mango class.
		System.out.println("=======================");

		Mango m1 = new Mango();

		m1.cut();
		m1.makeJuice();
		m1.types();

	}

}
