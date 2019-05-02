package toranj.login.domain;

public class User {
	
	int id;
	String userName;
	String password;
	int key;
	String session;
	
	public User() {
		super();
	}
	
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
	
	public String getSession() {
		return session;
	}

	public void setSession(String session) {
		this.session = session;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}


}
