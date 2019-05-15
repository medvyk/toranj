package toranj.registration.service;
import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;
import static org.mockito.Mockito.*;

import java.util.ArrayList;
import java.util.List;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.Mock;
import org.springframework.test.context.junit4.SpringRunner;

import toranj.registration.domain.Employee;
import toranj.registration.domain.Extra;
import toranj.registration.domain.Laptop;
import toranj.registration.repository.RegistrationRepository;
import toranj.registration.domain.Office;
import toranj.registration.domain.Order;
import toranj.registration.domain.Position;
import toranj.registration.domain.Software;

@RunWith(SpringRunner.class)
public class RegistrationServiceImplTest {
	@Mock
	RegistrationRepository registrationRepository;
	
	RegistrationServiceImpl rs;
	
	@Before
	public void setUp() {
		rs= new RegistrationServiceImpl(registrationRepository);
	}
	
	@Test
	public void addMemberTest() {
		Employee employee = new Employee();
		when(registrationRepository.addEmployee(any(Employee.class))).thenReturn(true);
		
		boolean isOK = rs.addMember(employee);
		
		assertTrue(isOK);
	}
	
	@Test
	public void showOfficesTest() {
		
		List<Office> offices= new ArrayList<>();
		when(registrationRepository.getOffices()).thenReturn(offices);
		List<Office> isOk = rs.showOffices();
		
		assertEquals(offices.size(), isOk.size());
	}

	@Test
	public void showPositionTest() {
		List<Position> positions = new ArrayList<>();
		when(registrationRepository.getPosition()).thenReturn(positions);
		List<Position> isOk=rs.showPosition();
		assertEquals(positions.size(), isOk.size());
	}
	
	@Test
	public void showSoftwareTest() {
		List<Software> softwares = new ArrayList<>();
		when(registrationRepository.getSoftware()).thenReturn(softwares);
		List<Software> isOk=rs.showSoftware();
		assertEquals(softwares.size(), isOk.size());
	}
	
	@Test
	public void showEmployeeTest() {
		List<Employee> employees = new ArrayList<>();
		when(registrationRepository.getEmployee()).thenReturn(employees);
		List<Software> isOk=rs.showSoftware();
		assertEquals(employees.size(), isOk.size());
	}
	
	@Test
	public void showLaptopTest() {
		List<Laptop> laptops = new ArrayList<>();
		when(registrationRepository.getLaptop()).thenReturn(laptops);
		List<Laptop> isOk=rs.showLaptop();
		assertEquals(laptops.size(), isOk.size());
	}
	
	@Test
	public void showExtraTest() {
		List<Extra> extras = new ArrayList<>();
		when(registrationRepository.getExtra()).thenReturn(extras);
		List<Extra> isOk=rs.showExtra();
		assertEquals(extras.size(), isOk.size());
	}
	
	@Test
	public void makeOrderTest() {
		Order order = new Order();
		when(registrationRepository.placeOrder(any(Order.class))).thenReturn(true);
		
		boolean isOK = rs.makeOrder(order);
		
		assertTrue(isOK);
	}
}
