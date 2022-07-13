package com.amzn.demo;

import com.amzn.logistics.Basket;
import com.amzn.people.RetailerV3;
import com.amzn.people.UrbanFarmerV3;

public class ThreadDemoV4 {
	
	public static void main(String[] args) {
		//main0(args) ;// // Demo basic stuff like priority, stopping a thread
		main1(args) ;// Thread from lambda expressions.
	}
	
	public static void main1(String[] args) {
		
		Runnable mythread1 = () -> {
			for(int i=0;i<10;i++) System.out.println("mythread1 "+i);
		};
		
		Runnable mythread2 = () -> {
			for(int i=0;i<10;i++) System.out.println("mythread2 "+i);
		};
		
		Thread tuf1 = new Thread(mythread1);
		tuf1.start();
		Thread tuf2 = new Thread(mythread2);
		tuf2.start();
		
	}
	
	public static void main0(String[] args) {
		Basket basket = new Basket();// shared resource

		UrbanFarmerV3 uf1 = new UrbanFarmerV3("Shasi V3", (short) 34, basket);
		Thread tuf1 = new Thread(uf1);
		UrbanFarmerV3 uf2 = new UrbanFarmerV3("Manja V3", (short) 56, basket);
		Thread tuf2 = new Thread(uf2);

		RetailerV3 retailer1 = new RetailerV3("retailer-1 V3", (short) 74, basket);
		Thread tRetailer1 = new Thread(retailer1);

		RetailerV3 retailer2 = new RetailerV3("retailer-2 V3", (short) 33, basket);
		Thread tRetailer2 = new Thread(retailer2);

		// Setting priority
		tuf1.setPriority(10);
		tuf2.setPriority(1);
		// On windows OS, setting priority has effect.
		// However on Realtime OS, priority will have effect

		tuf1.start();
		tuf2.start();
		tRetailer1.start();
		tRetailer2.start();

		int i = 100000;
		while (i-- > 100)
			;

//		tuf1.stop();
		tRetailer1.stop();

		tRetailer1.start();// won't work. We cannot re-start threads.
		// We cannot restart a Thread that has completed its run() method.
		//

	}

}
