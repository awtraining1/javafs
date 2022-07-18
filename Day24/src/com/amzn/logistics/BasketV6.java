package com.amzn.logistics;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

public class BasketV6 {
	List<Integer> fruitList = new ArrayList<>();
	Lock mylock = new ReentrantLock();

	public void addFruit(int i) throws InterruptedException {
		System.out.printf("\n Inside addFruit for int %s", i);

		while (!fruitList.isEmpty()) {
			mylock.unlock();// release the lock
		}

		// T1 T2 T3
		try {
			mylock.lockInterruptibly(); // acquiring the lock
			fruitList.add(i);
		} catch(Exception e){
			
		}finally {
			mylock.unlock();
		}

	}

	public int removeFruit() throws InterruptedException {
//		System.out.printf("\n Inside removeFruit for int ");
		while (fruitList.isEmpty()) {
			mylock.unlock();// release the lock
		}
		;

		int i = 0;
		try {
			mylock.lockInterruptibly(); // acquiring the lock
			i = fruitList.remove(0);
		} catch(Exception e){
			
		}finally {
			mylock.unlock();
		}

		return i;
	}

	public boolean isEmpty() {
		return fruitList.isEmpty();
	}

}