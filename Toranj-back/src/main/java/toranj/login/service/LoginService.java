package toranj.login.service;

import toranj.login.domain.User;

//we create an interface for login service to be called from controller. 
public interface LoginService {
	
	public int checkUser(User user);
	
	public String getSession(User user);
	
	public boolean checkSession(String session);
	
	public boolean logout(String session);

}
