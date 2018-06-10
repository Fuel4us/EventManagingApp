
package pt.isep.nsheets.server.lapr4.green.s1.ipc.n1140317.ExportXML.application;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;

import pt.isep.nsheets.server.services.ExportServiceImpl;
import pt.isep.nsheets.shared.core.Spreadsheet;
import pt.isep.nsheets.shared.core.Workbook;
import pt.isep.nsheets.shared.lapr4.red.s1.core.n1161292.services.WorkbookDTO;



/**
 *
 * @author Carlos Figueiredo (1140317)
 */


public class ExportXMLController {

    private final ExportXML expXML = new ExportXML();


    public ExportXMLController() {
    }

    public boolean exportWorkbook(Workbook activeWorkbook) {
        FileOutputStream stream = null;

        try {
            stream = new FileOutputStream("../XML.xml");
        } catch (FileNotFoundException ex) {
            Logger.getLogger(ExportXMLController.class.getName()).log(Level.SEVERE, null, ex);
            return false;
        }

        ArrayList<String[][]> workbook = new ArrayList<>();

        for(int i = 0; i < activeWorkbook.getSpreadsheetCount(); i++) {
                Spreadsheet s = activeWorkbook.getSpreadsheet(i);

                int r_count = s.getRowCount();
                int c_count = s.getColumnCount();

                String[][] ssheet = new String[c_count][r_count];

                for(int x = 0; i < c_count; x++){
                    for(int y = 0; i < r_count; y++){


                        ssheet[x][y] = s.getCell(x,y).getContent();
                    }
                }
                workbook.add(ssheet);
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


