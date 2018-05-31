package pt.isep.nsheets.shared.services;

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
}
