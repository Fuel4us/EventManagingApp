package pt.isep.nsheets.shared.lapr4.red.s1.core.n1161292.settings;

import pt.isep.nsheets.shared.core.Workbook;
import pt.isep.nsheets.shared.lapr4.red.s1.core.n1161292.services.WorkbookDTO;

/**
 *
 * @author Tiago João Santos Rios, 1161292@isep.ipp.pt
 */
public class Settings {
    
    public static String[][][] SPREADSHEET_DEFAULT = {{
                {"\u200B", "\u200B", "\u200B", "\u200B", "\u200B", "\u200B", "\u200B"},
                {"\u200B", "\u200B", "\u200B", "\u200B", "\u200B", "\u200B", "\u200B"},
                {"\u200B", "\u200B", "\u200B", "\u200B", "\u200B", "\u200B", "\u200B"},
                {"\u200B", "\u200B", "\u200B", "\u200B", "\u200B", "\u200B", "\u200B"},
                {"\u200B", "\u200B", "\u200B", "\u200B", "\u200B", "\u200B", "\u200B"},
                {"\u200B", "\u200B", "\u200B", "\u200B", "\u200B", "\u200B", "\u200B"},
            }};
    
    private static Settings instance = null;
    
    public static Settings getInstance(){
        if (instance == null){
            return new Settings();
        }
        
        return instance;
    }
    
    private Workbook workbook;
    
    private Settings(){}
    
    public Workbook getWorkbook(){
        return this.workbook;
    }
    
    public void updateWorkbook(WorkbookDTO workbook) {
        this.workbook = Workbook.fromDTO(workbook);
    }
}
