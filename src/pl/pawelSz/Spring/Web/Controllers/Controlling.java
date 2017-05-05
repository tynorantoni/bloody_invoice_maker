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
	
//PDF Builder
	@RequestMapping(value="/downloadpdf", method=RequestMethod.GET)
	public String showPDF(@ModelAttribute("nameHosp")@Valid Hospitals hospitals,BindingResult result2, Model model){
		List<Hospitals> hospital = servicu.getCurrent();
		model.addAttribute("nameHosp", hospital);
		
		return "invoice";
	}
	
//List of orders	
	@RequestMapping("/showorders")
	public String showOrder(Model model) {

		return "showorders";
	}

//Order Form	
	@RequestMapping(value="/orderForm", method=RequestMethod.GET)
	public String orderForm(Model model) {
		List<Hospitals> hospital = servicu.getCurrent();
		model.addAttribute("combinedCommand", new CombinedCommand());
		model.addAttribute("hospitals", hospital);
		model.addAttribute("ordersPatient", new OrdersPatient());
		model.addAttribute("orders", new Orders());
		return "orderForm";
	}

//Inserting values from form to MySQL	
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

			servicu.create(ordersPatient);
			servicu.create(orders);

			return "redirect:/show";
		}
	
// Temporary	
	@RequestMapping("/price")
	public String showPrice(Model model) {
		List<Orders> orders = servicu.getPrice(); 
		model.addAttribute("order", orders);
		model.addAttribute("netPrice", orders);
		return "netprice";
	}
	
	@RequestMapping("/show")
	public String showPatientOrder(Model model) {
		List<Orders> orders = servicu.getPrice(); 
		List<Orders> ordersShow = servicu.getOrder(); 
		List<OrdersPatient> patient = servicu.getPatient(); 
		
		model.addAttribute("idOrder", patient);
		model.addAttribute("addressHosp", patient);
		model.addAttribute("order", orders);
		model.addAttribute("netPrice", orders);
		model.addAttribute("KKCZqty", ordersShow);
		model.addAttribute("ordersShow", ordersShow);
		model.addAttribute("patient", patient);
		return "showorders";
	}
}
