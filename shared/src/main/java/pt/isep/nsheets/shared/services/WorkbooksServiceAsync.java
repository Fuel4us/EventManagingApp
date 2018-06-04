package pt.isep.nsheets.shared.services;

import java.util.ArrayList;
import com.google.gwt.user.client.rpc.AsyncCallback;
import pt.isep.nsheets.shared.lapr4.red.s1.core.n1161292.services.WorkbookDTO;

public interface WorkbooksServiceAsync {

    void getWorkbooks(AsyncCallback<ArrayList<WorkbookDTO>> callback);

    void addWorkbookDescription(WorkbookDTO wdDto, AsyncCallback<WorkbookDTO> callback);

    void findByName(String name, AsyncCallback<WorkbookDTO> callback);

    void setName(String name, WorkbookDTO workbookDTO, AsyncCallback<WorkbookDTO> callback);

    void deleteWorkbook(WorkbookDTO workbook, AsyncCallback<WorkbookDTO> callback);
}
