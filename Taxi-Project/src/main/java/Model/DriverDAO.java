package Model;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;

import javax.sql.DataSource;

public class DriverDAO {

	//connecting to the database
	private String jdbcURL = "jdbc:mysql://localhost:3306/Taxi";
    private String jdbcUsername = "root";
    private String jdbcPassword = "";
    private Connection jdbcConnection;
    DataSource dataSource;
    
    public boolean updateDriver(register driver) throws SQLException {
        
        boolean rowInserted = false;
	      connect();
	      //update customer details 
	      PreparedStatement preparedStatement = jdbcConnection
	            .prepareStatement("UPDATE driverinfo SET userName = ?, password = ? WHERE telephone = ?");
	      preparedStatement.setString(1, driver.getUserName());
	      preparedStatement.setString(2, driver.getPassword());
	      preparedStatement.setString(3, driver.getTelephoneNo());
	      
	      rowInserted = preparedStatement.executeUpdate() > 0;
	      preparedStatement.close();
	      disconnect();

	      return rowInserted;
        
    }
	
	 protected void connect() throws SQLException {
	        if (jdbcConnection == null || jdbcConnection.isClosed()) {
	            try {
	                Class.forName("com.mysql.jdbc.Driver");
	                //handling sql exception 
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
