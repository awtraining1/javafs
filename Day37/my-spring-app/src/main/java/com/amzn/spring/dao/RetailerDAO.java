package com.amzn.spring.dao;

import java.util.List;

import com.amzn.beans.Retailer;

public interface RetailerDAO {

	int createRetailer(Retailer retailer);

	List<Retailer> getAllRetailers();	
	
	int deleteRetailer(Retailer retailer);

}