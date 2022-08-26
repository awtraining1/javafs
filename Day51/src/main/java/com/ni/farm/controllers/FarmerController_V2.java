package com.ni.farm.controllers;

import java.util.List;

import javax.validation.Valid;

import com.ni.farm.Farmer;
import com.ni.farm.services.FarmerService_V2;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.view.RedirectView;

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
    
    @PostMapping("/farmers/add")
    @ResponseBody
    public RedirectView addFarmer(@Valid Farmer farmer){   
        // Save the farmer in the DB
        Farmer resultFarmer = farmerService.addFarmer(farmer);
        System.out.format("Added farmer with id = %s", resultFarmer.getFarmerId());
        
        RedirectView redirectView = new RedirectView("/jpa/farmers/list"); 
        return redirectView;
    } 
    
    // 48A Can you implement delete a farmer functionality
    // given his id value
    @PostMapping("farmers/delete")
	@ResponseBody
	public RedirectView deleteFarmer(int farmerId) 
    {
        farmerService.deletefarmer(farmerId);
      		
		RedirectView redirectView = new RedirectView("/jpa/farmers/list");
		return redirectView;
	}

    // 48B How about deleting a farmer, given his name??
    @PostMapping("farmers/delete-by-name")
	@ResponseBody
	public RedirectView deleteFarmerByName(@RequestParam String name) 
    {
        farmerService.deleteFarmerByName(name);
      		
		RedirectView redirectView = new RedirectView("/jpa/farmers/list");
		return redirectView;
	}

    @PostMapping("farmers/delete-by-age")
	@ResponseBody
	public RedirectView deleteFarmerByAge(@RequestParam int age) 
    {
        farmerService.deleteFarmerByAge(age);
      		
		RedirectView redirectView = new RedirectView("/jpa/farmers/list");
		return redirectView;
	}

    // 48C Build a search-by-name functionality web page

    
}
