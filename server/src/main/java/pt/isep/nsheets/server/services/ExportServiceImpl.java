package pt.isep.nsheets.server.services;

import java.io.IOException;
import java.util.logging.Level;
import java.util.logging.Logger;

import com.google.gwt.user.server.rpc.RemoteServiceServlet;
import pt.isep.nsheets.server.lapr4.green.s1.ipc.n1140317.ExportXML.application.ExportXMLController;
//import pt.isep.nsheets.server.lapr4.green.s1.ipc.n1140317.ExportXML.application.ExportXMLController;

import pt.isep.nsheets.server.lapr4.green.s1.ipc.n1150503.ExportPDF.ExportPdfController;
import pt.isep.nsheets.server.lapr4.green.s1.ipc.n1160998.ExportCSV.ExportCSVController;
import pt.isep.nsheets.shared.core.Workbook;
import pt.isep.nsheets.shared.lapr4.red.s1.core.n1161292.services.WorkbookDTO;
import pt.isep.nsheets.shared.services.ExportService;

/**
 *
 * @author Carlos Figueiredo (1140317)
 */
public class ExportServiceImpl extends RemoteServiceServlet implements ExportService {

   @Override
   public WorkbookDTO exportWorkbook(WorkbookDTO workbookDTO, String type){

       ExportXMLController ctrl = new ExportXMLController();
       ExportCSVController csvController = new ExportCSVController();
       ExportPdfController pdfController = new ExportPdfController();

       Workbook workbook = Workbook.fromDTO(workbookDTO);

       if (type.equalsIgnoreCase("CSV")) {
           csvController.exportWorkbook(workbook);
       }

       if(type.equalsIgnoreCase("XML")) {
           ctrl.exportWorkbook(workbook);
       }

       if(type.equalsIgnoreCase("PDF")) {
           pdfController.exportWorkbook(workbook);
       }

       return workbookDTO;
   
    }

}
