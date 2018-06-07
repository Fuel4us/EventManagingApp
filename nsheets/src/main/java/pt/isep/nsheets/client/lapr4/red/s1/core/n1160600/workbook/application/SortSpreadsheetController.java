package pt.isep.nsheets.client.lapr4.red.s1.core.n1160600.workbook.application;

import pt.isep.nsheets.shared.core.IllegalValueTypeException;
import pt.isep.nsheets.shared.core.Spreadsheet;
import pt.isep.nsheets.shared.core.formula.compiler.FormulaCompilationException;

public class SortSpreadsheetController {
    public void sortCells(String stringCell1, String stringCell2, Spreadsheet spreadSheet, boolean ascendant) throws IllegalValueTypeException, FormulaCompilationException {
        SortSpreadsheetService s = new SortSpreadsheetService();
        s.sortCells(stringCell1, stringCell2, spreadSheet, ascendant);
    }
}
