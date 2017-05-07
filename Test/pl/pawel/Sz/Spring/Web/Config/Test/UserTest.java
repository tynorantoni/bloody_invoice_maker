package pl.pawel.Sz.Spring.Web.Config.Test;

import static org.junit.Assert.assertTrue;

import javax.sql.DataSource;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.test.context.ActiveProfiles;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import pl.pawelSz.Spring.Web.DAO.UserDAO;
import pl.pawelSz.Spring.Web.DAO.Users;

@ActiveProfiles("dev")
@ContextConfiguration(locations = { "classpath:pl/pawelSz/Spring/Web/Config/dao-context.xml",
		"classpath:pl/pawelSz/Spring/Web/Config/data.xml",
		"classpath:pl/pawelSz/Spring/Web/Config/security-context.xml" })
@RunWith(SpringJUnit4ClassRunner.class)
public class UserTest {

	@Autowired
	private UserDAO userDAO;
	@Autowired
	private DataSource dataSource;

	@Before
	public void init() {
		JdbcTemplate jdbc = new JdbcTemplate(dataSource);

		jdbc.execute("delete from users");
		jdbc.execute("delete from authorities");

	}

	@Test
	public void testCreateUser() {
		Users users = new Users("Pablito", "1234", true, "ROLE_USER");
		assertTrue("Should return true", userDAO.createUser(users));
	}

}
