package Model;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;

public class confirmRideService {
	private String jdbcURL;
	private String jdbcUsername;
	private String jdbcPassword;
	private Connection jdbcConnection;
	
	//create constructors
	public confirmRideService(String jdbcURL, String jdbcUsername, String jdbcPassword) {
		this.jdbcURL = jdbcURL;
		this.jdbcUsername = jdbcUsername;
		this.jdbcPassword = jdbcPassword;
	}
	
	 //open connection to the MySQL database
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
	
	//validation
	 public boolean insert(ConfirmRide con) throws SQLException {
	      boolean rowInserted = false;
	      connect();
	    
	      PreparedStatement preparedStatement = jdbcConnection
	            .prepareStatement("insert into confirmeddriver values (?, ?, ?, ?, ?, ?, ?, ?)");
	      preparedStatement.setString(1, con.getUsername());
	      preparedStatement.setString(2, con.getTelephone());
	      preparedStatement.setString(3, con.getVehicle());
	      

	      rowInserted = preparedStatement.executeUpdate() > 0;
	      preparedStatement.close();
	      disconnect();

	      return rowInserted;
	   }
	
}
