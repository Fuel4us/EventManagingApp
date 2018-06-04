package pt.isep.nsheets.server.lapr4.green.s1.ipc.n1140317.ExportXML.application;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import pt.isep.nsheets.server.services.ExportServiceImp;
import pt.isep.nsheets.shared.core.Spreadsheet;
import pt.isep.nsheets.shared.core.Workbook;

/**
 *
 * @author Carlos Figueiredo (1140317)
 */
public class ExportXMLController {

    private final ExportXML expXML = new ExportXML();

    public ExportXMLController() {
    }

    public boolean exportWorkbook(String name, String description, List<String[][]> cells) throws FileNotFoundException, IOException {
        FileOutputStream stream = null;

        try {
            stream = new FileOutputStream("../server\\\\src\\\\test\\\\java\\\\pt\\\\isep\\\\nsheets\\\\server\\\\lapr4\\\\green\\\\s1\\\\ipc\\\\n1140317\\\\ExportXML\\\\application\\\\workbookTest.xml");
        } catch (FileNotFoundException ex) {
            Logger.getLogger(ExportXMLController.class.getName()).log(Level.SEVERE, null, ex);
            return false;
        }

        try {
            expXML.write(cells, stream);
            stream.close();
        } catch (IOException ex) {
            Logger.getLogger(ExportXMLController.class.getName()).log(Level.SEVERE, null, ex);
            return false;
        }
        return true;
    }
//
//    public boolean exportSpreadsheet(Spreadsheet activeSpreadsheet, File filePath) throws FileNotFoundException, IOException {
//
//        FileOutputStream stream = null;
//        String[][] spreadsheet = ExportServiceImp.exportSpreadsheet(activeSpreadsheet);
//        try {
//            stream = new FileOutputStream(filePath);
//        } catch (FileNotFoundException ex) {
//            Logger.getLogger(ExportXMLController.class.getName()).log(Level.SEVERE, null, ex);
//            return false;
//        }
//
//        try {
//            expXML.write(spreadsheet, stream);
//
//            stream.close();
//        } catch (IOException ex) {
//            Logger.getLogger(ExportXMLController.class.getName()).log(Level.SEVERE, null, ex);
//            return false;
//        }
//        return true;
//    }
//
//    public boolean exportSpreadsheetCells(Spreadsheet activeSpreadsheet, int beginColumn, int beginRow, int endColumn, int endRow, File filePath) throws FileNotFoundException, IOException {
//
//        FileOutputStream stream = null;
//        String[][] spreadsheet = ExportServiceImp.exportPartOfSpreadsheet(activeSpreadsheet, beginColumn, beginRow, endColumn, endRow);
//        try {
//            stream = new FileOutputStream(filePath);
//        } catch (FileNotFoundException ex) {
//            Logger.getLogger(ExportXMLController.class.getName()).log(Level.SEVERE, null, ex);
//            return false;
//        }
//
//        try {
//            expXML.write(spreadsheet, stream);
//
//            stream.close();
//        } catch (IOException ex) {
//            Logger.getLogger(ExportXMLController.class.getName()).log(Level.SEVERE, null, ex);
//            return false;
//        }
//        return true;
//    }
}
