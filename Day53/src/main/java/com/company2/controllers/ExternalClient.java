package com.company2.controllers;


import com.ni.farm.Farmer;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.client.RestTemplate;

@Controller
@RequestMapping("/client1")
public class ExternalClient {

    @Autowired
    RestTemplate restTemplate;

   
    @GetMapping( value = {"/test"})
    @ResponseBody
    public String abc(){
        return "<h2>Welcome Test</h2>";
    }

    @GetMapping("/farmer/{id}")    
    @ResponseBody
    public Farmer abc(@PathVariable int id) {
        System.out.println(" Inside abc(@PathVariable int id) ");

        Farmer farmer = 
        restTemplate
        .getForObject("http://localhost:8080/api/farmer/" + id, Farmer.class);
        
        return farmer;
    }

}