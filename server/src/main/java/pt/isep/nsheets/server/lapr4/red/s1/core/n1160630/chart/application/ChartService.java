/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package pt.isep.nsheets.server.lapr4.red.s1.core.n1160630.chart.application;

import eapli.framework.persistence.DataConcurrencyException;
import eapli.framework.persistence.DataIntegrityViolationException;
import pt.isep.nsheets.server.lapr4.red.s1.core.n1160630.chart.domain.BarChart;
import pt.isep.nsheets.server.lapr4.red.s1.core.n1160630.chart.domain.Chart;
import pt.isep.nsheets.shared.services.ChartType;
import pt.isep.nsheets.server.lapr4.red.s1.core.n1160630.chart.persistence.ChartRepository;
import pt.isep.nsheets.server.lapr4.white.s1.core.n4567890.workbooks.persistence.PersistenceContext;
import pt.isep.nsheets.shared.core.Workbook;
import pt.isep.nsheets.shared.services.ChartDTO;

/**
 * The Chart Service.
 * @author pedromonteiro
 */
public class ChartService{
    
    /**
     * Find all the charts in the persistence
     * @return all charts
     */
    public Iterable<Chart> allCharts() {
        final ChartRepository chartRepo = PersistenceContext.repositories().charts();
        return chartRepo.findAll();
    }
    
    /**
     * Adds a Chart to the persistence
     * @param dto Chart DTO
     * @param type Chart Type
     * @return the added Chart
     * @throws DataConcurrencyException
     * @throws DataIntegrityViolationException
     */
    public Chart addUChart(ChartDTO dto, ChartType type) throws DataConcurrencyException, DataIntegrityViolationException {

        final ChartRepository chartRepo = PersistenceContext.repositories().charts();
        
        Chart chart = null;
        
        switch(type){
            
            case BAR_CHART:
                Workbook wb = new Workbook(dto.getContent());
                chart = new BarChart(dto.getGraph_name(), wb.getSpreadsheet(0), dto.getFirstAddress(), dto.getLastAddress(),dto.isConsiderFirstField(), dto.isIsRow());
                break;
                
        }
        if(chart != null) chartRepo.save(chart);
        return chart;
    }
    
}
