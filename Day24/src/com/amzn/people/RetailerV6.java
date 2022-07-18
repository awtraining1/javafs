package com.amzn.people;

import java.util.List;

import com.amzn.logistics.Basket;
import com.amzn.logistics.BasketV6;

public class RetailerV6 implements Runnable {
	private String retailerName;
	private short age;
	BasketV6 fruitBasket;

	public RetailerV6(String name, short age, BasketV6 fruitBasket) {
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
