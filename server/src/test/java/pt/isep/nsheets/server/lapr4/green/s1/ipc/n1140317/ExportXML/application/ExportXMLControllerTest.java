package pt.isep.nsheets.server.lapr4.green.s1.ipc.n1140317.ExportXML.application;

import java.io.File;
import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import static org.junit.Assert.*;
import pt.isep.nsheets.shared.core.Spreadsheet;
import pt.isep.nsheets.shared.core.Workbook;

/**
 *
 * @author Carlos Figueiredo (1140317)
 */
public class ExportXMLControllerTest {
    
    public ExportXMLControllerTest() {
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
     * Test of exportWorkbook method, of class ExportXMLController.
     */
    @Test
    public void testExportWorkbook() throws Exception {
        System.out.println("exportWorkbook");
       
        String filePath = "../server\\src\\test\\java\\pt\\isep\\nsheets\\server\\lapr4\\green\\s1\\ipc\\n1140317\\ExportXML\\application\\workbookTest.xml";
        File file = new File(filePath);
 
        Workbook activeWorkbook = new Workbook("","",2);
        ExportXMLController instance = new ExportXMLController();
 
        boolean expResult = true;
        boolean result = instance.exportWorkbook(activeWorkbook, file);
        assertEquals(expResult, result);
    }

    /**
     * Test of exportSpreadsheet method, of class ExportXMLController.
     */
    @Test
    public void testExportSpreadsheet() throws Exception {
        System.out.println("exportSpreadsheet");
        String filePath = "../server\\src\\test\\java\\pt\\isep\\nsheets\\server\\lapr4\\green\\s1\\ipc\\n1140317\\ExportXML\\application\\spreadsheetTest.xml";
        File file = new File(filePath);
 
        Workbook workbook = new Workbook("","",3);
        Spreadsheet activeSpreadsheet = workbook.getSpreadsheet(0);
        ExportXMLController instance = new ExportXMLController();
 
        boolean expResult = true;
        boolean result = instance.exportSpreadsheet(activeSpreadsheet, file);
        assertEquals(expResult, result);
    }
    

    /**
     * Test of exportSpreadsheetCells method, of class ExportXMLController.
     */
    @Test
    public void testExportSpreadsheetCells() throws Exception {
        System.out.println("exportSpreadsheet");
        String filePath = "../server\\src\\test\\java\\pt\\isep\\nsheets\\server\\lapr4\\green\\s1\\ipc\\n1140317\\ExportXML\\application\\spreadsheetCellsTest.xml";
        File file = new File(filePath);
 
        Workbook workbook = new Workbook("","",4);
        Spreadsheet activeSpreadsheet = workbook.getSpreadsheet(0);
        ExportXMLController instance = new ExportXMLController();
 
        boolean expResult = true;
        boolean result = instance.exportSpreadsheetCells(activeSpreadsheet, 1, 1, 2, 2, file);
        assertEquals(expResult, result);
    }
    
}
