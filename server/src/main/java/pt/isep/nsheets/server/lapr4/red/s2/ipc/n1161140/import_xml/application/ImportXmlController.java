package pt.isep.nsheets.server.lapr4.red.s2.ipc.n1161140.import_xml.application;

import pt.isep.nsheets.shared.lapr4.red.s1.core.n1161292.services.WorkbookDTO;

public class ImportXmlController {

    public WorkbookDTO importWorkbooks(String fileName) {
        ImportXmlService service = new ImportXmlService();

        return service.importWorkbooks(fileName);
    }
}