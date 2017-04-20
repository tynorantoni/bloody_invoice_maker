package pl.pawelSz.Spring.Web.DAO;

import org.springframework.beans.factory.annotation.Autowired;

public class Hospitals {

	private int idHosp;
	@Autowired // czy to potrzebne...
	private String nameHosp;
	private String addressHosp;
	
	
	public Hospitals() {
		
	}

	public Hospitals(String nameHosp){
		this.nameHosp=nameHosp;
	}
	public Hospitals(int idHosp, String nameHosp, String addressHosp) {
	
		this.idHosp = idHosp;
		this.nameHosp = nameHosp;
		this.addressHosp = addressHosp;
	}


	public int getIdHosp() {
		return idHosp;
	}


	public void setIdHosp(int idHosp) {
		this.idHosp = idHosp;
	}


	public String getNameHosp() {
		return nameHosp;
	}


	public void setNameHosp(String nameHosp) {
		this.nameHosp = nameHosp;
	}


	public String getAddressHosp() {
		return addressHosp;
	}


	public void setAddressHosp(String addressHosp) {
		this.addressHosp = addressHosp;
	}


	@Override
	public String toString() {
		return "Hospitals [idHosp=" + idHosp + ", nameHosp=" + nameHosp + ", addressHosp=" + addressHosp
				+ "]";
	}
	
	}

