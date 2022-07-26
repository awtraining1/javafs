package comamzn.servlets;

import java.io.*;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.*;

@WebServlet("/FooterServlet")
public class FooterServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		PrintWriter pw = response.getWriter();
		pw.print("<hr>");
		pw.print("<h4> Company Address: 29000 USA </h4>");
		pw.print("<h4> Company Contact:  +1 600 23343 4343</h4>");
		pw.print("<hr>");
		pw.flush();
		pw.close();
	}


}