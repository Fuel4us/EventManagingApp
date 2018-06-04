package pt.isep.nsheets.shared.services;

import com.google.gwt.user.client.rpc.RemoteService;
import com.google.gwt.user.client.rpc.RemoteServiceRelativePath;
import pt.isep.nsheets.shared.core.Spreadsheet;
import pt.isep.nsheets.shared.core.Workbook;

import java.util.List;

/**
 *
 * @author Rúben (1160998)
 */
@RemoteServiceRelativePath("ExportService")
public interface ExportService extends RemoteService {
    void exportWorkbook(ExportDTO exportDTO);
//
//    String[][] exportSpreadsheet(Spreadsheet spreadsheet);
//
//    String[][] exportPartOfSpreadsheet(Spreadsheet spreadsheet, int beginColumn, int beginRow, int endColumn, int endRow);
}
