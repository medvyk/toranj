package toranj.login.controller;

import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import toranj.login.service.LoginService;
import toranj.login.service.LoginServiceImpl;

//	WE SPRING TO CREATE THE ENDPOINT. THE FRAMEWORK WILL MANAGE THE ENDPOINT

@CrossOrigin(origins = "C://Users//Medovik//Documents//GitHub//toranj//Toranj-front//login//welcome.html", maxAge = 3600)

@RestController
public class LoginController {
	
	public LoginController() {
	}
	
	@PostMapping("/login")
    public int login(@RequestParam("user") String user, @RequestParam("password") String password) {
        LoginService loginService = new LoginServiceImpl();
        int userId = loginService.checkUser(user, password);
        return userId;
    }
	

}