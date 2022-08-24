package com.ni.farm.controllers;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
@RequestMapping("profiles-demo")
public class ProfilesDemoController {

    @Value("${team.name}")
    String teamName;

    // Accessing application.properties key,values
    // of activated profile
    @GetMapping( value = {"/team"})
    @ResponseBody
    public String team(){     
        String str1="<h2>Welcome to "+teamName +"</h2>";

        return str1;
    }
}

// 49C add one more profile "marketing" with team.name=Marketing
// Test it.
