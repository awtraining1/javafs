package com.amzn.fruits;

import com.amzn.annotations.Aromatic;
import com.amzn.fruits.interfaces.IFruit;

@Aromatic(smell="sweety", ingredients={"vitamin-c","vitamin-a"})
public class Orange implements IFruit{	
	
	
	// @Aromatic ; compile error because Aromatic cannot be applied to Fields
	public String name;
	
	private String color;
	
	@Aromatic(smell="sweety", ingredients={"vitamin-c","vitamin-a"})
	public Orange(){
		
	}

	@Override	
	public void cut() {		
		
	}

	@Override
	@Aromatic(smell="salty",ingredients="vitamin-c", alcoholPercentage=25)
	public void makeJuice() {		
		
	}

}
