package pt.isep.nsheets.server.lapr4.green.s1.ipc.n1140317.ExportXML.application;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.FileWriter;
import java.io.IOException;
import java.util.logging.Level;
import java.util.logging.Logger;
import pt.isep.nsheets.shared.core.Spreadsheet;
import pt.isep.nsheets.shared.core.Workbook;

/**
 *
 * @author Carlos Figueiredo (1140317)
 */
public class ExportXMLController {

    private final ExportXML expXML = new ExportXML();

    private final String CRLF = ",\r\n";
    private String delimiter = ",";

    public ExportXMLController() {
    }

    public boolean exportWorkbook(Workbook activeWorkbook) throws FileNotFoundException, IOException {

        try {
            String xmlFile = "../XML.xml";

            FileWriter writer = new FileWriter(xmlFile);

            writer.append(activeWorkbook.name() + CRLF + activeWorkbook.description() + CRLF);

            for (int x = 0; x < activeWorkbook.getSpreadsheetCount(); x++) {
                Spreadsheet s = activeWorkbook.getSpreadsheet(x);

                int r_count = s.getRowCount();
                int c_count = s.getColumnCount();

                for (int y = 0; y < r_count; y++) {
                    for (int z = 0; z < c_count; z++) {
                        writer.append(s.getCell(y, z).getContent());

                        if (z < r_count - 1) {
                            writer.append(delimiter);
                        }
                    }

                    if (y < c_count - 1) {
                        writer.append(CRLF);
                    }
                }
            }

            writer.flush();
            writer.close();
        } catch (IOException e) {
            e.printStackTrace();
        }

//    public boolean exportWorkbook(Workbook activeWorkbook, File filePath) throws FileNotFoundException, IOException {
//        FileOutputStream stream = null;
//        WorkbookDTO w = activeWorkbook.toDTO();
//        List<String[][]> workbook = ExportServiceImp.exportWorkbook(w,"");
//
//        try {
//            stream = new FileOutputStream(filePath);
//        } catch (FileNotFoundException ex) {
//            Logger.getLogger(ExportXMLController.class.getName()).log(Level.SEVERE, null, ex);
//            return false;
//        }
//
//        try {
//            expXML.write(workbook, stream);
//            stream.close();
//        } catch (IOException ex) {
//            Logger.getLogger(ExportXMLController.class.getName()).log(Level.SEVERE, null, ex);
//            return false;
//        }
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
