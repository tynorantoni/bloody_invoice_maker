package pl.pawelSz.Spring.Web.PDF;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.sql.DataSource;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.jdbc.core.namedparam.NamedParameterJdbcTemplate;
import org.springframework.stereotype.Component;

import com.itextpdf.text.Document;
import com.itextpdf.text.DocumentException;
import com.itextpdf.text.Element;
import com.itextpdf.text.Font;
import com.itextpdf.text.Paragraph;
import com.itextpdf.text.pdf.PdfPCell;
import com.itextpdf.text.pdf.PdfPTable;
import com.itextpdf.text.pdf.PdfWriter;
import com.itextpdf.text.zugferd.profiles.BasicProfile;

import pl.pawelSz.Spring.Web.DAO.Hospitals;
import pl.pawelSz.Spring.Web.DAO.OrderDAO;
import pl.pawelSz.Spring.Web.DAO.Orders;
import pl.pawelSz.Spring.Web.DAO.OrdersPatient;
import pl.pawelSz.Spring.Web.Service.Servicu;
@Component
public class PDFBuilder extends ITextPDF {
	
	@Autowired
	private Servicu servicu;
	@Autowired
	Hospitals hospital = new Hospitals();
	@Autowired
	private Orders orders;
	@Autowired
	private OrdersPatient ordersPatient ;
	@Autowired
	 private OrderDAO orderDAO ;

	
	
	Date date = new Date( );
    SimpleDateFormat dateForm = new SimpleDateFormat ("dd.MM.yyyy  HH:mm:ss");
    SimpleDateFormat dateFormYear = new SimpleDateFormat ("yyyy");
    
   
   @Autowired
	private NamedParameterJdbcTemplate jdbc;

	@Autowired
	public void setDataSource(DataSource jdbc) {
		this.jdbc = new NamedParameterJdbcTemplate(jdbc);
	}
//	
//	List<Hospitals> getHosps = jdbc.query("select (nameHosp, addressHosp) from hospitals where idHosp=1", new RowMapper<Hospitals>() {
//		
//		public Hospitals mapRow(ResultSet rs, int rowNum) throws SQLException {
//			Hospitals hospital = new Hospitals();
//
//			hospital.setNameHosp(rs.getString("nameHosp"));
//			hospital.setAddressHosp(rs.getString("addressHosp"));
//			
//			return hospital;
//		}
//
//	});
		
	
	public List<Hospitals> getHosps() {

		return jdbc.query("select nameHosp, addressHosp from hospitals where idHosp=1", new RowMapper<Hospitals>() {

			public Hospitals mapRow(ResultSet rs, int rowNum) throws SQLException {
				

				hospital.setNameHosp(rs.getString("nameHosp"));
				hospital.setAddressHosp(rs.getString("addressHosp"));
				
				return hospital;
			}

		});
	}
	
	public List<OrdersPatient> getPatient() {

		return jdbc.query("select namePat, surnamePat, peselPat from patient order by idOrder DESC limit 1", new RowMapper<OrdersPatient>() {

			public OrdersPatient mapRow(ResultSet rs, int rowNum) throws SQLException {
				OrdersPatient ordersPatient = new OrdersPatient();

				ordersPatient.setNamePat(rs.getString("namePat"));
				ordersPatient.setSurnamePat(rs.getString("surnamePat"));
				ordersPatient.setPeselPat(rs.getString("peselPat"));
				
				return ordersPatient;
			}

		});
	}
	
	public List<Orders> getOrders() {

		return jdbc.query("select KKCZqty, FFPqty, KKPqty, KKPafqty from orders order by idOrder DESC limit 1", new RowMapper<Orders>() {

			public Orders mapRow(ResultSet rs, int rowNum) throws SQLException {
				Orders orders = new Orders();
				
				orders.setKKCZqty(rs.getInt("KKCZqty"));
				orders.setFFPqty(rs.getInt("FFPqty"));
				orders.setKKPqty(rs.getInt("KKPqty"));
				orders.setKKPafqty(rs.getInt("KKPafqty"));
				return orders;
			}

		});
	}

	 protected Font font10;
	    protected Font font10b;
	    protected Font font12;
	    protected Font font12b;
	    protected Font font14;
	
