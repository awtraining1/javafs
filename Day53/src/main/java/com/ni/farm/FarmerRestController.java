package com.ni.farm;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.http.*;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

import java.util.*;

@RestController
@RequestMapping("api/farmer")
public class FarmerRestController {

    // Listing all farmers from the repositry
    @GetMapping("/list")
    public List<Farmer> listFarmers() {
        return FarmerRepositry.farmerList;
    }

    // Get a particular farmer detail
    @GetMapping(value = "/{id}")
    public Farmer listFarmers(@PathVariable int id) {
        return FarmerRepositry.farmerList.size() > 0 ? FarmerRepositry.farmerList.get(id - 1) : null;
    }

    // Get a particular farmer detail along with some custom HTTP headers
    // and our own status code
    @GetMapping(value = "/v2/{id}")
    public ResponseEntity<Farmer> listFarmers_V2(@PathVariable int id) {
        //Create and set our own custom http headers
        HttpHeaders responseHeaders = new HttpHeaders();
        responseHeaders.set("Company-name", "Nich");
        responseHeaders.set("Company-year", "2465");
        responseHeaders.set("Farmer-API-Version", "2.1");

        //The farmer that we want to sent
        Farmer resultFarmer = FarmerRepositry.farmerList.size() > 0 ? FarmerRepositry.farmerList.get(id - 1) : null;

        return new ResponseEntity<Farmer>(
            resultFarmer,
            responseHeaders,
            resultFarmer!=null ? HttpStatus.FOUND : HttpStatus.NOT_FOUND
            );
    }

    // 45B Rewrite 
   // @GetMapping("/list")
    // public List<Farmer> listFarmers()
    // using ResponseEntity

}
