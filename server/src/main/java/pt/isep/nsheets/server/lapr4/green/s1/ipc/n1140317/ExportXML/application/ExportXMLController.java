/*
package pt.isep.nsheets.server.lapr4.green.s1.ipc.n1140317.ExportXML.application;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.FileWriter;
import java.io.IOException;
import java.util.logging.Level;
import java.util.logging.Logger;

import com.sun.tools.javac.util.List;
import pt.isep.nsheets.server.services.ExportServiceImpl;
import pt.isep.nsheets.shared.core.Spreadsheet;
import pt.isep.nsheets.shared.core.Workbook;
import pt.isep.nsheets.shared.lapr4.red.s1.core.n1161292.services.WorkbookDTO;

*/
/**
 *
 * @author Carlos Figueiredo (1140317)
 *//*

public class ExportXMLController {

    private final ExportXML expXML = new ExportXML();

    private final String CRLF = ",\r\n";
    private String delimiter = ",";

    public ExportXMLController() {
    }

    public boolean exportWorkbook(Workbook activeWorkbook, File filePath) throws FileNotFoundException, IOException {
        FileOutputStream stream = null;
        WorkbookDTO w = activeWorkbook.toDTO();
        List<String[][]> workbook = ExportServiceImpl.exportWorkbook(w,"");

        try {
            stream = new FileOutputStream(filePath);
        } catch (FileNotFoundException ex) {
            Logger.getLogger(ExportXMLController.class.getName()).log(Level.SEVERE, null, ex);
            return false;
        }
     try {
            expXML.write(workbook, stream);
            stream.close();
        } catch (IOException ex) {
            Logger.getLogger(ExportXMLController.class.getName()).log(Level.SEVERE, null, ex);
            return false;
        }
        return true;
    }

    public boolean exportSpreadsheet(Spreadsheet activeSpreadsheet, File filePath) throws FileNotFoundException, IOException {

        FileOutputStream stream = null;
        String[][] spreadsheet = ExportXML.exportSpreadsheet(activeSpreadsheet);
        try {
            stream = new FileOutputStream(filePath);

        } catch (FileNotFoundException ex) {
            Logger.getLogger(ExportXMLController.class
                    .getName()).log(Level.SEVERE, null, ex);
            return false;
        }
        try {
            expXML.write(spreadsheet, stream);

            stream.close();

        } catch (IOException ex) {
            Logger.getLogger(ExportXMLController.class
                    .getName()).log(Level.SEVERE, null, ex);
            return false;
        }
        return true;
    }

    public boolean exportSpreadsheetCells(Spreadsheet activeSpreadsheet, int beginColumn, int beginRow, int endColumn, int endRow, File filePath) throws FileNotFoundException, IOException {

        FileOutputStream stream = null;
        String[][] spreadsheet = ExportXML.exportPartOfSpreadsheet(activeSpreadsheet, beginColumn, beginRow, endColumn, endRow);
        try {
            stream = new FileOutputStream(filePath);

        } catch (FileNotFoundException ex) {
            Logger.getLogger(ExportXMLController.class
                    .getName()).log(Level.SEVERE, null, ex);
            return false;
        }

        try {
            expXML.write(spreadsheet, stream);

            stream.close();

        } catch (IOException ex) {
            Logger.getLogger(ExportXMLController.class
                    .getName()).log(Level.SEVERE, null, ex);
            return false;
        }
        return true;
    }
}
*/
