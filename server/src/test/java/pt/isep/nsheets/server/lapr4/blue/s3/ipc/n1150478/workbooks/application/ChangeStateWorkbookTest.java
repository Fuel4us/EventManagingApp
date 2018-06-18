/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package pt.isep.nsheets.server.lapr4.blue.s3.ipc.n1150478.workbooks.application;

import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import pt.isep.nsheets.server.lapr4.white.s1.core.n4567890.workbooks.persistence.PersistenceContext;
import pt.isep.nsheets.server.lapr4.white.s1.core.n4567890.workbooks.persistence.WorkbookRepository;
import pt.isep.nsheets.shared.lapr4.red.s1.core.n1161292.services.WorkbookDTO;

/**
 *
 * @author João Pereira <1150478@isep.ipp.pt>
 */
public class ChangeStateWorkbookTest {

    ChangeStateWorkbook instance;

    public ChangeStateWorkbookTest() {

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
     * Test of changeStateWorkbook method, of class ChangeStateWorkbook.
     */
    @Test
    public void testChangeStateWorkbook() {
        System.out.println("changeStateWorkbook");
        boolean state = false;
        WorkbookDTO workbookDTO = new WorkbookDTO("Workbook", "forTesting", 2);
       // instance.changeStateWorkbook(state, workbookDTO);
    }

}
