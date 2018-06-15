package pt.isep.nsheets.shared.lapr4.red.s1.core.n1161292.services;

import com.google.gwt.user.client.rpc.IsSerializable;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author Tiago João Santos Rios, 1161292@isep.ipp.pt
 */
@SuppressWarnings("serial")
public class WorkbookDTO implements IsSerializable {
    
    public String name;
    public String description;
    public List<SpreadsheetDTO> spreadsheets = new ArrayList<>();
    public int createdSpreadsheets;
    public boolean publicState;
    public String userName;
    
    public WorkbookDTO() {};
    
    public WorkbookDTO(String name, String description, List<SpreadsheetDTO> spreadsheets){
        this.name = name;
        this.description = description;
        this.spreadsheets = spreadsheets;
        this.createdSpreadsheets = spreadsheets.size();
    }
    public WorkbookDTO(String name, String description, boolean publicState, List<SpreadsheetDTO> spreadsheets, String userName){
        this.name = name;
        this.description = description;
        this.spreadsheets = spreadsheets;
        this.createdSpreadsheets = spreadsheets.size();
        this.publicState = publicState;
        this.userName = userName;
    }
    
    public WorkbookDTO(String name, String description, int createdSpreadsheets){
        this.name = name;
        this.description = description;
        this.createdSpreadsheets = createdSpreadsheets;
    }
    
    public WorkbookDTO(String name, String description, boolean publicState, int createdSpreadsheets, String userName){
        this.name = name;
        this.description = description;
        this.createdSpreadsheets = createdSpreadsheets;
        this.publicState = publicState;
        this.userName = userName;
    }
}
