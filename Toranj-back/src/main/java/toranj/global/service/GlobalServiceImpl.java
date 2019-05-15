package toranj.global.service;

import java.util.List;

import toranj.global.repository.GlobalRepository;
import toranj.registration.domain.Employee;


public class GlobalServiceImpl implements GlobalService{

	GlobalRepository globalRepository;
	
	public GlobalServiceImpl(GlobalRepository globalRepository) {
		this.globalRepository = globalRepository;
		
	}
	
	public List<Employee> displayEmployee() {


		List<Employee> fullEmployee = globalRepository.showEmployee();

		return fullEmployee;
	}
	
	public List<Employee> displayEmployeeOffice() {


		List<Employee> employeeAtOffice = globalRepository.showEmployeeAtOffice();

		return employeeAtOffice;
	}
	
	public List<Employee> displayEmployeePosition() {


		List<Employee> employeePosition = globalRepository.showEmployeePosition();

		return employeePosition;
	}
	
	public int sumEmployee() {


		int totalEmployee = globalRepository.totalEmployee();

		return totalEmployee;
	}

	public int sumSoftware() {


		int totalSoftware = globalRepository.totalSoftware();

		return totalSoftware;
	}
	
	public int sumLaptop() {


		int totalLaptop = globalRepository.totalLaptop();

		return totalLaptop;
	}
}
