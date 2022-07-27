package comamzn.servlets;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/CookieDemoServlet")
public class CookieDemoServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
   
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		response.setContentType("text/html");			
		PrintWriter pw = response.getWriter();
		
		Cookie[] cookies = request.getCookies();
		
		pw.print("We found the following cookies in your browser");
		for(Cookie cookie: cookies) {
			pw.print("<br/> Cokkie name: "+cookie.getName() + ", Value="+cookie.getValue());
			pw.print("<br/> Cokkie expiry: "+cookie.getMaxAge());
		};
		
		pw.flush();
		pw.close();		
	}

}
