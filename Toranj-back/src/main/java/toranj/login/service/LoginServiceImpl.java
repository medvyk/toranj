package main.java.toranj.login.service;

import main.java.toranj.login.repository.LoginRepository;

public class LoginServiceImpl implements LoginService{

	public int checkUser(String user, String password) {
		LoginRepository loginRepository = new LoginRepository();
		int isValid = loginRepository.findUser(user, password);
		return isValid;
	}
}
