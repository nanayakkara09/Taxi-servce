package Model;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class registerService {
	private String jdbcURL;
	private String jdbcUsername;
	private String jdbcPassword;
	private Connection jdbcConnection;

	public registerService(String jdbcURL, String jdbcUsername, String jdbcPassword) {
		this.jdbcURL = jdbcURL;
		this.jdbcUsername = jdbcUsername;
		this.jdbcPassword = jdbcPassword;
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
	
	 public boolean isTelephoneExists(String telephone) {
	        boolean status = false;
	        try {
	        	connect();
	            PreparedStatement preparedStatement = jdbcConnection
	                    .prepareStatement("select * from userInfo where telephone = ?");
	            preparedStatement.setString(1, telephone);
	            ResultSet rs = preparedStatement.executeQuery();
	            if(rs.next()) {
	            	status = true;
	            }
	           

	        } catch (SQLException e) {
	            e.printStackTrace();
	        }
	       
	        return status;
	    }
	 
	 public boolean isDriverTelephoneExists(String telephone) {
	        boolean status = false;
	        try {
	        	connect();
	            PreparedStatement preparedStatement = jdbcConnection
	                    .prepareStatement("select * from driverinfo where telephone = ?");
	            preparedStatement.setString(1, telephone);
	            ResultSet rs = preparedStatement.executeQuery();
	            if(rs.next()) {
	            	status = true;
	            }
	           

	        } catch (SQLException e) {
	            e.printStackTrace();
	        }
	       
	        return status;
	    }
	
	 public boolean register(register reg) throws SQLException {
	      boolean rowInserted = false;
	      connect();
	      
	      
	      
	      PreparedStatement preparedStatement = jdbcConnection
	            .prepareStatement("insert into userInfo (telephone, password,userName) values (?, ?, ?)");
	      preparedStatement.setString(1, reg.getTelephoneNo());
	      preparedStatement.setString(2, reg.getPassword());
	      preparedStatement.setString(3, reg.getUserName());
	      

	      rowInserted = preparedStatement.executeUpdate() > 0;
	      preparedStatement.close();
	      disconnect();

	      return rowInserted;
	   }
	 
	 public boolean registerDriver(register reg) throws SQLException {
	      boolean rowInserted = false;
	      connect();
	      
	      System.out.println("pleaseeeee");
	      
	      PreparedStatement preparedStatement = jdbcConnection
	            .prepareStatement("insert into driverinfo (telephone, password,userName) values (?, ?, ?)");
	      preparedStatement.setString(1, reg.getTelephoneNo());
	      preparedStatement.setString(2, reg.getPassword());
	      preparedStatement.setString(3, reg.getUserName());
	      

	      rowInserted = preparedStatement.executeUpdate() > 0;
	      preparedStatement.close();
	      disconnect();

	      return rowInserted;
	   }
	
	}


