package toranj.login.controller;

import static org.mockito.Mockito.when;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.Mock;
import org.powermock.api.mockito.PowerMockito;
import org.powermock.core.classloader.annotations.PrepareForTest;
import org.powermock.modules.junit4.PowerMockRunner;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;


import static org.junit.Assert.assertEquals;
import static org.mockito.Mockito.*;
import toranj.login.service.LoginService;
import toranj.login.service.LoginServiceImpl;
import toranj.common.helper.EncodingHelper;
import toranj.login.domain.Session;
import toranj.login.domain.User;
import toranj.login.repository.LoginRepository;


@RunWith(PowerMockRunner.class)
//@PrepareForTest({LoginServiceImpl.class, LoginRepository.class,EncodingHelper.class })
public class LoginControllerTest {

	@Mock
	LoginRepository loginRepository;
	
	@Mock
	EncodingHelper eHelper;
	
	
	//LoginService loginService = spy(LoginServiceImpl.class);
	
	//global variable
	LoginController loginController;
	
	//create in before an object of the class
	@Before
	public void setup() throws Exception {
		PowerMockito.whenNew(LoginRepository.class).withAnyArguments().thenReturn(loginRepository);
		PowerMockito.whenNew(EncodingHelper.class).withAnyArguments().thenReturn(eHelper);
		loginController = new LoginController();
	}
	
	
	@Test
	public void loginUnauthorizedTest() throws Exception {
		//PowerMockito.whenNew(LoginService.class).withAnyArguments().thenReturn(loginService);
		User user = new User();
		//when(loginService.checkUser(any(User.class))).thenReturn(0);
		when(loginRepository.findUser(any(User.class))).thenReturn(0);
		//User user = new User();
		ResponseEntity<Session> session = loginController.login(user);
		
		assertEquals(HttpStatus.UNAUTHORIZED, session.getStatusCode());
		
	}
	
	//@Test
	public void loginTest() throws Exception {
		PowerMockito.whenNew(LoginRepository.class).withAnyArguments().thenReturn(loginRepository);
		PowerMockito.whenNew(EncodingHelper.class).withAnyArguments().thenReturn(eHelper);
		when(loginRepository.findUser(any(User.class))).thenReturn(1);
		String token = "session";
		when(eHelper.encodeValues(any(User.class))).thenReturn(token);
		when(loginRepository.setSession(anyInt(), anyString())).thenReturn(1);
	
		User user = new User();
		user.setUserName("user");
		user.setPassword("pass");
		
		ResponseEntity<Session> session = loginController.login(user);
		
		assertEquals(HttpStatus.OK, session.getStatusCode());
		
	}
	
	//@Test
	public void loginInternalServerErrorTest() throws Exception {
		PowerMockito.whenNew(LoginRepository.class).withAnyArguments().thenReturn(loginRepository);
		PowerMockito.whenNew(EncodingHelper.class).withAnyArguments().thenReturn(eHelper);
		when(loginRepository.findUser(any(User.class))).thenReturn(1);
		String token = "session";
		when(eHelper.encodeValues(any(User.class))).thenReturn(token);
		when(loginRepository.setSession(anyInt(), anyString())).thenReturn(0);
	
		User user = new User();
		user.setUserName("user");
		user.setPassword("pass");
		
		ResponseEntity<Session> session = loginController.login(user);
		
		assertEquals(HttpStatus.INTERNAL_SERVER_ERROR, session.getStatusCode());
		
	}
	
	//@Test
	public void logoutUnauthorizedTest() throws Exception {
		User user = new User();
		user.setUserName("");
		user.setId(1);
		user.setPassword("");
		user.setSession("");
		
		PowerMockito.whenNew(LoginRepository.class).withAnyArguments().thenReturn(loginRepository);
		PowerMockito.whenNew(EncodingHelper.class).withAnyArguments().thenReturn(eHelper);
		when(loginRepository.checkSession(any(User.class))).thenReturn(false);
		when(eHelper.decodeValues(any(String.class))).thenReturn(user);
		
		ResponseEntity byeSession = loginController.logout("");
		
		assertEquals(HttpStatus.UNAUTHORIZED, byeSession.getStatusCode());
		
	}
	
	//@Test
	public void logout() throws Exception {
		User user = new User();
		user.setUserName("");
		user.setId(1);
		user.setPassword("");
		user.setSession("");
		
		PowerMockito.whenNew(LoginRepository.class).withAnyArguments().thenReturn(loginRepository);
		PowerMockito.whenNew(EncodingHelper.class).withAnyArguments().thenReturn(eHelper);
		when(loginRepository.checkSession(any(User.class))).thenReturn(true);
		when(eHelper.decodeValues(any(String.class))).thenReturn(user);
		when(loginRepository.logout(any(User.class))).thenReturn(true);
		
		
		ResponseEntity okSession = loginController.logout("");
		assertEquals(HttpStatus.OK, okSession.getStatusCode());
		
	}

	//@Test
	public void logoutInternalServerError() throws Exception {
		User user = new User();
		user.setUserName("");
		user.setId(1);
		user.setPassword("");
		user.setSession("");
		
		PowerMockito.whenNew(LoginRepository.class).withAnyArguments().thenReturn(loginRepository);
		PowerMockito.whenNew(EncodingHelper.class).withAnyArguments().thenReturn(eHelper);
		when(loginRepository.checkSession(any(User.class))).thenReturn(true);
		when(eHelper.decodeValues(any(String.class))).thenReturn(user);
		when(loginRepository.logout(any(User.class))).thenReturn(false);
		
		
		ResponseEntity session = loginController.logout("");
		assertEquals(HttpStatus.INTERNAL_SERVER_ERROR, session.getStatusCode());
		
	}
	
}
