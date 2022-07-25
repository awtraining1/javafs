package comamzn.servlets;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;

import javax.servlet.ServletConfig;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet(urlPatterns = {"/home.html", "/home.htm", "/h", "/home/*"})
public class HomeServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
	int counter =0;
	
	
	@Override
	public void init(ServletConfig config) {
		System.out.println("Inside HomeServlet. I am getting initiliazed. Counter=" + counter);
		// This method is useful for creating some resources that we will use in the Service methods.
		// Like creating a DB connection and use that connection multiple times in the Service methods.
		
		
	}

	//http://localhost:8080/FarmWebApp/home.html?name=farmer1&age=20
	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		System.out.println("Inside HomeServlet doGet. I am serving you. Counter=" + counter++);		
		
		
		
		PrintWriter pw = response.getWriter();
		
		String nameStr = request.getParameter("name");
		String ageStr = request.getParameter("age");
		
		int age=0;
		if(ageStr!=null)
		age = Integer.parseInt(ageStr);
		
		pw.write("<center><h1> Welcome to Amzn </h1></center>");
		pw.print("<center><h4> You are vistor no:"+ counter +" </h4></center>");
		pw.write(" Your IP address: "+request.getRemoteAddr());
		
		pw.append("</h2>  " + nameStr + ", here are the products you choose from:" + "</h2>");
		pw.append("<h2> Here are the products </h2>");
		pw.append("<ul>");
		pw.append("<li> Totapuri </li>");
		pw.append("<li> Alphonso </li>");
		pw.append("<li> Raspuri </li>");
		pw.append("<li> Dasheri </li>");
		pw.append("</ul>");
		
		if(age<6) {
			pw.append("<ul> Here are additional products for you");
			pw.append("<li> Rail toys </li>");
			pw.append("<li> Plane toys </li>");
			pw.append("<li> Kid skating board </li>");
			pw.append("</ul>");
		}else {
			response.sendRedirect("ProfileServlet");
		}
		
		
		pw.flush();
		pw.close();
	}
	
	@Override
	public void destroy() {
		System.out.println("Inside HomeServlet. I am getting destroyed.. ");
		
	}

}
