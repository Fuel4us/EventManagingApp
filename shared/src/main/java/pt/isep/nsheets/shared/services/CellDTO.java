package pt.isep.nsheets.shared.services;

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
}
