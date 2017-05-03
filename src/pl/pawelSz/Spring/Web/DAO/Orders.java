package pl.pawelSz.Spring.Web.DAO;

import javax.validation.constraints.NotNull;

public class Orders {

	private int IdOrder;
	@NotNull(message="Notnull")
	private int KKCZqty;
	@NotNull
	private int KKCZED5;
	@NotNull
	private int KKCZEC2;
	@NotNull
	private int KKPqty;
	@NotNull
	private int KKPED5;
	@NotNull
	private int KKPEC2;
	@NotNull
	private int KKPafqty;
	@NotNull
	private int KKPafED5;
	@NotNull
	private int KKPafEC2;
	@NotNull
	private int FFPqty;
	@NotNull
	private int FFPEK6;
	@NotNull
	private int FFPEGB;
	
	private int netPrice;
	
	
	
	public Orders() {
		
	}

public Orders(int NetPrice) {
		this.netPrice = NetPrice; 
	}

	public Orders(int idOrder, int kKCZqty, int kKCZED5, int kKCZEC2, int kKPqty, int kKPED5, int kKPEC2, int kKPafqty,
			int kKPafED5, int kKPafEC2, int fFPqty, int fFPEK6, int fFPEGB, int NetPrice) {
		super();
		IdOrder = idOrder;
		KKCZqty = kKCZqty;
		KKCZED5 = kKCZED5;
		KKCZEC2 = kKCZEC2;
		KKPqty = kKPqty;
		KKPED5 = kKPED5;
		KKPEC2 = kKPEC2;
		KKPafqty = kKPafqty;
		KKPafED5 = kKPafED5;
		KKPafEC2 = kKPafEC2;
		FFPqty = fFPqty;
		FFPEK6 = fFPEK6;
		FFPEGB = fFPEGB;
		this.netPrice = NetPrice;
	}



	public int getIdOrder() {
		return IdOrder;
	}



	public void setIdOrder(int idOrder) {
		IdOrder = idOrder;
	}



	public int getKKCZqty() {
		return KKCZqty;
	}



	public void setKKCZqty(int kKCZqty) {
		KKCZqty = kKCZqty;
	}



	public int getKKCZED5() {
		return KKCZED5;
	}



	public void setKKCZED5(int kKCZED5) {
		KKCZED5 = kKCZED5;
	}



	public int getKKCZEC2() {
		return KKCZEC2;
	}



	public void setKKCZEC2(int kKCZEC2) {
		KKCZEC2 = kKCZEC2;
	}



	public int getKKPqty() {
		return KKPqty;
	}



	public void setKKPqty(int kKPqty) {
		KKPqty = kKPqty;
	}



	public int getKKPED5() {
		return KKPED5;
	}



	public void setKKPED5(int kKPED5) {
		KKPED5 = kKPED5;
	}



	public int getKKPEC2() {
		return KKPEC2;
	}



	public void setKKPEC2(int kKPEC2) {
		KKPEC2 = kKPEC2;
	}



	public int getKKPafqty() {
		return KKPafqty;
	}



	public void setKKPafqty(int kKPafqty) {
		KKPafqty = kKPafqty;
	}



	public int getKKPafED5() {
		return KKPafED5;
	}



	public void setKKPafED5(int kKPafED5) {
		KKPafED5 = kKPafED5;
	}



	public int getKKPafEC2() {
		return KKPafEC2;
	}



	public void setKKPafEC2(int kKPafEC2) {
		KKPafEC2 = kKPafEC2;
	}



	public int getFFPqty() {
		return FFPqty;
	}



	public void setFFPqty(int fFPqty) {
		FFPqty = fFPqty;
	}



	public int getFFPEK6() {
		return FFPEK6;
	}



	public void setFFPEK6(int fFPEK6) {
		FFPEK6 = fFPEK6;
	}



	public int getFFPEGB() {
		return FFPEGB;
	}



	public void setFFPEGB(int fFPEGB) {
		FFPEGB = fFPEGB;
	}



	public int getNetPrice() {
		return netPrice;
	}

	public void setNetPrice(int NetPrice) {
		this.netPrice = NetPrice;
	}

	@Override
	public String toString() {
		return "Orders [IdOrder=" + IdOrder + ", KKCZqty=" + KKCZqty + ", KKCZED5=" + KKCZED5 + ", KKCZEC2=" + KKCZEC2
				+ ", KKPqty=" + KKPqty + ", KKPED5=" + KKPED5 + ", KKPEC2=" + KKPEC2 + ", KKPafqty=" + KKPafqty
				+ ", KKPafED5=" + KKPafED5 + ", KKPafEC2=" + KKPafEC2 + ", FFPqty=" + FFPqty + ", FFPEK6=" + FFPEK6
				+ ", FFPEGB=" + FFPEGB + ", NetPrice=" + netPrice + "]";
	}

	
}
