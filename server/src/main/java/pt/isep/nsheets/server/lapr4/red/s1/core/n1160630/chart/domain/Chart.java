/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package pt.isep.nsheets.server.lapr4.red.s1.core.n1160630.chart.domain;

import java.io.Serializable;
import pt.isep.nsheets.shared.core.Address;
import pt.isep.nsheets.shared.core.Cell;
import pt.isep.nsheets.shared.core.Spreadsheet;
import pt.isep.nsheets.shared.services.ChartDTO;

/**
 * The Chart Interface.
 * @author pedromonteiro
 */
public interface Chart extends Serializable{
    
    ChartDTO toDTO();
    Cell associatedCell();
    void generateChartValues(Spreadsheet spreadsheet);
    
}
