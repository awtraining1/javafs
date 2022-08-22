package com.ni.farm.controllers;

import java.util.List;

import com.ni.farm.Farmer;
import com.ni.farm.services.FarmerService_V2;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
@RequestMapping("jpa")
public class FarmerController_V2 {

    @Autowired
    FarmerService_V2 farmerService;

    @GetMapping("/farmers/list")
    @ResponseBody
    public List<Farmer> allFarmers(){      
        return farmerService.getAllFarmers();
    }  
    
    
    
}
