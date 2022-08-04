package com.amzn.beans;

import java.sql.ResultSet;
import java.sql.SQLException;

import org.springframework.jdbc.core.RowMapper;

public class FarmerMapper implements RowMapper<Farmer> {

	public Farmer mapRow(ResultSet resultSet, int i) throws SQLException {

		Farmer farmer = new Farmer();
		
		farmer.setName(resultSet.getString("name"));
		farmer.setAge(resultSet.getInt("age"));
		
		return farmer;
	}
}
