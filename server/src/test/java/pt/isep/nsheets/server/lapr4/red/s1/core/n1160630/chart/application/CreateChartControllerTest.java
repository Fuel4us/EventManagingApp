/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package pt.isep.nsheets.server.lapr4.red.s1.core.n1160630.chart.application;

import org.junit.After;
import org.junit.AfterClass;
import org.junit.Assert;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import static org.junit.Assert.*;
import pt.isep.nsheets.server.lapr4.red.s1.core.n1160630.chart.domain.BarChart;
import pt.isep.nsheets.server.lapr4.red.s1.core.n1160630.chart.domain.Chart;
import pt.isep.nsheets.shared.core.Address;
import pt.isep.nsheets.shared.core.Workbook;
import pt.isep.nsheets.shared.lapr4.red.s1.core.n1161292.services.SpreadsheetDTO;
import pt.isep.nsheets.shared.services.ChartDTO;
import pt.isep.nsheets.shared.services.ChartType;

/**
 *
 * @author pedromonteiro
 */
public class CreateChartControllerTest {
    
    ChartDTO c;
//    SpreadsheetDTO ssDto;
    
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
        
//        Workbook wb = new Workbook("Workbook test", "Workbook test desc", content);
//        ssDto = wb.getSpreadsheet(0).toDTO();
    }
    
    @After
    public void tearDown() {
    }

    /**
     * Test of newChart method, of class CreateChartController.
     */
    @Test
    public void testNewChart() {
        
        System.out.println("newChart");
        
        ChartDTO dto = c;
        SpreadsheetDTO spreadsheet = null;
        
        CreateChartController instance = new CreateChartController();
        
        Chart expResult = new BarChart(dto);
        Chart result = instance.newChart(dto, spreadsheet);
        
        assertEquals(expResult, result);
    }

    /**
     * Test of generateChartValues method, of class CreateChartController.
     */
    @Test
    public void testGenerateChartValues() {
//        System.out.println("generateChartValues");
//        
//        ChartDTO dto = c;
//        
//        SpreadsheetDTO ss = null;
//        
//        CreateChartController instance = new CreateChartController();
//        
//        ChartDTO result = instance.generateChartValues(dto, ss);
//        
//        
//        Assert.assertArrayEquals(result.getContent(), dto.getContent());
    }
    
}
