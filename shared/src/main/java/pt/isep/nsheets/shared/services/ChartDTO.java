/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package pt.isep.nsheets.shared.services;

import java.io.Serializable;
import pt.isep.nsheets.shared.core.Address;

/**
 *
 * @author pedromonteiro
 */
@SuppressWarnings("serial")
public class ChartDTO implements Serializable{
    
//    private  String [] field_names;
    private  String graph_name;
    private  String [][] content;
    private  Address firstAddress;
    private  Address lastAddress;
    private  boolean considerFirstField;
    private  boolean isRow;

    public ChartDTO(/*String[] field_names,*/  String graph_name,Address firstAddress, Address lastAddress, String[][] content, boolean isRow, boolean considerFirstField) {

//        this.field_names = field_names;
        this.graph_name = graph_name;
        this.firstAddress = firstAddress;
        this.lastAddress = lastAddress;
        this.content = content;
        this.isRow = isRow;
        this.considerFirstField = considerFirstField;
    }
    
    
    // It is mandatory to have a default constructor with no arguments to be serializable!
    public ChartDTO(){
//        this.field_names = new String[]{};
        this.graph_name = "";
        this.firstAddress = new Address(-1, -1);
        this.lastAddress = new Address(-1, -1);
        this.content = new String[][]{};
        this.isRow = false;
        this.considerFirstField = false;
    }
    

//    public String[] getField_names() {
//        return field_names;
//    }

    public String getGraph_name() {
        return graph_name;
    }

    public String[][] getContent() {
        return content;
    }

    public boolean isConsiderFirstField() {
        return considerFirstField;
    }

    public boolean isIsRow() {
        return isRow;
    }

    public Address getFirstAddress() {
        return firstAddress;
    }

    public Address getLastAddress() {
        return lastAddress;
    }
    
    
   
    
    
    
    
    
    
    
    
    
}