	@Override
	protected void buildPdfDocument(Map<String, Object> model, Document document, PdfWriter writer,
			HttpServletRequest request, HttpServletResponse response) throws Exception {

		 BasicProfile basic; //= invoiceData.createBasicProfileData(invoice);//miejsce a data from DB
		
			 Hospitals hospital = new Hospitals();
			
			 Orders orders = new Orders();
			
			 OrdersPatient ordersPatient = new OrdersPatient();
			
			  OrderDAO orderDAO = new OrderDAO();

        // header
        Paragraph p;
        p = new Paragraph("Faktura nr: " + orders.getIdOrder()+"/"+ dateFormYear.format(date), font14);
        p.setAlignment(Element.ALIGN_RIGHT);
        document.add(p);
        p = new Paragraph(dateForm.format(date), font12);
        p.setAlignment(Element.ALIGN_RIGHT);
        document.add(p);
 
        // Address seller / buyer
        PdfPTable table = new PdfPTable(2);
        table.setWidthPercentage(100);
        PdfPCell seller = getPartyAddress("Sprzedaj¹cy: \n RCKiK \n ul. Masarnicza 19\n 99-789 Tynorowo");
               
        table.addCell(seller);
        //buyer == hospital
      PdfPCell buyer = getPartyAddress("Kupuj¹cy");
      
      for (Hospitals hosp : getHosps()) {
    	  
    	  buyer = getPartyAddress(hosp.getNameHosp());
    	  buyer = getPartyAddress(hosp.getAddressHosp());
	}
      
        
        //mo¿e bêdzie dzia³aæ, mo¿e nie
        
        table.addCell((PdfPCell) buyer);
        
        table.addCell(seller);
        
        table.addCell(buyer);
        document.add(table);
 
        // line items
        table = new PdfPTable(6);
        table.setWidthPercentage(100);
        table.setSpacingBefore(10);
        table.setSpacingAfter(10);
        table.setWidths(new int[]{7, 2, 1, 2, 2, 2});
        table.addCell(getCell("Sk³adnik:", Element.ALIGN_LEFT, font12b));
        table.addCell(getCell("Cena:", Element.ALIGN_LEFT, font12b));
        table.addCell(getCell("Iloœæ:", Element.ALIGN_LEFT, font12b));
        table.addCell(getCell("Cena netto:", Element.ALIGN_LEFT, font12b));
        table.addCell(getCell("VAT:", Element.ALIGN_LEFT, font12b));
        table.addCell(getCell("£¹cznie:", Element.ALIGN_LEFT, font12b));
       
        for (OrdersPatient patient : getPatient()) {
           
            table.addCell(getCell("Imiê: "+patient.getNamePat(), Element.ALIGN_LEFT, font12));
            table.addCell(getCell("Nazwisko: "+patient.getSurnamePat(), Element.ALIGN_LEFT, font12));
            table.addCell(getCell("Numer Pesel: "+patient.getPeselPat(), Element.ALIGN_LEFT, font12));
            //table.addCell(getCell(InvoiceData.format2dec(InvoiceData.round(product.getPrice())), Element.ALIGN_RIGHT, font12));
            
            for (Orders ord : getOrders()) {
               
            table.addCell(getCell(String.valueOf(ord.getKKCZqty()), Element.ALIGN_RIGHT, font12));
            table.addCell(getCell(String.valueOf(ord.getFFPqty()), Element.ALIGN_RIGHT, font12));
            table.addCell(getCell(String.valueOf(ord.getKKPqty()), Element.ALIGN_RIGHT, font12));
            table.addCell(getCell(String.valueOf(ord.getKKPafqty()), Element.ALIGN_RIGHT, font12));
//            table.addCell(getCell(InvoiceData.format2dec(InvoiceData.round(item.getCost())), Element.ALIGN_RIGHT, font12));
//            table.addCell(getCell(InvoiceData.format2dec(InvoiceData.round(product.getVat())), Element.ALIGN_RIGHT, font12));
            }
            for(Orders netprice : orderDAO.getNetPrice()){
            	
            
            table.addCell(getCell(String.valueOf(netprice.getNetPrice()), Element.ALIGN_RIGHT, font12));
            table.addCell(getCell(String.valueOf(netprice.getNetPrice() + ((netprice.getNetPrice() * 8 / 100))),  Element.ALIGN_RIGHT, font12));
        }
        }
        document.add(table);
 
        // grand totals
        document.add(getTotalsTable("8%",":NetPrice","PLN"));
        // payment info
        document.add(getPaymentInfo("P³aæ i P³acz, adres podano wy¿ej","34 1209 2128 0000 2190 0000 0007", "PL34 1209 2128 0000 2190 0000 0007"));
 
        // XML version raczej nie potrzebne
//        InvoiceDOM dom = new InvoiceDOM(basic);
//        PdfDictionary parameters = new PdfDictionary();
//        parameters.put(PdfName.MODDATE, new PdfDate());
//        PdfFileSpecification fileSpec = writer.addFileAttachment(
//                "ZUGFeRD invoice", dom.toXML(), null,
//                "ZUGFeRD-invoice.xml", "application/xml",
//                AFRelationshipValue.Alternative, parameters);
//        PdfArray array = new PdfArray();
//        array.add(fileSpec.getReference());
//        writer.getExtraCatalog().put(PdfName.AF, array);
 
        // step 5
        document.close();
    }
 
