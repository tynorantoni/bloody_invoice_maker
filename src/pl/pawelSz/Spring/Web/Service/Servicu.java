package pl.pawelSz.Spring.Web.Service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import pl.pawelSz.Spring.Web.DAO.Hospitals;
import pl.pawelSz.Spring.Web.DAO.OffersDAO;
import pl.pawelSz.Spring.Web.DAO.Orders;
import pl.pawelSz.Spring.Web.DAO.OrdersPatient;
import pl.pawelSz.Spring.Web.DAO.UserDAO;
import pl.pawelSz.Spring.Web.DAO.Users;

@Service("servicu")
public class Servicu {

	
		@Autowired
		private OffersDAO offersDAO;
		@Autowired
		private UserDAO userDAO;
		
		@Autowired
		public void setOffersDAO(OffersDAO offersDAO) {
			this.offersDAO = offersDAO;
		}
		
		@Autowired
		public void setUserDAO(UserDAO userDAO) {
			this.userDAO = userDAO;
		}
		
		public List<Hospitals> getCurrent(){
			return offersDAO.getHosps();
		}
		
		

		public void create(OrdersPatient ordersPatient) {
			offersDAO.createPatient(ordersPatient);
			
			
		}
		
		public void create(Orders orders) {
			offersDAO.createOrder(orders);
			
		}
		
		public void create(Users users) {
			userDAO.createUser(users);
			
		}
		
		public void createAuth(Users users) {
			userDAO.createAuth(users);
			
		}
		
		public List <Users> getUser() {
			return userDAO.getUsers();
			
		}
	
	
}
