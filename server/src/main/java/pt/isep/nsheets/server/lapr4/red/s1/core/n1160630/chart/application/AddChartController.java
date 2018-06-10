/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package pt.isep.nsheets.server.lapr4.red.s1.core.n1160630.chart.application;

import eapli.framework.application.Controller;
import eapli.framework.persistence.DataConcurrencyException;
import eapli.framework.persistence.DataIntegrityViolationException;
import java.util.logging.Level;
import java.util.logging.Logger;
import pt.isep.nsheets.server.lapr4.red.s1.core.n1160630.chart.domain.Chart;
import pt.isep.nsheets.shared.services.ChartDTO;

/**
 * The Add Chart Controller
 *
 * @author pedromonteiro
 */
public class AddChartController implements Controller {

    /**
     * Add a chart to the persistence
     *
     * @param chartDto Chart DTO
     * @return the added Chart
     */
    public Chart addChart(ChartDTO chartDto){

        Chart c = null;
        try {
            c =  new ChartService().addUChart(chartDto);
        } catch (DataConcurrencyException | DataIntegrityViolationException ex) {
            Logger.getLogger(AddChartController.class.getName()).log(Level.SEVERE, null, ex);
        }
        
        return c;
    }
    
    

}
