package toranj.global.controller;

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

import toranj.global.service.GlobalService;
import toranj.login.service.LoginService;
import toranj.registration.domain.Employee;


@RunWith(PowerMockRunner.class)
@PrepareForTest(GlobalController.class)
public class GlobalControllerTest {
	
	@Mock
	LoginService loginService;
	
	@Mock
	GlobalService globalService;

	GlobalController gController;
	
	@Before
	public void setup() throws Exception {
		PowerMockito.mockStatic(GlobalController.class);
		gController = new GlobalController();
	}
	
	@Test
	public void displayEmployeeTest() throws Exception {
		when(GlobalController.getLoginService()).thenReturn(loginService);
		when(GlobalController.getGlobalService()).thenReturn(globalService);
		when(loginService.checkSession(any(String.class))).thenReturn(true);
		
		List<Employee> employees = new ArrayList<>();
		Employee e = new Employee();
		employees.add(e);
		when(globalService.displayEmployee()).thenReturn(employees);
		
		ResponseEntity<List<Employee>> result = gController.displayEmployee("token");
		
		assertEquals(HttpStatus.OK, result.getStatusCode());
		assertEquals(1, result.getBody().size());
	}
	
	@Test
	public void displayEmployeeOfficeTest() throws Exception {
		when(GlobalController.getLoginService()).thenReturn(loginService);
		when(GlobalController.getGlobalService()).thenReturn(globalService);
		when(loginService.checkSession(any(String.class))).thenReturn(true);
		
		List<Employee> employees = new ArrayList<>();
		Employee e = new Employee();
		employees.add(e);
		when(globalService.displayEmployeeOffice()).thenReturn(employees);
		
		ResponseEntity<List<Employee>> result = gController.displayEmployeeOffice("token");
		
		assertEquals(HttpStatus.OK, result.getStatusCode());
		assertEquals(1, result.getBody().size());
	}
	
	@Test
	public void displayEmployeePositionTest() throws Exception {
		when(GlobalController.getLoginService()).thenReturn(loginService);
		when(GlobalController.getGlobalService()).thenReturn(globalService);
		when(loginService.checkSession(any(String.class))).thenReturn(true);
		
		List<Employee> employees = new ArrayList<>();
		Employee e = new Employee();
		employees.add(e);
		when(globalService.displayEmployeePosition()).thenReturn(employees);
		
		ResponseEntity<List<Employee>> result = gController.displayEmployeePosition("token");
		
		assertEquals(HttpStatus.OK, result.getStatusCode());
		assertEquals(1, result.getBody().size());
	}
	
	@Test
	public void sumEmployeeTest() throws Exception {
		when(GlobalController.getLoginService()).thenReturn(loginService);
		when(GlobalController.getGlobalService()).thenReturn(globalService);
		when(loginService.checkSession(any(String.class))).thenReturn(true);
		when(globalService.sumEmployee()).thenReturn(1);
		
		 ResponseEntity<Integer> result = gController.sumEmployee("token");
		
		assertEquals(HttpStatus.OK, result.getStatusCode());
		assertEquals(1, result.getBody().intValue());
	}
	
	@Test
	public void sumSoftwareTest() throws Exception {
		when(GlobalController.getLoginService()).thenReturn(loginService);
		when(GlobalController.getGlobalService()).thenReturn(globalService);
		when(loginService.checkSession(any(String.class))).thenReturn(true);
		when(globalService.sumSoftware()).thenReturn(1);
		
		 ResponseEntity<Integer> result = gController.sumSoftware("token");
		
		assertEquals(HttpStatus.OK, result.getStatusCode());
		assertEquals(1, result.getBody().intValue());
	}
	
	@Test
	public void sumLaptopTest() throws Exception {
		when(GlobalController.getLoginService()).thenReturn(loginService);
		when(GlobalController.getGlobalService()).thenReturn(globalService);
		when(loginService.checkSession(any(String.class))).thenReturn(true);
		when(globalService.sumLaptop()).thenReturn(1);
		
		 ResponseEntity<Integer> result = gController.sumLaptop("token");
		
		assertEquals(HttpStatus.OK, result.getStatusCode());
		assertEquals(1, result.getBody().intValue());
	}
}
