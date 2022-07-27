package comamzn.servlets;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

@WebServlet("/LoginServlet")
public class LoginServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		response.setContentType("text/html");
		PrintWriter pw = response.getWriter();

		// Extract the form field values
		String nameStr = request.getParameter("userName");
		String passwordStr = request.getParameter("passwd");
		
		//Logic to check if the username and password 
		// match that is that database.
		// For today's demo, lets manually check U&P combo.
		
		HttpSession session = null;
		if(nameStr.equalsIgnoreCase("saba") && passwordStr.equals("topsecret")) {
			session = request.getSession(true);
			session.setAttribute("loggedIn", true);
			//
			pw.printf("Login Success!! for %s", nameStr);
		}
		else {
			response.sendRedirect("login.html");
		};
		
		pw.flush();pw.close();

	}

}
