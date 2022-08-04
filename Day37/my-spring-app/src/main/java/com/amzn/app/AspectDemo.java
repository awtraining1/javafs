package com.amzn.app;

import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.context.annotation.ComponentScan;

import com.amzn.beans.Address;
import com.amzn.beans.Farmer;
import com.amzn.beans.Retailer;
import com.amzn.beans.WholeSaler;


public class AspectDemo {

	public static void main(String[] args) {


		AnnotationConfigApplicationContext context = new AnnotationConfigApplicationContext(ProjectConfig.class);

		
		Retailer retailer1 = context.getBean( Retailer.class);
		retailer1.setName("Sameer");
		retailer1.PQRasasa("Sameer",8);
		retailer1.PQRasasa("Sameer");
		
		WholeSaler ws1 = context.getBean( WholeSaler.class);
		ws1.setName("Raju");
		//ws1.setAge(1000); // this method throws a RT exception therefore out aspect @Afterthrowing will run		
	
		ws1.getName();
	}

}
