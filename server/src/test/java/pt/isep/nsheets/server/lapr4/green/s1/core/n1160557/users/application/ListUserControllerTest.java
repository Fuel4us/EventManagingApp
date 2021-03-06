//package pt.isep.nsheets.server.lapr4.green.s1.core.n1160557.users.application;
//
//import static org.junit.Assert.assertTrue;
//
//import java.util.Properties;
//
//import org.junit.After;
//import org.junit.AfterClass;
//import org.junit.Before;
//import org.junit.BeforeClass;
//import org.junit.FixMethodOrder;
//import org.junit.Test;
//import org.junit.runners.MethodSorters;
//
//import pt.isep.nsheets.server.lapr4.green.s1.core.n1160557.users.application.ListUserController;
//import pt.isep.nsheets.server.lapr4.green.s1.core.n1160557.users.domain.User;
//import pt.isep.nsheets.server.lapr4.white.s1.core.n4567890.workbooks.persistence.PersistenceContext;
//import pt.isep.nsheets.server.lapr4.white.s1.core.n4567890.workbooks.persistence.PersistenceSettings;
//
//@FixMethodOrder(MethodSorters.NAME_ASCENDING)
//public class ListUserControllerTest {
//
//	   public ListUserControllerTest() {
//	   }
//
//	   @BeforeClass
//	   public static void setUpClass() {
//	       System.out.println("ListUserControllerTest");
//	       
//	       // Setup the context to use a memory database for testing
//			Properties props=new Properties();
//	        props.put("persistence.repositoryFactory", "pt.isep.nsheets.server.lapr4.white.s1.core.n4567890.workbooks.persistence.jpa.JpaRepositoryFactory");
//	        props.put("persistence.persistenceUnit", "lapr4.NSheetsPU-test");
//	        
//	        // Other JPA properties that one might want to override from the ones in persistence.xml 
//	        // props.put("javax.persistence.jdbc.url", "jdbc:h2:mem:");
//			props.put("javax.persistence.jdbc.url", "jdbc:h2:mem:ListUserControllerTest");
//	        props.put("javax.persistence.schema-generation.database.action", "create");
//	        // appProps.put("javax.persistence.jdbc.password", "");
//	        // appProps.put("javax.persistence.jdbc.driver", "org.h2.Driver");
//	        // appProps.put("javax.persistence.jdbc.user", "");
//	        // appProps.put("eclipselink.logging.level", "FINE");
//	        
//			PersistenceSettings extensionSettings=new PersistenceSettings(props);
//
//			PersistenceContext.setSettings(extensionSettings);
//	   }
//
//	   @AfterClass
//	   public static void tearDownClass() {
//	   }
//
//	   @Before
//	   public void setUp() {
//	   
//	   }
//
//	   @After
//	   public void tearDown() {
//	   }
//
//	   @Test 
//	   public void testAensureGetWorkbooksEmpty() {
//		   System.out.println("testAensureGetUsersEmpty");
//		   
//		   ListUserController ctrl=new ListUserController();
//		   
//		   Iterable<User> usrs=ctrl.listUsers();
//		   
//		   assertTrue("the list of Users is not empty", !usrs.iterator().hasNext());
//	   }
//	   
//		@Test
//		public void testBtestDatabaseInsertion() throws Exception {
//			System.out.println("testBtestDatabaseInsertion");
//
//			final User expected = new User("1160557@isep.ipp.pt", "Hilario", "coelho98", "123pass", false);
//
//			AddUserController ctrlAdd = new AddUserController();
//
//			User result = ctrlAdd.addUser(expected.toDTO());
//			
//			ListUserController ctrlList=new ListUserController();
//			   
//			Iterable<User> usrs=ctrlList.listUsers();
//
//			assertTrue("the added User is not in the database", usrs.iterator().hasNext());
//		}	   
//}
