package com.ni.farm.services;

import java.util.ArrayList;
import java.util.List;

import com.ni.farm.Farmer;
import com.ni.farm.respositries.FarmerRepositry_V2;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
public class FarmerService_V2 {

    @Autowired
    FarmerRepositry_V2 farmerRepositry;

    public List<Farmer> getAllFarmers() {
        List<Farmer> farmersList = new ArrayList<Farmer>();

        farmerRepositry
                .findAll()
                .forEach(farmer -> farmersList.add(farmer));

        return farmersList;
    }

    public Farmer updateFarmer(Farmer farmer) {
        return farmerRepositry.save(farmer);
    }

    public Farmer addFarmer(Farmer farmer) {
        return farmerRepositry.save(farmer);
    }

    public void deletefarmer(int farmerId) {
        // farmerRepositry.deleteById(farmerId);
        // deleteById throws Exception when farmer with that id does not exist,
        // Therefore we are trying alternative below

        List<Farmer> farmerList = getAllFarmers();

        for (Farmer farmer : farmerList) {
            if (farmer.getFarmerId() == farmerId)
                farmerRepositry.deleteById(farmerId);
        }
    }

    @Transactional
    public void deleteFarmerByName(String name) {
        farmerRepositry.deleteByName(name);
    }
    
    @Transactional
    public void deleteFarmerByAge(int age) {
        farmerRepositry.deleteByAge(age);
    }

}
