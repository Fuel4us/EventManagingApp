package pt.isep.nsheets.client.lapr4.red.s2.ipc.n1160600.workbook.application;

import java.util.ArrayList;
import java.util.List;

import com.google.gwt.core.client.GWT;
import com.google.gwt.user.client.rpc.AsyncCallback;
import gwt.material.design.client.ui.MaterialToast;
import pt.isep.nsheets.shared.core.Cell;
import pt.isep.nsheets.shared.core.Spreadsheet;
import pt.isep.nsheets.shared.core.Workbook;
import pt.isep.nsheets.shared.core.formula.compiler.FormulaCompilationException;
import pt.isep.nsheets.shared.lapr4.red.s1.core.n1161292.services.CellDTO;
import pt.isep.nsheets.shared.lapr4.red.s1.core.n1161292.services.SpreadsheetDTO;
import pt.isep.nsheets.shared.lapr4.red.s1.core.n1161292.services.WorkbookDTO;
import pt.isep.nsheets.shared.services.WorkbookDescriptionDTO;
import pt.isep.nsheets.shared.services.WorkbooksService;
import pt.isep.nsheets.shared.services.WorkbooksServiceAsync;

public class SearchAndReplaceController {

    private int index = 0;
    private List<Cell> cellList = new ArrayList<>();
    private Spreadsheet spreadsheet;
    private String expression;

    

    public SearchAndReplaceController(Spreadsheet spreadsheet) {
     this.spreadsheet = spreadsheet;   
    }

    public void searchAll(String expression, String userNickname) {
        List<CellDTO> cellListDTO= new ArrayList<>();
        cellList.clear();
        ArrayList<WorkbookDTO> workbooksList = new ArrayList<WorkbookDTO>();

        WorkbooksServiceAsync workbookServiceAsync = GWT.create(WorkbooksService.class);
        AsyncCallback<ArrayList<WorkbookDTO>> callback = new AsyncCallback<ArrayList<WorkbookDTO>>() {
            @Override
            public void onFailure(Throwable caught) {
                MaterialToast.fireToast("Error getting users! " + caught.getMessage());
            }

            @Override
            public void onSuccess(ArrayList<WorkbookDTO> result) {
                for (WorkbookDTO w : result) {
                    workbooksList.add(w);
                }
                int numWorkbooks=0, numSheets=0;
                numWorkbooks=workbooksList.size();
                cellListDTO.clear();
                for(WorkbookDTO w: workbooksList){
                    numSheets=w.spreadsheets.size();
                    for(SpreadsheetDTO spread:w.spreadsheets){
                        for (int c = 0; c < spread.columns; c++) {
                            for (int r = 0; r < spread.rows; r++) {
                                CellDTO cell = spread.getCell(r, c);
                                if (cell.content.contains(expression)) {
                                    Cell finalCell = (Cell) cell;
                                    cellList.add(finalCell);
                                }
                            }
                        }
                    }
                } 
                
            }
        };

        workbookServiceAsync.listWorkbooksPerUser(userNickname, callback);
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
