package pl.pawelSz.Spring.Web.Service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import pl.pawelSz.Spring.Web.DAO.Hospitals;
import pl.pawelSz.Spring.Web.DAO.OrderDAO;
import pl.pawelSz.Spring.Web.DAO.Orders;
import pl.pawelSz.Spring.Web.DAO.OrdersPatient;
import pl.pawelSz.Spring.Web.DAO.UserDAO;
import pl.pawelSz.Spring.Web.DAO.Users;

@Service("servicu")
public class Servicu {

	
		@Autowired
		private OrderDAO orderDAO;
		@Autowired
		private UserDAO userDAO;
		
		@Autowired
		public void setOrderDAO(OrderDAO orderDAO) {
			this.orderDAO = orderDAO;
		}
		
		@Autowired
		public void setUserDAO(UserDAO userDAO) {
			this.userDAO = userDAO;
		}
		
		public List<Hospitals> getCurrent(){
			return orderDAO.getHosps();
		}
		
		

		public void create(OrdersPatient ordersPatient) {
			orderDAO.createPatient(ordersPatient);
			
			
		}
		
		public void create(Orders orders) {
			orderDAO.createOrder(orders);
			
		}
		
		public List <Orders> getPrice(){
			
			return orderDAO.getNetPrice();
		}
		
		public void create(Users users) {
			userDAO.createUser(users);
			
		}
		
		
			
		public List <Users> getUser() {
			return userDAO.getUsers();
			
		}
	
	
}
