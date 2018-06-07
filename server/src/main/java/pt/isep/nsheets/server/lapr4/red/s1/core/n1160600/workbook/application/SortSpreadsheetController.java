package pt.isep.nsheets.server.lapr4.red.s1.core.n1160600.workbook.application;

import eapli.framework.application.Controller;
import pt.isep.nsheets.shared.core.Address;
import pt.isep.nsheets.shared.core.IllegalValueTypeException;
import pt.isep.nsheets.shared.core.Spreadsheet;
import pt.isep.nsheets.shared.core.formula.compiler.FormulaCompilationException;
import pt.isep.nsheets.shared.lapr4.red.s1.core.n1161292.services.SpreadsheetDTO;

public class SortSpreadsheetController implements Controller{
    public void sortCells(String stringCell1, String stringCell2, Spreadsheet spreadSheet, boolean ascendant) throws IllegalValueTypeException, FormulaCompilationException {
        SortSpreadsheetService s = new SortSpreadsheetService();
        s.sortCells(stringCell1, stringCell2, spreadSheet, ascendant);
    }
}
