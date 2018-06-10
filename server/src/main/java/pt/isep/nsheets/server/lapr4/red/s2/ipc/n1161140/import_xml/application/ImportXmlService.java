package pt.isep.nsheets.server.lapr4.red.s2.ipc.n1161140.import_xml.application;

import gwt.material.design.client.ui.MaterialToast;
import org.w3c.dom.Document;
import org.w3c.dom.Element;
import org.w3c.dom.Node;
import org.w3c.dom.NodeList;
import org.xml.sax.SAXException;

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
                    String workbookName = workbookElement.getAttribute("name");
                    String workbookDescription = workbookElement.getAttribute("description");
                    String[][] workbookContents;
                    NodeList spreadsheetNodeList = document.getElementsByTagName("spreadsheet");
                }
            }
        } catch (Exception e) {
            MaterialToast.fireToast("Failed to read workbooks");
            return false;
        }
        return true;
    }

    public void importSpreadsheets() {

    }

    public void importCells() {

    }
}
