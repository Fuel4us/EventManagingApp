package pt.isep.nsheets.server.lapr4.green.s1.core.n1160557.users.application;

import static org.junit.Assert.assertTrue;

import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import pt.isep.nsheets.server.lapr4.green.s1.core.n1160557.users.domain.User;

import pt.isep.nsheets.shared.services.UserDTO;

public class LoginUserControllerTest {

	public LoginUserControllerTest() {
	}

	@BeforeClass
	public static void setUpClass() {
	}

	@AfterClass
	public static void tearDownClass() {
	}

	@Before
	public void setUp() {
	}

	@After
	public void tearDown() {
	}

	@Test
	public void testNormalBehaviour() throws Exception {
		System.out.println("testNormalBehaviour");
                
                final User expected = new User("1160557@isep.ipp.pt", "Hilario", "coelho98", "123Assd", true);

		LoginUserController ctrl = new LoginUserController();

		UserDTO result = ctrl.attemptLogin("1160557@isep.ipp.pt", "123Assd");
		UserDTO result_2 = ctrl.attemptLogin("1160557@isep.ipp.pt", "123Asdd");

		assertTrue("Failed to login with this user", expected.sameAs(User.fromDTO(result, true)));
		assertTrue("Failed to login with this user", result_2 == null);
	}
}