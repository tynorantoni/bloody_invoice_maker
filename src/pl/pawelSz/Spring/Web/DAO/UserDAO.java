package pl.pawelSz.Spring.Web.DAO;

import java.util.List;

import javax.sql.DataSource;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.namedparam.MapSqlParameterSource;
import org.springframework.jdbc.core.namedparam.NamedParameterJdbcTemplate;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Transactional;

import pl.pawelSz.Spring.Web.DAO.Users;

@Component("userDAO")
public class UserDAO {

	private NamedParameterJdbcTemplate jdbc;

	@Autowired
	private PasswordEncoder PasswordEncoder;

	@Autowired
	public void setPasswordEncoder(PasswordEncoder passwordEncoder) {
		PasswordEncoder = passwordEncoder;
	}

	@Autowired
	public void setDataSource(DataSource jdbc) {
		this.jdbc = new NamedParameterJdbcTemplate(jdbc);
	}

	//Query for making new user with specific authority.
	@Transactional
	public boolean createUser(Users users) {
		
		MapSqlParameterSource params = new MapSqlParameterSource();
		
		params.addValue("username", users.getUsername());
		params.addValue("password", PasswordEncoder.encode(users.getPassword()));
		params.addValue("enabled", users.isEnabled());
		params.addValue("authority", users.getAuthority());
		
		jdbc.update("insert into users (username, password, enabled) values (:username, :password, :enabled)", params);
		
		return jdbc.update("insert into authorities (username, authority) values (:username, :authority)", params) == 1;
	}

	
//TODO chyba do usuniêcia	
	public boolean exists(String username) {
		return jdbc.queryForObject("select count(*) from users where username=:username",
				new MapSqlParameterSource("username", username), Integer.class) > 0;
	}
//Shows list of users
	public List<Users> getUsers() {
		return jdbc.query("select * from users,  authorities where users.username=authorities.username",
				BeanPropertyRowMapper.newInstance(Users.class));
	}

}
