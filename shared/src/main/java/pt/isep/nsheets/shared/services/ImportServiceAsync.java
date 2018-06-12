package pt.isep.nsheets.shared.services;

import com.google.gwt.user.client.rpc.AsyncCallback;
import pt.isep.nsheets.shared.lapr4.red.s1.core.n1161292.services.WorkbookDTO;

public interface ImportServiceAsync {

    void importXmlFile(String fileName, AsyncCallback<WorkbookDTO> async);
}
