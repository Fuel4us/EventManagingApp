package pt.isep.nsheets.server.lapr4.red.s2.ipc.n1161140.import_xml.application;

public class ImportXmlController {

    public void importWorkbooks(String fileName) {
        ImportXmlService service = new ImportXmlService();

        service.importWorkbooks(fileName);
    }
}