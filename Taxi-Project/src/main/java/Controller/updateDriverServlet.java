package Controller;

import java.io.IOException;
import java.sql.SQLException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import Model.DriverDAO;
import Model.register;

//handle HTTP requests related to updating a driver
@WebServlet("/updateDriver")
//Singleton Design Pattern
public class updateDriverServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

    //update a driver and redirects the client based on the success or failure of the update operation
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		response.getWriter().append("Served at: ").append(request.getContextPath());
		String telephoneNumber = request.getParameter("telephoneNumber");
	    String username = request.getParameter("userName");
	    String password = request.getParameter("password");
	    register driver = new register(username,password,telephoneNumber);
	    DriverDAO driverdao = new DriverDAO();
	    boolean rowUpdated;
	    System.out.println(username);
		try {
			rowUpdated = driverdao.updateDriver(driver);
			if (rowUpdated) {
		        response.sendRedirect(request.getContextPath() + "/retrieveDriver");
		    } else {
		        response.getWriter().append("Failed to update driver");
		    }
			//sql exception handling
		} catch (SQLException e) {
			
			e.printStackTrace();
		}
	}
	
	//doGet(request, response);
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doGet(request, response);
		
		String telephoneNumber = request.getParameter("telephoneNumber");
		
	    String username = request.getParameter("username");
	    String password = request.getParameter("password");
	    System.out.println(password+"tele");
	    register driver = new register(username,password,telephoneNumber);
	    DriverDAO driverdao = new DriverDAO();
	    boolean rowUpdated;
	    System.out.println(username+"tolalala");
		try {
			rowUpdated = driverdao.updateDriver(driver);
			if (rowUpdated) {
		        response.sendRedirect(request.getContextPath() + "/retrieveDriver");
		    } else {
		        response.getWriter().append("Failed to update driver");
		    }
		} catch (SQLException e) {
			e.printStackTrace();
		}
	    
	}
}