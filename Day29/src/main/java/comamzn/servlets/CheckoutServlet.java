package comamzn.servlets;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

//Demo Forwarding to other servlet
@WebServlet("/CheckoutServlet")
public class CheckoutServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		PrintWriter pw = response.getWriter();		
		
		pw.append("<br></br>");
		pw.append("This is content from CheckoutServlet. Your bill 100 ");
		pw.append("<br></br>");
		System.out.println(" Inside CheckoutServlet before forwarding to Thanks Servlet");
		
		
		request
		.getRequestDispatcher("ThanksServlet?bill=100&fruit=apple&fruit=mango")
		.forward(request, response);
		
		System.out.println(" Inside CheckoutServlet after forwarding to Thanks Servlet");
		
		pw.flush();
		pw.close();
	}


}
