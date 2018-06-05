package pt.isep.nsheets.server.services;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.SortedSet;

import pt.isep.nsheets.server.lapr4.green.s1.ipc.n1150503.ExportPDF.ExportPdfController;
import pt.isep.nsheets.server.lapr4.green.s1.ipc.n1160998.ExportCSV.ExportCSVController;
import pt.isep.nsheets.shared.core.Address;
import pt.isep.nsheets.shared.core.Cell;
import pt.isep.nsheets.shared.core.Spreadsheet;
import pt.isep.nsheets.shared.core.Workbook;
import pt.isep.nsheets.shared.lapr4.red.s1.core.n1161292.services.WorkbookDTO;
import pt.isep.nsheets.shared.services.ExportService;

/**
 *
 * @author Carlos Figueiredo (1140317)
 */
public class ExportServiceImp implements ExportService {


    @Override
    public void exportWorkbook(WorkbookDTO workbookDTO, String type) {
        Workbook workbook = Workbook.fromDTO(workbookDTO);

        if(type.equalsIgnoreCase("CSV")) {
            ExportCSVController controller = new ExportCSVController();

            controller.exportWorkbook(workbook);
        }

        if(type.equalsIgnoreCase("PDF")) {
            ExportPdfController controller = new ExportPdfController();
            controller.exportWorkbook(workbook);
        }
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
