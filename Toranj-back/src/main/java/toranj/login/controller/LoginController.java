package toranj.login.controller;

import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import toranj.login.service.LoginService;
import toranj.login.service.LoginServiceImpl;

@RestController
public class LoginController {
	
	@PostMapping("/login")
    public int greeting(@RequestParam("user") String user, @RequestParam("password") String password) {
        LoginService loginService = new LoginServiceImpl();
        int userId = loginService.checkUser(user, password);
        return userId;
    }
	

}
