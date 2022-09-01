package com.ni.farm.controllers;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.web.authentication.logout.SecurityContextLogoutHandler;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
public class LoginController {

	@RequestMapping(value = "/login", method = { RequestMethod.GET, RequestMethod.POST })
	public String loginPage(
			@RequestParam(value = "error", required = false) String error,
			@RequestParam(value = "logout", required = false) String logout, Model model) {

		String errorMessage = null;
		String logoutMessage = null;

		if (error != null)
			errorMessage = "Username or Password is incorrect !!";

		if (logout != null)
			logoutMessage = "You have been successfully logged out !!";

		model.addAttribute("errorMessage", errorMessage);
		model.addAttribute("logoutMessage", logoutMessage);

		return "login.html";
	}

	@RequestMapping(value = "/logout", method = { RequestMethod.GET })
	public String logoutPage(HttpServletRequest request, HttpServletResponse response) {

		Authentication auth = SecurityContextHolder.getContext().getAuthentication();
	
		if (auth != null) {
			new SecurityContextLogoutHandler().logout(request, response, auth);
		}

		System.out.println("inside logoutPage for /logout ");
		return "redirect:/login?logout=true";
	}
	
	

}