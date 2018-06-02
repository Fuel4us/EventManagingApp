package pt.isep.nsheets.shared.lapr4.red.s1.core.n1161292.settings;

import pt.isep.nsheets.shared.core.Workbook;

/**
 *
 * @author Tiago João Santos Rios, 1161292@isep.ipp.pt
 */
public class Settings {
    
    private static String[][][] SPREADSHEET_DEFAULT = {{
            {"10", "9", "8", "7", "a", "b", "c"}, {"8", "=1+7", "6", "5", "4", "3", "2"},
            {"1", "2", "3", "4", "5", "6", "7"},}};
    
    private static Workbook WORKBOOK_BEING_USED = null;
    
    public static Workbook getInstance(){
        if (WORKBOOK_BEING_USED == null){
            return new Settings().WORKBOOK_BEING_USED;
        }
        
        return WORKBOOK_BEING_USED;
    }
    
    private Settings(){
        WORKBOOK_BEING_USED = new Workbook(SPREADSHEET_DEFAULT);
    }
}
