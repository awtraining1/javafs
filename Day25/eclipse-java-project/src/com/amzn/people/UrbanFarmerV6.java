package com.amzn.people;

import com.amzn.logistics.Basket;
import com.amzn.logistics.BasketV6;

public class UrbanFarmerV6 implements Runnable {

	private String farmerName;
	private short age;
	BasketV6 fruitBasket;

	public UrbanFarmerV6(String name, short age, BasketV6 fruitBasket) {
		this.farmerName = name;
		this.age = age;
		this.fruitBasket = fruitBasket;
	}


	public String getFarmerName() {
		return farmerName;
	}

	public void setFarmerName(String farmerName) {
		this.farmerName = farmerName;
	}

	public short getAge() {
		return age;
	}

	public void setAge(short age) {
		this.age = age;
	}

	public void harvest() throws InterruptedException {
		int i=0;
		while (true) {			
			
			//String str = String.format("%s harvesting %s-th fruit.. \n", this.farmerName, i);
			System.out.println(this.farmerName +" harvesting " + i +"-th fruit.." );
			
//			if(i>10)
//			Thread.currentThread().stop();
			
			fruitBasket.addFruit(i++);
			
			Thread.sleep(1000);// 1ms
		}
	}

	@Override
	public void run() {
		// System.out.printf("%s printing from thread.. \n",this.farmerName);
		try {
			harvest();
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

}
