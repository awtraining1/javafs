package com.amzn.app;

import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.context.annotation.ComponentScan;

import com.amzn.beans.Address;
import com.amzn.beans.Farmer;
import com.amzn.beans.Retailer;
import com.amzn.beans.WholeSaler;


public class App {

	public static void main(String[] args) {
//		Farmer f1 = new Farmer("Partha", 110);

		AnnotationConfigApplicationContext context = new AnnotationConfigApplicationContext(ProjectConfig.class);

		// Farmer f1 = context.getBean( Farmer.class); NoUniqueBean exception
		
		Farmer f1 = context.getBean("abc", Farmer.class);
		System.out.format("\n Farmer name is %s and age = %s", f1.getName(), f1.getAge());

		Farmer f2 = context.getBean("abc2", Farmer.class);
		System.out.format("\n Farmer name is %s and age = %s", f2.getName(), f2.getAge());

		Farmer f3 = context.getBean("Sujata33Farmer", Farmer.class);
		System.out.format("\n Farmer name is %s and age = %s", f3.getName(), f3.getAge());

		Farmer f5 = context.getBean( Farmer.class); // we will get the primary bean if one exists
		System.out.format("\n Farmer name is %s and age = %s", f5.getName(), f5.getAge());
		
		//Retailer is a @Component annotated class, so no need for a @Bean method 
		// for it the @configuration class
		Retailer retailer1 = context.getBean( Retailer.class);
		retailer1.setName("Sameer");
		System.out.format("\n Retailer name is %s, age = %s, license = ",
				retailer1.getName(), retailer1.getAge(), retailer1.getLicenceId());	
		
		// 35B - Create Mango class annotated with @Component 
		// and then an Mango instance using Sp FW context 
		
	//Address addr1 = context.getBean( Address.class); 
	//System.out.format("\n Created one address with doorNumber %s",addr1.getDoorNumber());
//		WholeSaler ws1 = context.getBean( WholeSaler.class);
//		ws1.setAddress(addr1);
//		System.out.format("\n WholeSaler name is %s, age = %s, license = , address = %s",
//				ws1.getName(), ws1.getAge(), ws1.getLicenceId(),ws1.getAddress() );	
		
		
		WholeSaler ws1 = context.getBean( WholeSaler.class);
//		System.out.format("\n WholeSaler ws1 name is %s, age = %s, license = %s, address = %s",
//				ws1.getName(), ws1.getAge(), ws1.getLicenceId(),ws1.getAddress().getDoorNumber() );	
	
		System.out.format("\n WholeSaler ws1 address is = %s",
				ws1.getAddress().getDoorNumber());	
	
	
	}

}
