package pt.isep.nsheets.server.lapr4.green.s1.ipc.n1160815.users.domain;

import java.util.Date;
import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import static org.junit.Assert.*;
import pt.isep.nsheets.shared.services.MessagesDTO;

/**
 *
 * @author Leandro, Pedro Vieira
 */
public class MessageTest {
    
    Message message;
    Date DEFAULT_DATE = new Date();
    String DEFAULT_USER = "user1";
    String DEFAULT_TEXT = "Test message";
    int DEFAULT_INDEX_CHAT = 0;
    
    @BeforeClass
    public static void setUpClass() {
    }
    
    @AfterClass
    public static void tearDownClass() {
    }
    
    @Before
    public void setUp() {
        message = new Message(DEFAULT_TEXT, DEFAULT_DATE, DEFAULT_USER, DEFAULT_INDEX_CHAT);
    }
    
    @After
    public void tearDown() {
    }

    /**
     * Test of is method, of class Message.
     */
    @Test(expected = NullPointerException.class)
    public void testIs() {
        System.out.println("is");
        
        message.is(0L);
    }

    /**
     * Test of id method, of class Message.
     */
    @Test
    public void testId() {
        System.out.println("id");
        
        assertEquals(null, message.id());
    }

    /**
     * Test of toDTO method, of class Message.
     */
    @Test
    public void testToDTO() {
        System.out.println("toDTO");
        
        Message instance = new Message(DEFAULT_TEXT, DEFAULT_DATE, DEFAULT_USER, DEFAULT_INDEX_CHAT);
        MessagesDTO expResult = new MessagesDTO(DEFAULT_TEXT, DEFAULT_DATE, DEFAULT_USER, DEFAULT_INDEX_CHAT);
        MessagesDTO result = instance.toDTO();
        
        assertEquals(expResult.getText(), result.getText());
        assertEquals(expResult.getDate(), result.getDate());
        assertEquals(expResult.getUser(), result.getUser());
        assertEquals(expResult.getDate(), result.getDate());
        assertEquals(expResult.getChatIndex(), result.getChatIndex());
    }

    /**
     * Test of fromDTO method, of class Message.
     */
    @Test
    public void testFromDTO() {
        System.out.println("fromDTO");
        
        MessagesDTO dto = new MessagesDTO(DEFAULT_TEXT, DEFAULT_DATE, DEFAULT_USER, DEFAULT_INDEX_CHAT);
        Message expResult = message;
        Message result = Message.fromDTO(dto);
        
        assertEquals(expResult.toDTO().getText(), result.toDTO().getText());
        assertEquals(expResult.toDTO().getDate(), result.toDTO().getDate());
        assertEquals(expResult.toDTO().getUser(), result.toDTO().getUser());
        assertEquals(expResult.toDTO().getDate(), result.toDTO().getDate());
        assertEquals(expResult.toDTO().getChatIndex(), result.toDTO().getChatIndex());
    }

    /**
     * Test of sameAs method, of class Message.
     */
    @Test
    public void testSameAs() {
        System.out.println("sameAs");
        
        Message instance = new Message(DEFAULT_TEXT, DEFAULT_DATE, DEFAULT_USER, DEFAULT_INDEX_CHAT);
        boolean expResult = true;
        boolean result = instance.sameAs(instance);
        
        assertEquals(expResult, result);
    }
    
}
