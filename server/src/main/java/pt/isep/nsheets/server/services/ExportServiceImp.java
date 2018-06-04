package pt.isep.nsheets.server.services;

import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

import pt.isep.nsheets.server.lapr4.green.s1.ipc.n1140317.ExportXML.application.ExportXMLController;
import pt.isep.nsheets.shared.core.Spreadsheet;
import pt.isep.nsheets.shared.core.Workbook;
import pt.isep.nsheets.shared.services.ExportDTO;
import pt.isep.nsheets.shared.services.ExportService;

/**
 *
 * @author Carlos Figueiredo (1140317)
 */
public class ExportServiceImp implements ExportService {
    ExportXMLController controller = new ExportXMLController();

    @Override
    public void exportWorkbook(ExportDTO exportDTO) {
        Workbook workbook = exportDTO.getWorkbook();
        List<String[][]> returnList = new ArrayList<>();
        Iterator<Spreadsheet> spreadsheetIterator = workbook.iterator();

        while (spreadsheetIterator.hasNext()) {
            returnList.add(exportSpreadsheet(spreadsheetIterator.next()));
        }

        try{
            controller.exportWorkbook(workbook.name(), workbook.description(), returnList);
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public String[][] exportSpreadsheet(Spreadsheet spreadsheet) {
        int spreadsheetColumnCount = spreadsheet.getColumnCount();
        int spreadsheetRowCount = spreadsheet.getRowCount();

        String result[][] = new String[spreadsheetRowCount][spreadsheetColumnCount];

        for (int i = 0; i < spreadsheetRowCount; i++) {
            for (int j = 0; j < spreadsheetColumnCount; j++) {
                result[i][j] = spreadsheet.getCell(i, j).getContent();
            }
        }

        return result;
    }

//    @Override
//    public String[][] exportPartOfSpreadsheet(Spreadsheet spreadsheet, int beginColumn, int beginRow, int endColumn, int endRow) {
//        Address addBegin = new Address(beginColumn, beginRow);
//        Address addEnd = new Address(endColumn, endRow);
//
//        SortedSet<Cell> cells = spreadsheet.getCells(addBegin, addEnd);
//
//        String result[][] = new String[(endRow - beginRow) + 1][(endColumn - beginColumn) + 1];
//
//        for (int i = 0; i < result.length; i++) {
//            for (int j = 0; j < result[0].length; j++) {
//                result[i][j] = cells.iterator().next().getContent();
//            }
//        }
//
//        return result;
//    }
}
