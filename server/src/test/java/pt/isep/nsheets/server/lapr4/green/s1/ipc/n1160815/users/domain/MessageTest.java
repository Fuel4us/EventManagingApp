/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
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
 * @author Leandro
 */
public class MessageTest {
    
    Message message;
    String DEFAULT_USER = "user1";
    String DEFAULT_TEXT = "Test message";
    long DEFAULT_NUMBER_DATE = 100;
    Date DEFAULT_DATE;
    
    @BeforeClass
    public static void setUpClass() {
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
        
        Message instance = new Message(DEFAULT_TEXT, DEFAULT_DATE, DEFAULT_USER);
        MessagesDTO expResult = new MessagesDTO(DEFAULT_TEXT, DEFAULT_DATE, DEFAULT_USER);
        MessagesDTO result = instance.toDTO();
        
        assertEquals(expResult.getText(), result.getText());
        assertEquals(expResult.getUser(), result.getUser());
        assertEquals(expResult.getDate(), result.getDate());
    }

    /**
     * Test of fromDTO method, of class Message.
     */
    @Test
    public void testFromDTO() {
        System.out.println("fromDTO");
        
        MessagesDTO dto = new MessagesDTO(DEFAULT_TEXT, DEFAULT_DATE, DEFAULT_USER);;
        Message expResult = message;
        Message result = Message.fromDTO(dto);
        
        assertEquals(expResult.toDTO().getText(), result.toDTO().getText());
        assertEquals(expResult.toDTO().getUser(), result.toDTO().getUser());
        assertEquals(expResult.toDTO().getDate(), result.toDTO().getDate());
    }

    /**
     * Test of sameAs method, of class Message.
     */
    @Test
    public void testSameAs() {
        System.out.println("sameAs");
        
        Message instance = new Message(DEFAULT_TEXT, DEFAULT_DATE, DEFAULT_USER);
        boolean expResult = true;
        boolean result = instance.sameAs(instance);
        
        assertEquals(expResult, result);
    }
    
}
