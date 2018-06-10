package pt.isep.nsheets.server.lapr4.red.s2.ipc.n1161140.import_xml.application;

public class ImportXmlController {

    public void importWorkbooks() {
        ImportXmlService service = new ImportXmlService();

        service.importWorkbooks();
    }

    public void importSpreadsheets() {
        ImportXmlService service = new ImportXmlService();

        service.importSpreadsheets();
    }

    public void importCells() {
        ImportXmlService service = new ImportXmlService();

        service.importCells();
    }
}