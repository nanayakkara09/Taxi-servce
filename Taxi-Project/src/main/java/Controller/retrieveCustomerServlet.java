package Controller;

import java.io.IOException;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import Model.User;
import Model.CRUDcustomer;

/**
 * Servlet implementation class retrieveCustomerServlet
 */
@WebServlet("/retrieveCustomer")
public class retrieveCustomerServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		response.getWriter().append("Served at: ").append(request.getContextPath());
		
		CRUDcustomer customer=new CRUDcustomer();
		
		// Retrieve all requested rides from the database
	    List<User> users = customer.selectAllUsers();
	    if(users.size()==0) {
	    	System.out.println("gg");
	    }
	    else {
	   

	    // Set the requested rides as an attribute in the request object
	    request.setAttribute("users", users);

	    // Forward the request to the JSP page
	    RequestDispatcher dispatcher = request.getRequestDispatcher("customerList.jsp");
	    dispatcher.forward(request, response);
	    }
		
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
