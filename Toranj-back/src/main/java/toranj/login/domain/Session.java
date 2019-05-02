package toranj.login.domain;

public class Session {
	String token;
	String error;
	
	public Session() {
		super();
	}

	public String getToken() {
		return token;
	}

	public void setToken(String token) {
		this.token = token;
	}



	public String getError() {
		return error;
	}

	public void setError(String error) {
		this.error = error;
	}
	
	

}
