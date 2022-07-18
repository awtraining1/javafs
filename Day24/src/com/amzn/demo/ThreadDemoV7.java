package com.amzn.demo;

import java.util.Date;
import java.util.concurrent.Callable;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.Executor;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Future;

import com.amzn.fruits.Mango;

public class ThreadDemoV7 {

	public static void main(String[] args) throws InterruptedException, ExecutionException {
//		main0(args);//
//		main1(args);//CACHEABLE THREAD POOL DEMO
		
		main2(args);//Launch callable threads
	}
	
	
	public static void main2(String[] args) throws InterruptedException, ExecutionException {
		Callable<Mango> myCallableThread1 = () -> {
			System.out.println("Creating Thread 1");
			int i=0;
			for(i=0;i<10;i++) System.out.println(" CRITICAL  MESSAGE "+ "mythread1 "+i);
			
			return new Mango("totapuri","blue", 13);
		};
		
		ExecutorService  threadPool = Executors.newCachedThreadPool();
		
		Future<Mango> execution = threadPool.submit(myCallableThread1);
		threadPool.shutdown();
		
		while(!execution.isDone()) {
			// System.out.println(new Date() + " INFO MESSAGE "+ " Thread is still working..");
		};
		
		Mango j = execution.get();
	   System.out.printf("\n FATAL MESSAGE Callable Thread gave us mango of color: %s",  j.getColor());		
	}
	
	// CACHEABLE THREAD POOL DEMO
		public static void main1(String[] args) {		
			
			ExecutorService  threadPool = Executors.newCachedThreadPool();
			
			Runnable mythread1 = () -> {
				System.out.println("Creating Thread 1");;
				for(int i=0;i<2;i++) System.out.println("mythread1 "+i);
			};
			
			Runnable mythread2 = () -> {
				System.out.println("Creating Thread 2");
				for(int i=0;i<20;i++) System.out.println("mythread2 "+i);
			};
			
			threadPool.execute(mythread1);
			threadPool.execute(mythread2);
			threadPool.execute(mythread1); // Thread Pools can re-run(reuse) any thread
			threadPool.execute(mythread2);
			
			threadPool.shutdown();	
			
			// threadPool.execute(mythread1); 
			// exception above. once shutdown is called, threadpool will not accept 
			// execution of threads. 

		}
	// FIXED THREAD POOL DEMO
	public static void main0(String[] args) {
	
		int poolSize =2;// Our program will run max 2 thread from the pool.
		ExecutorService  threadPool = Executors.newFixedThreadPool(poolSize);
		
		Runnable mythread1 = () -> {
			for(int i=0;i<10;i++) System.out.println("mythread1 "+i);
		};
		
		Runnable mythread2 = () -> {
			for(int i=0;i<10;i++) System.out.println("mythread2 "+i);
		};
		
		threadPool.execute(mythread1);
		threadPool.execute(mythread2);
		threadPool.execute(mythread1); // Thread Pools can re-run(reuse) any thread
		threadPool.execute(mythread2);
		
		threadPool.shutdown();	
		
		// threadPool.execute(mythread1); 
		// exception above. once shutdown is called, threadpool will not accept 
		// execution of threads. 

	}

}
