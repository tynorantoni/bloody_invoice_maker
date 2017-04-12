package pl.pawelSz.Spring.Web.DAO;

public class Products {

	private int idProd;
	private String nameProd;
	private String priceProd;
	private String descriptionProd;
	private String servProd;
	
	
	public Products() {
		
	}


	public Products(int idProd, String nameProd, String priceProd, String descriptionProd, String servProd) {
		super();
		this.idProd = idProd;
		this.nameProd = nameProd;
		this.priceProd = priceProd;
		this.descriptionProd = descriptionProd;
		this.servProd = servProd;
	}


	public int getIdProd() {
		return idProd;
	}


	public void setIdProd(int idProd) {
		this.idProd = idProd;
	}


	public String getNameProd() {
		return nameProd;
	}


	public void setNameProd(String nameProd) {
		this.nameProd = nameProd;
	}


	public String getPriceProd() {
		return priceProd;
	}


	public void setPriceProd(String priceProd) {
		this.priceProd = priceProd;
	}


	public String getDescriptionProd() {
		return descriptionProd;
	}


	public void setDescriptionProd(String descriptionProd) {
		this.descriptionProd = descriptionProd;
	}


	public String getServProd() {
		return servProd;
	}


	public void setServProd(String servProd) {
		this.servProd = servProd;
	}


	@Override
	public String toString() {
		return "Products [idProd=" + idProd + ", nameProd=" + nameProd + ", priceProd=" + priceProd
				+ ", descriptionProd=" + descriptionProd + ", servProd=" + servProd + "]";
	}

	
	
}