package com.amzn.spring.dao;

import java.util.List;

import javax.sql.DataSource;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Transactional;

import com.amzn.beans.Farmer;
import com.amzn.beans.FarmerMapper;

@Component
public class FarmerDAOImpl implements FarmerDAO{

	DataSource datasource;
	JdbcTemplate jdbcTemplate;
	
	@Autowired
	FarmerDAOImpl(DataSource datasource){
		this.jdbcTemplate = new JdbcTemplate(datasource);
	}
	
	public List<Farmer> getAllFarmers() {
		List<Farmer> farmersList = jdbcTemplate.query("select * from FARMER", new FarmerMapper());
		
		return farmersList;
	}
	
	@Transactional
	public int createFarmer(Farmer farmer) {
		int count = jdbcTemplate.update("insert into FARMER(name,age) values(?,? )",
				farmer.getName(), farmer.getAge());
		
		return count;
	};

	public void createFarmerTable() {
		jdbcTemplate.execute("CREATE TABLE FARMER(name varchar(40), age int)");		
	}

}
