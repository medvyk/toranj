package toranj.registration.service;

import java.util.List;

import toranj.registration.domain.Employee;
import toranj.registration.domain.Extra;
import toranj.registration.domain.Laptop;
import toranj.registration.domain.Office;
import toranj.registration.domain.Order;
import toranj.registration.domain.Position;
import toranj.registration.domain.Software;
import toranj.registration.repository.RegistrationRepository;

public class RegistrationServiceImpl implements RegistrationService {

	RegistrationRepository registrationRepository;
	
	public RegistrationServiceImpl(RegistrationRepository registrationRepository) {
		this.registrationRepository = registrationRepository;
	}

	public boolean addMember(Employee employee) {


		boolean success = registrationRepository.addEmployee(employee);

		return success;
	}

	public List<Office> showOffices() {


		List<Office> offices = registrationRepository.getOffices();

		return offices;
	}

	public List<Position> showPosition() {


		List<Position> positions = registrationRepository.getPosition();

		return positions;
	}

	public List<Software> showSoftware() {


		List<Software> softwares = registrationRepository.getSoftware();

		return softwares;
	}

	public List<Employee> showEmployee() {


		List<Employee> employees = registrationRepository.getEmployee();

		return employees;
	}

	public List<Laptop> showLaptop() {


		List<Laptop> laptops = registrationRepository.getLaptop();

		return laptops;
	}

	public List<Extra> showExtra() {


		List<Extra> extras = registrationRepository.getExtra();

		return extras;
	}

	public boolean makeOrder(Order order) {


		boolean success = registrationRepository.placeOrder(order);

		return success;
	}
}
