package comamzn.servlets;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.Arrays;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

//Demo Forwarding to other servlet
@WebServlet("/ThanksServlet")
public class ThanksServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		PrintWriter pw = response.getWriter();		
		
		int billAmt = Integer.parseInt(request.getParameter("bill"));
		String[] fruitArr = request.getParameterValues("fruit");
		
		pw.append("<br></br>");
		
		pw.append("Thanks for purchase of INR "+billAmt+".<br>  Happy shopping! ");
		
		pw.append("You bought:");
		for(String f:fruitArr) {
			pw.append("<li>"+f + "</li>");
		};
		
		pw.append("<br></br>");
		
		pw.flush();
		pw.close();
	}


}
