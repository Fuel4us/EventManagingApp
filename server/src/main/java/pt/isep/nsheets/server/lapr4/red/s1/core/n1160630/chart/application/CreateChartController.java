/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package pt.isep.nsheets.server.lapr4.red.s1.core.n1160630.chart.application;

import eapli.framework.application.Controller;
import pt.isep.nsheets.server.lapr4.red.s1.core.n1160630.chart.domain.BarChart;
import pt.isep.nsheets.server.lapr4.red.s1.core.n1160630.chart.domain.Chart;
import pt.isep.nsheets.shared.services.ChartType;
import pt.isep.nsheets.shared.core.Address;
import pt.isep.nsheets.shared.core.Spreadsheet;

/**
 * The create chart controller.
 * @author pedromonteiro
 */
public class CreateChartController implements Controller{
    
    /**
     * Creates a new chart based on the following parameters:
     * @param graph_name Graph name
     * @param ss SpreadSheet
     * @param firstAddress First Cell Address
     * @param lastAddress Last Cell Address
     * @param isRow if is about row
     * @param considerFirstField if consider first field
     * @param type chart Type
     * @return the created chart
     */
    public Chart newChart(String graph_name, Spreadsheet ss,String firstAddress, String lastAddress, boolean isRow, boolean considerFirstField, ChartType type){
        
        Chart chart = null;
        
        switch(type){
            case BAR_CHART:
                chart = new BarChart(graph_name, ss, new Address(firstAddress), new Address(lastAddress),considerFirstField, isRow);
        }
        return chart;
    }
    
}
