/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package pt.isep.nsheets.server.lapr4.red.s1.core.n1160630.chart.application;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import static org.junit.Assert.*;
import pt.isep.nsheets.server.lapr4.red.s1.core.n1160630.chart.domain.BarChart;
import pt.isep.nsheets.server.lapr4.red.s1.core.n1160630.chart.domain.Chart;
import pt.isep.nsheets.shared.core.Address;
import pt.isep.nsheets.shared.lapr4.red.s1.core.n1161292.services.SpreadsheetDTO;
import pt.isep.nsheets.shared.services.ChartDTO;
import pt.isep.nsheets.shared.services.ChartType;

/**
 *
 * @author pedromonteiro
 */
public class AddChartControllerTest {
    
    ChartDTO c;
    SpreadsheetDTO ssDto = null;
    
    
    @Before
    public void setUp() {
        List<String>  contentList = new ArrayList<>();
        
        String[][] content = new String[][]{
                    {"1", "2", "3"},
                    {"1", "5", "8"},
                    {"7", "6", "3"}};
        
        c = new ChartDTO("Chart Test 7",
                new Address(0, 0),
                new Address(2, 2),
                true,
                true,
                ChartType.BAR_CHART,
                new Address(3, 3),
                content
        );
        
        for(int i = 0; i<content.length;i++){
            contentList.addAll(Arrays.asList(content[i]));
        }
    }
    
    @After
    public void tearDown() {
    }

    /**
     * Test of addChart method, of class AddChartController.
     */
    @Test
    public void testCanAddChart() {
//        System.out.println("Can add Chart");
//        ChartDTO chartDto = c;
//        
//        AddChartController instance = new AddChartController();
//        
//        Chart expResult = new BarChart(chartDto);
//        Chart result = instance.addChart(chartDto);
//        
//        assertEquals(expResult, result);
    }
    
    /**
     * Test of canNOTaddChart method, of class AddChartController.
     */
    @Test
    public void testCanNOTAddChart() {
        System.out.println("Cannot add Chart");
        ChartDTO chartDto = c;
        SpreadsheetDTO ss = null;
        
        AddChartController instance = new AddChartController();
        
        
        instance.addChart(chartDto);
        Chart result = instance.addChart(chartDto);
        
        assertNull(result);
    }
    
}
