package pl.pawelSz.Spring.Web.Controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import pl.pawelSz.Spring.Web.DAO.CombinedCommand;
import pl.pawelSz.Spring.Web.DAO.Hospitals;
import pl.pawelSz.Spring.Web.DAO.Orders;
import pl.pawelSz.Spring.Web.DAO.OrdersPatient;
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

		return "home";
	}

	@RequestMapping("/orderForm")
	public String showForm(Model model) {
		List<Hospitals> hospital = servicu.getCurrent();
		model.addAttribute("combinedCommand", new CombinedCommand());
		model.addAttribute("hospitals", hospital);
		model.addAttribute("ordersPatient", new OrdersPatient());
		model.addAttribute("orders", new Orders());
		return "orderForm";
	}

	@RequestMapping(value = "/create", method = RequestMethod.POST)
	public String doCreate(Hospitals hospitals, Model model, OrdersPatient ordersPatient, Orders orders,
			BindingResult result) {

		if (result.hasErrors()) {
			return "error";
		} else {

			model.addAttribute("nameHosp", hospitals);
			model.addAttribute("orders", new Orders());
			model.addAttribute("ordersPatient", new OrdersPatient());
			servicu.create(ordersPatient);
			servicu.create(orders);

			return "success";
		}
	}
}