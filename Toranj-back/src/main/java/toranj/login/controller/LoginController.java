package main.java.toranj.login.controller;

@RestController
public class LoginController {
	
	@PostMapping("/login")
    public String greeting(@RequestParam(value="user") String user, @RequestParam(value="password") String password) {
        LoginService loginService = new LoginService();
        int userId = loginService.checkUser(user, password);
        return userId;
    }
	

}
