package com.amzn.fruits;

import com.amzn.fruits.interfaces.IFruit;

public abstract class WildGauva implements IFruit {

	@Override
	public void cut() {
		System.out.println("cutting gauva..");
		
	}

	// 
	@Override	
	public abstract  void makeJuice();

}
