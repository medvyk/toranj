package toranj.registration.service;

import toranj.registration.domain.Position;

import java.util.List;

import toranj.registration.domain.Employee;
import toranj.registration.domain.Extra;
import toranj.registration.domain.Laptop;
import toranj.registration.domain.Office;
import toranj.registration.domain.Order;
import toranj.registration.domain.Software;

public interface RegistrationService {
	
	
	public boolean addMember(Employee employee );
	
	public List<Office> showOffices();
	
	public List<Position> showPosition();
	
	public List<Software> showSoftware();
	
	public List<Employee> showEmployee();
	
	public List<Laptop> showLaptop();
	
	public List<Extra> showExtra();
	
	public boolean makeOrder(Order order);

}
