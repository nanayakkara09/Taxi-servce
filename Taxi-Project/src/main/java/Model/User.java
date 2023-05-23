package Model;

public class User {
	private String username;
    private String telephoneNumber;
    
    
    
	public User(String username, String telephoneNumber) {
		this.username = username;
		this.telephoneNumber = telephoneNumber;
	}
	public String getUsername() {
		return username;
	}
	public void setUsername(String username) {
		this.username = username;
	}
	public String getTelephoneNumber() {
		return telephoneNumber;
	}
	public void setTelephoneNumber(String telephoneNumber) {
		this.telephoneNumber = telephoneNumber;
	}
    
    
    
}
