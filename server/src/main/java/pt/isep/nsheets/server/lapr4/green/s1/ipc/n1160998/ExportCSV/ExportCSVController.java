package pt.isep.nsheets.server.lapr4.green.s1.ipc.n1160998.ExportCSV;

import pt.isep.nsheets.server.lapr4.green.s1.ipc.n1140317.ExportXML.application.ExportXMLController;
import pt.isep.nsheets.shared.core.Workbook;

import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author Rúben (1160998)
 */
public class ExportCSVController {
    public ExportCSVController() {
    }

    public void exportWorkbook(Workbook workbook){
        FileOutputStream stream = null;
        
        try {
            stream = new FileOutputStream("../Workbook.xml");
        } catch (FileNotFoundException ex) {
            Logger.getLogger(ExportXMLController.class.getName()).log(Level.SEVERE, null, ex);
        }

        try {
            ExportCSV.write(workbook, stream);
            stream.close();
        } catch (IOException ex) {
            Logger.getLogger(ExportXMLController.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
}
