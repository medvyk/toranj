package toranj.registration.controller;

import static org.junit.Assert.assertEquals;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.when;

import java.util.ArrayList;
import java.util.List;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.Mock;
import org.powermock.api.mockito.PowerMockito;
import org.powermock.core.classloader.annotations.PrepareForTest;
import org.powermock.modules.junit4.PowerMockRunner;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;

import toranj.login.controller.LoginController;
import toranj.login.domain.User;
import toranj.login.service.LoginService;
import toranj.registration.domain.Employee;
import toranj.registration.domain.Extra;
import toranj.registration.domain.Laptop;
import toranj.registration.domain.Office;
import toranj.registration.domain.Order;
import toranj.registration.domain.Position;
import toranj.registration.domain.Software;
import toranj.registration.service.RegistrationService;


@RunWith(PowerMockRunner.class)
@PrepareForTest(RegistrationController.class)
public class RegistrationControllerTest {
	
	@Mock
	LoginService loginService;
	
	@Mock
	RegistrationService registrationService;
	
	//global variable
	RegistrationController rController;
	
	//create in before an object of the class
	@Before
	public void setup() throws Exception {
		PowerMockito.mockStatic(RegistrationController.class);
		rController = new RegistrationController();
	}
	
	@Test
	public void addEmployeeTest() throws Exception {
		when(RegistrationController.getLoginService()).thenReturn(loginService);
		when(RegistrationController.getRegistrationService()).thenReturn(registrationService);
		User user = new User();
		when(loginService.checkSession(any(String.class))).thenReturn(true);
		when(registrationService.addMember(any(Employee.class))).thenReturn(true);
		
		ResponseEntity result = rController.addEmployee("", new Employee());
		
		assertEquals(HttpStatus.OK, result.getStatusCode());
		
	}
	
	@Test
	public void getOfficesTest() throws Exception {
		when(RegistrationController.getLoginService()).thenReturn(loginService);
		when(RegistrationController.getRegistrationService()).thenReturn(registrationService);
		when(loginService.checkSession(any(String.class))).thenReturn(true);
		
		List<Office> offices = new ArrayList<>();
		Office o = new Office();
		offices.add(o);
		when(registrationService.showOffices()).thenReturn(offices);
		
		ResponseEntity<List<Office>> result = rController.getOffices("");
		
		assertEquals(HttpStatus.OK, result.getStatusCode());
		assertEquals(1, result.getBody().size());
	}
	
	@Test
	public void getPositionTest() throws Exception {
		when(RegistrationController.getLoginService()).thenReturn(loginService);
		when(RegistrationController.getRegistrationService()).thenReturn(registrationService);
		when(loginService.checkSession(any(String.class))).thenReturn(true);
		
		List<Position> positions = new ArrayList<>();
		Position p = new Position();
		positions.add(p);
		when(registrationService.showPosition()).thenReturn(positions);
		
		ResponseEntity<List<Position>> result = rController.getPosition("");
		
		assertEquals(HttpStatus.OK, result.getStatusCode());
		assertEquals(1, result.getBody().size());
	}
	
	@Test
	public void getSoftwaresTest() throws Exception {
		when(RegistrationController.getLoginService()).thenReturn(loginService);
		when(RegistrationController.getRegistrationService()).thenReturn(registrationService);
		when(loginService.checkSession(any(String.class))).thenReturn(true);
		
		List<Software> software = new ArrayList<>();
		Software s = new Software();
		software.add(s);
		when(registrationService.showSoftware()).thenReturn(software);
		
		ResponseEntity<List<Software>> result = rController.getSoftwares("");
		
		assertEquals(HttpStatus.OK, result.getStatusCode());
		assertEquals(1, result.getBody().size());
	}
	
	@Test
	public void getEmployeeTest() throws Exception {
		when(RegistrationController.getLoginService()).thenReturn(loginService);
		when(RegistrationController.getRegistrationService()).thenReturn(registrationService);
		when(loginService.checkSession(any(String.class))).thenReturn(true);
		
		List<Employee> employees = new ArrayList<>();
		Employee e = new Employee();
		employees.add(e);
		when(registrationService.showEmployee()).thenReturn(employees);
		
		ResponseEntity<List<Employee>> result = rController.getEmployee("");
		
		assertEquals(HttpStatus.OK, result.getStatusCode());
		assertEquals(1, result.getBody().size());
	}
	
	@Test
	public void getLaptopTest() throws Exception {
		when(RegistrationController.getLoginService()).thenReturn(loginService);
		when(RegistrationController.getRegistrationService()).thenReturn(registrationService);
		when(loginService.checkSession(any(String.class))).thenReturn(true);
		
		List<Laptop> laptops = new ArrayList<>();
		Laptop l = new Laptop();
		laptops.add(l);
		when(registrationService.showLaptop()).thenReturn(laptops);
		
		ResponseEntity<List<Laptop>> result = rController.getLaptops("");
		
		assertEquals(HttpStatus.OK, result.getStatusCode());
		assertEquals(1, result.getBody().size());
	}
	
	@Test
	public void getExtraTest() throws Exception {
		when(RegistrationController.getLoginService()).thenReturn(loginService);
		when(RegistrationController.getRegistrationService()).thenReturn(registrationService);
		when(loginService.checkSession(any(String.class))).thenReturn(true);
		
		List<Extra> extras = new ArrayList<>();
		Extra e = new Extra();
		extras.add(e);
		when(registrationService.showExtra()).thenReturn(extras);
		
		ResponseEntity<List<Extra>> result = rController.getExtras("");
		
		assertEquals(HttpStatus.OK, result.getStatusCode());
		assertEquals(1, result.getBody().size());
	}
	
	@Test
	public void addOrderTest() throws Exception {
		when(RegistrationController.getLoginService()).thenReturn(loginService);
		when(RegistrationController.getRegistrationService()).thenReturn(registrationService);
		when(loginService.checkSession(any(String.class))).thenReturn(true);
		
		List<Order> orders = new ArrayList<>();
		Order o = new Order();
		orders.add(o);
		when(registrationService.makeOrder(any(Order.class))).thenReturn(true);
		
		ResponseEntity result = rController.addOrder("", new Order());
		
		assertEquals(HttpStatus.OK, result.getStatusCode());
	}
}
