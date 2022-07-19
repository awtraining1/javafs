package com.amzn.demo;

public class TypeCastingDemo {
	
	public static void main(String args[]) {
		
		short s1= 10;
		
		int i = s1;
		
		// can we store a bugger size variable in smaller one. NO
		int i1 = 10;
		// short s2=i1; // compile error
		
		// But we downsize the bigger variable to the smaller and store
		// That is typecasting
		short s2 = (short) i1;
		byte b1 =  (byte) i1;
		
		
		double f = 1.097d;
		int x = (int) f;
		
		//boolean y = (boolean) f;  COMP ERROR
		
		String str =" Hello World";
		// int z = (int) str; COMP ERROR
		
		
	}

}
