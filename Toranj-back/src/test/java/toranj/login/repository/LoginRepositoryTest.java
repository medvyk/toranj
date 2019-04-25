package toranj.login.repository;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.Mock;
import org.powermock.api.mockito.PowerMockito;
import org.powermock.core.classloader.annotations.PrepareForTest;
import org.powermock.modules.junit4.PowerMockRunner;
import com.mysql.jdbc.Connection;

import static org.mockito.Mockito.*;

import java.sql.ResultSet;
import java.sql.Statement;

import toranj.common.repository.DataBaseConexionUtil;

@RunWith(PowerMockRunner.class)
@PrepareForTest(LoginRepository.class)
public class LoginRepositoryTest {

	@Mock
	Connection connection;
	
	@Mock
	Statement st;
	
	@Mock
	ResultSet rs;
	
	DataBaseConexionUtil util;
	
	@Before
	public void setup() {
		 util = PowerMockito.mock(DataBaseConexionUtil.class);
	}
	
	@Test
	public void findUserTest() throws Exception {
		PowerMockito.whenNew(DataBaseConexionUtil.class).withNoArguments().thenReturn(util);
		when(util.connect()).thenReturn(connection);
		when(connection.createStatement()).thenReturn(st);
		when(st.executeQuery(any(String.class))).thenReturn(rs);
		when(rs.getInt("idEmployee")).thenReturn(0);
		
		LoginRepository loginRepository = new LoginRepository();
		int userId = loginRepository.findUser("user", "password");
		
		Assert.assertEquals(userId, 0);
		
	}
}
