package toranj.login.controller;

import static org.mockito.Mockito.when;

import org.junit.Before;
import org.junit.Test;
import org.mockito.Mock;
import org.powermock.api.mockito.PowerMockito;

import static org.junit.Assert.assertEquals;
import static org.mockito.Mockito.*;
import toranj.login.service.LoginService;

public class LoginControllerTest {

	@Mock
	LoginService ls;
	
	//global variable
	LoginController loginController;
	
	//create in before an object of the class
	@Before
	public void setup() {
		loginController = new LoginController();
	}
	
	
	@Test
	public void loginTest() throws Exception {
		PowerMockito.whenNew(LoginService.class).withNoArguments().thenReturn(ls);
		when(ls.checkUser(any(String.class), any(String.class))).thenReturn(0);
		
		int userId = loginController.login("user","1");
		
		assertEquals(0, userId);
		
	}
	
}
