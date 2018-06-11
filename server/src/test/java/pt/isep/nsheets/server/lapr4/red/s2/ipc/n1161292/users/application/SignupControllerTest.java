package pt.isep.nsheets.server.lapr4.red.s2.ipc.n1161292.users.application;

import java.util.Properties;
import org.junit.After;
import org.junit.AfterClass;
import static org.junit.Assert.assertTrue;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import pt.isep.nsheets.server.lapr4.green.s1.core.n1160557.users.application.ListUserController;
import pt.isep.nsheets.server.lapr4.green.s1.core.n1160557.users.domain.User;
import pt.isep.nsheets.server.lapr4.white.s1.core.n4567890.workbooks.persistence.PersistenceContext;
import pt.isep.nsheets.server.lapr4.white.s1.core.n4567890.workbooks.persistence.PersistenceSettings;
import pt.isep.nsheets.shared.services.UserDTO;

/**
 *
 * @author Tiago João Santos Rios, 1161292@isep.ipp.pt
 */
public class SignupControllerTest {
    
    private static final String EMAIL = "1161292@isep.ipp.pt";
    private static final String USERNAME = "tiago";
    private static final String NAME = "Tiago";
    private static final String PASSWORD = "Teste123";
    private static final Boolean SUPERUSER = false;
    
    @BeforeClass
    public static void setUpClass() {
        // Setup the context to use a memory database for testing
        Properties props = new Properties();
        props.put("persistence.repositoryFactory",
                "pt.isep.nsheets.server.lapr4.white.s1.core.n4567890.workbooks.persistence.jpa.JpaRepositoryFactory");
        props.put("persistence.persistenceUnit", "lapr4.NSheetsPU-test");

        // Other JPA properties that one might want to override from the ones in
        // persistence.xml
        // props.put("javax.persistence.jdbc.url", "jdbc:h2:mem:");
        props.put("javax.persistence.jdbc.url", "jdbc:h2:mem:SignupControllerTest");
        props.put("javax.persistence.schema-generation.database.action", "create");
        // appProps.put("javax.persistence.jdbc.password", "");
        // appProps.put("javax.persistence.jdbc.driver", "org.h2.Driver");
        // appProps.put("javax.persistence.jdbc.user", "");
        // appProps.put("eclipselink.logging.level", "FINE");

        PersistenceSettings extensionSettings = new PersistenceSettings(props);

        PersistenceContext.setSettings(extensionSettings);
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
        
        final User expected = new User(EMAIL, NAME, USERNAME, PASSWORD, "", SUPERUSER);
        SignupController ctrl = new SignupController();

        User result = ctrl.signupUser(new UserDTO(EMAIL, NAME, USERNAME, PASSWORD, "", SUPERUSER));

        assertTrue("The added User does not have the same data as input", expected.sameAs(result));
    }
    
    @Test
    public void testIfUserWasAdded() throws Exception {
        System.out.println("testIfUserWasAdded");

        final User expected = new User(EMAIL, NAME, USERNAME, PASSWORD, "", SUPERUSER);
        SignupController ctrl = new SignupController();
        User result = ctrl.signupUser(new UserDTO(EMAIL, NAME, USERNAME, PASSWORD, "", SUPERUSER));

        ListUserController ctrlList = new ListUserController();
        Iterable<User> list = ctrlList.listUsers();

        assertTrue("The added User is not in the database", list.iterator().hasNext());
    }
}
