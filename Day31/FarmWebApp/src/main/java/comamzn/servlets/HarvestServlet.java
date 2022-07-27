package comamzn.servlets;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.Arrays;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/HarvestServlet")
public class HarvestServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		response.setContentType("text/html");
		
		//Extract the form field values
		String nameStr = request.getParameter("farmerName");
		String noOfTomatoesStr = request.getParameter("noOfTomatoes");
		String noOfMangoesStr = request.getParameter("noOfMangoes");
		String noOfApplesStr = request.getParameter("noOfApples");
		String[] modeOfNotificationArr = request.getParameterValues("modeOfNotification");

		PrintWriter pw = response.getWriter();
		
		pw.printf("Thank you %s, for harvesting the following:<br><br>", nameStr);
		pw.printf("<li>Tomatoes %s </li>", noOfTomatoesStr);
		pw.printf("<li>Mangoes %s </li>", noOfMangoesStr);
		pw.printf("<li>Apples %s </li>", noOfApplesStr);
		pw.printf("<br><br>You will recieve the payment in 5 working days. "
				+ "A notification will be sent to on %s", Arrays.toString(modeOfNotificationArr));
		
		pw.flush();
		pw.close();
	}
}
