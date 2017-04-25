package pl.pawelSz.Spring.Web.Controllers;

import java.util.List;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import pl.pawelSz.Spring.Web.DAO.Users;
import pl.pawelSz.Spring.Web.Service.Servicu;


@Controller
public class UserController {

	private Servicu servicu;

	@Autowired
	public void setServicu(Servicu servicu) {
		this.servicu = servicu;
	}
	
	@RequestMapping("/users")
	public String newUser(Model model){
		model.addAttribute("users", new Users());
		
		return "users";
	
	}
	@RequestMapping(value="usercreate", method= RequestMethod.POST)
	public String userCreated(Model model,@ModelAttribute("users")@Valid Users users, BindingResult result){
		model.addAttribute("users", new Users());
		if(result.hasErrors()){
			return "users";
		}
		
		servicu.create(users);
		users.setAuthority("ROLE_USER");
		users.setEnabled(true);
		return "usercreated";
	}
	

	@RequestMapping("/userlist")
	public String showAdmin(Model model) {
		
		List<Users> users = servicu.getUser();
		
		model.addAttribute("users", users);
		
		return "userlist";
	}
}
