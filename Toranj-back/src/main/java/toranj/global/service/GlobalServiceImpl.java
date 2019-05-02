package toranj.global.service;

import java.util.List;

import toranj.global.repository.GlobalRepository;
import toranj.registration.domain.Employee;


public class GlobalServiceImpl implements GlobalService{

	public GlobalServiceImpl() {
		super();
		
	}
	
	public List<Employee> displayEmployee() {

		GlobalRepository globalRepository = new GlobalRepository();

		List<Employee> fullEmployee = globalRepository.showEmployee();

		return fullEmployee;
	}
	
	public List<Employee> displayEmployeeOffice() {

		GlobalRepository globalRepository = new GlobalRepository();

		List<Employee> employeeAtOffice = globalRepository.showEmployeeAtOffice();

		return employeeAtOffice;
	}
	
	public List<Employee> displayEmployeePosition() {

		GlobalRepository globalRepository = new GlobalRepository();

		List<Employee> employeePosition = globalRepository.showEmployeePosition();

		return employeePosition;
	}
	
	public int sumEmployee() {

		GlobalRepository globalRepository = new GlobalRepository();

		int totalEmployee = globalRepository.totalEmployee();

		return totalEmployee;
	}

	public int sumSoftware() {

		GlobalRepository globalRepository = new GlobalRepository();

		int totalSoftware = globalRepository.totalSoftware();

		return totalSoftware;
	}
	
	public int sumLaptop() {

		GlobalRepository globalRepository = new GlobalRepository();

		int totalLaptop = globalRepository.totalLaptop();

		return totalLaptop;
	}
}
