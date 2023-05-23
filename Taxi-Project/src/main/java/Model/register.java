package Model;

public class register {
	private String userName;
	private String password;
	private String telephoneNo;
	public register(String userName, String password, String telephoneNo) {
		
		this.userName = userName;
		this.password = password;
		this.telephoneNo = telephoneNo;
	}
	public String getUserName() {
		return userName;
	}
	public void setUserName(String userName) {
		this.userName = userName;
	}
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}
	public String getTelephoneNo() {
		return telephoneNo;
	}
	public void setTelephoneNo(String telephoneNo) {
		this.telephoneNo = telephoneNo;
	}
	
	
	
}
