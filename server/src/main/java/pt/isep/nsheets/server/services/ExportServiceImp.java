package pt.isep.nsheets.server.services;

import java.io.IOException;
import java.util.logging.Level;
import java.util.logging.Logger;
import pt.isep.nsheets.server.lapr4.green.s1.ipc.n1140317.ExportXML.application.ExportXMLController;

import pt.isep.nsheets.shared.core.Workbook;
import pt.isep.nsheets.shared.lapr4.red.s1.core.n1161292.services.WorkbookDTO;
import pt.isep.nsheets.shared.services.ExportService;

/**
 *
 * @author Carlos Figueiredo (1140317)
 */
public class ExportServiceImp implements ExportService {

   @Override
   public void exportWorkbook(WorkbookDTO workbookDTO, String type){
       
        ExportXMLController ctrl = new ExportXMLController();
           
     
       try {
           ctrl.exportWorkbook(Workbook.fromDTO(workbookDTO));
       } catch (IOException ex) {
           Logger.getLogger(ExportServiceImp.class.getName()).log(Level.SEVERE, null, ex);
       }
   
    }



    
   
}
