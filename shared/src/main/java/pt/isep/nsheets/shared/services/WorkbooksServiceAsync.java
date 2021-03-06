package pt.isep.nsheets.shared.services;

import java.util.ArrayList;
import com.google.gwt.user.client.rpc.AsyncCallback;
import pt.isep.nsheets.shared.lapr4.red.s1.core.n1161292.services.WorkbookDTO;

public interface WorkbooksServiceAsync {

    void getWorkbooks(AsyncCallback<ArrayList<WorkbookDTO>> callback);

    void addWorkbookDescription(WorkbookDTO wdDto, AsyncCallback<WorkbookDTO> callback);

    void findByName(String name, AsyncCallback<WorkbookDTO> callback);

    void renameWorkbook(String name, WorkbookDTO workbookDTO, AsyncCallback<WorkbookDTO> callback);

    void deleteWorkbook(WorkbookDTO workbook, AsyncCallback<WorkbookDTO> callback);
    
    void searchWorkbooks(String name, boolean state, AsyncCallback<ArrayList<WorkbookDTO>> callback);
    
    void changeState(boolean state, WorkbookDTO workbookDTO, AsyncCallback<WorkbookDTO> callback);
    
    void listWorkbooksPerUser(String user, AsyncCallback<ArrayList<WorkbookDTO>> callback);
}
