package pt.isep.nsheets.shared.services;

import com.google.gwt.user.client.rpc.RemoteService;
import com.google.gwt.user.client.rpc.RemoteServiceRelativePath;
import pt.isep.nsheets.shared.lapr4.red.s1.core.n1161292.services.WorkbookDTO;



/**
 *
 * @author Rúben (1160998)
 */
@RemoteServiceRelativePath("ExportService")
public interface ExportService extends RemoteService {

      void exportWorkbook(WorkbookDTO workbookDTO, String type);
//
//    String[][] exportSpreadsheet(Spreadsheet spreadsheet);
//
//    String[][] exportPartOfSpreadsheet(Spreadsheet spreadsheet, int beginColumn, int beginRow, int endColumn, int endRow);
}
