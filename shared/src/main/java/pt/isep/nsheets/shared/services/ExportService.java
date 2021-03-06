package pt.isep.nsheets.shared.services;

import com.google.gwt.user.client.rpc.RemoteService;
import com.google.gwt.user.client.rpc.RemoteServiceRelativePath;
import java.io.ByteArrayOutputStream;
import java.util.List;
import pt.isep.nsheets.shared.lapr4.blue.n1050475.s2.services.CellStyleDTO;
import pt.isep.nsheets.shared.lapr4.red.s1.core.n1161292.services.WorkbookDTO;

/**
 *
 * @author Rúben (1160998)
 */
@RemoteServiceRelativePath("ExportService")
public interface ExportService extends RemoteService {

    //void exportWorkbook(WorkbookDTO workbookDTO, String type);
    boolean exportWorkbookAsCSV(WorkbookDTO workbookDTO);

    boolean exportWorkbookAsXML(WorkbookDTO workbookDTO);

    boolean exportWorkbookAsPDF(WorkbookDTO workbookDTO);

    boolean exportWorkbookAsCSL(WorkbookDTO workbookDTO);

    boolean exportStyledWorkbookPDF(List<CellStyleDTO> list, WorkbookDTO workbookDTO, String style, String color, int range);

    boolean exportCompleteWorkbookPDF(List<Object> listOptions, List<CellStyleDTO> list, WorkbookDTO workbookDTO, String style, String color, int range);

//    String[][] exportPartOfSpreadsheet(Spreadsheet spreadsheet, int beginColumn, int beginRow, int endColumn, int endRow);
}
