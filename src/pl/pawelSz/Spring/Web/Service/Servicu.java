package pl.pawelSz.Spring.Web.Service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import pl.pawelSz.Spring.Web.DAO.Hospitals;
import pl.pawelSz.Spring.Web.DAO.OffersDAO;

@Service("servicu")
public class Servicu {

	
		@Autowired
		private OffersDAO offersDAO;
		
		@Autowired
		public void setOffersDAO(OffersDAO offersDAO) {
			this.offersDAO = offersDAO;
		}
		
		public List<Hospitals> getCurrent(){
			return offersDAO.getHosps();
		}
		
		
	
	
}
