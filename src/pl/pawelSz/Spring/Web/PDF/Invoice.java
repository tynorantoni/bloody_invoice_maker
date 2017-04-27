package pl.pawelSz.Spring.Web.PDF;

public class Invoice {

	private String hospName;

	public Invoice(String hospName) {
		super();
		this.hospName = hospName;
	}

	public String getHospName() {
		return hospName;
	}

	public void setHospName(String hospName) {
		this.hospName = hospName;
	}

	
}
