package Model;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.PreparedStatement;

import javax.sql.DataSource;



public class CustomerDAO {
	
	private String jdbcURL = "jdbc:mysql://localhost:3306/Taxi";
    private String jdbcUsername = "root";
    private String jdbcPassword = "";
    private Connection jdbcConnection;
    DataSource dataSource;
    
    public boolean updateCustomer(register customer) throws SQLException {
        
        boolean rowInserted = false;
	      connect();
	      
	      
	      
	      PreparedStatement preparedStatement = jdbcConnection
	            .prepareStatement("UPDATE userinfo SET userName = ?, password = ? WHERE telephone = ?");
	      preparedStatement.setString(1, customer.getUserName());
	      preparedStatement.setString(2, customer.getPassword());
	      preparedStatement.setString(3, customer.getTelephoneNo());
	      System.out.println(customer.getTelephoneNo()+"telephone");
	      System.out.println(customer.getPassword()+"password");
	      System.out.println(customer.getUserName()+"username");
	      

	      rowInserted = preparedStatement.executeUpdate() > 0;
	      preparedStatement.close();
	      disconnect();

	      return rowInserted;
        
    }


	
	 protected void connect() throws SQLException {
	        if (jdbcConnection == null || jdbcConnection.isClosed()) {
	            try {
	                Class.forName("com.mysql.jdbc.Driver");
	            } catch (ClassNotFoundException e) {
	                throw new SQLException(e);
	            }
	            jdbcConnection = DriverManager.getConnection(jdbcURL, jdbcUsername, jdbcPassword);
	        }
	    }

	    protected void disconnect() throws SQLException {
	        if (jdbcConnection != null && !jdbcConnection.isClosed()) {
	            jdbcConnection.close();
	        }
	    }

}
