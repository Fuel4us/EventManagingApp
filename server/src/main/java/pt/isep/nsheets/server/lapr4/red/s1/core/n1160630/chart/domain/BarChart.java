/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package pt.isep.nsheets.server.lapr4.red.s1.core.n1160630.chart.domain;

import eapli.framework.domain.AggregateRoot;
import java.io.Serializable;
import java.util.Objects;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import pt.isep.nsheets.shared.core.Address;
import pt.isep.nsheets.shared.core.Cell;
import pt.isep.nsheets.shared.core.Spreadsheet;
import pt.isep.nsheets.shared.core.Workbook;
import pt.isep.nsheets.shared.services.ChartDTO;

/**
 *
 * @author pedromonteiro
 */
@SuppressWarnings("serial")
@Entity
public class BarChart implements AggregateRoot<Long>, Serializable, Chart{

//    private String [] field_names;
    private String graph_name;
    private String [][] content;
    private Address firstCell;
    private Address lastCell;
    private boolean considerFirstField;
    private boolean isRow;
    private static String BAR_CHART_NAME = "Bar Chart";
    
    @Id
    @GeneratedValue
    private Long id;

    protected BarChart() {
        //FOR ORM
    }
    
    public BarChart(Spreadsheet sh, Address firstAddress, Address lastAddress, boolean considerFirstField, boolean isRow) {
        this.graph_name = BAR_CHART_NAME;
        firstCell = firstAddress;
        lastCell = lastAddress;
        generateChart(sh, considerFirstField, isRow);
        
    }
    
    
    public BarChart(String graph_name,Spreadsheet sh, Address firstAddress, Address lastAddress,boolean considerFirstField, boolean isRow ) {
       this(sh, firstAddress, lastAddress,considerFirstField, isRow);
       this.graph_name = graph_name;
    }

    @Override
    public void generateChart(Spreadsheet sh, boolean considerFirstField, boolean isRow) {
       
       this.considerFirstField = considerFirstField;
       this.isRow = isRow;
       
       
       int endCol = lastCell.getColumn()+1;
       int startCol = firstCell.getColumn();
       int endRow = lastCell.getRow()+1;
       int startRow = firstCell.getRow(); 
       
       
       Cell[] cells = (Cell[])sh.getCells(firstCell, lastCell).toArray();
       
       
       if(isRow){
           if(considerFirstField){
//               field_names = buildRowFieldsName(cells, firstCell, lastCell);
               startRow++;
           }
       }else{
           if(considerFirstField){
//               field_names = buildColFieldsName(cells, firstCell, lastCell);
               startCol++;
           }
       }
       
       String values[][] = new String[endCol-startCol][endRow-startRow];
       int k = 0;
       for(int i = startCol; i< endCol; i++){
           for(int j = startRow; j<endRow; j++){
               values[i-startCol][j-startRow] = cells[k].getContent();
               k++;
           }
       }
        
       content = values;
    }
    @Override
    public ChartDTO toDTO(){
        return new ChartDTO(/*field_names,*/ graph_name,firstCell, lastCell, content, isRow, considerFirstField);
    }

    @Override
    public Chart newInstanceFromDTO(ChartDTO dto) throws IllegalArgumentException {
        
        //FIX ME 
        Workbook wb = new Workbook(dto.getContent());
        Chart chart = new  BarChart(dto.getGraph_name(),
                wb.getSpreadsheet(0),
                dto.getFirstAddress(),
                dto.getLastAddress(),
                dto.isConsiderFirstField(),
                dto.isIsRow());
        return chart;
    }


    @Override
    public boolean sameAs(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null) {
            return false;
        }
        if (getClass() != obj.getClass()) {
            return false;
        }
        final BarChart other = (BarChart) obj;
        if (this.considerFirstField != other.considerFirstField) {
            return false;
        }
        if (this.isRow != other.isRow) {
            return false;
        }
        if (!Objects.equals(this.firstCell, other.firstCell)) {
            return false;
        }
        return Objects.equals(this.lastCell, other.lastCell);
    }

    @Override
    public boolean is(Long id) {
        return (this.id.compareTo(id) == 0);
    }

    @Override
    public Long id() {
        return this.id;
    }


    
    
    
    
    
    
    
}
