package pt.isep.nsheets.server.lapr4.green.s1.ipc.n1140317.ExportXML.application;



import pt.isep.nsheets.server.services.XMLTransformService;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.util.Iterator;
import java.util.List;
import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.ParserConfigurationException;
import javax.xml.transform.TransformerException;
import org.w3c.dom.Document;
import org.w3c.dom.Element;
import pt.isep.nsheets.server.lapr4.green.s1.ipc.n1140317.ExportXML.persistence.WorkbookIO;
import pt.isep.nsheets.shared.core.Workbook;

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

}
