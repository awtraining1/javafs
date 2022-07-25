package comamzn.servlets;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletConfig;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/ProfileServlet")
public class ProfileServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
	
	@Override
	public void init(ServletConfig config) {
		System.out.println("Inside ProfileServlet. I am getting initiliazed.. ");
	}
    
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		response.setContentType("text/html");
		
		PrintWriter pw = response.getWriter();
		
		pw.write("<center><h1> Here is your profile! </h1></center>");
		pw.append("<script>alert('I am alert from JavaScript');"
				+ " document.write('Blah Blah ....');"
				+ "</script>");
		
		pw.flush();
		pw.close();
	}

	@Override
	public void destroy() {
		System.out.println("Inside ProfileServlet. I am getting destroyed.. ");
	}
}
