package com.amzn.fruits;

import com.amzn.fruits.interfaces.IFruit;

/*
 * Author: Arati Kad
 */

public class Apple implements IFruit {

	@Override
	final public void cut() {
		System.out.println("cutting apple...");
	}

	@Override
	public void makeJuice() {

		System.out.println("making apple juice... ");
	}

}