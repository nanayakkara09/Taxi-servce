package Model;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import com.mysql.cj.jdbc.MysqlDataSource;

//connecting to the database
public class CRUDrides {
	private String jdbcURL = "jdbc:mysql://localhost:3306/Taxi";
    private String jdbcUsername = "root";
    private String jdbcPassword = "";
    private Connection jdbcConnection;

    //select all rides where status=pending in ride database
    private static final String SELECT_ALL_Rides_SQL = "SELECT * FROM ride where status='pending';";
    
    //handling sql exception
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
    
    
    
    
    
    
    
    
    
    
    
    public List<Ride> selectAllRides() {
        List<Ride> rides = new ArrayList<>();
        try {
            
            MysqlDataSource dataSource = new MysqlDataSource();
            dataSource.setURL(jdbcURL);
            dataSource.setUser(jdbcUsername);
            dataSource.setPassword(jdbcPassword);

            
            Connection connection = dataSource.getConnection();
            
            
            PreparedStatement preparedStatement = connection.prepareStatement(SELECT_ALL_Rides_SQL);
            ResultSet rs = preparedStatement.executeQuery();

            
            while (rs.next()) {
            	int Id = rs.getInt("id");
                String username = rs.getString("username");
                String telephoneNumber = rs.getString("telephone_number");
                String vehicle = rs.getString("vehicle");
                String current_location = rs.getString("current_location");
                String destination = rs.getString("destination");
                int kilometers = rs.getInt("kilometers");
                int amount = rs.getInt("amount");
                String status = rs.getString("status");
                Ride ride =new Ride(username,telephoneNumber,vehicle,current_location,destination,kilometers,amount);
                ride.setStatus(status);
                ride.setId(Id);
                rides.add(ride);
                
            }
        } catch (SQLException e) {
            printSQLException(e);
        }
        
        
        
        return rides;
    }
    
    
    
    
    public boolean deleteRide(int id) throws SQLException {
    	System.out.println(id);
        String sql = "DELETE FROM ride where id = ?";
        
        connect();
        
        PreparedStatement statement = jdbcConnection.prepareStatement(sql);
        statement.setInt(1, id);
        

        
        

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


