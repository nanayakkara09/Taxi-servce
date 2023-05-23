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
import Model.CRUDdriverPending;
import Model.Driver;
import Model.DriverConfirmed;


@WebServlet("/retrieveDriverPending")
//Singleton Design Pattern
public class retrieveDriverPending extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
   
    public retrieveDriverPending() {
        super();
       
    }

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

		response.getWriter().append("Served at: ").append(request.getContextPath());
		CRUDdriverPending driver=new CRUDdriverPending();
		
		// Retrieve all requested rides from the database
		List<DriverConfirmed> drivers = driver.selectAllDriverConfirmed();
		
		
		// Set the requested rides as an attribute in the request object
		request.setAttribute("drivers", drivers);
		
	    // Forward the request to the JSP page
		RequestDispatcher dispatcher = request.getRequestDispatcher("DriverConfirmed.jsp");
	    dispatcher.forward(request, response);
	}

	//forwards the request to the doGet method to handle the request
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doGet(request, response);
	}

}
