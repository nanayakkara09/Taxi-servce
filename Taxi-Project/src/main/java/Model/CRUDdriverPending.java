package Model;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import com.mysql.cj.jdbc.MysqlDataSource;

import Model.DriverConfirmed;

//connecting to the database
public class CRUDdriverPending {
	private String jdbcURL = "jdbc:mysql://localhost:3306/Taxi";
    private String jdbcUsername = "root";
    private String jdbcPassword = "";
    private Connection jdbcConnection;
    
    private static final String SELECT_ALL_Drivers_Confirm_SQL = "SELECT * FROM confirmeddriver;";
    
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
     
    //driver confirmed rides retrieved from the database
    public List<DriverConfirmed> selectAllDriverConfirmed() {
        List<DriverConfirmed> drivers = new ArrayList<>();
        try {
            
            MysqlDataSource dataSource = new MysqlDataSource();
            dataSource.setURL(jdbcURL);
            dataSource.setUser(jdbcUsername);
            dataSource.setPassword(jdbcPassword);

            
            Connection connection = dataSource.getConnection();
            
            
            PreparedStatement preparedStatement = connection.prepareStatement(SELECT_ALL_Drivers_Confirm_SQL);
            ResultSet rs = preparedStatement.executeQuery(); 

            
            while (rs.next()) {
            	String customerUsename = rs.getString("CustomerUserName");
                String customerTelephoneNo = rs.getString("customerTelephoneNo");
                String vehicle = rs.getString("vehicle");
                String customerCurrentLocation = rs.getString("CustomerCurrentLocation");
                String customerDestination = rs.getString("customerDestination");
                double amount = rs.getDouble("amount");
                String DriverUsename = rs.getString("DriverUserName");
                String DriverTelephone = rs.getString("DriverTelephone");
                DriverConfirmed driver = new DriverConfirmed(customerUsename, customerTelephoneNo, vehicle, customerCurrentLocation, customerDestination, amount, DriverUsename, DriverTelephone);
                drivers.add(driver);
               
            }
            //handle the exception.
        } catch (SQLException e) {
        	printSQLException(e);
        }
        
        
        
        return drivers;
    }
}
