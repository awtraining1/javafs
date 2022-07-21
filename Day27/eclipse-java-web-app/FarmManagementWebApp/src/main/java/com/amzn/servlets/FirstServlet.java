package com.amzn.servlets;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

//@WebServlet(description = "My First Servlet", urlPatterns = { "/FirstServlet" })
public class FirstServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;    

	
	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		
		response.setContentType("text/html");
		
		PrintWriter pw = response.getWriter();
		
		pw.write("Hello Java Servlet World!");
		
		pw.flush();
		pw.close();
		
	}
		

	

}
