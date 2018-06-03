package pt.isep.nsheets.shared.services;

import pt.isep.nsheets.shared.core.Address;
import pt.isep.nsheets.shared.core.Cell;
import pt.isep.nsheets.shared.core.SpreadsheetImpl;
import pt.isep.nsheets.shared.core.formula.compiler.FormulaCompilationException;

import java.util.HashMap;
import java.util.Map;

/**
 *
 * @author TiagoRios(1161292)
 */
@SuppressWarnings("serial")
public class SpreadsheetDTO {
    
	private static final long serialVersionUID = 7010464744129096272L;
	public static final String BASE_TITLE = "Sheet ";
        
	private WorkbookDTO workbook;
	private Map<AddressDTO, CellDTO> cells = new HashMap<>();
	private String title;
	private int columns = 0;
	private int rows = 0;

	public SpreadsheetDTO(WorkbookDTO workbook, String title){
		this.workbook = workbook;
		this.title = title;
	}

	public WorkbookDTO getWorkbook() {
		return workbook;
	}

	public Map<AddressDTO, CellDTO> getCells() {
		return cells;
	}

	public String getTitle() {
		return title;
	}

	public SpreadsheetImpl fromDTO() throws FormulaCompilationException {
		Map<Address, Cell> cells = new HashMap<>();

		for(AddressDTO a : this.cells.keySet())
			cells.put(a.fromDTO(), this.cells.get(a).fromDTO());

		return new SpreadsheetImpl(this.getWorkbook().fromDTO(), this.getTitle(), cells);
	}
}
