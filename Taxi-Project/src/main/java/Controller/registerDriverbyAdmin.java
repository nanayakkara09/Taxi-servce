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


@WebServlet("/registerDriverbyAdmin")
//Singleton Design Pattern
public class registerDriverbyAdmin extends HttpServlet {
	private static final long serialVersionUID = 1L;
	private registerService register;
	   
	//connecting to the database
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
		
		//doGet(request, response);
		String telephoneNo=request.getParameter("telephoneNo");
		String password=request.getParameter("password");
		String userName=request.getParameter("userName");
		
		
		 register reg = new register(userName,password,telephoneNo);
		 
		 if (register.isDriverTelephoneExists(telephoneNo)) {
	            request.setAttribute("registerError", "This telephone number is already registered. Please try again.");
	            RequestDispatcher rd = request.getRequestDispatcher("registerDriverbyAdmin.jsp");
	            rd.forward(request, response);
	            return;
	        }

	      try {
	    	
	    	 
	         boolean rowInserted = register.registerDriver(reg);
	         if (rowInserted) {
	            response.sendRedirect("/Taxi-Project/retrieveDriver");
	         } else {
	            request.setAttribute("registerError", "Registration failed. Please try again.");
	            request.getRequestDispatcher("registerDriverbyAdmin.jsp").forward(request, response);
	         }
	         //handling exceptions
	    	
	      } catch (SQLException e) {
	         e.printStackTrace();
	      }
	      catch(Exception e) {
	    	  e.printStackTrace();
	      }
	   }
	}


