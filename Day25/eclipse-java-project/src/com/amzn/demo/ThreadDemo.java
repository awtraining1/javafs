package com.amzn.demo;

import com.amzn.people.UrbanFarmer;

public class ThreadDemo {

	public static void main(String[] args) throws InterruptedException {
		Thread uf1 =  new UrbanFarmer("Shasi", (short) 34);
		Thread uf2 =  new UrbanFarmer("Jami", (short) 44);
		Thread uf3 =  new UrbanFarmer("Rani", (short) 36);
		Thread uf4 =  new UrbanFarmer("Prakash", (short)74);
		
		uf2.setName("UrbanFarmer Jami Thread");
		String str = String.format("Name of thread uf2 is %s", uf2.getName());
		System.out.println(str);
		str = String.format("Name of thread uf3 is %s", uf3.getName());
		System.out.println(str);
		
		uf1.start();// calling this method means we are scheduling the task(run method of the thread) on the CPU
		uf2.start();
		uf3.start();
		uf4.start();
		
		uf1.join(); // after this statement, main thread will wait for completion of uf1
		uf2.join(); // after this statement, main thread will wait for completion of uf2
		
		System.out.println(" Launched all threads ");
		
	}

}
