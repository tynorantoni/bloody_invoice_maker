package pl.pawelSz.Spring.Web.Controllers;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

/*
 * Login Form Controller 
 */
@Controller
public class LoginController {

	@RequestMapping("/login")
	public String showLogin() {
		return "login";
	}

	@RequestMapping("/logout")
	public String showLoggedOut() {
		return "home";

	}
}
