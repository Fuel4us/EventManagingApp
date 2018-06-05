/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package pt.isep.nsheets.server.lapr4.green.s1.core.n1140302.search.Application;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import static org.junit.Assert.*;
import pt.isep.nsheets.server.lapr4.green.s1.core.n1140302.search.Domain.CellInfoDTO;
import pt.isep.nsheets.shared.core.*;

/**
 *
 * @author diogo
 */
public class SearchServiceTest {
    
    public SearchServiceTest() {
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
     * Test of getCellsFromSpreadSheets method, of class SearchService.
     */
    @Test
    public void testGetCellsFromSpreadSheets() {
        /*System.out.println("getCellsFromSpreadSheets");

        CellImpl cell = new CellImpl();
        Address address = new Address(1,1);
        Map<Address,Cell> map = new HashMap<>();
        map.put(address,cell);

        List<SpreadsheetImpl> spreadsheets = new ArrayList<>();

        SpreadsheetImpl spreadsheet = new SpreadsheetImpl("title",map);
        spreadsheets.add(spreadsheet);
        SearchService instance;
        instance = new SearchSrvice();
        int expResult = 1;


        List<CellImpl> method = instance.getCellsFromSpreadSheets(spreadsheets);
        int result = method.size();
        assertEquals(expResult, result);*/

    }

    /**
     * Test of getSpreadSheetsByWorkBookName method, of class SearchService.
     */
    @Test
    public void testGetSpreadSheetsByWorkBookName() {
        /*System.out.println("getSpreadSheetsByWorkBookName");
        String name = "";
        SearchService instance = new SearchService();
        List<SpreadsheetImpl> expResult = null;
        List<SpreadsheetImpl> result = instance.getSpreadSheetsByWorkBookName(name);
        assertEquals(expResult, result);
        */
    }

    /**
     * Test of getCellInfoFromEntityCell method, of class SearchService.
     */
    @Test
    public void testGetCellInfoFromEntityCell() {
        /*System.out.println("getCellInfoFromEntityCell");
        CellImpl cell = new CellImpl();
        Address address = new Address(1,1);
        Map<Address,Cell> map = new HashMap<>();
        map.put(address,cell);

        List<SpreadsheetImpl> spreadsheets = new ArrayList<>();

        SpreadsheetImpl spreadsheet = new SpreadsheetImpl("title",map);

        spreadsheet.getCell(address);
        spreadsheets.add(spreadsheet);
        List<CellImpl> cellList = new ArrayList<>();
        cellList.add((CellImpl)spreadsheet.getCell(address));
        SearchService instance = new SearchService();
        int expResult = 1;
        List<CellInfoDTO> list = instance.getCellInfoFromEntityCell(cellList);
        int result = list.size();
        assertEquals(expResult, result);*/

    }

    /**
     * Test of getCellInfoString method, of class SearchService.
     */
    @Test
    public void testGetCellInfoString() {
        /*System.out.println("getCellInfoString");
        List<CellImpl> cellList = null;
        String expression = "";
        SearchService instance = new SearchService();
        String expResult = "";
        String result = instance.getCellInfoString(cellList, expression);
        assertEquals(expResult, result);

        fail("The test case is a prototype.");*/
    }
    
}
