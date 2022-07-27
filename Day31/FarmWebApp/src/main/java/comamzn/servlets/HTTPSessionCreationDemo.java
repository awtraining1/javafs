package comamzn.servlets;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.Enumeration;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

@WebServlet("/HTTPSessionCreationDemo")
public class HTTPSessionCreationDemo extends HttpServlet {
	private static final long serialVersionUID = 1L;
	   
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		response.setContentType("text/html");			
		PrintWriter pw = response.getWriter();
		
		// HttpSession httpSession = request.getSession();// auto create session if not already present
		//HttpSession httpSession = request.getSession(false); // false don't create a new session if none exist
		HttpSession httpSession = request.getSession(true); // create a new session if none exist otherwise retrieve the existing session
		
		httpSession.setAttribute("Fav-Fruit", "Mango");
		httpSession.setAttribute("Fav-Cloth", "T-Shirt");
		List<Integer> listOfInt = List.of(1,2,3,4,5);
		httpSession.setAttribute("Fav-Numbers", listOfInt);
//		Mango m = new Mango();
//		httpSession.setAttribute("Fav-Fruit2", m);
		
		if(httpSession!=null) {
		pw.print("<br/>Hey there is a http session for current interaction with the web app");
		pw.print("<br/>Following items were found in your session");
		
		Enumeration<String> attrNames = httpSession.getAttributeNames();
		while(attrNames.hasMoreElements()) {
			String attrName = (String) attrNames.nextElement();
			pw.print("<br/>"+attrName + "," + httpSession.getAttribute(attrName));
		}
		
		}
		else
			pw.print("Hey there was NO http session "
					+ "for current interaction with the web app.");
		
		pw.flush();
		pw.close();		
	}

}
