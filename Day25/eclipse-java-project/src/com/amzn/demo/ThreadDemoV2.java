package com.amzn.demo;

import com.amzn.people.UrbanFarmerV2;

public class ThreadDemoV2 {

	// Thread demo by using Runnable objects
	public static void main(String[] args) {		

		UrbanFarmerV2 uf1 = new UrbanFarmerV2("Shasi V2", (short) 34);
		Thread tuf1 = new Thread(uf1);
		
		UrbanFarmerV2 uf2 = new UrbanFarmerV2("Jami V2", (short) 44);
		Thread tuf2 = new Thread(uf2);
		
		UrbanFarmerV2 uf3 = new UrbanFarmerV2("Rani V2", (short) 36);
		Thread tuf3 = new Thread(uf3);
		
		UrbanFarmerV2 uf4 = new UrbanFarmerV2("Prakash V2", (short)74);
		Thread tuf4 = new Thread(uf4);
		
		tuf1.start();
		tuf2.start();
		tuf3.start();
		tuf4.start();	
		
		System.out.println("End of main thread ");
	}

}
