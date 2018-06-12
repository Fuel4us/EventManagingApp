package pt.isep.nsheets.server.services;

import com.google.gwt.user.server.rpc.RemoteServiceServlet;
import pt.isep.nsheets.server.lapr4.red.s2.ipc.n1161140.import_xml.application.ImportXmlController;
import pt.isep.nsheets.shared.services.ImportService;

public class ImportServiceImpl extends RemoteServiceServlet implements ImportService {

    @Override
    public void importXmlFile() {
        ImportXmlController controller = new ImportXmlController();

        controller.importWorkbooks();
    }
}
