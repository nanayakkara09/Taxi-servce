package Model;

//encapsulation
public class ConfirmRide {
	private int id;
    private String username;
    private String telephoneNumber;
    private String vehicle;
    private String currentLocation;
    private String destination;
    private int kilometers;
    private int amount;
    private String status;
    private String userName;
    private String telephone;

    // constructor
    public ConfirmRide(String username, String telephoneNumber, String vehicle, String currentLocation, String destination, int kilometers, int amount, String userName, String telephone) {
        this.username = username;
        this.telephoneNumber = telephoneNumber;
        this.vehicle = vehicle;
        this.currentLocation = currentLocation;
        this.destination = destination;
        this.kilometers = kilometers;
        this.amount = amount;
        this.userName=userName;
        this.telephone=telephone;
        this.status = "pending";
    }

    // getters and setters
    public String getUsername() {
        return username;
    }
    
    

    public String getUserName() {
		return userName;
	}

	public void setUserName(String userName) {
		this.userName = userName;
	}

	public String getTelephone() {
		return telephone;
	}

	public void setTelephone(String telephone) {
		this.telephone = telephone;
	}

	public void setUsername(String username) {
		this.username = username;
	}

	public void setTelephoneNumber(String telephoneNumber) {
		this.telephoneNumber = telephoneNumber;
	}

	public void setVehicle(String vehicle) {
		this.vehicle = vehicle;
	}

	public void setCurrentLocation(String currentLocation) {
		this.currentLocation = currentLocation;
	}

	public void setDestination(String destination) {
		this.destination = destination;
	}

	public void setKilometers(int kilometers) {
		this.kilometers = kilometers;
	}

	public void setAmount(int amount) {
		this.amount = amount;
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

