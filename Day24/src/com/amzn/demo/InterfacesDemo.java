package com.amzn.demo;

import com.amzn.fruit_and_veg.Tomato;
import com.amzn.fruits.Apple;
import com.amzn.fruits.Mango;
import com.amzn.fruits.WildGauva;
import com.amzn.fruits.interfaces.IFruit;
import com.amzn.fruits.interfaces.IVegetable;

public class InterfacesDemo {

	public static void main(String[] args) {
		
		Mango m1 = new Mango();
		
		Apple a1 = new Apple();
		
		Tomato t1 = new Tomato();
		
		//// Better way of assigning object types
		IFruit m2 = new Mango(); // cut() makeJuice() types()
		m2.cut();
		m2.makeJuice();		
		// will NOT compile m2.types(); because types method is not avl in IFruit		
		
		IFruit a2 = new Apple();
		
		System.out.println("/n.The Tomatoes.");
		
		IFruit t2 = new Tomato();
		t2.cut();
		t2.makeJuice();
		// will NOT compile t2.cook(); because cook method is not avl in IFruit
		
		IVegetable t3 = new Tomato();
		t3.washVeg();
		t3.makeCurry();
	
		// will NOT compile t3.makeJuice(); because makeJuice method is not avl in IVegetable
		
		Tomato t4= (Tomato) t3;
		System.out.println("Typecasting the Veg Tomato as Tomato.");
		t4.cook();
		
		IFruit t5= (IFruit) t3;
		t5.cut();
		
		Mango mango1 = (Mango) t3;
		mango1.types();
		
		//IFruit wG1 = new WildGauva();
	}

}
