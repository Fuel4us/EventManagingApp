package pt.isep.nsheets.shared.lapr4.red.s1.core.n1161292.services;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author Tiago João Santos Rios, 1161292@isep.ipp.pt
 */
@SuppressWarnings("serial")
public class WorkbookDTO implements Serializable {
    
    public String name;
    public String description;
    public List<SpreadsheetDTO> spreadsheets = new ArrayList<>();
    public int createdSpreadsheets;
    
    private WorkbookDTO() {};
    
    public WorkbookDTO(String name, String description, List<SpreadsheetDTO> spreadsheets){
        this.name = name;
        this.description = description;
        this.spreadsheets = spreadsheets;
        this.createdSpreadsheets = spreadsheets.size();
    }
    
    public WorkbookDTO(String name, String description, int createdSpreadsheets){
        this.name = name;
        this.description = description;
        this.createdSpreadsheets = createdSpreadsheets;
    }
}
