package pt.isep.nsheets.server.lapr4.red.s2.ipc.n1161140.import_xml.application;

import gwt.material.design.client.ui.MaterialToast;
import org.w3c.dom.Document;
import org.w3c.dom.Element;
import org.w3c.dom.Node;
import org.w3c.dom.NodeList;
import org.xml.sax.SAXException;
import pt.isep.nsheets.shared.core.*;

import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.ParserConfigurationException;
import java.io.File;
import java.io.IOException;

public class ImportXmlService {

    DocumentBuilderFactory factory;
    DocumentBuilder builder;
    Document document;

    File file;

    public ImportXmlService() {
        try {
            factory = DocumentBuilderFactory.newInstance();
            builder = factory.newDocumentBuilder();
            document = builder.parse(file);
            document.getDocumentElement().normalize();
        } catch (ParserConfigurationException | IOException | SAXException e) {
            MaterialToast.fireToast("Failed to read the file");
            return;
        }
    }

    public boolean importWorkbooks() {
        try {
            NodeList workbookNodeList = document.getElementsByTagName("workbook");
            for (int i = 0; i < workbookNodeList.getLength(); i++) {
                Node workbookNode = workbookNodeList.item(i);
                if (workbookNode.getNodeType() == Node.ELEMENT_NODE) {
                    Element workbookElement = (Element) workbookNode;

                    String workbookTitle = workbookElement.getAttribute("title");
                    String descriptionTitle = workbookElement.getAttribute("description");

                    NodeList spreadsheetNodeList = document.getElementsByTagName("spreadsheet");
                    for (int j = 0; j < spreadsheetNodeList.getLength(); j++) {
                        Node spreadsheetNode = spreadsheetNodeList.item(i);
                        if (spreadsheetNode.getNodeType() == Node.ELEMENT_NODE) {
                            Element spreadsheetElement = (Element) spreadsheetNode;

                            String spreadsheetTitle = spreadsheetElement.getAttribute("title");

                            NodeList cellNodeList = document.getElementsByTagName("cell");
                            for (int k = 0; k < cellNodeList.getLength(); k++) {
                                Node cellNode = cellNodeList.item(k);
                                if (cellNode.getNodeType() == Node.ELEMENT_NODE) {
                                    Element cellElement = (Element) cellNode;

                                    String[][] values = new String[spreadsheetNodeList.getLength()][cellNodeList.getLength()];

                                    String pos = cellElement.getAttribute("pos");
                                    values[j][k] = cellElement.getElementsByTagName("value").item(0).getTextContent();

                                    Cell cell = new CellImpl();
                                }
                            }

                            Spreadsheet spreadsheet = new SpreadsheetImpl(/*workbook, spreadsheetTitle*/);
                        }
                    }

                    Workbook workbook = new Workbook(workbookTitle, descriptionTitle);
                }
            }
        } catch (Exception e) {
            MaterialToast.fireToast("Failed to import the workbooks");
            return false;
        }
        return true;
    }

    public void importSpreadsheets() {

    }

    public void importCells() {

    }
}
