package toranj.login.service;

import toranj.login.repository.LoginRepository;

//the implementation of the interface loginservice

public class LoginServiceImpl implements LoginService{
	
	

	public LoginServiceImpl() {
		super();
	}

	public int checkUser(String user, String password) {
		LoginRepository loginRepository = new LoginRepository();
		int isValid = loginRepository.findUser(user, password);
		return isValid;
	}
}
