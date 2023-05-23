package Controller;

import java.io.IOException;
import java.sql.SQLException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import Model.CRUDrides;

//handle HTTP requests related to deleting a ride
@WebServlet("/deleteRideServlet")
//Singleton Design Pattern
public class deleteRideServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
	CRUDrides rides =new CRUDrides();
       
    //delete a rides using the id, and redirects the client based on the success or failure of the deletion operation
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		response.getWriter().append("Served at: ").append(request.getContextPath());
		
		String id = request.getParameter("id");
		System.out.println(id);
		try {
			
			boolean deleted=rides.deleteRide(Integer.parseInt(id));
			if(deleted)
			{
				response.sendRedirect(request.getContextPath() + "/retrievePendingRides");
			}
			else {
				System.out.println("error");
			}
			//sql exception handling
		} catch (SQLException e) {
			e.printStackTrace();
		}
		
	}

	//forwards the request to the doGet method to handle the request
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doGet(request, response);
	}

}
