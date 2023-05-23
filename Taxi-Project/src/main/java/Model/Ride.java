package Model;

public class Ride {
	private int id;
    private String username;
    private String telephoneNumber;
    private String vehicle;
    private String currentLocation;
    private String destination;
    private int kilometers;
    private int amount;
    private String status;

    // constructor
    public Ride(String username, String telephoneNumber, String vehicle, String currentLocation, String destination, int kilometers, int amount) {
        this.username = username;
        this.telephoneNumber = telephoneNumber;
        this.vehicle = vehicle;
        this.currentLocation = currentLocation;
        this.destination = destination;
        this.kilometers = kilometers;
        this.amount = amount;
        this.status = "pending";
    }

    // getters and setters
    public String getUsername() {
        return username;
    }

    public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getTelephoneNumber() {
        return telephoneNumber;
    }

    public String getVehicle() {
        return vehicle;
    }

    public String getCurrentLocation() {
        return currentLocation;
    }

    public String getDestination() {
        return destination;
    }

    public int getKilometers() {
        return kilometers;
    }

    public int getAmount() {
        return amount;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }
}

