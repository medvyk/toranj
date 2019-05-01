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

	public RegistrationServiceImpl() {
		super();
	}

	public boolean addMember(Employee employee) {

		RegistrationRepository registrationRepository = new RegistrationRepository();

		boolean success = registrationRepository.addEmployee(employee);

		return success;
	}

	public List<Office> showOffices() {

		RegistrationRepository registrationRepository = new RegistrationRepository();

		List<Office> offices = registrationRepository.getOffices();

		return offices;
	}

	public List<Position> showPosition() {

		RegistrationRepository registrationRepository = new RegistrationRepository();

		List<Position> positions = registrationRepository.getPosition();

		return positions;
	}

	public List<Software> showSoftware() {

		RegistrationRepository registrationRepository = new RegistrationRepository();

		List<Software> softwares = registrationRepository.getSoftware();

		return softwares;
	}

	public List<Employee> showEmployee() {

		RegistrationRepository registrationRepository = new RegistrationRepository();

		List<Employee> employees = registrationRepository.getEmployee();

		return employees;
	}

	public List<Laptop> showLaptop() {

		RegistrationRepository registrationRepository = new RegistrationRepository();

		List<Laptop> laptops = registrationRepository.getLaptop();

		return laptops;
	}

	public List<Extra> showExtra() {

		RegistrationRepository registrationRepository = new RegistrationRepository();

		List<Extra> extras = registrationRepository.getExtra();

		return extras;
	}

	public boolean makeOrder(Order order) {

		RegistrationRepository registrationRepository = new RegistrationRepository();

		boolean success = registrationRepository.placeOrder(order);

		return success;
	}
}
