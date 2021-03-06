package pt.isep.nsheets.server.services;

import com.google.gwt.user.server.rpc.RemoteServiceServlet;
import java.util.List;
import pt.isep.nsheets.server.lapr4.blue.n1150372.s3.application.CompletePDFController;
import pt.isep.nsheets.server.lapr4.green.s1.ipc.n1140317.ExportXML.application.ExportXMLController;

import pt.isep.nsheets.server.lapr4.green.s1.ipc.n1150503.ExportPDF.ExportPdfController;
import pt.isep.nsheets.server.lapr4.green.s1.ipc.n1160998.ExportCSV.ExportCSVController;
import pt.isep.nsheets.server.lapr4.red.s1.core.n1160629.export.application.ExportCSLController;
import pt.isep.nsheets.server.lapr4.red.s2.ipc.n1160630.PDFStyleExport.application.ExportStyledPDFController;
import pt.isep.nsheets.shared.core.Workbook;
import pt.isep.nsheets.shared.lapr4.blue.n1050475.s2.services.CellStyleDTO;
import pt.isep.nsheets.shared.lapr4.red.s1.core.n1161292.services.WorkbookDTO;
import pt.isep.nsheets.shared.services.ExportService;

/**
 * @author Carlos Figueiredo (1140317)
 */
public class ExportServiceImpl extends RemoteServiceServlet implements ExportService {

    @Override
    public boolean exportWorkbookAsCSV(WorkbookDTO workbookDTO) {
        ExportCSVController csvController = new ExportCSVController();
        Workbook workbook = Workbook.fromDTO(workbookDTO);
        return csvController.exportWorkbook(workbook);
    }

    @Override
    public boolean exportWorkbookAsXML(WorkbookDTO workbookDTO) {
        ExportXMLController ctrl = new ExportXMLController();
        Workbook workbook = Workbook.fromDTO(workbookDTO);
        return ctrl.exportWorkbook(workbook);
    }

    @Override
    public boolean exportWorkbookAsPDF(WorkbookDTO workbookDTO) {
        ExportPdfController pdfController = new ExportPdfController();
        Workbook workbook = Workbook.fromDTO(workbookDTO);
        return pdfController.exportWorkbook(workbook);
    }

    @Override
    public boolean exportWorkbookAsCSL(WorkbookDTO workbookDTO) {
        ExportCSLController ctrl = new ExportCSLController();
        Workbook workbook = Workbook.fromDTO(workbookDTO);
        return ctrl.exportWorkbook(workbook);
    }

    @Override
    public boolean exportStyledWorkbookPDF(List<CellStyleDTO> list, WorkbookDTO workbookDTO, String style,String color, int range) {
        return new ExportStyledPDFController().buildPDF(list, workbookDTO, style,color, range);
    }
    
    @Override
    public boolean exportCompleteWorkbookPDF(List<Object> listOptions, List<CellStyleDTO> list, WorkbookDTO workbookDTO, String style,String color, int range) {
        return new CompletePDFController().buildPDF(listOptions, list, workbookDTO, style,color, range);
    }
    
    


}