    private PdfPCell getPartyAddress(String string) {
    	PdfPCell cell = new PdfPCell();
        cell.setBorder(PdfPCell.NO_BORDER);
		return cell;
	}

	public PdfPCell getPartyAddress(String who, String name, String line1, String line2, String countryID, String postcode, String city) {
        PdfPCell cell = new PdfPCell();
        cell.setBorder(PdfPCell.NO_BORDER);
        cell.addElement(new Paragraph(who, font12b));
        cell.addElement(new Paragraph(name, font12));
        cell.addElement(new Paragraph(line1, font12));
        cell.addElement(new Paragraph(line2, font12));
        cell.addElement(new Paragraph(String.format("%s-%s %s", countryID, postcode, city), font12));
        return cell;
    }
    public PdfPCell getPartyTax(String[] taxId, String[] taxSchema) {
        PdfPCell cell = new PdfPCell();
        cell.setBorder(PdfPCell.NO_BORDER);
        cell.addElement(new Paragraph("Tax ID(s):", font10b));
        if (taxId.length == 0) {
            cell.addElement(new Paragraph("Not applicable", font10));
        }
        else {
            int n = taxId.length;
            for (int i = 0; i < n; i++) {
                cell.addElement(new Paragraph(String.format("%s: %s", taxSchema[i], taxId[i]), font10));
            }
        }
        return cell;
    }
 
    public PdfPTable getTotalsTable(String tTax, String tTotal, String tCurrency
             ) throws DocumentException {
        PdfPTable table = new PdfPTable(6);
        table.setWidthPercentage(100);
        table.setWidths(new int[]{1, 1, 3, 3, 3, 1});
        table.addCell(getCell("VAT", Element.ALIGN_LEFT, font12b));
        table.addCell(getCell("%", Element.ALIGN_RIGHT, font12b));
        table.addCell(getCell("Wartoœæ Netto:", Element.ALIGN_LEFT, font12b));
        table.addCell(getCell("Podatek:", Element.ALIGN_LEFT, font12b));
        table.addCell(getCell("£¹cznie:", Element.ALIGN_LEFT, font12b));
        table.addCell(getCell("", Element.ALIGN_LEFT, font12b));
//        int n = type.length;
//        for (int i = 0; i < n; i++) {
//            table.addCell(getCell(type[i], Element.ALIGN_RIGHT, font12));
//            table.addCell(getCell(percentage[i], Element.ALIGN_RIGHT, font12));
//            table.addCell(getCell(base[i], Element.ALIGN_RIGHT, font12));
//            table.addCell(getCell(tax[i], Element.ALIGN_RIGHT, font12));
//            double total = Double.parseDouble(base[i]) + Double.parseDouble(tax[i]);
      //     table.addCell(getCell(InvoiceData.format2dec(InvoiceData.round(total)), Element.ALIGN_RIGHT, font12));
//            table.addCell(getCell(currency[i], Element.ALIGN_LEFT, font12));
//        }
        PdfPCell cell = getCell("", Element.ALIGN_LEFT, font12b);
        cell.setColspan(2);
        cell.setBorder(PdfPCell.NO_BORDER);
        table.addCell(cell);
//        table.addCell(getCell(tBase, Element.ALIGN_RIGHT, font12b));
        table.addCell(getCell(tTax, Element.ALIGN_RIGHT, font12b));
        table.addCell(getCell(tTotal, Element.ALIGN_RIGHT, font12b));
        table.addCell(getCell(tCurrency, Element.ALIGN_LEFT, font12b));
        return table;
    }
 
    public PdfPCell getCell(String value, int alignment, Font font) {
        PdfPCell cell = new PdfPCell();
        cell.setUseAscender(true);
        cell.setUseDescender(true);
        Paragraph p = new Paragraph(value, font);
        p.setAlignment(alignment);
        cell.addElement(p);
        return cell;
    }
 
    public Paragraph getPaymentInfo(String ref, String bic, String iban) {
        Paragraph p = new Paragraph(String.format(
                "P³atnoœæ przelewem na konto w terminie 90 dni: %s",
                ref), font12);
//        int n = bic.length;
//        for (int i = 0; i < n; i++) {
//            p.add(Chunk.NEWLINE);
//            p.add(String.format("BIC: %s - IBAN: %s", bic[i], iban[i]));
//        }
        return p;
    }
 
    public String convertDate(Date d, String newFormat) throws ParseException {
        SimpleDateFormat sdf = new SimpleDateFormat(newFormat);
        return sdf.format(d);
    }


}
