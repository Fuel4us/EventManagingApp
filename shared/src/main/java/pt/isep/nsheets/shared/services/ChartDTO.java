/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package pt.isep.nsheets.shared.services;

import java.io.Serializable;
import pt.isep.nsheets.shared.core.Address;

/**
 * A DTO for the Chart
 * @author pedromonteiro
 */
@SuppressWarnings("serial")
public class ChartDTO implements Serializable{
    
    private String graph_name;
    private Address firstAddress;
    private Address lastAddress;
    private ChartType type;
    private Address associatedCell;
    private boolean considerFirstField;
    private String[][] content;
    private boolean isRow;

    /**
     * Constrcutor with parameters: 
     * @param graph_name Graph name
     * @param firstAddress First address
     * @param lastAddress Last Address
     * @param spreadsheet SpreadSheet
     * @param isRow show row
     * @param considerFirstField consider first field as content cells.
     * @param type
     * @param content
     * @param associatedCell
     */
    public ChartDTO(String graph_name,
            Address firstAddress,
            Address lastAddress,
            /*Spreadsheet spreadsheet, */
            boolean isRow, 
            boolean considerFirstField, 
            ChartType type,
            Address associatedCell,
            String[][] content) {
        
        this.graph_name = graph_name;
        this.firstAddress = firstAddress;
        this.lastAddress = lastAddress;
        this.isRow = isRow;
        this.considerFirstField = considerFirstField;
        this.type = type;
        this.associatedCell = associatedCell;
        this.content = content;
        
    }
    
    

    /**
     * Empty constructor - It is mandatory to have a default constructor with no arguments to be serializable!.
     */
    public ChartDTO(){
        this.graph_name = "";
        this.firstAddress = new Address(-1, -1);
        this.lastAddress = new Address(-1, -1);
        this.content = new String[][]{};
        this.isRow = false;
        this.considerFirstField = false;
        this.type = null;
        this.associatedCell = null;
    }
    
    /**
     * Returns graph name
     * @return graph name
     */
    public String getGraph_name() {
        return graph_name;
    }


    /**
     * Returns if the first field shows be parte of the content
     * @return is consider first field
     */
    public boolean isConsiderFirstField() {
        return considerFirstField;
    }

    /**
     * Returns if it is ordered the row or column
     * @return is row
     */
    public boolean isRow() {
        return isRow;
    }

    /**
     * Returns the first cell address
     * @return first address
     */
    public Address getFirstAddress() {
        return firstAddress;
    }

    /**
     * Returns the last cell address
     * @return last address
     */
    public Address getLastAddress() {
        return lastAddress;
    }


    public ChartType getType() {
        return type;
    }

    public Address getAssociatedCell() {
        return associatedCell;
    }

    public String[][] getContent() {
        return content;
    }

    
}
