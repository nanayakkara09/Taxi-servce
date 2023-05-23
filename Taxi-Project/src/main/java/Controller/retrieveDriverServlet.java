package Controller;

import java.io.IOException;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;



import Model.CRUDdriver;
import Model.Driver;



@WebServlet("/retrieveDriver")
//Singleton Design Pattern
public class retrieveDriverServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		response.getWriter().append("Served at: ").append(request.getContextPath());
		CRUDdriver driver=new CRUDdriver();
		
		// Retrieve all requested rides from the database
		List<Driver> drivers = driver.selectAllDrivers();
		
		// Set the an attribute in the request object
		request.setAttribute("drivers", drivers);
		
	    // Forward the request to the JSP page
		RequestDispatcher dispatcher = request.getRequestDispatcher("driverList.jsp");
	    dispatcher.forward(request, response);
	    
	}

	//forwards the request to the doGet method to handle the request
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doGet(request, response);
	}

}
