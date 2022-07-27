package comamzn.servlets;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/AddCookieDemoServlet")
public class AddCookieDemoServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
   
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		response.setContentType("text/html");			
		PrintWriter pw = response.getWriter();
		
		Cookie cokkieIceCream = new Cookie("Fav-Fruit", "Mango");
		cokkieIceCream.setMaxAge(15*60*60*24);//15 day cookie
		
		response.addCookie(cokkieIceCream);
		
		pw.print("Just added a cookie to your browser. "
				+ "Go check it. It will be there for unlimited mins - forever");
		
		pw.flush();
		pw.close();		
	}

}
