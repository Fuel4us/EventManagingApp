package pt.isep.nsheets.server.lapr4.red.s2.ipc.n1161140.import_xml.application;

import com.google.gwt.core.client.GWT;

import java.io.File;

public class ImportXmlController {

    public void importWorkbooks() {
        ImportXmlService service = new ImportXmlService(new File(GWT.getModuleBaseURL()));

        service.importWorkbooks();
    }

    public void importSpreadsheets() {
    }

    public void importCells() {
    }
}