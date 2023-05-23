package Controller;

import java.io.IOException;
import java.sql.SQLException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import Model.RideDAO;
import Model.Ride;

@WebServlet("/Ride")
public class RideServlet extends HttpServlet {
    /**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        //Get the telephone number from the session
		HttpSession session = request.getSession();
		String telephoneNumber = (String) session.getAttribute("telephoneNo");

		// Validate the telephone number
		
		
		RideDAO rideDAO = new RideDAO();
		String username = null;
		try {
			username = rideDAO.getUsernameByTelephoneNumber(telephoneNumber);
			if (username == null) {
			    response.sendRedirect("ride_details.jsp?error=invalid_inputaaaar");
			    return;
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		
		
		
		// Get the ride details from the request
        String vehicle = request.getParameter("vehicle");
        String currentLocation = request.getParameter("current_location");
        String destination = request.getParameter("destination");
        int kilometers = Integer.parseInt(request.getParameter("kilometers"));

        // Validate the ride details
        if (vehicle == null || currentLocation == null || destination == null || kilometers <= 0) {
            response.sendRedirect("ride_details.jsp?error=invalid_inputeeee");
            return;
        }

        // Calculate the ride amount
        int amount;
        switch (vehicle) {
            case "car":
                amount = kilometers * 200;
                break;
            case "threewheel":
                amount = kilometers * 100;
                break;
            case "bike":
                amount = kilometers * 50;
                break;
            default:
                response.sendRedirect("ride_details.jsp?error=invalid_input");
                return;
        }

        // Store the ride details in the database
        

        Ride ride = new Ride(username, telephoneNumber, vehicle, currentLocation, destination, kilometers, amount);
        
        try {
			rideDAO.insertRide(ride);
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

        // Display the ride confirmation
        request.setAttribute("ride", ride);
        request.getRequestDispatcher("ride_confirmation.jsp").forward(request, response);
    }
}
