package com.amzn.fruits.exotic;

import com.amzn.fruits.Mango;

public class RaspuriMango extends Mango{
	int z=55;

	public RaspuriMango(){
		
	}
	
	RaspuriMango(String name){
		
	}	
	
	// cut() is inherited here from Mango since it is 
	// a protected method there
	// Let's make it public so that it can be invoked 
	// in the main class
	// Call super.cut(); so that super class Mango's cut()
	// code is executed
	// Essentially we are overriding cut() of Mango
//	@Override
//	public void cut() {
//		super.cut();
//		System.out.println("I am dancing,,,,");
//	};
	
	
	
	// signature of the below method is cut(int,int)
	public void cut(int speed, int howManyPieces) {
		super.cut();
		System.out.println("I am dancing,,,,");
	};
	
	@Override
	public void testMe() {
		System.out.println("I am in testMe of RaspuriMango");
	};
	
	// signature : cut(int)
	public void cut(int howManyPieces) {
		super.cut();
		System.out.println("cut(int howManyPieces) I am dancing,,,,");
	};
	
	// signature : cut(short)
		public void cut(short howManyPieces) {
			super.cut();
			System.out.println("cut(short howManyPieces) I am dancing,,,,");
		};
	
	// signature : cut(float, int)
		public void cut(float speed,int howManyPieces) {
			super.cut();
			System.out.println("I am dancing,,,,");
		};
		
		
	
	// makeJuice() is private in Mango so NOT inherited here
	
}
