package toranj.global.service;

import java.util.List;

import toranj.registration.domain.Employee;

public interface GlobalService {
	
	public List<Employee> displayEmployee();
	
	public List<Employee> displayEmployeeOffice ();
	
	public List<Employee> displayEmployeePosition ();
	
	public int sumEmployee ();
	
	public int sumSoftware ();
	
	public int sumLaptop ();
	

}
