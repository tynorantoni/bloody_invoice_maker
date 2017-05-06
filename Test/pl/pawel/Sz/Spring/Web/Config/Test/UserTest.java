package pl.pawel.Sz.Spring.Web.Config.Test;

import static org.junit.Assert.assertEquals;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.test.context.ActiveProfiles;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

@ActiveProfiles("dev")
@ContextConfiguration(locations = { "classpath:pl/pawelSz/Spring/Web/Config/dao-context.xml",
		"classpath:pl/pawelSz/Spring/Web/Config/data.xml",
		"classpath:pl/pawelSz/Spring/Web/Config/security-context.xml" })
@RunWith(SpringJUnit4ClassRunner.class)
public class UserTest {
	
	
	@Test
	public void dummy(){
		assertEquals("dummy",1,1);
	}

}
