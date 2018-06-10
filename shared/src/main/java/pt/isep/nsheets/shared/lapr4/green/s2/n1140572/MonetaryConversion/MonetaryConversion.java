/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package pt.isep.nsheets.shared.lapr4.green.s2.n1140572.MonetaryConversion;

import com.google.gwt.xml.client.Document;
import com.google.gwt.xml.client.Element;
import com.google.gwt.xml.client.Node;
import com.google.gwt.xml.client.XMLParser;
//import java.io.File;

/**
 *
 * @author Pedro Rodrigues - (1140572)
 */
public class MonetaryConversion {

    public static double EuroToDollar = 1.17;
    public static double EuroToPound = 0.88;
    public static double DollarToEuro = 0.85;
    public static double DollarToPound = 0.75;
    public static double PoundToDollar = 1.34;
    public static double PoundToEuro = 1.14;
//    public static File fileXML;

//    public static void readXML() throws FileNotFoundException, IOException {
//        fileXML = new File("MonetaryConversion.xml");
//
//        try {
//            DocumentBuilderFactory documentBuilderFactory = DocumentBuilderFactory.newInstance();
//            DocumentBuilder documentBuilder;
//            documentBuilder = documentBuilderFactory.newDocumentBuilder();
//            InputSource inputSource = new InputSource();
//            inputSource.setCharacterStream(new FileReader(fileXML));
//            Document document;
//            document = (Document) documentBuilder.parse(inputSource);
//
//            Element euroElement = (Element) document.getElementsByTagName("Euro").item(0);
//            EuroToDollar = Double.parseDouble(euroElement.getElementsByTagName("ToDollar").item(0).getNodeValue());
//            EuroToPound = Double.parseDouble(euroElement.getElementsByTagName("ToPound").item(0).getNodeValue());
//
//            Element dollarElement = (Element) document.getElementsByTagName("Dollar").item(0);
//            DollarToPound = Double.parseDouble(dollarElement.getElementsByTagName("ToPound").item(0).getNodeValue());
//            DollarToEuro = Double.parseDouble(dollarElement.getElementsByTagName("ToEuro").item(0).getNodeValue());
//
//            Element poundElement = (Element) document.getElementsByTagName("Pound").item(0);
//            PoundToEuro = Double.parseDouble(poundElement.getElementsByTagName("ToEuro").item(0).getNodeValue());
//            PoundToDollar = Double.parseDouble(poundElement.getElementsByTagName("ToDollar").item(0).getNodeValue());
//
//        } catch (ParserConfigurationException | SAXException ex) {
//            Logger.getLogger(MonetaryConversion.class.getName()).log(Level.SEVERE, null, ex);
//        }
//    }
    
//    public static void readGWTXML(){
//        Document document = XMLParser.parse("MonetaryConversion.xml");
//        
//        Node euroNode = document.getElementsByTagName("Euro").item(0);
//        EuroToDollar = Double.parseDouble(((Element)euroNode).getAttribute("ToDollar"));
//        System.out.println(EuroToDollar);
//    }
}
