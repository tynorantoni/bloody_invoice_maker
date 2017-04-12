package pl.pawelSz.Spring.Web.DAO;

public class Orders {

	private int id;
	private int idOrd;
	private String productOrd;
	private String servOrd;
	private String priceOrd;
	
	
	public Orders() {
		
	}


	public Orders(int id, int idOrd, String productOrd, String servOrd, String priceOrd) {
		super();
		this.id = id;
		this.idOrd = idOrd;
		this.productOrd = productOrd;
		this.servOrd = servOrd;
		this.priceOrd = priceOrd;
	}


	public int getId() {
		return id;
	}


	public void setId(int id) {
		this.id = id;
	}


	public int getIdOrd() {
		return idOrd;
	}


	public void setIdOrd(int idOrd) {
		this.idOrd = idOrd;
	}


	public String getProductOrd() {
		return productOrd;
	}


	public void setProductOrd(String productOrd) {
		this.productOrd = productOrd;
	}


	public String getServOrd() {
		return servOrd;
	}


	public void setServOrd(String servOrd) {
		this.servOrd = servOrd;
	}


	public String getPriceOrd() {
		return priceOrd;
	}


	public void setPriceOrd(String priceOrd) {
		this.priceOrd = priceOrd;
	}


	@Override
	public String toString() {
		return "Orders [id=" + id + ", idOrd=" + idOrd + ", productOrd=" + productOrd + ", servOrd=" + servOrd
				+ ", priceOrd=" + priceOrd + "]";
	}


	
}
