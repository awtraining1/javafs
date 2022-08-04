package com.amzn.beans;

import java.sql.ResultSet;
import java.sql.SQLException;

import org.springframework.jdbc.core.RowMapper;

public class RetailerMapper implements RowMapper<Retailer> {

	public Retailer mapRow(ResultSet resultSet, int i) throws SQLException {

		Retailer retailer = new Retailer();
		
		retailer.setName(resultSet.getString("name"));
		retailer.setAge(resultSet.getInt("age"));
		retailer.setLicenceId(resultSet.getInt("license_id"));
		
		return retailer;
	}
}
