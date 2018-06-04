package pt.isep.nsheets.shared.services;

import com.google.gwt.user.client.rpc.AsyncCallback;
import pt.isep.nsheets.shared.core.Spreadsheet;
import pt.isep.nsheets.shared.core.Workbook;

import java.util.List;

/**
 *
 * @author Rúben (1160998)
 */
public interface ExportServiceAsync {

    void exportWorkbook(ExportDTO exportDTO, AsyncCallback<ExportDTO> async);

//    void exportSpreadsheet(Spreadsheet spreadsheet);
//
//    void exportPartOfSpreadsheet(Spreadsheet spreadsheet, int beginColumn, int beginRow, int endColumn, int endRow);
}
