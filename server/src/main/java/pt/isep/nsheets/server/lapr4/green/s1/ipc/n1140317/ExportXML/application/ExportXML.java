package pt.isep.nsheets.server.lapr4.green.s1.ipc.n1140317.ExportXML.application;



import pt.isep.nsheets.server.services.XMLTransformService;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.util.Iterator;
import java.util.List;
import java.util.SortedSet;
import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.ParserConfigurationException;
import javax.xml.transform.TransformerException;
import org.w3c.dom.Document;
import org.w3c.dom.Element;
import pt.isep.nsheets.server.lapr4.green.s1.ipc.n1140317.ExportXML.persistence.WorkbookIO;
import pt.isep.nsheets.server.lapr4.green.s1.ipc.n1150503.ExportPDF.ExportPdfController;
import pt.isep.nsheets.server.lapr4.green.s1.ipc.n1160998.ExportCSV.ExportCSVController;
import pt.isep.nsheets.shared.core.Address;
import pt.isep.nsheets.shared.core.Cell;
import pt.isep.nsheets.shared.core.Spreadsheet;
import pt.isep.nsheets.shared.core.Workbook;
import pt.isep.nsheets.shared.lapr4.red.s1.core.n1161292.services.WorkbookDTO;

/**
 *
 * @author Carlos Figueiredo (1140317)
 */
public class ExportXML implements WorkbookIO {
    

    @Override
    public void write(List<String[][]> workbook, OutputStream stream) throws IOException {
        
        Document dom;
        // Make an  instance of the DocumentBuilderFactory
        DocumentBuilderFactory dbf = DocumentBuilderFactory.newInstance();

        Iterator<String[][]> spreadsheetIterator = workbook.iterator();
        int numSpreadsheets = 0;

        try {
            // use the factory to take an instance of the document builder
            DocumentBuilder db = dbf.newDocumentBuilder();
            // create instance of DOM
            dom = db.newDocument();

            // create the root element
            Element workbookE = dom.createElement(XMLTags.WORKBOOK.getDesc());
            
            // create data elements and place them under root
            while (spreadsheetIterator.hasNext()) {
                String[][] spreadsheet = spreadsheetIterator.next();
                Element spreadsheetE = createSpreadsheetElement(dom, spreadsheet);

                spreadsheetE.setAttribute("num", "" + numSpreadsheets++);
                workbookE.appendChild(spreadsheetE);
            }
            dom.appendChild(workbookE);

            try {
                XMLTransformService.transformXML(dom, stream);
            } catch (TransformerException e) {
                System.out.println(e.getMessage());
            }

        } catch (ParserConfigurationException pce) {
            System.out.println("DocumentBuilder : Error trying to instantiate" + pce);
        }
    }


    @Override
    public void write(String[][] spreadsheet, OutputStream stream) throws IOException {
        
        Document dom;
        DocumentBuilderFactory dbf = DocumentBuilderFactory.newInstance();

        try {
            // use the factory to take an instance of the document builder
            DocumentBuilder db = dbf.newDocumentBuilder();
            // create instance of DOM
            dom = db.newDocument();

            // create the root element
            Element spreadsheetE = createSpreadsheetElement(dom, spreadsheet);

            dom.appendChild(spreadsheetE);

            try {
                XMLTransformService.transformXML(dom, stream);
            } catch (TransformerException e) {
                System.out.println(e.getMessage());
            }

        } catch (ParserConfigurationException e) {
            System.out.println("DocumentBuilder : Error trying to instantiate" + e);
        }
        
    }

    public Element createSpreadsheetElement(Document dom, String[][] spreadsheet) {
       
        Element elementCell;
        Element elementSpreadsheet = dom.createElement(XMLTags.SPREADSHEET.getDesc());

        for (String[] spreadsheet1 : spreadsheet) {
            for (int column = 0; column < spreadsheet[0].length; column++) {
                elementCell = dom.createElement(XMLTags.CELL.getDesc());
                elementCell.setAttribute("address", spreadsheet1[column]);
                elementCell.appendChild(dom.createTextNode(spreadsheet1[column]));
                elementSpreadsheet.appendChild(elementCell);
            }
        }
        return elementSpreadsheet;
    }

    
    //not used abstract method mandatory to implement
    @Override
    public Workbook read(InputStream stream) throws IOException, ClassNotFoundException {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    
     public static void exportWorkbook(WorkbookDTO workbookDTO, String type) {
        Workbook workbook = Workbook.fromDTO(workbookDTO);

        if (type.equalsIgnoreCase("CSV")) {
            ExportCSVController controller = new ExportCSVController();

            controller.exportWorkbook(workbook);
        }

        if (type.equalsIgnoreCase("PDF")) {
            ExportPdfController controller = new ExportPdfController();
            controller.exportWorkbook(workbook);
        }
        if (type.equalsIgnoreCase("XML")) {
            ExportCSVController controller = new ExportCSVController();
            controller.exportWorkbook(workbook);
        }
    }

    public static String[][] exportSpreadsheet(Spreadsheet spreadsheet) {
        int spreadsheetColumnCount = spreadsheet.getColumnCount();
        int spreadsheetRowCount = spreadsheet.getRowCount();

        String result[][] = new String[spreadsheetRowCount][spreadsheetColumnCount];

        for (int i = 0; i < spreadsheetRowCount; i++) {
            for (int j = 0; j < spreadsheetColumnCount; j++) {
                result[i][j] = exportCell(spreadsheet, i, j);
            }
        }

        return result;
    }

    public static String[][] exportPartOfSpreadsheet(Spreadsheet spreadsheet, int beginColumn, int beginRow, int endColumn, int endRow) {
        Address addBegin = new Address(beginColumn, beginRow);
        Address addEnd = new Address(endColumn, endRow);

        SortedSet<Cell> cells = spreadsheet.getCells(addBegin, addEnd);

        String result[][] = new String[(endRow - beginRow) + 1][(endColumn - beginColumn) + 1];

        for (int i = 0; i < result.length; i++) {
            for (int j = 0; j < result[0].length; j++) {
                result[i][j] = cells.iterator().next().getContent();
            }
        }

        return result;
    }

    public static String exportCell(Spreadsheet spreadsheet, int column, int row) {
        return spreadsheet.getCell(column, row).getContent();
    }
}
