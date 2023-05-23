package Model;

public class DriverConfirmed {
	
	
	//create variables
	private String customerUserName;
	private String customerTelephoneNo;
	private String vehicle;
	private String customerCurrentLocation;
	private String customerDestination;
	private double amount;
	private String DriverUsename;
	private String DriverTelephone;
	
	//create constructors
	public DriverConfirmed(String customerUserName, String customerTelephoneNo, String vehicle,
			String customerCurrentLocation, String customerDestination, double amount, String DriverUsename, String DriverTelephone) {
		super();
		this.customerUserName = customerUserName;
		this.customerTelephoneNo = customerTelephoneNo;
		this.vehicle = vehicle;
		this.customerCurrentLocation = customerCurrentLocation;
		this.customerDestination = customerDestination;
		this.amount = amount;
		this.DriverTelephone=DriverTelephone;
		this.DriverUsename=DriverUsename;
		
	}
	
	public String getDriverUsename() {
		return DriverUsename;
	}

	public void setDriverUsename(String driverUsename) {
		DriverUsename = driverUsename;
	}

	public String getDriverTelephone() {
		return DriverTelephone;
	}

	public void setDriverTelephone(String driverTelephone) {
		DriverTelephone = driverTelephone;
	}

	public String getCustomerUserName() {
		return customerUserName;
	}
	public void setCustomerUserName(String customerUserName) {
		this.customerUserName = customerUserName;
	}
	public String getCustomerTelephoneNo() {
		return customerTelephoneNo;
	}
	public void setCustomerTelephoneNo(String customerTelephoneNo) {
		this.customerTelephoneNo = customerTelephoneNo;
	}
	public String getVehicle() {
		return vehicle;
	}
	public void setVehicle(String vehicle) {
		this.vehicle = vehicle;
	}
	public String getCustomerCurrentLocation() {
		return customerCurrentLocation;
	}
	public void setCustomerCurrentLocation(String customerCurrentLocation) {
		this.customerCurrentLocation = customerCurrentLocation;
	}
	public String getCustomerDestination() {
		return customerDestination;
	}
	public void setCustomerDestination(String customerDestination) {
		this.customerDestination = customerDestination;
	}
	public double getAmount() {
		return amount;
	}
	public void setAmount(double amount) {
		this.amount = amount;
	}
	
}
