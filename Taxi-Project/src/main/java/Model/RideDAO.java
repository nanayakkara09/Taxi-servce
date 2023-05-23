package Model;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;
import java.util.ArrayList;

public class RideDAO {
    private String jdbcURL = "jdbc:mysql://localhost:3306/Taxi";
    private String jdbcUsername = "root";
    private String jdbcPassword = "";
    private Connection connection;

    private static final String INSERT_RIDE_SQL = "INSERT INTO ride (username, telephone_number, vehicle, current_location, destination, kilometers, amount, status) VALUES (?, ?, ?, ?, ?, ?, ?, ?);";
    private static final String SELECT_ALL_RIDES_SQL = "SELECT * FROM ride WHERE status='pending';";
    private static final String UPDATE_RIDE_STATUS_SQL = "UPDATE ride SET status='confirmed' WHERE id=?;";
    private static final String Confirm="INSERT INTO confirmeddriver (CustomerUserName, CustomerTelephoneNo, Vehicle, CustomerCurrentLocation, CustomerDestination, amount, DriverUserName, DriverTelephone) SELECT username, telephone_number, vehicle, current_location, destination, amount, ?, ? FROM ride WHERE status = 'Confirmed';";


    public void insertRide(Ride ride) throws SQLException {
        try (Connection connection = DriverManager.getConnection(jdbcURL, jdbcUsername, jdbcPassword);
             PreparedStatement preparedStatement = connection.prepareStatement(INSERT_RIDE_SQL)) {
            preparedStatement.setString(1, ride.getUsername());
            preparedStatement.setString(2, ride.getTelephoneNumber());
            preparedStatement.setString(3, ride.getVehicle());
            preparedStatement.setString(4, ride.getCurrentLocation());
            preparedStatement.setString(5, ride.getDestination());
            preparedStatement.setInt(6, ride.getKilometers());
            preparedStatement.setInt(7, ride.getAmount());
            preparedStatement.setString(8, ride.getStatus());
            preparedStatement.executeUpdate();
        } catch (SQLException e) {
            printSQLException(e);
        }
    }
    
    public void insertConfirmRide(ConfirmRide ride) throws SQLException {
        try (Connection connection = DriverManager.getConnection(jdbcURL, jdbcUsername, jdbcPassword);
             PreparedStatement preparedStatement = connection.prepareStatement(INSERT_RIDE_SQL)) {
            preparedStatement.setString(1, ride.getUsername());
            preparedStatement.setString(2, ride.getTelephoneNumber());
            preparedStatement.setString(3, ride.getVehicle());
            preparedStatement.setString(4, ride.getCurrentLocation());
            preparedStatement.setString(5, ride.getDestination());
            preparedStatement.setInt(6, ride.getKilometers());
            preparedStatement.setInt(7, ride.getAmount());
            preparedStatement.setString(8, ride.getStatus());
            preparedStatement.executeUpdate();
        } catch (SQLException e) {
            printSQLException(e);
        }
    }

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
    
    public String getUsernameByTelephoneNumber(String telephoneNumber) throws SQLException {
    	String jdbcURL = "jdbc:mysql://localhost:3306/Taxi";
        String jdbcUsername = "root";
        String jdbcPassword = "";
        Connection connection = DriverManager.getConnection(jdbcURL, jdbcUsername, jdbcPassword);
        PreparedStatement preparedStatement = (PreparedStatement) connection.prepareStatement("SELECT userName FROM userInfo WHERE telephone = ?");
        preparedStatement.setString(1, telephoneNumber);
        ResultSet resultSet = preparedStatement.executeQuery();
        if (resultSet.next()) {
            String username = resultSet.getString("username");
            return username;
        } else {
            return null;
        }
    }
    
    public List<Ride> selectAllRequestedRides() {
        List<Ride> rides = new ArrayList<>();
        try (Connection connection = DriverManager.getConnection(jdbcURL, jdbcUsername, jdbcPassword);
             PreparedStatement preparedStatement = connection.prepareStatement(SELECT_ALL_RIDES_SQL)) {
            ResultSet rs = preparedStatement.executeQuery();

            while (rs.next()) {
            	int id = rs.getInt("id");
                String username = rs.getString("username");
                String telephoneNumber = rs.getString("telephone_number");
                String vehicle = rs.getString("vehicle");
                String currentLocation = rs.getString("current_location");
                String destination = rs.getString("destination");
                int kilometers = rs.getInt("kilometers");
                int amount = rs.getInt("amount");
                String status = rs.getString("status");

                Ride ride = new Ride(username, telephoneNumber, vehicle, currentLocation, destination, kilometers, amount);
                ride.setStatus(status);
                ride.setId(id);
                rides.add(ride);
                
            }
        } catch (SQLException e) {
            printSQLException(e);
        }
        return rides;
    }

    public void updateRideStatus(int id) throws SQLException {
        try (Connection connection = DriverManager.getConnection(jdbcURL, jdbcUsername, jdbcPassword);
             PreparedStatement preparedStatement = connection.prepareStatement(UPDATE_RIDE_STATUS_SQL)) {
            preparedStatement.setInt(1, id);
            preparedStatement.executeUpdate();
        } catch (SQLException e) {
            printSQLException(e);
        }
    }
    
    public void setConfirmed(String telephone) throws SQLException {
    	String driverUsername = null;
    	try {
    		Connection connection = DriverManager.getConnection(jdbcURL, jdbcUsername, jdbcPassword);
    	    PreparedStatement statement = connection.prepareStatement("SELECT userName FROM driverinfo WHERE telephone = ?");
    	    statement.setString(1, telephone);
    	    ResultSet resultSet = statement.executeQuery();
    	    if (resultSet.next()) {
    	        driverUsername = resultSet.getString("userName");
    	    }
    	    resultSet.close();
    	    statement.close();
    	} catch (SQLException e) {
    	    e.printStackTrace();
    	}

        try (Connection connection = DriverManager.getConnection(jdbcURL, jdbcUsername, jdbcPassword);
             PreparedStatement preparedStatement = connection.prepareStatement(Confirm)) {
        	preparedStatement.setString(1, driverUsername);
        	preparedStatement.setString(2, telephone);
            preparedStatement.executeUpdate();
        } catch (SQLException e) {
            printSQLException(e);
        }
    }
    
    
}

