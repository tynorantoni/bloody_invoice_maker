package pl.pawelSz.Spring.Web.PDF;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;
import java.util.Map;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.sql.DataSource;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.jdbc.core.namedparam.NamedParameterJdbcTemplate;
import com.itextpdf.text.BaseColor;
import com.itextpdf.text.Document;
import com.itextpdf.text.Font;
import com.itextpdf.text.FontFactory;
import com.itextpdf.text.Paragraph;
import com.itextpdf.text.Phrase;
import com.itextpdf.text.pdf.PdfPCell;
import com.itextpdf.text.pdf.PdfPTable;
import com.itextpdf.text.pdf.PdfWriter;

import pl.pawelSz.Spring.Web.DAO.Hospitals;

public class PDFBuilder extends ITextPDF {

	private NamedParameterJdbcTemplate jdbc;

	@Autowired
	public void setDataSource(DataSource jdbc) {
		this.jdbc = new NamedParameterJdbcTemplate(jdbc);
	}

	public List<Hospitals> getHosps() {

		return jdbc.query("select nameHosp from hospitals", new RowMapper<Hospitals>() {

			public Hospitals mapRow(ResultSet rs, int rowNum) throws SQLException {
				Hospitals hospital = new Hospitals("nameHosp");

				hospital.setNameHosp(rs.getString("nameHosp"));

				return hospital;
			}

		});
	}

	@Override
	protected void buildPdfDocument(Map<String, Object> model, Document doc, PdfWriter writer,
			HttpServletRequest request, HttpServletResponse response) throws Exception {

		doc.add(new Paragraph("Lista Szpitali"));

		PdfPTable table = new PdfPTable(5);
		table.setWidthPercentage(100.0f);
		table.setWidths(new float[] { 3.0f, 2.0f, 2.0f, 2.0f, 1.0f });
		table.setSpacingBefore(10);

		// define font for table header row
		Font font = FontFactory.getFont(FontFactory.HELVETICA);
		font.setColor(BaseColor.WHITE);

		// define table header cell
		PdfPCell cell = new PdfPCell();
		cell.setBackgroundColor(BaseColor.BLUE);
		cell.setPadding(5);

		// write table header
		cell.setPhrase(new Phrase("Szpital", font));
		table.addCell(cell);

		// write table row data
		for (Hospitals aHosp : getHosps()) {
			table.addCell(aHosp.getNameHosp());

		}

		doc.add(table);

	}

}
