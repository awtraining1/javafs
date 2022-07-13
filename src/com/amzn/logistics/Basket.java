package com.amzn.logistics;

import java.util.ArrayList;
import java.util.List;

public class Basket {
	List<Integer> fruitList = new ArrayList<>();

	public void addFruit(int i) throws InterruptedException {
		System.out.printf("\n Inside addFruit for int %s", i);

		synchronized (this) {
			while (!fruitList.isEmpty()) {
				wait();
			}
			;

			// T1 T2 T3
			fruitList.add(i);

			notifyAll();
		}
		;
	}

	public synchronized int removeFruit() throws InterruptedException {
//		System.out.printf("\n Inside removeFruit for int ");
		while (fruitList.isEmpty()) {
			wait(); // release lock
		}
		;

		int i = fruitList.remove(0);
		notifyAll();

		return i;
	}

	public boolean isEmpty() {
		return fruitList.isEmpty();
	}

}
