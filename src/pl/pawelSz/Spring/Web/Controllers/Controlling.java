package pl.pawelSz.Spring.Web.Controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import pl.pawelSz.Spring.Web.DAO.Hospitals;
import pl.pawelSz.Spring.Web.Service.Servicu;

@Controller
public class Controlling {
	@Autowired
	private Servicu servicu;

	@Autowired
	public void setServicu(Servicu servicu) {
		this.servicu = servicu;
	}

	@RequestMapping("/")
	public String showHome(Model model) {

		List<Hospitals> hospital = servicu.getCurrent();
		model.addAttribute("hospitals", hospital);
		return "home";
	}
	@RequestMapping("/orderForm")
	public String showForm(){
		return "orderForm";
	}
}
