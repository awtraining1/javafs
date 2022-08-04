package com.amzn.app;

import java.util.List;

import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import com.amzn.beans.Farmer;
import com.amzn.spring.dao.FarmerDAO;
import com.amzn.spring.dao.FarmerDAOImpl;

public class SpringJDBCDemoUsingH2 {

	public static void main(String[] args) {
		AnnotationConfigApplicationContext context = new AnnotationConfigApplicationContext(ProjectConfig.class);
		
		FarmerDAO farmerDAO = context.getBean(FarmerDAOImpl.class);
		
		farmerDAO.createFarmerTable(); // create the FARMER Table
		
		Farmer f1 = new Farmer("Raghu", 77);
		Farmer f2 = new Farmer("Partha", 67);
		
		farmerDAO.createFarmer(f1);
		farmerDAO.createFarmer(f2);
		
		//verify we get two rows from the table
		List<Farmer> farmerList = farmerDAO.getAllFarmers();
		System.out.format("\n List of Farmers in the FARMER Table");
		for(Farmer f: farmerList) {
			System.out.format("\n %s %s", f.getName(), f.getAge());
		}
		

	}

}
