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

import pl.pawelSz.Spring.Web.DAO.CombinedCommand;
import pl.pawelSz.Spring.Web.DAO.Hospitals;
import pl.pawelSz.Spring.Web.DAO.Orders;
import pl.pawelSz.Spring.Web.DAO.OrdersPatient;
import pl.pawelSz.Spring.Web.Service.Servicu;

@Controller
public class Controlling {
	
	private Servicu servicu;

	@Autowired
	public void setServicu(Servicu servicu) {
		this.servicu = servicu;
	}

	@RequestMapping("/")
	public String showHome(Model model) {

		return "home";
	}
	
	@RequestMapping("/home")
	public String showHome2(Model model) {

		return "home";
	}
	@RequestMapping(value="/downloadpdf", method=RequestMethod.GET)
	public String showPDF(@ModelAttribute("nameHosp")@Valid Hospitals hospitals,BindingResult result2, Model model){
		List<Hospitals> hospital = servicu.getCurrent();
		model.addAttribute("nameHosp", hospital);
		
		return "invoice";
	}
	
	
	@RequestMapping("/showorders")
	public String showOrder(Model model) {

		return "showorders";
	}

	@RequestMapping(value="/orderForm", method=RequestMethod.GET)
	public String orderForm(Model model) {
		List<Hospitals> hospital = servicu.getCurrent();
		model.addAttribute("combinedCommand", new CombinedCommand());
		model.addAttribute("hospitals", hospital);
		model.addAttribute("ordersPatient", new OrdersPatient());
		model.addAttribute("orders", new Orders());
		return "orderForm";
	}

	@RequestMapping(value = "/create", method = RequestMethod.POST)
	public String create(@ModelAttribute("nameHosp")@Valid Hospitals hospitals,BindingResult result2,
			@ModelAttribute("ordersPatient")@Valid OrdersPatient ordersPatient,BindingResult result1,
			@ModelAttribute("orders") @Valid Orders orders, BindingResult result,
			@ModelAttribute("combinedCommand") @Valid CombinedCommand combinedCommand, BindingResult result3,
			 Model model) {

		if (result.hasErrors()) {
			orderForm(model) ;
		
			return "/orderForm";
		} 

//			model.addAttribute("nameHosp", hospitals);
//			model.addAttribute("orders", new Orders());
//			model.addAttribute("ordersPatient", new OrdersPatient());
			servicu.create(ordersPatient);
			servicu.create(orders);

			return "home";
		}
	}
