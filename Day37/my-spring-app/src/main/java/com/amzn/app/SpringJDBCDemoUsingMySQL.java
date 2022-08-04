package com.amzn.app;

import java.util.List;

import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import com.amzn.beans.Farmer;
import com.amzn.beans.Retailer;
import com.amzn.spring.dao.FarmerDAO;
import com.amzn.spring.dao.FarmerDAOImpl;
import com.amzn.spring.dao.RetailerDAO;
import com.amzn.spring.dao.RetailerDAOImpl;

public class SpringJDBCDemoUsingMySQL {

	public static void main(String[] args) {
		AnnotationConfigApplicationContext context = new AnnotationConfigApplicationContext(ProjectConfig.class);

		RetailerDAO retailerDAO = context.getBean(RetailerDAOImpl.class);

		//Retailer f11 = new Retailer("Raghu_RetailerQQQQQQQQQQQQQQQQQQQQQQQQQQQQ", 77, 101);
		//Retailer f22 = new Retailer("Partha_Retailer", 67, 102);

		//int rowCount = retailerDAO.createRetailer(f11);
		//System.out.format(" Retailer inserted count ? %s ",rowCount); 
		//retailerDAO.createRetailer(f22);

		// verify we get two rows from the table
		List<Retailer> retailerList = retailerDAO.getAllRetailers();

		System.out.format("\n List in the RETAILER Table");
		System.out.format("\n -----------------------------------");
		for (Retailer f : retailerList) {
			System.out.format("\n %s, %s, %s", f.getName(), f.getAge(), f.getLicenceId());
		};
		
		Retailer f22 = new Retailer("Partha_Retailer", 67, 102);
		retailerDAO.deleteRetailer(f22);
		
		System.out.format("\\\n List after deleting  Partha_Retailer in the RETAILER Table");
		System.out.format("\n -----------------------------------");
		retailerList = retailerDAO.getAllRetailers();
		for (Retailer f : retailerList) {
			System.out.format("\n %s, %s, %s", f.getName(), f.getAge(), f.getLicenceId());
		};

	}

}
