package com.amzn.demo;

import com.amzn.fruits.Mango;
import com.amzn.fruits.exotic.RaspuriMango;

public class DynamicBindingDemo {

	public static void main(String[] args) {
		Mango rp = new RaspuriMango();
		
		System.out.println(rp.z);// 10 ? or 55?
		
		rp.testMe();

	}

}
