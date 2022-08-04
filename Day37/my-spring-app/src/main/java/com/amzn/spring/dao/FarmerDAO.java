package com.amzn.spring.dao;

import java.util.List;

import com.amzn.beans.Farmer;

public interface FarmerDAO {
	
	List<Farmer> getAllFarmers();
	
	int createFarmer(Farmer farmer);
	
	void createFarmerTable();
}
