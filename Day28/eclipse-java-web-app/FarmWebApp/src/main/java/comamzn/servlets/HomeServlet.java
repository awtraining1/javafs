package comamzn.servlets;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/HomeServlet")
public class HomeServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		//Set the content type
		response.setContentType("text/html");
		
		String nameStr = request.getParameter("name");
		String ageStr = request.getParameter("age");
		int age = Integer.parseInt(ageStr);	
		
		PrintWriter pw = response.getWriter();
		
		pw.write("<center><h1> Welcome to Amzn </h1></center>");
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

}
