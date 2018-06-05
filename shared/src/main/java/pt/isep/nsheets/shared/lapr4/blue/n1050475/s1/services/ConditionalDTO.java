package pt.isep.nsheets.shared.lapr4.blue.n1050475.s1.services;

import pt.isep.nsheets.shared.core.Cell;
import pt.isep.nsheets.shared.core.Value;
import pt.isep.nsheets.shared.ext.extensions.lapr4.red.s1.core.n1160629.Configuration;
import pt.isep.nsheets.shared.lapr4.blue.n1050475.s1.extensions.Conditional;

import java.io.Serializable;

@SuppressWarnings("serial")
public class ConditionalDTO implements Serializable{
    private Cell cell;
    private Configuration configuration;
    private String condOperator;
    private Value condValue;

    public ConditionalDTO(Cell cell, Configuration configuration, String condOperator, Value condValue){
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

    public Conditional fromDTO(){
        return new Conditional(this.cell, this.configuration, this.condOperator, this.condValue);
    }

    public Cell getCell(){ return cell;}

    public Configuration getConfiguration(){ return configuration;}

    public String getCondOperator() {
        return condOperator;
    }

    public Value getCondValue() {
        return condValue;
    }
}