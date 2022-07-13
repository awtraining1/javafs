package com.amzn.demo;

import com.amzn.logistics.BasketV6;
import com.amzn.people.RetailerV6;
import com.amzn.people.UrbanFarmerV6;

// Demo of replacing "synchronized" with Lock objects
public class ThreadDemoV6 {

	public static void main(String[] args) {
		BasketV6 basket = new BasketV6();// shared resource

		UrbanFarmerV6 uf1 = new UrbanFarmerV6("Shasi V3", (short) 34, basket);
		Thread tuf1 = new Thread(uf1);
		UrbanFarmerV6 uf2 = new UrbanFarmerV6("Manja V3", (short) 56, basket);
		Thread tuf2 = new Thread(uf2);

		RetailerV6 retailer1 = new RetailerV6("retailer-1 V3", (short) 74, basket);
		Thread tRetailer1 = new Thread(retailer1);
		
		RetailerV6 retailer2 = new RetailerV6("retailer-2 V3", (short) 33, basket);
		Thread tRetailer2 = new Thread(retailer2);

		tuf1.start();
		tuf2.start();
		tRetailer1.start();		
		tRetailer2.start();

	}

}
