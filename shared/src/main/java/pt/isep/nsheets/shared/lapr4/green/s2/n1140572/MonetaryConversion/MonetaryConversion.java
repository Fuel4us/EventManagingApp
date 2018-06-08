/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package pt.isep.nsheets.shared.lapr4.green.s2.n1140572.MonetaryConversion;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.ParserConfigurationException;
import org.w3c.dom.Document;
import org.w3c.dom.Element;
import org.w3c.dom.Node;
import org.w3c.dom.NodeList;
import org.xml.sax.InputSource;
import org.xml.sax.SAXException;

/**
 *
 * @author Pedro Rodrigues - (1140572)
 */
public class MonetaryConversion {

    public static double EuroToDollar;
    public static double EuroToPound;
    public static double DollarToEuro;
    public static double DollarToPound;
    public static double PoundToDollar;
    public static double PoundToEuro;
    public static File fileXML;

    public static void readXML() throws FileNotFoundException, IOException {
        fileXML = new File("MonetaryConversion.xml");
        try {
            DocumentBuilderFactory documentBuilderFactory = DocumentBuilderFactory.newInstance();
            DocumentBuilder documentBuilder;
            documentBuilder = documentBuilderFactory.newDocumentBuilder();
            InputSource inputSource = new InputSource();
            inputSource.setCharacterStream(new FileReader(fileXML));
            Document document = documentBuilder.parse(inputSource);

            Element euroElement = (Element) document.getElementsByTagName("Euro").item(0);
            EuroToDollar = Double.parseDouble(euroElement.getElementsByTagName("ToDollar").item(0).getTextContent());
            EuroToPound = Double.parseDouble(euroElement.getElementsByTagName("ToPound").item(0).getTextContent());

            Element dollarElement = (Element) document.getElementsByTagName("Dollar").item(0);
            DollarToPound = Double.parseDouble(dollarElement.getElementsByTagName("ToPound").item(0).getTextContent());
            DollarToEuro = Double.parseDouble(dollarElement.getElementsByTagName("ToEuro").item(0).getTextContent());

            Element poundElement = (Element) document.getElementsByTagName("Pound").item(0);
            PoundToEuro = Double.parseDouble(poundElement.getElementsByTagName("ToEuro").item(0).getTextContent());
            PoundToDollar = Double.parseDouble(poundElement.getElementsByTagName("ToDollar").item(0).getTextContent());

        } catch (SAXException | ParserConfigurationException ex) {
            Logger.getLogger(MonetaryConversion.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
}
