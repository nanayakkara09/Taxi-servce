	package Controller;

import java.io.IOException;
import java.sql.SQLException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import Model.Login;
import Model.adminLoginService;


@WebServlet("/adminLoginServlet")
//Singleton Design Pattern
public class adminLoginServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
	
	private adminLoginService login;
	
	//connecting to the database
	public void init() {
		String jdbcURL="jdbc:mysql://localhost:3306/Taxi";
		String jdbcUserName="root";
		String jdbcPassword="";
		
		login = new adminLoginService(jdbcURL,jdbcUserName,jdbcPassword);
	}
	
	// extract the values submitted by the client as part of the HTTP POST request
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String telephoneNo=request.getParameter("telephoneNo");
		String password=request.getParameter("password");
		
		Login log=new Login(telephoneNo,password);

	//login details validate
	try {
        if (login.validate(log)) {
           HttpSession session = request.getSession();
           session.setAttribute("telephoneNo", telephoneNo);
           response.sendRedirect("adminDashboard.jsp");
        }
        //error massage
        else {
           response.sendRedirect("adminLogin.jsp?error=Invalid telephone or password.");
        }
        //sqlexception handling
     } catch (SQLException e) {
        throw new ServletException(e);
     }
  }
}


