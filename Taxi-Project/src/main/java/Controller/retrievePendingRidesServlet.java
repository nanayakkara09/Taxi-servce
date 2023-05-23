package Controller;

import java.io.IOException;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import Model.CRUDrides;

import Model.Ride;


@WebServlet("/retrievePendingRides")
//Singleton Design Pattern
public class retrievePendingRidesServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		response.getWriter().append("Served at: ").append(request.getContextPath());
		CRUDrides rides=new CRUDrides();
		// Retrieve all requested rides from the database
		List<Ride> ride = rides.selectAllRides();
		
		// Set the requested rides as an attribute in the request object
		request.setAttribute("ride", ride);
		
	    // Forward the request to the JSP page
		RequestDispatcher dispatcher = request.getRequestDispatcher("rideList.jsp");
	    dispatcher.forward(request, response);
	}

	//forwards the request to the doGet method to handle the request
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doGet(request, response);
	}

}
