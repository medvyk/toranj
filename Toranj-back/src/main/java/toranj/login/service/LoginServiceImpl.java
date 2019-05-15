package toranj.login.service;

import toranj.common.helper.EncodingHelper;
import toranj.login.domain.User;
import toranj.login.repository.LoginRepository;

//the implementation of the interface loginservice

public class LoginServiceImpl implements LoginService{
	
	LoginRepository loginRepository;
	EncodingHelper eHelper;
	

	public LoginServiceImpl(LoginRepository loginRepository, EncodingHelper eHelper) {
		this.eHelper = eHelper;
		this.loginRepository = loginRepository;
	}

	@Override
	public int checkUser(User user) {
		int isValid = loginRepository.findUser(user);
		return isValid;
	}

	@Override
	public String getSession(User user) {
		String session = eHelper.encodeValues(user);
		int result = loginRepository.setSession(user.getId(), session); 
		if(result == 1) {
			return session;
		} else {
			return null;
		}
	}

	@Override
	public boolean checkSession(String session) {
		User user = eHelper.decodeValues(session);
		return loginRepository.checkSession(user);
	}

	@Override
	public boolean logout(String session) {
		User user = eHelper.decodeValues(session);
		return loginRepository.logout(user);
	}

}
