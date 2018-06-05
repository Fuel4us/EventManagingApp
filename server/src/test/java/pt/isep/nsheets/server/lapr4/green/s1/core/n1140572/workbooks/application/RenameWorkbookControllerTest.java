/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package pt.isep.nsheets.server.lapr4.green.s1.core.n1140572.workbooks.application;

import eapli.framework.persistence.DataConcurrencyException;
import eapli.framework.persistence.DataIntegrityViolationException;
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
import pt.isep.nsheets.shared.lapr4.red.s1.core.n1161292.services.WorkbookDTO;

/**
 *
 * @author Pedro Rodrigues
 */
public class RenameWorkbookControllerTest {

    public RenameWorkbookControllerTest() {
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
     * Test of renameWorkbook method, of class RenameWorkbookController.
     */
    @Test
    public void testRenameWorkbook() {
       /* String expResult = "LAPR4-UNIT";
        WorkbookRepository repo = PersistenceContext.repositories().workbooks();
        WorkbookDTO wdto = new WorkbookDTO("TEST", "TEST", 0);
        Workbook w1 = repo.findByName(wdto.name);
        try {
            repo.save(w1);
        } catch (DataConcurrencyException | DataIntegrityViolationException ex) {
            Logger.getLogger(SearchWorkbooksControllerTest.class.getName()).log(Level.SEVERE, null, ex);
        }
        RenameWorkbookController instance = new RenameWorkbookController();
        instance.renameWorkbook(expResult, wdto);
        repo.deleteWorkbook(w1);
        String result = w1.name();
        assertEquals(expResult, result);*/
        assertEquals("", "");
    }

}
