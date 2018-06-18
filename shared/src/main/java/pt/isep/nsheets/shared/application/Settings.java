package pt.isep.nsheets.shared.application;

import java.util.ArrayList;
import java.util.List;
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
    private List<Workbook> openWorkbooks = new ArrayList<>();
    
    private Settings(){
        workbook = new Workbook("Title", "Tile", SPREADSHEET_DEFAULT);
    }
    
    public Workbook getWorkbook(){
        return this.workbook;
    }
    
    public void updateWorkbook(WorkbookDTO workbook) {
        this.workbook = Workbook.fromDTO(workbook);
    }
    
    
    public List<Workbook> getOpenedWorkbooks() {
        return this.openWorkbooks;
    }
    
    public void addOpenWorkbook(Workbook workbook) {
        for(Workbook w : this.openWorkbooks) {
            if(w.name().equals(workbook.name()))
                return;
        }
        
        this.openWorkbooks.add(workbook);
    }
    
    public void closeOpenedWorkbook(Workbook workbook) {
        for(int i = 0; i < this.openWorkbooks.size(); i++) {
            if(this.openWorkbooks.get(i).name().equals(workbook.name())) {
                this.openWorkbooks.remove(i);
                return;
            }
        }
    }
}
