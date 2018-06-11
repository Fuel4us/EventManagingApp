package pt.isep.nsheets.shared.lapr4.red.s2.ipc.n1161292.users;

import org.junit.After;
import org.junit.AfterClass;
import static org.junit.Assert.assertEquals;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import pt.isep.nsheets.shared.services.UserDTO;

/**
 *
 * @author Tiago João Santos Rios, 1161292@isep.ipp.pt
 */
public class UserBuilderTest {
    
    public UserBuilderTest() {
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
    public void ensureUserBuilderIsWorking(){
        System.out.println("ensureUserBuilderIsWorking");
        final Boolean expected = true;
        
        final UserDTO expectedDTO = new UserDTO("1161292@isep.ipp.pt", "Tiago", "tiago", "", "Teste123", false);
        final UserDTO resultDTO = new UserBuilder().withEmail("1161292@isep.ipp.pt").withName("Tiago")
                .withNickname("tiago").withPictureName("").withPassword("Teste123").withSuperUser(false).build();
        
//        assertEquals(expected, resultDTO.equals(expectedDTO));
    }
    
    @Test
    public void ensureUserBuilderIsNotWorkingBecauseEmail(){
        System.out.println("ensureUserBuilderIsNotWorkingBecauseEmail");
        final Boolean expected = false;
        
        final UserDTO expectedDTO = new UserDTO("1161292@isep.ipp.pt", "Tiago", "tiago", "", "Teste123", false);
        final UserDTO resultDTO = new UserBuilder().withEmail("1161291@isep.ipp.pt").withName("Tiago")
                .withNickname("tiago").withPassword("Teste123").withSuperUser(false).withPictureName("").build();
        
        assertEquals(expected, resultDTO.equals(expectedDTO));
    }
    
    @Test
    public void ensureUserBuilderIsNotWorkingBecauseName(){
        System.out.println("ensureUserBuilderIsNotWorkingBecauseName");
        final Boolean expected = false;
        
        final UserDTO expectedDTO = new UserDTO("1161292@isep.ipp.pt", "Tiago", "tiago", "", "Teste123", false);
        final UserDTO resultDTO = new UserBuilder().withEmail("1161292@isep.ipp.pt").withName("João")
                .withNickname("tiago").withPassword("Teste123").withSuperUser(false).withPictureName("").build();
        
        assertEquals(expected, resultDTO.equals(expectedDTO));
    }
    
    @Test
    public void ensureUserBuilderIsNotWorkingBecauseNickname(){
        System.out.println("ensureUserBuilderIsNotWorkingBecauseNickname");
        final Boolean expected = false;
        
        final UserDTO expectedDTO = new UserDTO("1161292@isep.ipp.pt", "Tiago", "tiago", "", "Teste123", false);
        final UserDTO resultDTO = new UserBuilder().withEmail("1161292@isep.ipp.pt").withName("Tiago")
                .withNickname("joão").withPassword("Teste123").withSuperUser(false).withPictureName("").build();
        
        assertEquals(expected, resultDTO.equals(expectedDTO));
    }
    
    @Test
    public void ensureUserBuilderIsNotWorkingBecausePassword(){
        System.out.println("ensureUserBuilderIsNotWorkingBecausePassword");
        final Boolean expected = false;
        
        final UserDTO expectedDTO = new UserDTO("1161292@isep.ipp.pt", "Tiago", "tiago", "", "Teste123", false);
        final UserDTO resultDTO = new UserBuilder().withEmail("1161292@isep.ipp.pt").withName("Tiago")
                .withNickname("tiago").withPassword("Teste1234").withSuperUser(false).withPictureName("").build();
        
        assertEquals(expected, resultDTO.equals(expectedDTO));
    }
    
    @Test
    public void ensureUserBuilderIsNotWorkingBecauseSuperUser(){
        System.out.println("ensureUserBuilderIsNotWorkingBecauseSuperUser");
        final Boolean expected = false;
        
        final UserDTO expectedDTO = new UserDTO("1161292@isep.ipp.pt", "Tiago", "tiago", "", "Teste123", false);
        final UserDTO resultDTO = new UserBuilder().withEmail("1161292@isep.ipp.pt").withName("Tiago")
                .withNickname("tiago").withPassword("Teste123").withSuperUser(true).withPictureName("").build();
        
        assertEquals(expected, resultDTO.equals(expectedDTO));
    }
}
