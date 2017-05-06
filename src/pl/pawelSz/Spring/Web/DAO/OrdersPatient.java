package pl.pawelSz.Spring.Web.DAO;

import javax.validation.constraints.NotNull;
import javax.validation.constraints.Pattern;
import javax.validation.constraints.Size;

public class OrdersPatient {

	private int idOrder;
	
	private String addressHosp;
	private String nameHosp;
	@NotNull(message="Wpisz Imiê!")
	private String namePat;
	@NotNull(message="Wpisz Nazwisko!")
	private String surnamePat;
	@Size(min=11, max=11, message="Podaj nr Pesel!")
	@Pattern(regexp="\\d", message="B³êdny numer!") 
	private String peselPat;
	
	
	
	public OrdersPatient() {
		
	}


	public OrdersPatient(int idOrder, String nameHosp, String namePat, String surnamePat, String peselPat) {
		
		this.idOrder = idOrder;
		this.nameHosp = nameHosp;
		this.namePat = namePat;
		this.surnamePat = surnamePat;
		this.peselPat = peselPat;
	}


	public int getIdOrder() {
		return idOrder;
	}


	public void setIdOrder(int idOrder) {
		this.idOrder =idOrder;
	}


	public String getNameHosp() {
		return nameHosp;
	}


	public void setNameHosp(String nameHosp) {
		this.nameHosp = nameHosp;
	}


	public String getNamePat() {
		return namePat;
	}


	public void setNamePat(String namePat) {
		this.namePat = namePat;
	}


	public String getSurnamePat() {
		return surnamePat;
	}


	public void setSurnamePat(String surnamePat) {
		this.surnamePat = surnamePat;
	}


	public String getPeselPat() {
		return peselPat;
	}


	public void setPeselPat(String peselPat) {
		this.peselPat = peselPat;
	}


	public String getAddressHosp() {
		return addressHosp;
	}


	public void setAddressHosp(String addressHosp) {
		this.addressHosp = addressHosp;
	}


	@Override
	public String toString() {
		return "OrdersPatient [idOrder=" + idOrder + ", nameHosp=" + nameHosp + ", namePat=" + namePat + ", surnamePat="
				+ surnamePat + ", peselPat=" + peselPat + ", addressHosp=" + addressHosp + "]";
	}


	
	
	
	
}