package com.amzn.demo;

import com.amzn.logistics.Basket;
import com.amzn.people.RetailerV3;
import com.amzn.people.UrbanFarmerV3;

public class ThreadDemoV3 {

	public static void main(String[] args) {
		Basket basket = new Basket();// shared resource

		UrbanFarmerV3 uf1 = new UrbanFarmerV3("Shasi V3", (short) 34, basket);
		Thread tuf1 = new Thread(uf1);
		UrbanFarmerV3 uf2 = new UrbanFarmerV3("Manja V3", (short) 56, basket);
		Thread tuf2 = new Thread(uf2);

		RetailerV3 retailer1 = new RetailerV3("retailer-1 V3", (short) 74, basket);
		Thread tRetailer1 = new Thread(retailer1);
		
		RetailerV3 retailer2 = new RetailerV3("retailer-2 V3", (short) 33, basket);
		Thread tRetailer2 = new Thread(retailer2);

		tuf1.start();
		tuf2.start();
		tRetailer1.start();		
		tRetailer2.start();

	}
	
	

}
