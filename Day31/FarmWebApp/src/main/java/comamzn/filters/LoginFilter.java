package comamzn.filters;

import java.io.IOException;
import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.FilterConfig;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.annotation.WebFilter;
import javax.servlet.http.HttpFilter;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

@WebFilter(urlPatterns = {"/home.html", "/home.htm", "/h", "/home/*", "ProfileServlet", "HarvestServlet"})
public class LoginFilter extends HttpFilter implements Filter {

	public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain)
			throws IOException, ServletException {
		
		System.out.println("LoginFilter req servlet mapping "+request.getServletContext().getServletContextName());

		// Check if the user is logged or not.
		HttpSession session = ((HttpServletRequest) request).getSession(true);

		String yes = (String) session.getAttribute("loggedIn");

		if (yes == null || !yes.equals("true")) {
			((HttpServletResponse) response).sendRedirect("login.html");
		}
		;

		// pass the request along the filter chain
		chain.doFilter(request, response);
	}

}
