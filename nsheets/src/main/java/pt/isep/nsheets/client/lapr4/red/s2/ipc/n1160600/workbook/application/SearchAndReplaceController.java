package pt.isep.nsheets.client.lapr4.red.s2.ipc.n1160600.workbook.application;

import java.util.ArrayList;
import java.util.List;
import pt.isep.nsheets.server.lapr4.white.s1.core.n4567890.workbooks.application.WorkbookDescriptionService;
import pt.isep.nsheets.shared.core.Cell;
import pt.isep.nsheets.shared.core.Spreadsheet;
import pt.isep.nsheets.shared.core.Workbook;
import pt.isep.nsheets.shared.core.formula.compiler.FormulaCompilationException;

public class SearchAndReplaceController {

    private int index = 0;
    private List<Cell> cellList = new ArrayList<>();
    private Spreadsheet spreadsheet;
    private String expression;
    private Iterable<Workbook> workbookList;
    private WorkbookDescriptionService workbookService;
    

    public SearchAndReplaceController(Spreadsheet spreadsheet) {
     this.spreadsheet = spreadsheet;   
    }
    
    public void searchAll(String expression, String username) {
        int cont=0, numSheets=0;
        workbookList=workbookService.allWorkbooksFromUser(username);
        cellList.clear();
        for(Workbook w: workbookList){
            numSheets=w.getSpreadsheetCount();
            for(Spreadsheet spread: w.getSpreadSheets()){
                for (int c = 0; c < spread.getColumnCount(); c++) {
                    for (int r = 0; r < spread.getRowCount(); r++) {
                        Cell cell = spread.getCell(c, r);
                        if (cell.getContent().contains(expression)) {
                            cellList.add(cell);
                        }
                    }
                }
            }
        }        
        this.expression = expression;
    }

    public void setSpreadsheet(Spreadsheet spreadsheet) {
        this.spreadsheet = spreadsheet;
    }

    public String replacePossibility(String expression, Cell cell) {
        String aux = cell.getContent();
        return aux.replaceFirst(this.expression, expression);
    }

    public String replace(String expression, Cell cell) throws FormulaCompilationException {
        cell.setContent(replacePossibility(expression, cell));
        return getCurrent().getContent();
    }

    public Cell getCurrent() {
        return cellList.get(index);
    }

    public Cell getNext() {
        if (index + 1 < cellList.size()) {
            return cellList.get(++index);
        }
        return null;
    }

    public Cell getPrevious() {
        if (index - 1 >= 0) {
            return cellList.get(--index);
        }
        return null;
    }

    public void replaceAll(String expression) throws FormulaCompilationException {
        for (Cell c : cellList) {
            replace(expression, c);
        }
    }
}
