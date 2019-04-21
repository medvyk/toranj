package main.java.toranj.login.controller;

import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import main.java.toranj.login.service.LoginService;
import main.java.toranj.login.service.LoginServiceImpl;

@RestController
public class LoginController {
	
	@PostMapping("/login")
    public int greeting(@RequestParam(value="user") String user, @RequestParam(value="password") String password) {
        LoginService loginService = new LoginServiceImpl();
        int userId = loginService.checkUser(user, password);
        return userId;
    }
	

}
