package toranj.login.controller;

import java.util.Base64;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import toranj.login.domain.Session;
import toranj.login.domain.User;
import toranj.login.service.LoginService;
import toranj.login.service.LoginServiceImpl;

//	WE SPRING TO CREATE THE ENDPOINT. THE FRAMEWORK WILL MANAGE THE ENDPOINT

//This is not a good practice but we need to do it because it is required
@CrossOrigin(origins = "*", maxAge = 3600)

@RestController
public class LoginController {
	
	public LoginController() {
	}
	
	@PostMapping("/login")
    public ResponseEntity<Session> login(@RequestBody User user) {
		Session session = new Session();
        LoginService loginService = new LoginServiceImpl();
        int userId = loginService.checkUser(user);
        if(userId > 0) {
        	user.setId(userId);
        	String token = loginService.getSession(user);
        	if(token == null) {
        		session.setError("Error occured while creating the session");
        	    return new ResponseEntity<>(session, HttpStatus.INTERNAL_SERVER_ERROR);
        	} else {
        		session.setToken(token);
        		return ResponseEntity.ok(session);
        	}
        }
        session.setError("Credentials are inccorect.");
        return new ResponseEntity<>(session, HttpStatus.UNAUTHORIZED); 
    }
	

}