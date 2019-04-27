package toranj.login.service;

import static org.junit.Assert.assertEquals;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.when;

import org.junit.Before;
import org.junit.Test;
import org.mockito.Mock;
import org.powermock.api.mockito.PowerMockito;

import toranj.login.repository.LoginRepository;

public class LoginServiceImplTest {

	@Mock
	LoginRepository lr;

	LoginServiceImpl lsi;

	@Before
	public void setup() {
		lsi = new LoginServiceImpl();
	}

	@Test
	public void checkUserTest() throws Exception {

		PowerMockito.whenNew(LoginRepository.class).withNoArguments().thenReturn(lr);
		when(lr.findUser(any(String.class), any(String.class))).thenReturn(0);

		int userId = lr.findUser("user", "1");

		assertEquals(0, userId);

	}

}
