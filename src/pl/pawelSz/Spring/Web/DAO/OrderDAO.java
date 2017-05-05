package pl.pawelSz.Spring.Web.DAO;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;

import javax.sql.DataSource;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.jdbc.core.namedparam.BeanPropertySqlParameterSource;
import org.springframework.jdbc.core.namedparam.MapSqlParameterSource;
import org.springframework.jdbc.core.namedparam.NamedParameterJdbcTemplate;
import org.springframework.jdbc.core.namedparam.SqlParameterSource;
import org.springframework.jdbc.core.namedparam.SqlParameterSourceUtils;
import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Transactional;

@Component("orderDAO")
public class OrderDAO {

	private NamedParameterJdbcTemplate jdbc;
	
	@Autowired
	public void setDataSource(DataSource jdbc) {
		this.jdbc = new NamedParameterJdbcTemplate(jdbc);
	}
//List of Hospitals from DB
	public List<Hospitals> getHosps() {

		return jdbc.query("select nameHosp, from hospitals", new RowMapper<Hospitals>() {

			public Hospitals mapRow(ResultSet rs, int rowNum) throws SQLException {
				Hospitals hospital = new Hospitals("nameHosp");
				
				hospital.setNameHosp(rs.getString("nameHosp"));
				
				return hospital;
			}

		});
	}
//Query for orderForm	
	public boolean createPatient(OrdersPatient ordersPatient){
		BeanPropertySqlParameterSource param = new BeanPropertySqlParameterSource(ordersPatient);
		
		return jdbc.update("insert into patient (nameHosp,namePat,surnamePat,peselPat) values (:nameHosp,:namePat,:surnamePat,:peselPat)", param)==1;
	}
	
//Query for orderForm	
	public boolean createOrder(Orders orders){
		BeanPropertySqlParameterSource param = new BeanPropertySqlParameterSource(orders);
		
		return jdbc.update("insert into orders (KKCZqty,KKCZED5,KKCZEC2,KKPqty,KKPED5,KKPEC2,KKPafqty,KKPafED5,KKPafEC2,FFPqty,FFPEK6,FFPEGB) values (:KKCZqty,:KKCZED5,:KKCZEC2,:KKPqty,:KKPED5,:KKPEC2,:KKPafqty,:KKPafED5,:KKPafEC2,:FFPqty,:FFPEK6,:FFPEGB)", param)==1;
	}
	
//SQL Query calculating net price of order	
	public List<Orders> getNetPrice() {

		return jdbc.query("select (KKCZEC2+KKCZED5+180)*KKCZqty+(KKPED5+KKPEC2+670)*KKPqty+(KKPafED5+KKPafEC2+1111)*KKPafqty+(FFPEGB+FFPEK6+112)*FFPqty as NetPrice from orders order by idOrder DESC limit 1", new RowMapper<Orders>() {

			public Orders mapRow(ResultSet rs, int rowNum) throws SQLException {
				Orders orders = new Orders();
				
				orders.setNetPrice(rs.getInt("NetPrice"));

				return orders;
			}

		});
	}
	
	
	
	// That Query shows last order
	public List<OrdersPatient> getPatients() {

		return jdbc.query("select idOrder, patient.nameHosp, namePat, surnamePat, peselPat, hospitals.addressHosp from patient  INNER JOIN hospitals ON patient.nameHosp = hospitals.nameHosp Order by patient.idOrder DESC Limit 1", new RowMapper<OrdersPatient>() {

			public OrdersPatient mapRow(ResultSet rs, int rowNum) throws SQLException {
			
				OrdersPatient ordersPatient = new OrdersPatient();
				
				
				ordersPatient.setAddressHosp(rs.getString("addressHosp"));
				ordersPatient.setIdOrder(rs.getInt("idOrder"));
				ordersPatient.setNameHosp(rs.getString("nameHosp"));
				ordersPatient.setNamePat(rs.getString("namePat"));
				ordersPatient.setSurnamePat(rs.getString("surnamePat"));
				ordersPatient.setPeselPat(rs.getString("peselPat"));
				
				return ordersPatient;
			}

		});
	}
	// That Query shows last order
	public List<Orders> getOrders() {

		return jdbc.query("select * from orders order by idOrder DESC limit 1", new RowMapper<Orders>() {

			public Orders mapRow(ResultSet rs, int rowNum) throws SQLException {
				Orders orders = new Orders();
				orders.setIdOrder(rs.getInt("idOrder"));
				orders.setKKCZqty(rs.getInt("KKCZqty"));
				orders.setFFPqty(rs.getInt("FFPqty"));
				orders.setKKPqty(rs.getInt("KKPqty"));
				orders.setKKPafqty(rs.getInt("KKPafqty"));
				return orders;
			}

		});
	}
	
	
	
	
}

//TODO clean this.
//	public boolean update(Offer offer) {
//		BeanPropertySqlParameterSource params = new BeanPropertySqlParameterSource(offer);
//		
//		return jdbc.update("update offers set name=:name, text=:text, email=:email where id=:id", params) == 1;
//	}
//	
//	public boolean create(Offer offer) {
//		
//		BeanPropertySqlParameterSource params = new BeanPropertySqlParameterSource(offer);
//		
//		return jdbc.update("insert into offers (name, text, email) values (:name, :text, :email)", params) == 1;
//	}
//	
//	@Transactional
//	public int[] create(List<Offer> offers) {
//		
//		SqlParameterSource[] params = SqlParameterSourceUtils.createBatch(offers.toArray());
//		
//		return jdbc.batchUpdate("insert into offers (id, name, text, email) values (:id, :name, :text, :email)", params);
//	}
//	
//	public boolean delete(int id) {
//		MapSqlParameterSource params = new MapSqlParameterSource("id", id);
//		
//		return jdbc.update("delete from offers where id=:id", params) == 1;
//	}

//	public Offer getOffer(int id) {
//
//		MapSqlParameterSource params = new MapSqlParameterSource();
//		params.addValue("id", id);
//
//		return jdbc.queryForObject("select * from offers where id=:id", params,
//				new RowMapper<Offer>() {
//
//					public Offer mapRow(ResultSet rs, int rowNum)
//							throws SQLException {
//						Offer offer = new Offer();
//
//						offer.setId(rs.getInt("id"));
//						offer.setName(rs.getString("name"));
//						offer.setText(rs.getString("text"));
//						offer.setEmail(rs.getString("email"));
//
//						return offer;
//					}
//
//				});
//	}
	

