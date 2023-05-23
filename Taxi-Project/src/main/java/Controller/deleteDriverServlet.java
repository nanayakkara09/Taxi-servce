package Controller;

import java.io.IOException;
import java.sql.SQLException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import Model.CRUDdriver;

//handle HTTP requests related to deleting a driver
@WebServlet("/deleteDriverServlet")
//Singleton Design Pattern
public class deleteDriverServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
	CRUDdriver crud=new CRUDdriver();
   
    public deleteDriverServlet() {
        CRUDdriver crud=new CRUDdriver();
    }

	
    //delete a driver using the telephone number, and redirects the client based on the success or failure of the deletion operation
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		response.getWriter().append("Served at: ").append(request.getContextPath());
		
		String telephone = request.getParameter("telephoneNumber");
		System.out.println(telephone);
		
		try {
			boolean deleted=crud.deleteDriver(telephone);
			if(deleted)
			{
				response.sendRedirect(request.getContextPath() + "/retrieveDriver");
			}
			else {
				System.out.println("error");
			}
			//sql exception handling
		} catch (SQLException e) {
		
			e.printStackTrace();
		}
		
	}

	//forwards the request to the doGet method to handle the request
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doGet(request, response);
	}

}
