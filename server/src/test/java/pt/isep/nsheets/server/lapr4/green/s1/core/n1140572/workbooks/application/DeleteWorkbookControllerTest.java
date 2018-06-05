/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package pt.isep.nsheets.server.lapr4.green.s1.core.n1140572.workbooks.application;

import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import static org.junit.Assert.*;
import pt.isep.nsheets.shared.lapr4.red.s1.core.n1161292.services.WorkbookDTO;

/**
 *
 * @author Pedro Rodrigues - (1140572)
 */
public class DeleteWorkbookControllerTest {

    public DeleteWorkbookControllerTest() {
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
     * Test of deleteWorkbook method, of class DeleteWorkbookController.
     */
    @Test
    public void testDeleteWorkbook() {
        /*
        WorkbookRepository repo = PersistenceContext.repositories().workbooks();
        WorkbookDTO wdto = new WorkbookDTO("TEST", "TEST", 0);
        Workbook w1 = repo.findByName(wdto.name);
        try {
            repo.save(w1);
        } catch (DataConcurrencyException | DataIntegrityViolationException ex) {
            Logger.getLogger(SearchWorkbooksControllerTest.class.getName()).log(Level.SEVERE, null, ex);
        }
        DeleteWorkbookController instance = new DeleteWorkbookController();
        instance.deleteWorkbook(wdto);
        repo.deleteWorkbook(w1);
        Workbook result = null;
        Workbook result = repo.findByName(wdto.name);
        assertEquals(expResult, result);*/
        assertEquals("", "");
    }

}
