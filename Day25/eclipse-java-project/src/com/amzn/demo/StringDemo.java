package com.amzn.demo;

public class StringDemo {

	public static void main(String[] args) {
		String s1="abc";
		String s2= new String("abc");
		
		boolean sameStrings = s1==s2;
		System.out.println(sameStrings);
		
		String s3="abc";
		sameStrings = s1==s3;
		System.out.println(sameStrings);
		
		String s4="abc1";
		sameStrings = s1==s4;
		System.out.println(sameStrings);
		
		String s5= new String("abc");
		
		sameStrings = s2==s5;
		System.out.println(sameStrings);
		
		// To compare the actual content, use .equals( ) method
		// or
		// .equalsIgnoreCase( )
		sameStrings = s1.equals(s2);
		System.out.println(sameStrings); // true
		
		sameStrings = s5.equals(s2);
		System.out.println(sameStrings); // true
		
		
		// lexicographical comparison returns +ve or -ve or 0
		System.out.println("lexicographical comparisons ");
		String ss1="ABC";String ss2="acc";String ss3="ABC";
		int i = ss2.compareTo(ss1);
		System.out.println("ss2.compareTo(ss1) " + i) ;//		returns 32
		i = ss2.compareToIgnoreCase(ss1);
		System.out.println("ss2.compareToIgnoreCase(ss1) " + i);// returns 1
	
		i = ss1.compareToIgnoreCase(ss3);
		System.out.println("ss1.compareToIgnoreCase(ss3) "+i);
		
		// Splitting a string 
		System.out.println("Splitting a string  ");
		String str="apple,mango,banana";
		String[] fruits= str.split(","); // delimiter is ,
		
		for(String f: fruits)
			System.out.println(f);
		
		// trim a string
		String appleStr = "    apple   is a fruit    ";
		System.out.println(appleStr.trim());
		
		// replacing chars in a str
		System.out.println("replacing chars a string  ");
		System.out.println(appleStr.replace("a", "1"));
		System.out.println(appleStr.trim().replace("a", "5"));
		
		// substring of a string
		System.out.println("\n substring of a string  ");
		String roseStr= "Rose is a flower";
		System.out.println(roseStr.substring(10));//flower
		
		// charAt(index)
		
		// toLowerCase and toUpperCase
		
		//Can you write code for properCase() methods now?
		
		// Immutability of String
		System.out.println("\n Immutability of String  ");
		String iceStr = new String("ice");
		System.out.format("\n iceStr before = %s",	iceStr);
		iceStr = iceStr.toUpperCase();
		//System.out.format("\n iceStr = %s",	capIcseStr);	
		System.out.format("\n iceStr after = %s",	iceStr);// ice or ICE??	
		
	}

}
