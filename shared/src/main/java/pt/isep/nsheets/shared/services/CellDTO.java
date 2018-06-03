package pt.isep.nsheets.shared.services;

import pt.isep.nsheets.shared.core.CellImpl;
import pt.isep.nsheets.shared.core.formula.compiler.FormulaCompilationException;

/**
 *
 * @author TiagoRios(1161292)
 */
@SuppressWarnings("serial")
public class CellDTO {
    
	private SpreadsheetDTO spreadsheet;
	private AddressDTO address;
	private String content = "";
        
    public CellDTO(SpreadsheetDTO spreadsheet, AddressDTO address){
        this.spreadsheet = spreadsheet;
        this.address = address;
    }

    public CellImpl fromDTO() throws FormulaCompilationException {
        return new CellImpl(this.spreadsheet.fromDTO(), this.address.fromDTO(), this.content);
    }
}
