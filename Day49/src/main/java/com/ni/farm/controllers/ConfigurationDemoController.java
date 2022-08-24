package com.ni.farm.controllers;

import java.util.Arrays;

import com.ni.config.CompanyProps;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.PropertySource;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

@PropertySource("classpath:company.properties")
@Controller
@RequestMapping("about")
public class ConfigurationDemoController {
    @Value("${company.name}")
    String compName;

    @Value("${company.ceo}")
    String compCEO;

    @Autowired
    CompanyProps companyProps;
    
    // Accessing company.properties key,values
    @GetMapping( value = {"/company"})
    @ResponseBody
    public String company(){     
        String str1="<h2>Welcome to "+compName +"</h2>";
        String strCEO="<h2>Welcome to "+compCEO +"</h2><hr/>";

        String employeeCountStr = 
        "<br/><br/>Number of employees : " +companyProps.getCount();

        String employeeDoWFHStr = 
        "<br/><br/>Employees WFH : " + companyProps.isWfh();

        String employeeHolidays = "<br/><br/> Holidays : "+ companyProps.getHolidays();
        
        return str1 + strCEO + employeeCountStr + employeeDoWFHStr + employeeHolidays;
    }

    //49A Add and print the company history text
    //49B Instead of ResponseBody, create a Thymeleaf html file and 
    // show the company properties.
}
