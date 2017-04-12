package pl.pawelSz.Spring.Web.DAO;

public class OrdersPatient {

	private int idPatient;
	private int idOrd;
	private String hospitalPat;
	private String namePat;
	private String surnamePat;
	private int peselPat;
	
	
	public OrdersPatient() {
		
	}


	public OrdersPatient(int idPatient, int idOrd, String hospitalPat, String namePat, String surnamePat,
			int peselPat) {
		super();
		this.idPatient = idPatient;
		this.idOrd = idOrd;
		this.hospitalPat = hospitalPat;
		this.namePat = namePat;
		this.surnamePat = surnamePat;
		this.peselPat = peselPat;
	}


	public int getIdPatient() {
		return idPatient;
	}


	public void setIdPatient(int idPatient) {
		this.idPatient = idPatient;
	}


	public int getIdOrd() {
		return idOrd;
	}


	public void setIdOrd(int idOrd) {
		this.idOrd = idOrd;
	}


	public String getHospitalPat() {
		return hospitalPat;
	}


	public void setHospitalPat(String hospitalPat) {
		this.hospitalPat = hospitalPat;
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


	public int getPeselPat() {
		return peselPat;
	}


	public void setPeselPat(int peselPat) {
		this.peselPat = peselPat;
	}


	@Override
	public String toString() {
		return "OrdersPatient [idPatient=" + idPatient + ", idOrd=" + idOrd + ", hospitalPat=" + hospitalPat
				+ ", namePat=" + namePat + ", surnamePat=" + surnamePat + ", peselPat=" + peselPat + "]";
	}


	
}