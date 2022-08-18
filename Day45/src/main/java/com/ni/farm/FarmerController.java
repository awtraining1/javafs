package com.ni.farm;

import java.util.List;
import java.util.stream.Collectors;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.view.RedirectView;

@Controller
@RequestMapping("farmer")
public class FarmerController {

    // @GetMapping("/1")
    // @ResponseBody
    // public String abc() {
    // return "First Farmer is Anna";
    // }

    // @GetMapping("/2")
    // @ResponseBody
    // public String abc1() {
    // return "First Farmer is Bopiah";
    // }

    //Example URL: "localhost:8080/farmer/id/1/age/100"
    @GetMapping("/id/{id}/age/{age}")
    @ResponseBody
    public String abc1(@PathVariable String id, @PathVariable int age) {

        return id + "-th Farmer is Bopiah " + id + " and age is " + age;
    }

    // Listing all farmers from the repositry
    @GetMapping("/list")
    @ResponseBody
    public List<Farmer> listFarmers() {
        return FarmerRepositry.farmerList;
    }

    // Listing all farmers from the repositry, using Thymeleaf templates
    @GetMapping("/list-v2")
    public String listFarmersV2(Model model) {
        model.addAttribute("farmerList", FarmerRepositry.farmerList);

        return "farmer-list.html";
    }

    // HTML form processing
    // form input values are captured as the method arguments when they have same
    // name
    @PostMapping("/addnewfarmer")
    @ResponseBody
    public RedirectView addNewFarmer(String farmerName, int farmerAge, float farmerExperience) {
        FarmerRepositry.farmerList.add(new Farmer(farmerName, farmerAge, farmerExperience));
        int farmerCount = FarmerRepositry.farmerList.size();

        // String response = String.format("Recieved a new farmer (%s %s %s). Thank you, your are farmer no %s",
        //         farmerName, farmerAge, farmerExperience, farmerCount);
        // return response;

        RedirectView redirectView = new RedirectView("/farmer/list-v2"); 
        return redirectView;

        //return "redirect:/farmer/list-v2";
    }

    // A more powerful way of capturing form input parameters
    // Note that for this to work, form field names have to match the
    // domain class feild names
    @PostMapping("/addnewfarmer_v2")
    @ResponseBody
    public RedirectView addNewFarmer_V2(Farmer farmer) {
        FarmerRepositry.farmerList.add(farmer);
       
        RedirectView redirectView = new RedirectView("/farmer/list-v2"); 
        return redirectView;
    }

    //45A Create the Retailer domain class,  
    // and similar respositry class for it. Also a new RetailerController class.
    // Implement form processing in the controller class
    // for adding a new Retailer. 

    // 44A Create the Retailer domain class, and similar respositry class for it.
    // Populate few Retailers in the respositry class.
    // Create a HTML form that will remove Retailer based id/name feild.
    @PostMapping("/deletefarmer")
    @ResponseBody
    public RedirectView DeleteFarmer(String farmerName, int farmerAge) {
        FarmerRepositry.farmerList = FarmerRepositry.farmerList
                .stream()
                .filter( farmer -> !(farmer.name.equals(farmerName) && farmer.age==farmerAge ))
                .collect(Collectors.toList());

        int farmerCount = FarmerRepositry.farmerList.size();

        // String response = String.format("Deleted farmer  (%s). Farmer list count- %s",
        //         farmerName, farmerCount);
        // return response;

        // return "redirect:list-v2";
        //44B Solved
        RedirectView redirectView = new RedirectView("/farmer/list-v2"); 
        return redirectView;
    }

    //44B
    // Enhance addnewfarmer and deletefarmer 
    // such that they return the user to farmer listing
}
