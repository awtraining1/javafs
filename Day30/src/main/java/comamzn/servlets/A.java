package comamzn.servlets;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

//Demo including content from other servlet
@WebServlet("/A")
public class A extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		PrintWriter pw = response.getWriter();
		
		request.getRequestDispatcher("HeaderServlet").include(request, response);
		//request.getRequestDispatcher("AdvtServlet").include(request, response);
		
		pw.append("<br></br>");
		pw.append("This is content from Servlet A");
		pw.append("<br></br>");
		
		request.getRequestDispatcher("FooterServlet").include(request, response);
		
		pw.flush();
		pw.close();
	}


}
