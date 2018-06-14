package pt.isep.nsheets.client.lapr4.red.s2.ipc.n1160600.workbook.application;

import java.util.ArrayList;
import java.util.List;
import pt.isep.nsheets.shared.core.Cell;
import pt.isep.nsheets.shared.core.Spreadsheet;
import pt.isep.nsheets.shared.core.formula.compiler.FormulaCompilationException;

public class SearchAndReplaceController {

    private int index = 0;
    private List<Cell> cellList = new ArrayList<>();
    private Spreadsheet spreadsheet;
    private String expression;

    public SearchAndReplaceController(Spreadsheet spreadsheet) {
     this.spreadsheet = spreadsheet;   
    }
    
    public void searchAll(String expression) {
        cellList.clear();
        for (int c = 0; c < spreadsheet.getColumnCount(); c++) {
            for (int r = 0; r < spreadsheet.getRowCount(); r++) {
                Cell cell = spreadsheet.getCell(c, r);
                if (cell.getContent().contains(expression)) {
                    cellList.add(cell);
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
