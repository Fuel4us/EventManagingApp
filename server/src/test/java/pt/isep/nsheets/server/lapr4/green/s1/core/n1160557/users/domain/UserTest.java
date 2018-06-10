/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package pt.isep.nsheets.server.lapr4.green.s1.core.n1160557.users.domain;

import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import static org.junit.Assert.*;
import pt.isep.nsheets.shared.lapr4.red.s2.ipc.n1161292.users.Password;
import pt.isep.nsheets.shared.services.UserDTO;

/**
 *
 * @author Hilario Coelho
 */
public class UserTest {

    User testUser;
    String defaultEmail = "1160557@isep.ipp.pt";
    String defaultName = "Hilario";
    String defaultNickname = "coelho98";
    Password defaultPassword = new Password("123Asd");
    boolean defaultSuperuser = true;

    public UserTest() {
    }

    @BeforeClass
    public static void setUpClass() {
    }

    @AfterClass
    public static void tearDownClass() {
    }

    @Before
    public void setUp() {
        testUser = new User(defaultEmail, defaultName, defaultNickname, defaultPassword, defaultSuperuser);
    }

    @After
    public void tearDown() {
    }

    /**
     * Test of getEmail method, of class User.
     */
    @Test
    public void testGetEmail() {
        System.out.println("getEmail");
        assertEquals(defaultEmail, testUser.getEmail());
    }

    /**
     * Test of getName method, of class User.
     */
    @Test
    public void testGetName() {
        System.out.println("getName");
        assertEquals(defaultName, testUser.getName());
    }

    /**
     * Test of getNickname method, of class User.
     */
    @Test
    public void testGetNickname() {
        System.out.println("getNickname");
        assertEquals(defaultNickname, testUser.getNickname());
    }

    /**
     * Test of getPassword method, of class User.
     */
    @Test
    public void testGetPassword() {
        System.out.println("getPassword");
        assertEquals(defaultPassword, testUser.getPassword());
    }

    /**
     * Test of isSuperuser method, of class User.
     */
    @Test
    public void testIsSuperuser() {
        System.out.println("isSuperuser");
        assertEquals(defaultSuperuser, testUser.isSuperuser());
    }

    /**
     * Test of verifyPassword method, of class User.
     */
    @Test
    public void testVerifyPassword() {
        System.out.println("verifyPassword");
        assertEquals(true, testUser.verifyPassword(defaultPassword));
        assertEquals(false, testUser.verifyPassword(new Password("1234Aasd")));
    }

    /**
     * Test of toString method, of class User.
     */
    @Test
    public void testToString() {
        System.out.println("toString");
        assertEquals(defaultEmail + " " + defaultName + " " + defaultNickname, testUser.toString());
    }

    /**
     * Test of sameAs method, of class User.
     */
    @Test
    public void testSameAs() {
        System.out.println("sameAs");
        User user_1 = new User(defaultEmail, defaultName, defaultNickname, defaultPassword, defaultSuperuser);
        User user_2 = new User("", defaultName, defaultNickname, defaultPassword, defaultSuperuser);
        User user_3 = new User(defaultEmail, "", defaultNickname, defaultPassword, defaultSuperuser);
        User user_4 = new User(defaultEmail, defaultName, "", defaultPassword, defaultSuperuser);
        User user_5 = new User(defaultEmail, defaultName, defaultNickname, new Password("Mnb12345"), defaultSuperuser);
        User user_6 = new User(defaultEmail, defaultName, defaultNickname, defaultPassword, false);

        assertEquals(false, testUser.sameAs(new String()));
        assertEquals(true, testUser.sameAs(testUser));
        assertEquals(true, testUser.sameAs(user_1));
        assertEquals(false, testUser.sameAs(user_2));
        assertEquals(false, testUser.sameAs(user_3));
        assertEquals(false, testUser.sameAs(user_4));
        assertEquals(false, testUser.sameAs(user_5));
        assertEquals(false, testUser.sameAs(user_6));
    }

    /**
     * Test of is method, of class User.
     */
    @Test(expected = NullPointerException.class)
    public void testIs() {
        System.out.println("is");
        testUser.is(0L);
    }

    /**
     * Test of id method, of class User.
     */
    @Test
    public void testId() {
        System.out.println("id");
        assertEquals(null, testUser.id());
    }

    /**
     * Test of toDTO method, of class User.
     */
    @Test
    public void testToDTO() {
        System.out.println("toDTO");
        UserDTO expected = new UserDTO(defaultEmail, defaultName, defaultNickname, defaultPassword.toString(), defaultSuperuser);
        assertEquals(true, testUser.toDTO().equals(expected));
    }

    /**
     * Test of fromDTO method, of class User.
     */
    @Test
    public void testFromDTO() {
        System.out.println("fromDTO");
        UserDTO dto = new UserDTO(defaultEmail, defaultName, defaultNickname, defaultPassword.toString(), defaultSuperuser);
        assertEquals(true, User.fromDTO(dto, true).sameAs(testUser));
    }

}
