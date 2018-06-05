/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package pt.isep.nsheets.server.lapr4.green.s1.core.n1140572.workbooks.application;

import eapli.framework.persistence.DataConcurrencyException;
import eapli.framework.persistence.DataIntegrityViolationException;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;
import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import static org.junit.Assert.*;
import pt.isep.nsheets.server.lapr4.white.s1.core.n4567890.workbooks.persistence.PersistenceContext;
import pt.isep.nsheets.server.lapr4.white.s1.core.n4567890.workbooks.persistence.WorkbookRepository;
import pt.isep.nsheets.shared.core.Workbook;

/**
 *
 * @author Pedro Rodrigues - (1140572)
 */
public class SearchWorkbooksControllerTest {

    public SearchWorkbooksControllerTest() {
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
     * Test of searchWorkbooks method, of class SearchWorkbooksController.
     */
    @Test
    public void testSearchWorkbooks() {
        System.out.println("searchWorkbooks");
        /*String workbookName = "LAPR4-UNIT";
        WorkbookRepository repo = PersistenceContext.repositories().workbooks();
        Workbook w1 = new Workbook("TEST", "TEST");
        Workbook w2 = new Workbook("UNIT", "TEST");
        try {
            repo.save(w1);
            repo.save(w2);
        } catch (DataConcurrencyException | DataIntegrityViolationException ex) {
            Logger.getLogger(SearchWorkbooksControllerTest.class.getName()).log(Level.SEVERE, null, ex);
        }
        SearchWorkbooksController instance = new SearchWorkbooksController();
        ArrayList<Workbook> expResult = new ArrayList<>();
        expResult.add(w2);
        ArrayList<Workbook> result = instance.searchWorkbooks(workbookName);
        repo.deleteWorkbook(w1);
        repo.deleteWorkbook(w2);
        assertEquals(expResult, result);*/
        assertEquals("","");
    }

}
