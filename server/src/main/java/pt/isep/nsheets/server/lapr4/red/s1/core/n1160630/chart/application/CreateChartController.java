/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package pt.isep.nsheets.server.lapr4.red.s1.core.n1160630.chart.application;

import com.google.gwt.user.client.Window;
import eapli.framework.application.Controller;
import pt.isep.nsheets.server.lapr4.red.s1.core.n1160630.chart.domain.BarChart;
import pt.isep.nsheets.server.lapr4.red.s1.core.n1160630.chart.domain.Chart;
import pt.isep.nsheets.shared.core.Spreadsheet;
import pt.isep.nsheets.shared.services.ChartDTO;

/**
 * The create chart controller.
 * @author pedromonteiro
 */
public class CreateChartController implements Controller{
    
    /**
     * Creates a new chart based on the following parameters:
     * @param dto
     * @param spreadsheet
     * @return the created chart
     */
    public Chart newChart(ChartDTO dto/*, Spreadsheet spreadsheet*/){
        
        Chart chart = null;
        
        switch(dto.getType()){
            case BAR_CHART:
                chart = new BarChart(dto.getGraph_name(), dto.getFirstAddress(), dto.getLastAddress(),dto.isConsiderFirstField(), dto.isRow(), dto.getAssociatedCell());
        }
        return chart;
    }
    
    public String[][] generateChartValues(ChartDTO dto/*, Spreadsheet ss*/){
        Window.alert("generateChartValues");
        Chart c = newChart(dto);
        c.generateChartValues(null);
        return c.toDTO().getContent();
    }
    
}
