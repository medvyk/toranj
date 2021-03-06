package toranj.login.controller;


import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestHeader;
import org.springframework.web.bind.annotation.RestController;

import toranj.common.helper.EncodingHelper;
import toranj.login.domain.Session;
import toranj.login.domain.User;
import toranj.login.repository.LoginRepository;
import toranj.login.service.LoginService;
import toranj.login.service.LoginServiceImpl;

//	WE SPRING TO CREATE THE ENDPOINT. THE FRAMEWORK WILL MANAGE THE ENDPOINT

//This is not a good practice but we need to do it because it is required
@CrossOrigin(origins = "*", maxAge = 3600)

@RestController
public class LoginController {
	
	@PostMapping("/login")
    public ResponseEntity<Session> login(@RequestBody User user) {
		Session session = new Session();
        LoginService loginService = getLoginService();
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
	
	@PostMapping("/logout")
    public ResponseEntity logout(@RequestHeader("Authorization") String session) {
		LoginService lService = getLoginService();
		if (!lService.checkSession(session)) {
			return new ResponseEntity<>(null, HttpStatus.UNAUTHORIZED);
		} else {
			boolean isOk = lService.logout(session);
			if(isOk) {
				return new ResponseEntity(HttpStatus.OK);
			} else {
				return new ResponseEntity(HttpStatus.INTERNAL_SERVER_ERROR);
			}
		}
		
	}
	
	protected static LoginService getLoginService() {
		return new LoginServiceImpl(new LoginRepository(), new EncodingHelper());
	}

}