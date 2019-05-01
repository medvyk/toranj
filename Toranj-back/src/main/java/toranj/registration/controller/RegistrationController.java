package toranj.registration.controller;

import java.util.List;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;
import toranj.registration.domain.Employee;
import toranj.registration.domain.Extra;
import toranj.registration.domain.Laptop;
import toranj.registration.domain.Office;
import toranj.registration.domain.Order;
import toranj.registration.domain.Position;
import toranj.registration.domain.Software;
import toranj.registration.service.RegistrationService;
import toranj.registration.service.RegistrationServiceImpl;

@RestController
public class RegistrationController {
	
	//ADD EMPLOYEE
	@PutMapping("/employee")
    public ResponseEntity addEmployee(@RequestBody Employee employee) {
        RegistrationService registrationService = new RegistrationServiceImpl();
        boolean isOk = registrationService.addMember(employee);
        if(isOk) {
        	return new ResponseEntity(HttpStatus.OK);
        } else {
        	return new ResponseEntity(HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }
	
	//SHOW OFFICE
	@GetMapping("/offices")
    public ResponseEntity<List<Office>> getOffices() {
        RegistrationService registrationService = new RegistrationServiceImpl();
        List<Office> offices = registrationService.showOffices();
        return ResponseEntity.ok(offices);
    }
	
	//SHOW POSITION
	@GetMapping("/positions")
    public ResponseEntity<List<Position>> getPosition() {
        RegistrationService registrationService = new RegistrationServiceImpl();
        List<Position> positions = registrationService.showPosition();
        return ResponseEntity.ok(positions);
    }
	
	//SHOW SOFTWARE
	@GetMapping("/softwares")
    public ResponseEntity<List<Software>> getSoftwares() {
        RegistrationService registrationService = new RegistrationServiceImpl();
        List<Software> softwares = registrationService.showSoftware();
        return ResponseEntity.ok(softwares);
    }
	
	//SHOW EMPLOYEE
	@GetMapping("/employee")
    public ResponseEntity<List<Employee>> getEmployee() {
        RegistrationService registrationService = new RegistrationServiceImpl();
        List<Employee> employees = registrationService.showEmployee();
        return ResponseEntity.ok(employees);
    }
	
	//SHOW LAPTOPS
	@GetMapping("/laptops")
    public ResponseEntity<List<Laptop>> getLaptop() {
        RegistrationService registrationService = new RegistrationServiceImpl();
        List<Laptop> laptops = registrationService.showLaptop();
        return ResponseEntity.ok(laptops);
    }
	
	//SHOW EXTRA
	@GetMapping("/extras")
    public ResponseEntity<List<Extra>> getExtra() {
        RegistrationService registrationService = new RegistrationServiceImpl();
        List<Extra> extras = registrationService.showExtra();
        return ResponseEntity.ok(extras);
    }
	
	//UPDATE ORDER
	@PostMapping("/order")
    public ResponseEntity addEmployee(@RequestBody Order order) {
        RegistrationService registrationService = new RegistrationServiceImpl();
        boolean isOk = registrationService.makeOrder(order);
        if(isOk) {
        	return new ResponseEntity(HttpStatus.OK);
        } else {
        	return new ResponseEntity(HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

}
