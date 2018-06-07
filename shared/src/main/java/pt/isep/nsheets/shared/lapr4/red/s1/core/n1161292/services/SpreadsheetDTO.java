package pt.isep.nsheets.shared.lapr4.red.s1.core.n1161292.services;

import java.io.Serializable;
import java.util.Map;

/**
 *
 * @author Tiago João Santos Rios, 1161292@isep.ipp.pt
 */
@SuppressWarnings("serial")
public class SpreadsheetDTO implements Serializable {
        
    public Map<AddressDTO, CellDTO> cells;
    public String title;
    public int columns;
    public int rows;
    
    protected SpreadsheetDTO() {}
    
    public SpreadsheetDTO(Map<AddressDTO, CellDTO> cells, String title, int columns, int rows){
        this.cells = cells;
        this.title = title;
        this.columns = columns;
        this.rows = rows;
    }
    
    public CellDTO getCell(int row, int column) {
        for (AddressDTO add : cells.keySet()) {
            if (add.column == column && add.row == row) {
                return cells.get(add);
            }
        }

        return null;
    }
}
