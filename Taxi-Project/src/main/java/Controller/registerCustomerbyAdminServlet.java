package Controller;

import java.io.IOException;
import java.sql.SQLException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import Model.register;
import Model.registerService;


@WebServlet("/registerCustomerbyAdmin")
public class registerCustomerbyAdminServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	 private registerService register;
	   
	   public void init() {
			String jdbcURL="jdbc:mysql://localhost:3306/Taxi";
			String jdbcUserName="root";
			String jdbcPassword="";
			
			register = new registerService(jdbcURL,jdbcUserName,jdbcPassword);
	   }
			
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		response.getWriter().append("Served at: ").append(request.getContextPath());
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		doGet(request, response);
		
		String telephoneNo=request.getParameter("telephoneNo");
		String password=request.getParameter("password");
		String userName=request.getParameter("userName");
		doGet(request, response);
		
		 register reg = new register(userName,password,telephoneNo);
		 
		 if (register.isTelephoneExists(telephoneNo)) {
	            request.setAttribute("registerError", "This telephone number is already registered. Please try again.");
	            RequestDispatcher rd = request.getRequestDispatcher("register.jsp");
	            rd.forward(request, response);
	            return;
	        }

	      try {
	    	
	    	 
	         boolean rowInserted = register.register(reg);
	         if (rowInserted) {
	            response.sendRedirect("/Taxi-Project/retrieveCustomer");
	         } else {
	            request.setAttribute("registerError", "Registration failed. Please try again.");
	            request.getRequestDispatcher("register.jsp").forward(request, response);
	         }
	    	
	      } catch (SQLException e) {
	         e.printStackTrace();
	      }
	      catch(Exception e) {
	    	  e.printStackTrace();
	      }
	   }
	}



