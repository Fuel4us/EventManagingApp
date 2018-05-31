package pt.isep.nsheets.shared.services;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author TiagoRios(1161292)
 */
@SuppressWarnings("serial")
public class WorkbookDTO implements Serializable {
    
	private List<SpreadsheetDTO> spreadsheets;
	private int createdSpreadsheets;
        
        public WorkbookDTO(){
            this.spreadsheets = new ArrayList<>();
            this.createdSpreadsheets = 0;
        }
}
