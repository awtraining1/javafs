package com.mycompany.app;

import java.io.IOException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import org.apache.pdfbox.pdmodel.PDDocument;
import org.apache.pdfbox.pdmodel.PDPage;

public class App {
	public static void main(String[] args) throws SQLException {
		// STEP 1 - Get a connection to the Database we want to connect
		Connection conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/amzn", "root", "rootroot");

		// STEP 2 create a statement object (this object represents SQL statements
		Statement stmt = conn.createStatement();

		// STEP 3 Execute our actual sql statements
		ResultSet rs = stmt.executeQuery("select * from FARMER");

		System.out.format("%s, %s, %s  %s\n","NAME","DOB","AGE","SALARY");
		System.out.format("---------------------------------\n");
		
		
//		while (rs.next()) {
//			System.out.format("Name %s\n", rs.getString(1)); // Print column1 (name) value as String
//			System.out.format("DOB %s\n", rs.getDate(2)); // Print column2 (dob) value as Date
//			System.out.format("Age %s\n", rs.getInt(3)); // Print column3 (age) value as int			
//		};
		
		//Fetch row data using column index
		while (rs.next()) {
			 System.out.format("%s, %s, %s\n", rs.getString(1), rs.getDate(2), rs.getInt(3) );			 
		};
		
		rs = stmt.executeQuery("select * from FARMER"); // executing the query again, because we already looped through once
		//Fetch row data using column name
		System.out.format("%s, %s, %s  %s\n","NAME","DOB","AGE","SALARY");
		System.out.format("---------------------------------\n");
		while (rs.next()) {			
			 System.out.format("%s, %s, %s, %s\n",
					 rs.getString("name"), rs.getDate("dob"), rs.getInt("age"), rs.getFloat("salary"));
		};
		
		//25B Using JDBC fetch all farmers whose age is >50 and <

		// Demo insert sqls
		System.out.format("\n\n--------------INSERT DEMO------------\n");
		//int rowCount = stmt.executeUpdate("insert into FARMER values ('Sujatha2', now(), 57, 987404178, 6001.1,'MP');"); 
		//System.out.format("%s were affected \n",rowCount); 
		// Insert multiple rows
//		String insert2Rows= "insert into FARMER values ('Sujatha3', now(), 57, 987424178, 6001.1,'MP');"
//		+ "insert into FARMER values ('Sujatha4', now(), 47, 287424178, 6001.1,'MP');";
//		int rowCount = stmt.executeUpdate(insert2Rows); 
//		System.out.format("%s were affected \n",rowCount); 
		
		// Demo update sqls
		System.out.format("\n\n--------------UPDATE DEMO------------\n");
		int updateCount = stmt.executeUpdate("UPDATE FARMER SET region='ASSAM' where region='MP' ");
				System.out.format("%s were affected \n",updateCount); 
				
		
	}

	public static void main0(String[] args) throws IOException {
		System.out.println("Hello World Day 20!");
		PDDocument pdfdoc = new PDDocument();
		pdfdoc.addPage(new PDPage());
		// path where the PDF file will be store
		pdfdoc.save("Sample.pdf");
		// prints the message if the PDF is created successfully
		System.out.println("PDF created");
		// closes the document
		pdfdoc.close();
	}
}
