package pt.isep.nsheets.shared.services;

import com.google.gwt.user.client.rpc.AsyncCallback;
import pt.isep.nsheets.shared.lapr4.red.s1.core.n1161292.services.WorkbookDTO;

/**
 *
 * @author Rúben (1160998)
 */
public interface ExportServiceAsync {

    void exportWorkbookAsCSV(WorkbookDTO workbookDTO, AsyncCallback<Boolean> async);

    void exportWorkbookAsXML(WorkbookDTO workbookDTO, AsyncCallback<Boolean> async);

    void exportWorkbookAsPDF(WorkbookDTO workbookDTO, AsyncCallback<Boolean> async);

    void exportWorkbookAsCSL(WorkbookDTO workbookDTO, AsyncCallback<Boolean> async);

//    void exportPartOfSpreadsheet(Spreadsheet spreadsheet, int beginColumn, int beginRow, int endColumn, int endRow);
}
