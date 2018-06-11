package pt.isep.nsheets.shared.lapr4.blue.n1050475.s1.services;

import pt.isep.nsheets.shared.core.Cell;
import pt.isep.nsheets.shared.core.CellImpl;
import pt.isep.nsheets.shared.core.Value;
import pt.isep.nsheets.shared.ext.extensions.lapr4.red.s1.core.n1160629.Configuration;
import pt.isep.nsheets.shared.lapr4.blue.n1050475.s1.extensions.Conditional;
import pt.isep.nsheets.shared.lapr4.red.s1.core.n1161292.services.CellDTO;
import pt.isep.nsheets.shared.services.CellDTOAux;

import java.io.Serializable;

@SuppressWarnings("serial")
public class ConditionalDTO implements Serializable{
    public CellDTO cell;
    public Configuration configuration;
    public String condOperator;
    public Value condValue;

    public ConditionalDTO(CellDTO cell, Configuration configuration, String condOperator, Value condValue){
        this.cell = cell;
        this.configuration = configuration;
        this.condOperator = condOperator;
        this.condValue = condValue;
    }

    /**
     * It is mandatory to have a default constructor with no arguments to be
     * serializable!
     */
    public ConditionalDTO() {
    }

    public CellDTO getCell(){ return cell;}

    public Configuration getConfiguration(){ return configuration;}

    public String getCondOperator() {
        return condOperator;
    }

    public Value getCondValue() {
        return condValue;
    }
}