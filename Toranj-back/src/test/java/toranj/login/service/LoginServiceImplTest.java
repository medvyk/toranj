package toranj.login.service;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.when;

import static org.mockito.Mockito.*;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.Mock;
import org.powermock.api.mockito.PowerMockito;
import org.powermock.core.classloader.annotations.PrepareForTest;
import org.powermock.modules.junit4.PowerMockRunner;
import org.springframework.test.context.junit4.SpringRunner;

import toranj.common.helper.EncodingHelper;
import toranj.login.domain.User;
import toranj.login.repository.LoginRepository;

@RunWith(SpringRunner.class)
public class LoginServiceImplTest {

	@Mock
	LoginRepository lr;
	
	@Mock
	EncodingHelper eHelper;

	LoginServiceImpl lsi;

	@Before
	public void setup() throws Exception {
		lsi = new LoginServiceImpl(lr, eHelper);
	}

	@Test
	public void checkUserTest() throws Exception {
		
		when(lr.findUser(any(User.class))).thenReturn(0);
		User user = new User();
		user.setUserName("user");
		user.setPassword("password");
		
		int userId = lsi.checkUser(user);

		assertEquals(0, userId);

	}
	
	@Test
	public void  getSession() throws Exception {
		
		User user = new User();
		String session="isOk";
		
		when(eHelper.encodeValues(any(User.class))).thenReturn(session);
		when(lr.setSession(anyInt(), any(String.class))).thenReturn(1);
		
		String result = lsi.getSession(user);
		
		assertEquals(session,result);
		
	}
	
	@Test
	public void checkSessionTest() {
		String session="ok";
		User user = new User();
		
		when(eHelper.decodeValues(any(String.class))).thenReturn(user);
		when(lr.checkSession(any(User.class))).thenReturn(true);
		
		boolean isOk = lsi.checkSession(session);
		
		assertTrue(isOk);
	}
	
	@Test
	public void logout() {
		String session="ok";
		User user = new User();
		
		when(eHelper.decodeValues(any(String.class))).thenReturn(user);
		when(lr.logout(any(User.class))).thenReturn(true);
		
		boolean isOk = lsi.logout(session);
		
		assertTrue(isOk);
	}

}
