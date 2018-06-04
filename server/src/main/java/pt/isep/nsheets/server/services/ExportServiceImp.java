package pt.isep.nsheets.server.services;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.SortedSet;
import pt.isep.nsheets.shared.core.Address;
import pt.isep.nsheets.shared.core.Cell;
import pt.isep.nsheets.shared.core.Spreadsheet;
import pt.isep.nsheets.shared.core.Workbook;

/**
 *
 * @author Carlos Figueiredo (1140317)
 */
public class ExportServiceImp {

    public static List<String[][]> exportWorkbook(Workbook workbook) {
        List<String[][]> returnList = new ArrayList<>();
        Iterator<Spreadsheet> spreadsheetIterator = workbook.iterator();

        while (spreadsheetIterator.hasNext()) {
            returnList.add(exportSpreadsheet(spreadsheetIterator.next()));
        }

        return returnList;
    }

    public static String[][] exportSpreadsheet(Spreadsheet spreadsheet) {
        int spreadsheetColumnCount = spreadsheet.getColumnCount();
        int spreadsheetRowCount = spreadsheet.getRowCount();

        String result[][] = new String[spreadsheetRowCount][spreadsheetColumnCount];

        for (int i = 0; i < spreadsheetRowCount; i++) {
            for (int j = 0; j < spreadsheetColumnCount; j++) {
                result[i][j] = exportCell(spreadsheet, i, j);
            }
        }

        return result;
    }

    public static String[][] exportPartOfSpreadsheet(Spreadsheet spreadsheet, int beginColumn, int beginRow, int endColumn, int endRow) {
        Address addBegin = new Address(beginColumn, beginRow);
        Address addEnd = new Address(endColumn, endRow);

        SortedSet<Cell> cells = spreadsheet.getCells(addBegin, addEnd);

        String result[][] = new String[(endRow - beginRow) + 1][(endColumn - beginColumn) + 1];

        for (int i = 0; i < result.length; i++) {
            for (int j = 0; j < result[0].length; j++) {
                result[i][j] = cells.iterator().next().getContent();
            }
        }

        return result;
    }

    public static String exportCell(Spreadsheet spreadsheet, int column, int row) {
        return spreadsheet.getCell(column, row).getContent();
    }
}
