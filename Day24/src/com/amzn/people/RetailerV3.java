package com.amzn.people;

import java.util.List;

import com.amzn.logistics.Basket;

public class RetailerV3 implements Runnable {
	private String retailerName;
	private short age;
	Basket fruitBasket;

	public RetailerV3(String name, short age, Basket fruitBasket) {
		this.retailerName = name;
		this.age = age;
		this.fruitBasket = fruitBasket;
	}

	public void buyFruitsFromFarmer() throws InterruptedException {
		while (true) {			

			int fruitInt = fruitBasket.removeFruit();
			System.out.printf("%s bought %s-th fruit.. \n", this.retailerName, fruitInt);

			Thread.sleep(1000);
		}
	}

	@Override
	public void run() {
		try {
			buyFruitsFromFarmer();
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

}
