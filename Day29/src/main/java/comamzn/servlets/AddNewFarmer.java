package comamzn.servlets;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;

import javax.servlet.ServletConfig;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/AddNewFarmer")
public class AddNewFarmer extends HttpServlet {
	private static final long serialVersionUID = 1L;
	PreparedStatement psmt;
	Connection conn;
	
	@Override
	public void init(ServletConfig config) {
		// This method is useful for creating some resources that we will use in the Service methods.
		// Like creating a DB connection and use that connection multiple times in the Service methods.
		
		try {
			conn = DriverManager.getConnection("jdbc:mysql://127.0.0.1:3306/amzn", "root", "rootroot");
			psmt = conn.prepareStatement("INSERT INTO FARMER values (?,?)");
			System.out.println("Inside HomeServlet.  JDBC connection success!!");
		} catch (SQLException e) {
			System.out.println("Inside HomeServlet.  JDBC connection failed!!");
		}
		
	}
	
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		//Set the content type
				response.setContentType("text/html");
				PrintWriter pw = response.getWriter();
				
				String nameStr = request.getParameter("name");
				String ageStr = request.getParameter("age");
				
				int age=0;
				if(ageStr!=null)
				age = Integer.parseInt(ageStr);				
				
				try {
					psmt.setString(1,nameStr);
					psmt.setInt(2,age);
					psmt.executeUpdate();			
					
					pw.write("<center>Added a new farmer</center>");
				} catch (SQLException e) {
					pw.write("<center>Failed to add a new farmer</center>");
				}
				finally {
					pw.flush();
					pw.close();
				}			
				
	}

	@Override
	public void destroy() {
		System.out.println("Inside HomeServlet. I am getting destroyed.. ");
		try {
			conn.close();
		} catch (SQLException e) {
			System.out.println("Inside HomeServlet.  JDBC connection closing failed!!");
		}
	}

}
