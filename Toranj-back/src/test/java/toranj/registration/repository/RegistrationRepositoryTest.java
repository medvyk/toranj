package toranj.registration.repository;

import static org.junit.Assert.assertEquals;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.when;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.sql.ResultSet;
import java.sql.Statement;
import static org.mockito.Mockito.*;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.Mock;
import org.powermock.api.mockito.PowerMockito;
import org.powermock.core.classloader.annotations.PrepareForTest;
import org.powermock.modules.junit4.PowerMockRunner;
import org.springframework.test.context.junit4.SpringRunner;

import com.mysql.jdbc.Connection;

import toranj.common.repository.DataBaseConnectionUtil;
import toranj.registration.domain.Employee;
import toranj.registration.domain.Extra;
import toranj.registration.domain.Laptop;
import toranj.registration.domain.Office;
import toranj.registration.domain.Order;
import toranj.registration.domain.Position;
import toranj.registration.domain.Software;
import toranj.registration.repository.RegistrationRepository;

@RunWith(PowerMockRunner.class)
@PrepareForTest(RegistrationRepository.class)

public class RegistrationRepositoryTest {
	@Mock
	Connection connection;
	
	@Mock
	Statement st;
	
	@Mock
	ResultSet rs;
	
	DataBaseConnectionUtil util;
	RegistrationRepository registrationRepository;
	
	@Before
	public void setup() {
		 registrationRepository = new RegistrationRepository();
		 util = PowerMockito.mock(DataBaseConnectionUtil.class);
	}

	@Test
	public void addEmployeeTest() throws Exception {
		Employee employee = new Employee();
		employee.setArrivalDate(new Date());
		employee.setComment("c");
		employee.setExtra(new Extra());
		employee.setLaptop(new Laptop());
		employee.setName("n");
		employee.setSurname("s");
		employee.setOffice(new Office());
		employee.setPosition(new Position());
		employee.setSoftware(new Software());
		
	
		PowerMockito.whenNew(DataBaseConnectionUtil.class).withNoArguments().thenReturn(util);
		when(util.connect()).thenReturn(connection);
		when(connection.createStatement()).thenReturn(st);
		when(st.executeUpdate(any(String.class))).thenReturn(1);
		
		boolean result = registrationRepository.addEmployee(employee);
		
		Assert.assertTrue(result);
	}
	
	@Test
	public void getOfficesTest() throws Exception {
		
		List<Office> offices = new ArrayList<>();
		Office office = new Office();
		office.setIdOffice(1);
		office.setName("name");
		offices.add(office);
		
		PowerMockito.whenNew(DataBaseConnectionUtil.class).withNoArguments().thenReturn(util);
		when(util.connect()).thenReturn(connection);
		when(connection.createStatement()).thenReturn(st);
		when(st.executeQuery(any(String.class))).thenReturn(rs);
		
		when(rs.next()).thenReturn(true).thenReturn(false);
		when(rs.getInt(anyInt())).thenReturn(1);
		when(rs.getString(any(String.class))).thenReturn("name");
		
		List<Office> isOk = registrationRepository.getOffices();
		assertEquals(offices.size(), isOk.size());
	}
	
	@Test
	public void getPositionTest() throws Exception {
		
		List<Position> positions = new ArrayList<>();
		Position position = new Position();
		position.setIdPosition(1);
		position.setName("name");
		positions.add(position);
		
		PowerMockito.whenNew(DataBaseConnectionUtil.class).withNoArguments().thenReturn(util);
		when(util.connect()).thenReturn(connection);
		when(connection.createStatement()).thenReturn(st);
		when(st.executeQuery(any(String.class))).thenReturn(rs);
		
		when(rs.next()).thenReturn(true).thenReturn(false);
		when(rs.getInt(anyInt())).thenReturn(1);
		when(rs.getString(any(String.class))).thenReturn("name");
		
		List<Position> isOk = registrationRepository.getPosition();
		assertEquals(positions.size(), isOk.size());
	}
	
