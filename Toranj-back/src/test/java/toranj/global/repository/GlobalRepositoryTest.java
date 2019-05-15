package toranj.global.repository;

import static org.junit.Assert.assertEquals;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.ArgumentMatchers.anyInt;
import static org.mockito.Mockito.when;

import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.Mock;
import org.powermock.api.mockito.PowerMockito;
import org.powermock.core.classloader.annotations.PrepareForTest;
import org.powermock.modules.junit4.PowerMockRunner;


import com.mysql.jdbc.Connection;

import toranj.common.repository.DataBaseConnectionUtil;
import toranj.registration.domain.Employee;
import toranj.registration.domain.Extra;
import toranj.registration.domain.Laptop;
import toranj.registration.domain.Office;
import toranj.registration.domain.Position;
import toranj.registration.domain.Software;
import toranj.registration.repository.RegistrationRepository;

@RunWith(PowerMockRunner.class)
@PrepareForTest(GlobalRepository.class)
public class GlobalRepositoryTest {
	
	@Mock
	Connection connection;
	
	@Mock
	Statement st;
	
	@Mock
	ResultSet rs;
	
	DataBaseConnectionUtil util;
	
	GlobalRepository globalRepository;
	
	@Before
	public void setUp() {
		this.globalRepository = new GlobalRepository();
		 util = PowerMockito.mock(DataBaseConnectionUtil.class);
	}
	
	@Test
	public void showEmployeeTest() throws Exception {
		List<Employee> employees = new ArrayList<>();
		Employee employee = new Employee();
		employees.add(employee);
		
		PowerMockito.whenNew(DataBaseConnectionUtil.class).withNoArguments().thenReturn(util);
		when(util.connect()).thenReturn(connection);
		when(connection.createStatement()).thenReturn(st);
		when(st.executeQuery(any(String.class))).thenReturn(rs);
		when(rs.next()).thenReturn(true).thenReturn(false);
		
		List<Employee> isOk = globalRepository.showEmployee();
		assertEquals(employees.size(), isOk.size());
	}

	@Test
	public void showEmployeeAtOfficeTest() throws Exception {
		List<Employee> employees = new ArrayList<>();
		Employee employee = new Employee();
		employees.add(employee);
		
		PowerMockito.whenNew(DataBaseConnectionUtil.class).withNoArguments().thenReturn(util);
		when(util.connect()).thenReturn(connection);
		when(connection.createStatement()).thenReturn(st);
		when(st.executeQuery(any(String.class))).thenReturn(rs);
		when(rs.next()).thenReturn(true).thenReturn(false);
		
		List<Employee> isOk = globalRepository.showEmployeeAtOffice();
		assertEquals(employees.size(), isOk.size());
	}
	
	@Test
	public void showEmployeePositionTest() throws Exception {
		List<Employee> employees = new ArrayList<>();
		Employee employee = new Employee();
		employees.add(employee);
		
		PowerMockito.whenNew(DataBaseConnectionUtil.class).withNoArguments().thenReturn(util);
		when(util.connect()).thenReturn(connection);
		when(connection.createStatement()).thenReturn(st);
		when(st.executeQuery(any(String.class))).thenReturn(rs);
		when(rs.next()).thenReturn(true).thenReturn(false);
		
		List<Employee> isOk = globalRepository.showEmployeePosition();
		assertEquals(employees.size(), isOk.size());
	}
	
	@Test
	public void totalEmployeeTest() throws Exception {
		
		PowerMockito.whenNew(DataBaseConnectionUtil.class).withNoArguments().thenReturn(util);
		when(util.connect()).thenReturn(connection);
		when(connection.createStatement()).thenReturn(st);
		when(st.executeQuery(any(String.class))).thenReturn(rs);
		when(rs.getInt(anyInt())).thenReturn(0);
		
		int isOk = globalRepository.totalEmployee();
		assertEquals(0, isOk);
	}
	
	@Test
	public void totalSoftwareTest() throws Exception {
		
		PowerMockito.whenNew(DataBaseConnectionUtil.class).withNoArguments().thenReturn(util);
		when(util.connect()).thenReturn(connection);
		when(connection.createStatement()).thenReturn(st);
		when(st.executeQuery(any(String.class))).thenReturn(rs);
		when(rs.getInt(anyInt())).thenReturn(0);
		
		int isOk = globalRepository.totalSoftware();
		assertEquals(0, isOk);
	}
	
	@Test
	public void totalLaptopTest() throws Exception {
		
		PowerMockito.whenNew(DataBaseConnectionUtil.class).withNoArguments().thenReturn(util);
		when(util.connect()).thenReturn(connection);
		when(connection.createStatement()).thenReturn(st);
		when(st.executeQuery(any(String.class))).thenReturn(rs);
		when(rs.getInt(anyInt())).thenReturn(0);
		
		int isOk = globalRepository.totalLaptop();
		assertEquals(0, isOk);
	}
}
