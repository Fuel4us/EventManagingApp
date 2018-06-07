/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package pt.isep.nsheets.server.lapr4.red.s1.core.n1160630.chart.domain;

import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import static org.junit.Assert.*;
import pt.isep.nsheets.shared.core.Address;
import pt.isep.nsheets.shared.core.Spreadsheet;
import pt.isep.nsheets.shared.services.ChartDTO;
import pt.isep.nsheets.shared.services.ChartType;

/**
 *
 * @author pedromonteiro
 */
public class BarChartTest {
    
    ChartDTO c;
    
    public BarChartTest() {
    }
    
    @BeforeClass
    public static void setUpClass() {
    }
    
    @AfterClass
    public static void tearDownClass() {
    }
    
    @Before
    public void setUp() {
        
        String[][] content = new String[][]{
                    {"1", "2", "3"},
                    {"1", "5", "8"},
                    {"7", "6", "3"}};
        
        c = new ChartDTO("Chart Test",
                new Address(0, 0),
                new Address(2, 2),
                true,
                true,
                ChartType.BAR_CHART,
                new Address(3, 3),
                content
        );
    }
    
    @After
    public void tearDown() {
    }


    /**
     * Test of toDTO method, of class BarChart.
     */
    @Test
    public void testToDTO() {
//        System.out.println("toDTO");
//        BarChart instance = new BarChart(c);
//        
//        ChartDTO result = instance.toDTO();
//        
//        assertEquals(c, result);
    }

    /**
     * Test of associatedCell method, of class BarChart.
     */
    @Test
    public void testAssociatedCell() {
//        System.out.println("associatedCell");
//        
//        BarChart bc = new BarChart(c);
//        bc.generateChartValues(null);
//        BarChart instance = bc;
//        Address expResult = new Address(c.getLastAddress().getColumn(), c.getFirstAddress().getRow());
//        Address result = instance.associatedCell();
//        
//        assertEquals(expResult, result);
    }
    
}
