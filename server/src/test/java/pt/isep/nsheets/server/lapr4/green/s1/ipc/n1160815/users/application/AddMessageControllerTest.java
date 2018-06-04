/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package pt.isep.nsheets.server.lapr4.green.s1.ipc.n1160815.users.application;

import java.util.Date;
import java.util.Properties;
import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import static org.junit.Assert.*;
import pt.isep.nsheets.server.lapr4.green.s1.ipc.n1160815.users.domain.Message;
import pt.isep.nsheets.server.lapr4.white.s1.core.n4567890.workbooks.persistence.PersistenceContext;
import pt.isep.nsheets.server.lapr4.white.s1.core.n4567890.workbooks.persistence.PersistenceSettings;
import pt.isep.nsheets.shared.services.MessagesDTO;

/**
 *
 * @author Leandro
 */
public class AddMessageControllerTest {

    Message message;
    String DEFAULT_USER = "user1";
    String DEFAULT_TEXT = "Test message";
    long DEFAULT_NUMBER_DATE = 100;
    Date DEFAULT_DATE;

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
        props.put("javax.persistence.jdbc.url", "jdbc:h2:mem:AddUserControllerTest");
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
        DEFAULT_DATE = new Date(DEFAULT_NUMBER_DATE);
        message = new Message(DEFAULT_TEXT, DEFAULT_DATE, DEFAULT_USER);
    }

    @After
    public void tearDown() {
    }

    /**
     * Test of addMessage method, of class AddMessageController.
     */
    @Test
    public void testAddMessage() throws Exception {
        /*System.out.println("addMessage");
        MessagesDTO mDTO = new MessagesDTO(DEFAULT_TEXT, DEFAULT_DATE, DEFAULT_USER);
        AddMessageController instance = new AddMessageController();
        Message expResult = new Message(DEFAULT_TEXT, DEFAULT_DATE, DEFAULT_USER);
        Message result = instance.addMessage(mDTO);

        assertEquals(expResult, result);*/
    }

}
