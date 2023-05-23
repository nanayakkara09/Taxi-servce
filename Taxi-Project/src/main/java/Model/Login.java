package Model;

public class Login {
	private String password;
	private String telephoneNo;
	private String userName;
	
	public Login(String telephoneNo,String password) {
		this.telephoneNo=telephoneNo;
		this.password=password;
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
	
	public String getTelephoneNo() {
		return telephoneNo;
	}
	
	
	
	

}
