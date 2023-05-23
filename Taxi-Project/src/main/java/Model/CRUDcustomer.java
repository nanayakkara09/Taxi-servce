package Model;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import com.mysql.cj.jdbc.MysqlDataSource;

public class CRUDcustomer {
	
	 	private String jdbcURL = "jdbc:mysql://localhost:3306/Taxi";
	    private String jdbcUsername = "root";
	    private String jdbcPassword = "";
	    private Connection jdbcConnection;

	    private static final String SELECT_ALL_USERS_SQL = "SELECT userName,telephone FROM userinfo;";
	    
	    


	    
	    private void printSQLException(SQLException ex) {
	        for (Throwable e : ex) {
	            if (e instanceof SQLException) {
	                e.printStackTrace(System.err);
	                System.err.println("SQLState: " + ((SQLException) e).getSQLState());
	                System.err.println("Error Code: " + ((SQLException) e).getErrorCode());
	                System.err.println("Message: " + e.getMessage());
	                Throwable t = ex.getCause();
	                while (t != null) {
	                    System.out.println("Cause: " + t);
	                    t = t.getCause();
	                }
	            }
	        }
	    }
	    
	    
	    
	    
	    
	    
	    
	    
	    
	    
	    
	    public List<User> selectAllUsers() {
	        List<User> users = new ArrayList<>();
	        try {
	            
	            MysqlDataSource dataSource = new MysqlDataSource();
	            dataSource.setURL(jdbcURL);
	            dataSource.setUser(jdbcUsername);
	            dataSource.setPassword(jdbcPassword);

	            
	            Connection connection = dataSource.getConnection();
	            
	            
	            PreparedStatement preparedStatement = connection.prepareStatement(SELECT_ALL_USERS_SQL);
	            ResultSet rs = preparedStatement.executeQuery();

	            
	            while (rs.next()) {
	                String username = rs.getString("userName");
	                String telephoneNumber = rs.getString("telephone");
	                User user = new User(username, telephoneNumber);
	                users.add(user);
	            }
	        } catch (SQLException e) {
	            printSQLException(e);
	        }
	        
	        
	        
	        return users;
	    }
	    
	    
	    
	    
	    public boolean deleteCustomer(String telephone) throws SQLException {
	        String sql = "DELETE FROM userInfo where telephone = ?";
	        System.out.println(telephone);
	        connect();

	        PreparedStatement statement = jdbcConnection.prepareStatement(sql);
	        statement.setString(1, telephone);

	        boolean rowDeleted = statement.executeUpdate() > 0;
	        statement.close();
	        disconnect();
	        return rowDeleted;
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
