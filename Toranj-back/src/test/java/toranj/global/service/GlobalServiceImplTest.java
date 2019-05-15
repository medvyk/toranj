package toranj.global.service;

import java.util.ArrayList;
import java.util.List;

import static org.junit.Assert.assertEquals;
import static org.mockito.Mockito.*;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.Mock;
import org.springframework.test.context.junit4.SpringRunner;

import toranj.global.repository.GlobalRepository;
import toranj.registration.domain.Employee;

@RunWith(SpringRunner.class)
public class GlobalServiceImplTest {

	@Mock
	GlobalRepository globalRepository;
	
	GlobalServiceImpl gsi;
	
	@Before
	public void setUp() {
		this.gsi = new GlobalServiceImpl(globalRepository);
	}
	
	@Test
	public void displayEmployeeTest() {
		List<Employee> employees = new ArrayList<>();
		
		when(globalRepository.showEmployee()).thenReturn(employees);
		List<Employee> isOk = gsi.displayEmployee();
		
		assertEquals(employees.size(), isOk.size());
		
	}
	
	@Test
	public void displayEmployeeOfficeTest() {
		List<Employee> employees = new ArrayList<>();
		
		when(globalRepository.showEmployeeAtOffice()).thenReturn(employees);
		List<Employee> isOk = gsi.displayEmployeeOffice();
		
		assertEquals(employees.size(), isOk.size());
		
	}
	
	@Test
	public void displayEmployeePositionTest() {
		List<Employee> employees = new ArrayList<>();
		
		when(globalRepository.showEmployeePosition()).thenReturn(employees);
		List<Employee> isOk = gsi.displayEmployeePosition();
		
		assertEquals(employees.size(), isOk.size());
		
	}
	
	@Test
	public void sumEmployeeTest() {
		
		when(globalRepository.totalEmployee()).thenReturn(1);
		int isOk = gsi.sumEmployee();
		
		assertEquals(1, isOk);
		
	}
	
	@Test
	public void sumSoftwareTest() {
		
		when(globalRepository.totalSoftware()).thenReturn(1);
		int isOk = gsi.sumSoftware();
		
		assertEquals(1, isOk);
		
	}
	
	@Test
	public void sumLaptopTest() {
		
		when(globalRepository.totalLaptop()).thenReturn(1);
		int isOk = gsi.sumLaptop();
		
		assertEquals(1, isOk);
		
	}
}
