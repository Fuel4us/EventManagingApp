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

    File file;

    public ImportXmlService(File file) {
        this.file = file;
    }

    /**
     * Imports one or more workbooks and its respective spreadsheets and cells
     *
     * @return true, if the import is successful; false, if something bad happens
     */
    public boolean importWorkbooks() {
        try {
            DocumentBuilderFactory factory = DocumentBuilderFactory.newInstance();
            DocumentBuilder builder = factory.newDocumentBuilder();
            Document document = builder.parse(file);
            document.getDocumentElement().normalize();

            NodeList workbookNodeList = document.getElementsByTagName("workbook");
            for (int i = 0; i < workbookNodeList.getLength(); i++) {

                String spreadsheetTitle = null;

                Node workbookNode = workbookNodeList.item(i);
                if (workbookNode.getNodeType() == Node.ELEMENT_NODE) {
                    Element workbookElement = (Element) workbookNode;

                    String workbookTitle = workbookElement.getAttribute("title");
                    String descriptionTitle = workbookElement.getAttribute("description");

                    NodeList spreadsheetNodeList = document.getElementsByTagName("spreadsheet");
                    for (int j = 0; j < spreadsheetNodeList.getLength(); j++) {

                        Node spreadsheetNode = spreadsheetNodeList.item(j);
                        if (spreadsheetNode.getNodeType() == Node.ELEMENT_NODE) {
                            Element spreadsheetElement = (Element) spreadsheetNode;

                            spreadsheetTitle = spreadsheetElement.getAttribute("title");

                            NodeList cellNodeList = document.getElementsByTagName("cell");
                            for (int k = 0; k < cellNodeList.getLength(); k++) {

                                Node cellNode = cellNodeList.item(k);
                                if (cellNode.getNodeType() == Node.ELEMENT_NODE) {
                                    Element cellElement = (Element) cellNode;

                                    String[][] values = new String[26][9];

                                    String pos = cellElement.getAttribute("pos");

                                    values[(int) pos.charAt(0) - 65][pos.charAt(1) - 1] = cellElement.getElementsByTagName("value").item(0).getTextContent();

                                    Cell cell = new CellImpl();
                                }
                            }
                        }
                    }

                    Workbook workbook = new Workbook(workbookTitle, descriptionTitle);

                    Spreadsheet spreadsheet = new SpreadsheetImpl(workbook, spreadsheetTitle);
                }
            }
        } catch (ParserConfigurationException | IOException | SAXException e) {
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
