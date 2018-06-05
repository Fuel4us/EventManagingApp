/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package pt.isep.nsheets.server.lapr4.red.s1.core.n1160630.chart.application;

import pt.isep.nsheets.server.lapr4.red.s1.core.n1160630.chart.domain.Chart;

/**
 * List Charts Controller.
 * @author pedromonteiro
 */
public class ListChartsController {
    
    /**
     * Returns all Charts in the persistence
     *
     * @return all charts
     */
    public Iterable<Chart> listAllCharts() {
        return new ChartService().allCharts();
    }
}