	@Test
	public void getSoftwareTest() throws Exception {
		
		List<Software> softwares = new ArrayList<>();
		Software software = new Software();
		software.setIdSoftware(1);
		software.setName("name");
		software.setPrice(2);
		softwares.add(software);
		
		PowerMockito.whenNew(DataBaseConnectionUtil.class).withNoArguments().thenReturn(util);
		when(util.connect()).thenReturn(connection);
		when(connection.createStatement()).thenReturn(st);
		when(st.executeQuery(any(String.class))).thenReturn(rs);
		
		when(rs.next()).thenReturn(true).thenReturn(false);
		when(rs.getInt("idSoftware")).thenReturn(1);
		when(rs.getString(any(String.class))).thenReturn("name");
		when(rs.getInt("Price")).thenReturn(2);
		
		List<Software> isOk = registrationRepository.getSoftware();
		assertEquals(softwares.size(), isOk.size());
	}
	
	@Test
	public void getEmployeeTest() throws Exception {
		
		List<Employee> employees = new ArrayList<>();
		Employee employee = new Employee();
		employee.setIdEmployee(1);
		employee.setName("name");
		employee.setSurname("s");
		employees.add(employee);
		
		PowerMockito.whenNew(DataBaseConnectionUtil.class).withNoArguments().thenReturn(util);
		when(util.connect()).thenReturn(connection);
		when(connection.createStatement()).thenReturn(st);
		when(st.executeQuery(any(String.class))).thenReturn(rs);
		
		when(rs.next()).thenReturn(true).thenReturn(false);
		when(rs.getInt(anyInt())).thenReturn(1);
		when(rs.getString("name")).thenReturn("name");
		when(rs.getString("surname")).thenReturn("s");
		
		List<Employee> isOk = registrationRepository.getEmployee();
		assertEquals(employees.size(), isOk.size());
	}
	
	@Test
	public void getLaptopTest() throws Exception {
		
		List<Laptop> laptops = new ArrayList<>();
		Laptop laptop = new Laptop();
		laptop.setIdLaptop(1);
		laptop.setName("name");
		laptop.setPrice(2);
		laptops.add(laptop);
		
		PowerMockito.whenNew(DataBaseConnectionUtil.class).withNoArguments().thenReturn(util);
		when(util.connect()).thenReturn(connection);
		when(connection.createStatement()).thenReturn(st);
		when(st.executeQuery(any(String.class))).thenReturn(rs);
		
		when(rs.next()).thenReturn(true).thenReturn(false);
		when(rs.getInt("idLaptop")).thenReturn(1);
		when(rs.getString(any(String.class))).thenReturn("name");
		when(rs.getInt("price")).thenReturn(2);
		
		List<Laptop> isOk = registrationRepository.getLaptop();
		assertEquals(laptops.size(), isOk.size());
	}
	@Test
	public void getExtraTest() throws Exception {
		
		List<Extra> extras = new ArrayList<>();
		Extra extra = new Extra();
		extra.setIdExtra(1);
		extra.setName("name");
		extra.setMoney(2);
		extras.add(extra);
		
		PowerMockito.whenNew(DataBaseConnectionUtil.class).withNoArguments().thenReturn(util);
		when(util.connect()).thenReturn(connection);
		when(connection.createStatement()).thenReturn(st);
		when(st.executeQuery(any(String.class))).thenReturn(rs);
		
		when(rs.next()).thenReturn(true).thenReturn(false);
		when(rs.getInt("idExtra")).thenReturn(1);
		when(rs.getString(any(String.class))).thenReturn("name");
		when(rs.getInt("Money")).thenReturn(2);
		
		List<Extra> isOk = registrationRepository.getExtra();
		assertEquals(extras.size(), isOk.size());
	}
	
	@Test
	public void placeOrderTest() throws Exception {
		Order order = new Order();
		order.setIdEmployee(1);
		order.setIdExtra(2);
		order.setIdLaptop(3);
		order.setIdSoftware(4);
		
		PowerMockito.whenNew(DataBaseConnectionUtil.class).withNoArguments().thenReturn(util);
		when(util.connect()).thenReturn(connection);
		when(connection.createStatement()).thenReturn(st);
		when(st.executeBatch()).thenReturn(new int[0]);
		
		boolean result = registrationRepository.placeOrder(order);
		
		Assert.assertTrue(result);
	}
	
}
