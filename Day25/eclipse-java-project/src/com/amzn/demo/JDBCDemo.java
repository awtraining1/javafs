package com.amzn.demo;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class JDBCDemo {
	 

	public static void main(String[] args) throws SQLException {
		
		try {
			Class.forName("com.mysql.cj.jdbc.Driver").newInstance();
		} catch (InstantiationException | IllegalAccessException | ClassNotFoundException e) {
			System.err.println("Error loading JDBC driver" + e.getMessage());
		};
	
		// STEP 1 - Get a connection to the Database we want to connect
		Connection conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/amzn", "root", "rootroot");

		// STEP 2 create a statement object (this object represents SQL statements
		Statement stmt = conn.createStatement();

		// STEP 3 Execute our actual sql statements
		ResultSet rs = stmt.executeQuery("select * from FARMER");

		while (rs.next()) {

			System.out.format("Name %s\n", rs.getString(1)); // Print column1 (name) value as String
			System.out.format("DOB %s\n", rs.getDate(2)); // Print column2 (dob) value as Date
			System.out.format("Age %s\n", rs.getInt(3)); // Print column3 (age) value as int

		}
	}

}
