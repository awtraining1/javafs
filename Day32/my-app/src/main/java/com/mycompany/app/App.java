package com.mycompany.app;

import java.io.IOException;
import java.sql.CallableStatement;
import java.sql.Connection;
import java.sql.DatabaseMetaData;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.sql.Types;
import java.util.Scanner;

import org.apache.pdfbox.pdmodel.PDDocument;
import org.apache.pdfbox.pdmodel.PDPage;

public class App {
	
	public static void main(String[] args) throws SQLException {
		// main0(args);// Demo JDBC Connection and Statement object for QUERIES, INSERT and UPDATE
		// main1(args);// Demo Statement object for ANY any SQL statement
		Connection conn = DriverManager.getConnection("jdbc:mysql://127.0.0.1:3306/amzn", "root", "rootroot");
		
		// main2(conn); // Know more about the DB
		
		// main3(conn); // Demo PreparedStatement that accepts placeholder values
		// main3A(conn); // 26A
		// main3B(conn); // Demo batch insert
		// main4(conn); // Demo using CLOBS (character blob) datatype		
		// main5(conn); // Demo transactions		
		// main6(conn); // Demo calling stored procedures
		//main6A(conn); // 26B
		main7(conn); // programmatically creating a new database
		
		conn.close();
	};
	
	public static void main7(Connection conn) throws SQLException {
		Statement stmt = conn.createStatement();
		boolean isQuery = stmt.execute("DROP DATABASE MY_DB;");
		
		//if(!isQuery)
		System.out.println("Created database " + stmt.getUpdateCount());
	}
	
	public static void main6A(Connection conn) throws SQLException {
		//26B Try calling the other SP farmercount_byage (IN input_age INT, OUT farmers INT)
		CallableStatement csmt = conn.prepareCall("{call farmercount_byage(?,?)}");
		
		int farmerAge=25;
		csmt.setInt(1,farmerAge);// all farmers with age=90
		csmt.registerOutParameter(2, Types.INTEGER);
		
		csmt.execute();
		System.out.format("No of farmers with age %s : %s",farmerAge, csmt.getInt(2));
	}
	
	public static void main6(Connection conn) throws SQLException {
		// Demo calling stored procedures
		// Use farmer_total_salary(@total_salary) SP that we created other day.
		
		CallableStatement csmt = conn.prepareCall("{call farmer_total_salary(?)}");		
		
		csmt.registerOutParameter(1, Types.FLOAT);
		csmt.execute();
		
		System.out.format("Total farmer salary : %s",csmt.getFloat(1));
	}
	
	public static void main5(Connection conn) throws SQLException {
		//Demo transactions
		PreparedStatement psmt = 
				conn.prepareStatement("insert into FARMER values (?, now(), ?, ?, ?,?)");
		
		conn.setAutoCommit(false);
		try {
		/// insert 1
			psmt.setString(1,"Shaji1");
			psmt.setInt(2,55);
			psmt.setInt(3,111888654);
			psmt.setFloat(4,1500000);
			psmt.setString(5,"MAH");
			int nRows = psmt.executeUpdate();
			System.out.format(" %s rows afffected \n", nRows);
		
			/// insert 2 should fail because of unique constraint on phone
			// once it fails, rollback will happen of anything that was successful before it
			psmt.setString(1,"Shaji2");
			psmt.setInt(2,55);
			psmt.setInt(3,111888654);
			psmt.setFloat(4,1500000);
			psmt.setString(5,"MAH");
			
			nRows = psmt.executeUpdate();
			System.out.format(" %s rows afffected \n", nRows);
		/// insert 3
		/// insert 4
			conn.commit();
			System.out.println(" Committing ....");
		}catch(SQLException e) {
			System.out.println(" rolling back  ....");
			conn.rollback();
		}
	}
	
	public static void main4(Connection conn) throws SQLException {
		//Demo using CLOBS datatype
	}
	
	public static void main3B(Connection conn) throws SQLException {
		//Demo batch insert
		PreparedStatement psmt = 
				conn.prepareStatement("insert into FARMER values (?, now(), ?, ?, ?,?)");
		
		Scanner sc = new Scanner(System.in);
		
		int n=2;
		while (n-->0) {
			System.out.println("Enter name");
			psmt.setString(1,sc.next());
			System.out.println("Enter age");
			psmt.setInt(2,sc.nextInt());
			System.out.println("Enter phone no");
			psmt.setInt(3,sc.nextInt());
			System.out.println("Enter salary");
			psmt.setFloat(4,sc.nextFloat());
			System.out.println("Enter region");
			psmt.setString(5,sc.next());
			
			psmt.addBatch();			
		};	
		
		int[] nRows = psmt.executeBatch();	
		System.out.format(" %s rows afffected \n", nRows.length);		
	}
	
