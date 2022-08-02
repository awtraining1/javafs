package com.mycompany.designpatterns;

public class SingletonDemo {

	public static void main(String[] args) {
//		A  a1 = new A(); // compile error
//
//		A  a2 = new A(); // compile error
//		A  a3 = new A(); // compile error
		
		A  a1 = A.createInstance();
		
		A  a2 = A.createInstance();
		A  a3 = A.createInstance();
		
		if(a1==a2) {
			System.out.println("a1 and a2 point to same object");
		}
		
		if(a1==a3) {
			System.out.println("a1 and a3 point to same object");
		}

	}

}

