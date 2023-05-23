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

import Model.CRUDcustomer;
import Model.CustomerDAO;
import Model.User;
import Model.register;


@WebServlet("/updateServlet")
public class updateServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public updateServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
		
		String telephoneNumber = request.getParameter("telephoneNumber");
	    String username = request.getParameter("username");
	    String password = request.getParameter("password");
	    register customer = new register(username,password,telephoneNumber);
	    CustomerDAO customerDAO = new CustomerDAO();
	    boolean rowUpdated;
	    System.out.println(username);
		try {
			rowUpdated = customerDAO.updateCustomer(customer);
			if (rowUpdated) {
		        response.sendRedirect(request.getContextPath() + "/retrieveCustomer");
		    } else {
		        response.getWriter().append("Failed to update customer");
		    }
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	    
	}
}