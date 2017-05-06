package pl.pawelSz.Spring.Web.DAO;

import org.springframework.stereotype.Component;
/*
 * This class join Hospital, OrdersPatient and Orders Beans
 */
@Component
public class CombinedCommand {
	
	private OrdersPatient ordersPatient;
	private Hospitals hospitals;
	private Orders orders;
	
	public CombinedCommand() {

	}


	public Orders getOrders() {
		return orders;
	}

	public void setOrders(Orders orders) {
		this.orders = orders;
	}

	
	public OrdersPatient getOrdersPatient() {
		return ordersPatient;
	}

	public void setOrdersPatient(OrdersPatient ordersPatient) {
		this.ordersPatient = ordersPatient;
	}

	public Hospitals getHospitals() {
		return hospitals;
	}

	public String getHospitalName() {
		return hospitals.getNameHosp();
	}

	public void setHospitals(Hospitals hospitals) {
		this.hospitals = hospitals;
	}

}
