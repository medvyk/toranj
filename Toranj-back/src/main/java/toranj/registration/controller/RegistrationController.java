package toranj.registration.controller;

import java.util.List;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestHeader;
import org.springframework.web.bind.annotation.RestController;

import toranj.login.repository.LoginRepository;
import toranj.login.service.LoginService;
import toranj.login.service.LoginServiceImpl;
import toranj.registration.domain.Employee;
import toranj.registration.domain.Extra;
import toranj.registration.domain.Laptop;
import toranj.registration.domain.Office;
import toranj.registration.domain.Order;
import toranj.registration.domain.Position;
import toranj.registration.domain.Software;
import toranj.registration.service.RegistrationService;
import toranj.registration.service.RegistrationServiceImpl;

//This is not a good practice but we need to do it because it is required
@CrossOrigin(origins = "*", maxAge = 3600)


@RestController
public class RegistrationController {

	// ADD EMPLOYEE
	@PutMapping("/employee")
	public ResponseEntity addEmployee(@RequestHeader("Authorization") String session, @RequestBody Employee employee) {
		LoginService lService = new LoginServiceImpl();
		if (!lService.checkSession(session)) {
			return new ResponseEntity<>(null, HttpStatus.UNAUTHORIZED);
		} else {
		RegistrationService registrationService = new RegistrationServiceImpl();
		boolean isOk = registrationService.addMember(employee);
		if (isOk) {
			return new ResponseEntity(HttpStatus.OK);
		} else {
			return new ResponseEntity(HttpStatus.INTERNAL_SERVER_ERROR);
		}
	}
	}

	// SHOW OFFICE
	@GetMapping("/offices")
	public ResponseEntity<List<Office>> getOffices(@RequestHeader("Authorization") String session) {
		LoginService lService = new LoginServiceImpl();
		if (!lService.checkSession(session)) {
			return new ResponseEntity<>(null, HttpStatus.UNAUTHORIZED);
		} else {
			RegistrationService registrationService = new RegistrationServiceImpl();
			List<Office> offices = registrationService.showOffices();
			return ResponseEntity.ok(offices);
		}
	}

	// SHOW POSITION
	@GetMapping("/positions")
	public ResponseEntity<List<Position>> getPosition(@RequestHeader("Authorization") String session) {
		LoginService lService = new LoginServiceImpl();
		if (!lService.checkSession(session)) {
			return new ResponseEntity<>(null, HttpStatus.UNAUTHORIZED);
		} else {
			RegistrationService registrationService = new RegistrationServiceImpl();
			List<Position> positions = registrationService.showPosition();
			return ResponseEntity.ok(positions);
		}
	}

	// SHOW SOFTWARE
	@GetMapping("/softwares")
	public ResponseEntity<List<Software>> getSoftwares(@RequestHeader("Authorization") String session) {
		LoginService lService= new LoginServiceImpl();
		if(!lService.checkSession(session)) {
			return new ResponseEntity<>(null, HttpStatus.UNAUTHORIZED);
		} else {
		RegistrationService registrationService = new RegistrationServiceImpl();
		List<Software> softwares = registrationService.showSoftware();
		return ResponseEntity.ok(softwares);
	}
	}

	// SHOW EMPLOYEE
	@GetMapping("/employee")
	public ResponseEntity<List<Employee>> getEmployee(@RequestHeader("Authorization") String session) {
		LoginService lService= new LoginServiceImpl();
		if(!lService.checkSession(session)) {
			return new ResponseEntity<>(null, HttpStatus.UNAUTHORIZED);
		} else {
		RegistrationService registrationService = new RegistrationServiceImpl();
		List<Employee> employees = registrationService.showEmployee();
		return ResponseEntity.ok(employees);
	}
	}

	// SHOW LAPTOPS
	@GetMapping("/laptops")
	public ResponseEntity<List<Laptop>> getLaptop(@RequestHeader("Authorization") String session) {
		LoginService lService= new LoginServiceImpl();
		if(!lService.checkSession(session)) {
			return new ResponseEntity<>(null, HttpStatus.UNAUTHORIZED);
		} else {
		RegistrationService registrationService = new RegistrationServiceImpl();
		List<Laptop> laptops = registrationService.showLaptop();
		return ResponseEntity.ok(laptops);
	}
	}

	// SHOW EXTRA
	@GetMapping("/extras")
	public ResponseEntity<List<Extra>> getExtra(@RequestHeader("Authorization") String session) {
		LoginService lService= new LoginServiceImpl();
		if(!lService.checkSession(session)) {
			return new ResponseEntity<>(null, HttpStatus.UNAUTHORIZED);
		} else {
		RegistrationService registrationService = new RegistrationServiceImpl();
		List<Extra> extras = registrationService.showExtra();
		return ResponseEntity.ok(extras);
	}
	}

	// UPDATE ORDER
	@PostMapping("/order")
	public ResponseEntity addEmployee(@RequestHeader("Authorization") String session, @RequestBody Order order) {
		LoginService lService = new LoginServiceImpl();
		if (!lService.checkSession(session)) {
			return new ResponseEntity<>(null, HttpStatus.UNAUTHORIZED);
		} else {
		RegistrationService registrationService = new RegistrationServiceImpl();
		boolean isOk = registrationService.makeOrder(order);
		if (isOk) {
			return new ResponseEntity(HttpStatus.OK);
		} else {
			return new ResponseEntity(HttpStatus.INTERNAL_SERVER_ERROR);
		}
	}
	}
}
