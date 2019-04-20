package main.java.toranj.login.service;

public class LoginServiceImpl implements LoginService{

	public boolean checkUser(String user, String password) {
		LoginRepository loginRepository = new LoginRepository();
		boolean isValid = loginRepository.findUser(user, password);
		return isValid;
	}
}
