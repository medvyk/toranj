package toranj.login.service;

//we create an interface for login service to be called from controller. 
public interface LoginService {
	
	public int checkUser(String user, String password);
	

}
