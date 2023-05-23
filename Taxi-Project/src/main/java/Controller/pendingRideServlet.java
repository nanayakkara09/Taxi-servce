package Controller;

import java.io.IOException;
import java.sql.SQLException;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import Model.Ride;
import Model.RideDAO;


@WebServlet("/pending")
public class pendingRideServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
	
		response.getWriter().append("Served at: ").append(request.getContextPath());
		
		RideDAO rideDao=new RideDAO();
		
		// Retrieve all requested rides from the database
	    List<Ride> requestedRides = rideDao.selectAllRequestedRides();
	    
	   

	    // Set the requested rides as an attribute in the request object
	    request.setAttribute("requestedRides", requestedRides);

	    // Forward the request to the JSP page
	    RequestDispatcher dispatcher = request.getRequestDispatcher("rides.jsp");
	    dispatcher.forward(request, response);
	   
		
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		
		
		int rideId = Integer.parseInt(request.getParameter("rideId"));
		RideDAO rideDao=new RideDAO();
		try {
			rideDao.updateRideStatus(rideId);
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		
		
	    response.sendRedirect(request.getContextPath() + "/pending");
	    
	    
	    
	    
		
	}

}
