package com.ni.farm.controllers;

import java.util.concurrent.CompletableFuture;
import java.util.concurrent.ExecutionException;

import com.ni.farm.model.User;
import com.ni.farm.services.GitHubLookupService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.web.authentication.logout.SecurityContextLogoutHandler;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
@RequestMapping("github")
public class GithubLookupController {

    @Autowired
    GitHubLookupService gitHubLookupService;

    @GetMapping("/user/{username}")
    @ResponseBody
    public User users(@PathVariable String username) throws InterruptedException, ExecutionException {
        CompletableFuture<User> user = 
        gitHubLookupService.findUser(username);        

        return user.get();
    }
    
    //@GetMapping("/repos/{username}")

}
