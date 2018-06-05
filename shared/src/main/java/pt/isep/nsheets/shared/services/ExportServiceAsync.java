package pt.isep.nsheets.shared.services;

import com.google.gwt.user.client.rpc.AsyncCallback;
import pt.isep.nsheets.shared.core.Spreadsheet;
import pt.isep.nsheets.shared.core.Workbook;
import pt.isep.nsheets.shared.lapr4.red.s1.core.n1161292.services.WorkbookDTO;

import java.util.List;

/**
 *
 * @author Rúben (1160998)
 */
public interface ExportServiceAsync {

    void exportWorkbook(WorkbookDTO workbookDTO,String type, AsyncCallback<WorkbookDTO> async);

//    void exportSpreadsheet(Spreadsheet spreadsheet);
//
//    void exportPartOfSpreadsheet(Spreadsheet spreadsheet, int beginColumn, int beginRow, int endColumn, int endRow);
}
