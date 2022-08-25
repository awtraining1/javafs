package com.ni.farm;

import java.util.Arrays;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.PropertySource;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.client.RestTemplate;

// @PropertySource("classpath:company.properties")
@Controller
public class HelloWorldController{
   
    @Value("${company.name}")
    String compName;
    
    @GetMapping( value = {"/company"})
    @ResponseBody
    public String company(){       
        return "<h2>Welcome to "+compName +"</h2>";
    }

    @GetMapping( value = {"/home"})
    @ResponseBody
    public String abc(){
        // throw new RuntimeException("Dummy exception");
        return "<h2>Welcome to "+compName +"</h2>";
    }

    @GetMapping("/farmers")
    @ResponseBody
    public String farmers(){
        //int z=5;
        String[] arrFarmers = {"Tushar", "Tushar"}; 

        return Arrays.toString(arrFarmers);
    }

    // localhost:8080/farmer?name=Bala&age=71
    @GetMapping("/farmer1")
    @ResponseBody
    public String farmer(String name, int age){       

        return String.format("You name is %s and age is %d",name,age) ;
    }

    // Render dynamic content in html files
    @GetMapping("/farmer-life")
    public String farmerLife(Model model){      
        model.addAttribute("farmerName", "Jolly Sharma");

        Farmer f= new Farmer();
        f.name="Kaviraj";
        f.age=50;

        model.addAttribute("farmer", f);

        return "farmer-life.html" ;
    }

    @GetMapping("/farmer-client/{id}")
    @ResponseBody
    public Farmer abc(@PathVariable int id) {
        System.out.println(" Inside abc(@PathVariable int id) ");
        RestTemplate restTemplate = new RestTemplate();

        Farmer farmer = 
        restTemplate
        .getForObject("http://localhost:8080/api/farmer/" + id, Farmer.class);
        
        return farmer;
    }

    @GetMapping("/todo/{id}")
    @ResponseBody
    public Todo todo(@PathVariable int id) {
        RestTemplate restTemplate = new RestTemplate();

        Todo todo = 
        restTemplate
        .getForObject("https://jsonplaceholder.typicode.com/todos/" + id, Todo.class);
        
        return todo;
    }


    
}