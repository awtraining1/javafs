package com.amzn.fruit_and_veg;

import com.amzn.fruits.interfaces.IFruit;

import com.amzn.fruits.interfaces.IVegetable;

public class Tomato implements IVegetable, IFruit {

	String name;
	String colour;
	String type;
	private Object weight;

	public void eat() {
		System.out.println("eat the tomato");
	}

	public void cook() {
		System.out.println("cook a tomato ");
	}

	@Override
	public void cut() {
		System.out.println("cutting the fruit");

	}

	@Override
	public void makeJuice() {
		System.out.println("makeJuice the fruit");
	}

	@Override
	public void washVeg() {		
		System.out.println("washing the veg");
	}

	@Override
	public void makeCurry() {
		System.out.println("curring the veg");
		
	}
	
	@Override
	public boolean equals(Object tomatoObj)
	{
		
		if(tomatoObj instanceof Tomato==false)
			return false;
		
		Tomato tomato=(Tomato) tomatoObj;
		
		if( ( this.colour).equals(tomato.colour) 
				&& this.weight.equals(tomato.weight)  )
			    return true;
		else
			 return false;
		
	}

}