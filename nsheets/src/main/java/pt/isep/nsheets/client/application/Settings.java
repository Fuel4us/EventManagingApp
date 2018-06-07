package pt.isep.nsheets.client.application;

import pt.isep.nsheets.shared.core.Workbook;
import pt.isep.nsheets.shared.lapr4.red.s1.core.n1161292.services.WorkbookDTO;

/**
 *
 * @author Tiago João Santos Rios, 1161292@isep.ipp.pt
 */
public class Settings {
    
    public static String[][][] SPREADSHEET_DEFAULT = {{
                {"1", "2", "3", "4", "5", "6", "7"},
                {"a", "b", "c", "d", "e", "f", "g"},
                {"h", "i", "j", "k", "l", "m", "n"},
                {"o", "p", "8", "9", "10", "0", "23"},
                {"44", "67", "89", "q", "r", "s", "t"},
                {"u", "v", "x", "y", "z", "55", "66"},
            }};
    
    private static Settings instance = null;
    
    public static Settings getInstance(){
        if (instance == null){
            instance = new Settings();
        }
        
        return instance;
    }
    
    private Workbook workbook;
    
    private Settings(){
        workbook = new Workbook("Title", "Tile", SPREADSHEET_DEFAULT);
    }
    
    public Workbook getWorkbook(){
        return this.workbook;
    }
    
    public void updateWorkbook(WorkbookDTO workbook) {
        this.workbook = Workbook.fromDTO(workbook);
    }
}
