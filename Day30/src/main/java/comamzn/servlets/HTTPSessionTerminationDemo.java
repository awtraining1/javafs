package comamzn.servlets;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

@WebServlet("/HTTPSessionTerminationDemo")
public class HTTPSessionTerminationDemo extends HttpServlet {
	private static final long serialVersionUID = 1L;
	   
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		response.setContentType("text/html");			
		PrintWriter pw = response.getWriter();
				
		HttpSession httpSession = request.getSession(false); // false don't create a new session if none exist
		
		
		if(httpSession!=null) {
		httpSession.invalidate(); // Terminating the http session
		pw.print("Hey there is a http session "
				+ "for current interaction with the web app and terminating it");
		}
		else
			pw.print("Hey there was NO http session "
					+ "for current interaction with the web app. <br> So DID NOT Terminate");
		
		pw.flush();
		pw.close();		
	}

}
