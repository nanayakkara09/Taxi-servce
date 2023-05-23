package Controller;

import java.io.IOException;
import java.sql.SQLException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import Model.loginService;
import Model.Login;


@WebServlet("/login")
public class loginServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
	
	private loginService login;
	
	public void init() {
		String jdbcURL="jdbc:mysql://localhost:3306/Taxi";
		String jdbcUserName="root";
		String jdbcPassword="";
		
		login = new loginService(jdbcURL,jdbcUserName,jdbcPassword);
	}
	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String telephoneNo=request.getParameter("telephoneNo");
		String password=request.getParameter("password");
		
		Login log=new Login(telephoneNo,password);

	
	try {
        if (login.validate(log)) {
           HttpSession session = request.getSession();
           session.setAttribute("telephoneNo", telephoneNo);
           response.sendRedirect("ride_details.jsp");
        } else {
           response.sendRedirect("login.jsp?error=Invalid telephone or password.");
        }
     } catch (SQLException e) {
        throw new ServletException(e);
     }
  }
}


