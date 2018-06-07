package pt.isep.nsheets.server.services;

import com.google.gwt.user.server.rpc.RemoteServiceServlet;
import java.util.logging.Level;
import java.util.logging.Logger;
import pt.isep.nsheets.server.lapr4.red.s1.core.n1160600.workbook.application.SortSpreadsheetController;
import pt.isep.nsheets.shared.core.IllegalValueTypeException;
import pt.isep.nsheets.shared.core.Spreadsheet;
import pt.isep.nsheets.shared.core.formula.compiler.FormulaCompilationException;
import pt.isep.nsheets.shared.lapr4.red.n1160600.services.SpreadsheetService;
import pt.isep.nsheets.shared.lapr4.red.s1.core.n1161292.services.SpreadsheetDTO;

public class SpreadsheetServiceImpl extends RemoteServiceServlet implements SpreadsheetService {

    @Override
    public SpreadsheetDTO sortCells(String stringCell1, String stringCell2, SpreadsheetDTO spreadSheet, boolean ascendant) {
        SortSpreadsheetController s = new SortSpreadsheetController();
            return s.sortCells(stringCell1, stringCell2, spreadSheet, ascendant);
    }
    
}
