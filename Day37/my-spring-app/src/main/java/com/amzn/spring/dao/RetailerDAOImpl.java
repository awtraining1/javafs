package com.amzn.spring.dao;

import java.util.List;

import javax.sql.DataSource;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Transactional;

import com.amzn.beans.Farmer;
import com.amzn.beans.FarmerMapper;
import com.amzn.beans.Retailer;
import com.amzn.beans.RetailerMapper;

@Component
public class RetailerDAOImpl implements RetailerDAO{

	DataSource datasource;
	JdbcTemplate jdbcTemplate;
	
	@Autowired
	RetailerDAOImpl(DataSource datasource){
		this.jdbcTemplate = new JdbcTemplate(datasource);
	}
	
	public List<Retailer> getAllRetailers() {
		List<Retailer> retailersList = jdbcTemplate.query("select * from RETAILER", new RetailerMapper());
		
		return retailersList;
	}
	
	@Transactional
	public int createRetailer(Retailer retailer) {
		int rowCount = jdbcTemplate.update("insert into RETAILER(name,age,license_id) values(?,?,? )",
				retailer.getName(), retailer.getAge(),retailer.getLicenceId() );
		
		return rowCount;
	};

	public int deleteRetailer(Retailer retailer) {
		String sql = "delete from RETAILER where name=? and age=? and license_id=?";
		
		int rowCount = jdbcTemplate.update(sql,
				retailer.getName(), retailer.getAge(),retailer.getLicenceId() );
		
		return rowCount;
	};
}
