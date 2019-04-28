package toranj.login.domain;

public class User {
	
	String userName;
	String password;
	int key;
	
	
	public User(String userName, String password, int key) {
		super();
		this.userName = userName;
		this.password = password;
		this.key = key;
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
	public int getKey() {
		return key;
	}
	public void setKey(int key) {
		this.key = key;
	}
	
	

}
