package com.mycompany.designpatterns;

public class FactoryPatternDemo {

	public static void main(String[] args) {
		
		// Assumption : You have a interface called Fruit
		// and there are 3 class that implement Fruit
		// Mango Apple and Tomato
		
		//Following is not recommended
//		Mango  a1 = new Mango(); //
//		Apple  a2 = new Apple(); 
//		Tomato  a3 = new Tomato(); 
		
		// Instead create a factory class that will create these fruits.
		Mango  a1 = (Mango) FruitFactory.createFruit("Mango");
		Apple  a2 = (Apple) FruitFactory.createFruit("Apple");
	

	}

}

