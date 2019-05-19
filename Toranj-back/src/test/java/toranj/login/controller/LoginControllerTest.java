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
import toranj.login.domain.Session;
import toranj.login.domain.User;

@RunWith(PowerMockRunner.class)
@PrepareForTest(LoginController.class)
public class LoginControllerTest {

	@Mock
	LoginService loginService;
	
	//global variable
	LoginController loginController;
	
	//create in before an object of the class
	@Before
	public void setup() throws Exception {
		PowerMockito.mockStatic(LoginController.class);
		loginController = new LoginController();
	}
	
	
	@Test
	public void loginUnauthorizedTest() throws Exception {
		when(LoginController.getLoginService()).thenReturn(loginService);
		User user = new User();
		when(loginService.checkUser(any(User.class))).thenReturn(0);
		ResponseEntity<Session> session = loginController.login(user);
		
		assertEquals(HttpStatus.UNAUTHORIZED, session.getStatusCode());
		
	}
	
	@Test
	public void loginTest() throws Exception {
		when(LoginController.getLoginService()).thenReturn(loginService);
		String token = "session";
		when(loginService.checkUser(any(User.class))).thenReturn(1);
		when(loginService.getSession(any(User.class))).thenReturn(token);
	
		User user = new User();
		user.setUserName("user");
		user.setPassword("pass");
		
		ResponseEntity<Session> session = loginController.login(user);
		
		assertEquals(HttpStatus.OK, session.getStatusCode());
		
	}
	
	@Test
	public void loginInternalServerErrorTest() throws Exception {
		when(LoginController.getLoginService()).thenReturn(loginService);
		when(loginService.checkUser(any(User.class))).thenReturn(1);
		when(loginService.getSession(any(User.class))).thenReturn(null);
	
		User user = new User();
		user.setUserName("user");
		user.setPassword("pass");
		
		ResponseEntity<Session> session = loginController.login(user);
		
		assertEquals(HttpStatus.INTERNAL_SERVER_ERROR, session.getStatusCode());
		
	}
	
	@Test
	public void logoutUnauthorizedTest() throws Exception {
		when(LoginController.getLoginService()).thenReturn(loginService);
		when(loginService.checkSession(any(String.class))).thenReturn(false);
		
		ResponseEntity byeSession = loginController.logout("");
		
		assertEquals(HttpStatus.UNAUTHORIZED, byeSession.getStatusCode());
		
	}
	
	@Test
	public void logout() throws Exception {
		when(LoginController.getLoginService()).thenReturn(loginService);
		when(loginService.checkSession(any(String.class))).thenReturn(true);
		when(loginService.logout(any(String.class))).thenReturn(true);
		
		ResponseEntity okSession = loginController.logout("");
		assertEquals(HttpStatus.OK, okSession.getStatusCode());
		
	}

	@Test
	public void logoutInternalServerError() throws Exception {
		when(LoginController.getLoginService()).thenReturn(loginService);
		when(loginService.checkSession(any(String.class))).thenReturn(true);
		when(loginService.logout(any(String.class))).thenReturn(false);
		
		ResponseEntity session = loginController.logout("");
		assertEquals(HttpStatus.INTERNAL_SERVER_ERROR, session.getStatusCode());
		
	}
	
}
