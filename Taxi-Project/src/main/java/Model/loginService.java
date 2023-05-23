package Model;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class loginService {
	private String jdbcURL;
	private String jdbcUsername;
	private String jdbcPassword;
	private Connection jdbcConnection;

	public loginService(String jdbcURL, String jdbcUsername, String jdbcPassword) {
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

	public boolean validate(Login login) throws SQLException {
	      boolean isValid = false;
	      connect();
	      String sql = "SELECT * FROM userInfo WHERE telephone = ? and password = ?";
			PreparedStatement statement = jdbcConnection.prepareStatement(sql);
			statement.setString(1, login.getTelephoneNo());
			statement.setString(2, login.getPassword());
	      ResultSet result = statement.executeQuery();
	      if (result.next()) {
	         isValid = true;
	      }
	      
	      result.close();
	      statement.close();
	      disconnect();
	      return isValid;
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
	}