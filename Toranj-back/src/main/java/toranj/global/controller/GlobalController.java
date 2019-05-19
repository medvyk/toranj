package toranj.global.controller;

import java.util.List;


import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestHeader;
import org.springframework.web.bind.annotation.RestController;

import toranj.common.helper.EncodingHelper;
import toranj.global.repository.GlobalRepository;
import toranj.global.service.GlobalService;
import toranj.global.service.GlobalServiceImpl;
import toranj.login.repository.LoginRepository;
import toranj.login.service.LoginService;
import toranj.login.service.LoginServiceImpl;
import toranj.registration.domain.Employee;
import toranj.registration.domain.Office;
//This is not a good practice but we need to do it because it is required by localhost
@CrossOrigin(origins = "*", maxAge = 3600)

@RestController
public class GlobalController {
	
	// SHOW Employees in main table
	@GetMapping("/employeeData")
	public ResponseEntity<List<Employee>> displayEmployee(@RequestHeader("Authorization") String session) {
		LoginService lService = getLoginService();
		if (!lService.checkSession(session)) {
			return new ResponseEntity<>(null, HttpStatus.UNAUTHORIZED);
		} else {
			GlobalService globalService = getGlobalService();
			List<Employee> fullEmployees = globalService.displayEmployee();
			return ResponseEntity.ok(fullEmployees);
		}
	}

	// SHOW Employees per Office
	@GetMapping("/employeeAtOffice")
	public ResponseEntity<List<Employee>> displayEmployeeOffice(@RequestHeader("Authorization") String session) {
		LoginService lService = getLoginService();
		if (!lService.checkSession(session)) {
			return new ResponseEntity<>(null, HttpStatus.UNAUTHORIZED);
		} else {
			GlobalService globalService = getGlobalService();
			List<Employee> employeeAtOffice = globalService.displayEmployeeOffice();
			return ResponseEntity.ok(employeeAtOffice);
		}
	}
	
	// SHOW Employees per Position
		@GetMapping("/employeePosition")
		public ResponseEntity<List<Employee>> displayEmployeePosition(@RequestHeader("Authorization") String session) {
			LoginService lService = getLoginService();
			if (!lService.checkSession(session)) {
				return new ResponseEntity<>(null, HttpStatus.UNAUTHORIZED);
			} else {
				GlobalService globalService = getGlobalService();
				List<Employee> employeePosition = globalService.displayEmployeePosition();
				return ResponseEntity.ok(employeePosition);
			}
		}
		
		// SHOW total Employees 
		@GetMapping("/totalEmployee")
		public ResponseEntity<Integer> sumEmployee(@RequestHeader("Authorization") String session) {
			LoginService lService = getLoginService();
			if (!lService.checkSession(session)) {
				return new ResponseEntity<>(null, HttpStatus.UNAUTHORIZED);
			} else {
				GlobalService globalService = getGlobalService();
				int totalEmployee = globalService.sumEmployee();
				return ResponseEntity.ok(totalEmployee);
			}
		}
		
		// SHOW total Software 
		@GetMapping("/totalSoftware")
		public ResponseEntity <Integer> sumSoftware(@RequestHeader("Authorization") String session) {
			LoginService lService = getLoginService();
			if (!lService.checkSession(session)) {
				return new ResponseEntity<>(null, HttpStatus.UNAUTHORIZED);
			} else {
				GlobalService globalService = getGlobalService();
				int totalSoftware = globalService.sumSoftware();
				return ResponseEntity.ok(totalSoftware);
			}
		}
		// SHOW total laptop 
		@GetMapping("/totalLaptop")
		public ResponseEntity <Integer> sumLaptop(@RequestHeader("Authorization") String session) {
			LoginService lService = getLoginService();
			if (!lService.checkSession(session)) {
				return new ResponseEntity<>(null, HttpStatus.UNAUTHORIZED);
			} else {
				GlobalService globalService = getGlobalService();
				int totalLaptop = globalService.sumLaptop();
				return ResponseEntity.ok(totalLaptop);
			}
		}
		
		protected static LoginService getLoginService() {
			return new LoginServiceImpl(new LoginRepository(), new EncodingHelper());
		}
		
		protected static GlobalService getGlobalService() {
			return new GlobalServiceImpl(new GlobalRepository());
		}
}
