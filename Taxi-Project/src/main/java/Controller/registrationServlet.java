package Controller;

import java.io.IOException;
import java.sql.SQLException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;


import Model.registerService;
import Model.register;


@WebServlet("/register")
public class registrationServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
   private registerService register;
   
   public void init() {
		String jdbcURL="jdbc:mysql://localhost:3306/Taxi";
		String jdbcUserName="root";
		String jdbcPassword="";
		
		register = new registerService(jdbcURL,jdbcUserName,jdbcPassword);
	}
   
    public registrationServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		response.getWriter().append("Served at: ").append(request.getContextPath());
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
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
	            response.sendRedirect("login.jsp");
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



