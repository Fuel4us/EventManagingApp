package pt.isep.nsheets.shared.services;

import pt.isep.nsheets.shared.core.Spreadsheet;
import pt.isep.nsheets.shared.core.Workbook;
import pt.isep.nsheets.shared.core.formula.compiler.FormulaCompilationException;

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

    public WorkbookDTO(List<SpreadsheetDTO> spreadsheets, int createdSpreadsheets){
        this.spreadsheets = spreadsheets;
        this.createdSpreadsheets = createdSpreadsheets;
    }

    public List<SpreadsheetDTO> getSpreadsheets() {
        return spreadsheets;
    }

    public int getCreatedSpreadsheets() {
        return createdSpreadsheets;
    }

    public Workbook fromDTO() throws IllegalArgumentException, FormulaCompilationException {
        List<Spreadsheet> spreadsheet = new ArrayList<>();
        for (SpreadsheetDTO ss : this.getSpreadsheets())
            spreadsheet.add(ss.fromDTO());
        return new Workbook(spreadsheet);
    }
}