	public static void main3A(Connection conn) throws SQLException {
		//26A Use a Scanner to take farmer details input and a PStatement to insert four farmers
		PreparedStatement psmt = 
				conn.prepareStatement("insert into FARMER values (?, now(), ?, ?, ?,?)");
		
		Scanner sc = new Scanner(System.in);
		
		int n=2;
		while (n-->0) {
			////// DIY
			System.out.println("Enter name");
			psmt.setString(1,sc.next());
			System.out.println("Enter age");
			psmt.setInt(2,sc.nextInt());
			System.out.println("Enter phone no");
			psmt.setInt(3,sc.nextInt());
			System.out.println("Enter salary");
			psmt.setFloat(4,sc.nextFloat());
			System.out.println("Enter region");
			psmt.setString(5,sc.next());
			
			int nRows = psmt.executeUpdate();			
			System.out.format(" %s rows afffected \n", nRows);
		};		
		
	}
	
	public static void main3(Connection conn) throws SQLException {
		PreparedStatement psmt = 
				conn.prepareStatement("insert into FARMER values (?, now(), ?, ?, ?,?)");
		
		psmt.setString(1,"Sujatha6");
		psmt.setInt(2,55);
		psmt.setInt(3,977888654);
		psmt.setFloat(4,1500000);
		psmt.setString(5,"MAH");
		
		int nRows = psmt.executeUpdate();		
		
		System.out.format(" %s rows afffected \n", nRows);
		
		psmt.setString(1,"Sujatha7");
		psmt.setInt(2,55);
		psmt.setInt(3,966888654);
		psmt.setFloat(4,1500000);
		psmt.setString(5,"KAR");
		
		 nRows = psmt.executeUpdate();
		 System.out.format(" %s rows afffected \n", nRows);
	}
	
	public static void main2(Connection conn) throws SQLException {
		DatabaseMetaData  md = conn.getMetaData();
		System.out.format(" %s \n", md.getDatabaseProductName());
		System.out.format(" %s \n", md.getDatabaseProductVersion());	
		
		
		if(md.getDatabaseProductName().equalsIgnoreCase("MySQL")) {
			// write any sql statements that is a part of MYSQL
			System.out.println("--This is MYSQL DB ...");
		}else if(md.getDatabaseProductName().equalsIgnoreCase("Oracle")) {
			// write any sql statements that is a part of Oracle
			System.out.println("--This is Oracle DB ...");
		};
		
		System.out.println("---Avl Databases in DB Server---");
		ResultSet rs = md.getCatalogs();
		while (rs.next()) {
			 System.out.format("%s \n", rs.getString(1) );			 
		};
		
		// Research if it possible to know the list of tables of your database
		// Research if it possible to know the list of tables of some other database
		
	}
	
	
	
	public static void main1(String[] args) throws SQLException {
		Connection conn = DriverManager.getConnection("jdbc:mysql://127.0.0.1:3306/amzn", "root", "rootroot");

		Statement stmt = conn.createStatement();
		
		// TRY THIS : boolean sql_stmt_IS_Query = stmt.execute("CREATE TABLE TEMP_TABLE (fruit_name varchar(20) )");
		// TRY THIS NEXT: boolean sql_stmt_IS_Query = stmt.execute("DROP TABLE TEMP_TABLE");
		// TRY THIS NEXT: boolean sql_stmt_IS_Query = stmt.execute("select * from FARMER"); 
		 boolean sql_stmt_IS_Query = stmt.execute("update FARMER set age=90 where age=10"); 
		
		System.out.format("SQL statement succeeded : %s\n", sql_stmt_IS_Query);
		
		// If our sql  was a Query we can retrieve the result set
		if(sql_stmt_IS_Query==true) {
			ResultSet rs = stmt.getResultSet();
			
			while (rs.next()) {
				 System.out.format("%s, %s, %s\n", rs.getString(1), rs.getDate(2), rs.getInt(3) );			 
			};
		};
		
		// If our sql  was a insert/update we can retrieve the affected row count
		if(sql_stmt_IS_Query==false) {
			int noOfAffectedRows = stmt.getUpdateCount();
			System.out.format("%s rows updated \n",noOfAffectedRows);
		}

	}
	
	public static void main0(String[] args) throws SQLException {
		// STEP 1 - Get a connection to the Database we want to connect
		Connection conn = DriverManager.getConnection("jdbc:mysql://127.0.0.1:3306/amzn", "root", "rootroot");

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
				
		conn.close();	// make sure we close the connection after we are done with our job		
		
	}
	
//	public void SOF(String str0, String varStr1..){
//		
//	}

	
}
