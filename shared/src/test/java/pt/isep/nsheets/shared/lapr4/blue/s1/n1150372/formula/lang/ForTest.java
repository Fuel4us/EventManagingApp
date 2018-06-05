/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package pt.isep.nsheets.shared.lapr4.blue.s1.n1150372.formula.lang;

import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import static org.junit.Assert.*;
import pt.isep.nsheets.shared.core.Value;
import pt.isep.nsheets.shared.core.formula.Expression;
import pt.isep.nsheets.shared.core.formula.FunctionParameter;

/**
 *
 * @author pedro
 */
public class ForTest {
    
    public ForTest() {
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

    /**
     * Test of getIdentifier method, of class For.
     */
    @Test
    public void testGetIdentifier() {
        System.out.println("getIdentifier");
        For instance = new For();
        String expResult = "FOR{";
        String result = instance.getIdentifier();
        assertEquals(expResult, result);
    }

    /**
     * Test of applyTo method, of class For.
     */
    @Test
    public void testApplyTo() throws Exception {
//        System.out.println("applyTo");
//        Expression[] args = null;
//        For instance = new For();
//        Value expResult = null;
//        Value result = instance.applyTo(args);
//        assertEquals(expResult, result);
    }

    /**
     * Test of getParameters method, of class For.
     */
    @Test
    public void testGetParameters() {
//        System.out.println("getParameters");
//        For instance = new For();
//        FunctionParameter[] expResult = null;
//        FunctionParameter[] result = instance.getParameters();
//        assertArrayEquals(expResult, result);
//        // TODO review the generated test code and remove the default call to fail.
//        fail("The test case is a prototype.");
    }

    /**
     * Test of isVarArg method, of class For.
     */
    @Test
    public void testIsVarArg() {
//        System.out.println("isVarArg");
//        For instance = new For();
//        boolean expResult = false;
//        boolean result = instance.isVarArg();
//        assertEquals(expResult, result);;
    }
    
}
