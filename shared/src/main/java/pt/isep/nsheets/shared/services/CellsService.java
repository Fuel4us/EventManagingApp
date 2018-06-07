package pt.isep.nsheets.shared.services;

import com.google.gwt.user.client.rpc.RemoteService;
import com.google.gwt.user.client.rpc.RemoteServiceRelativePath;
import pt.isep.nsheets.shared.lapr4.red.s1.core.n1161292.services.WorkbookDTO;

@RemoteServiceRelativePath("cellsService")
public interface CellsService extends RemoteService {


    String getResult(String expression, WorkbookDTO workbookDTO);
}
