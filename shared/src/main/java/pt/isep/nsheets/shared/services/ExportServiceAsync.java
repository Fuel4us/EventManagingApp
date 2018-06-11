package pt.isep.nsheets.shared.services;

import com.google.gwt.user.client.rpc.AsyncCallback;
import com.itextpdf.text.BaseColor;
import java.io.ByteArrayOutputStream;
import pt.isep.nsheets.shared.lapr4.red.s1.core.n1161292.services.WorkbookDTO;
import pt.isep.nsheets.shared.lapr4.red.s2.ipc.n1160630.services.CellStyleLine;

/**
 *
 * @author Rúben (1160998)
 */
public interface ExportServiceAsync {

    void exportWorkbookAsCSV(WorkbookDTO workbookDTO, AsyncCallback<Boolean> async);

    void exportWorkbookAsXML(WorkbookDTO workbookDTO, AsyncCallback<Boolean> async);

    void exportWorkbookAsPDF(WorkbookDTO workbookDTO, AsyncCallback<Boolean> async);

    void exportWorkbookAsCSL(WorkbookDTO workbookDTO, AsyncCallback<Boolean> async);
    
    void exportStyledWorkbookPDF(WorkbookDTO workbookDTO,String style,String color, int range, AsyncCallback<Boolean> async);

//    void exportPartOfSpreadsheet(Spreadsheet spreadsheet, int beginColumn, int beginRow, int endColumn, int endRow);
}
