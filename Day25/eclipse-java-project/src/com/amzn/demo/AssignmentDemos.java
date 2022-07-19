package com.amzn.demo;

public class AssignmentDemos {

	public static void main(String[] args) {
		System.out.println("AssignmentDemos\n Diwakar's");
		//9A Diwakar		
		String str="peacock Is a biRd";
		String fi=str.substring(0,1);
		String re1=str.substring(1);
		fi=fi.toUpperCase();
		re1=re1.toLowerCase();
		String fi1=fi+re1;
		System.out.println(fi1);
		 
		System.out.println("\nAditya's");
		String s = "peacock Is A Bird";
	      s = s.toLowerCase();
	      String s1 = s.substring(0,1);
	      String re=s.substring(1);
	      s1 = s1.toUpperCase();
	      s = s1+re;
	      System.out.println(s);

	}

}
