package Controller;

import java.io.IOException;
import java.sql.SQLException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import Model.Driver;
import Model.driverLoginService;
import Model.RideDAO;



@WebServlet("/driver")
public class driverLoginServlet extends HttpServlet {
private static final long serialVersionUID = 1L;
	
	private driverLoginService driverLogin;
	
	public void init() {
		String jdbcURL="jdbc:mysql://localhost:3306/Taxi";
		String jdbcUserName="root";
		String jdbcPassword="";
		
		driverLogin = new driverLoginService(jdbcURL,jdbcUserName,jdbcPassword);
	}
	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		try {
		String telephoneNo=request.getParameter("telephoneNo");
		String password=request.getParameter("password");
		
		
		Driver driver=new Driver(telephoneNo,password);

	
	
        if (driverLogin.validate(driver)) {
           HttpSession session = request.getSession();
           session.setAttribute("telephoneNo", telephoneNo);
           RideDAO rideDAO = new RideDAO();
           

           
           rideDAO.setConfirmed(telephoneNo);
           response.sendRedirect("pending");
        } else {
           response.sendRedirect("driverLogin.jsp?error=Invalid telephone or password.");
        }
     } catch (SQLException e) {
        throw new ServletException(e);
     }
  }
}


