package com.ni.farm.services;

import java.util.ArrayList;
import java.util.List;

import com.ni.farm.Farmer;
import com.ni.farm.respositries.FarmerRepositry_V2;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class FarmerService_V2 {

    @Autowired
    FarmerRepositry_V2 farmerRepositry;

    public List<Farmer> getAllFarmers(){
        List<Farmer> farmersList = new ArrayList<Farmer>() ;

        farmerRepositry
        .findAll()
        .forEach( farmer -> farmersList.add(farmer) );

        return farmersList;
    }

    
}
