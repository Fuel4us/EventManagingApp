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
import pt.isep.nsheets.shared.core.formula.Literal;

/**
 *
 * @author pedro
 */
public class AssignmentTest {

    public AssignmentTest() {
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
     * Test of applyTo method, of class Assignment.
     */
    @Test
    public void testApplyTo() throws Exception {
//        System.out.println("applyTo");
//        Expression leftOperand = new Literal(new Value("B1"));
//        Expression rightOperand = new Literal(new Value(5));
//        Assignment instance = new Assignment();
//        Value expResult = new Value(5);
//        Value result = instance.applyTo(leftOperand, rightOperand);
//        assertEquals(expResult.toText(), result.toText());
    }

    /**
     * Test of getIdentifier method, of class Assignment.
     */
    @Test
    public void testGetIdentifier() {
        System.out.println("getIdentifier");
        Assignment instance = new Assignment();
        String expResult = ":=";
        String result = instance.getIdentifier();
        assertEquals(expResult, result);
    }

    /**
     * Test of getOperandValueType method, of class Assignment.
     */
    @Test
    public void testGetOperandValueType() {
        System.out.println("getOperandValueType");
        Assignment instance = new Assignment();
        Value.Type expResult = Value.Type.UNDEFINED;
        Value.Type result = instance.getOperandValueType();
        assertEquals(expResult, result);
    }

    /**
     * Test of toString method, of class Assignment.
     */
    @Test
    public void testToString() {
        System.out.println("toString");
        Assignment instance = new Assignment();
        String expResult = ":=";
        String result = instance.toString();
        assertEquals(expResult, result);
    }

}
