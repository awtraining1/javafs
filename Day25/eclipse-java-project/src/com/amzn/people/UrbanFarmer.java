package com.amzn.people;

public class UrbanFarmer extends Thread {
	private String farmerName;
	private short age;

	public UrbanFarmer(String name, short age) {
		this.farmerName = name;
		this.age = age;
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

	public void harvest() {
		for (int i = 0; i < 10; i++) {
			System.out.printf("%s harvesting %s-th fruit.. \n", this.farmerName, i);
			try {
				Thread.sleep(1000);// 1ms
			} catch (InterruptedException e) {
				System.out.println("caught exp : " + e.getMessage());
			}
		}
	}

	@Override
	public void run() {
		// System.out.printf("%s printing from thread.. \n",this.farmerName);
		harvest();
	}

}
