package pt.isep.nsheets.shared.services;

import java.util.ArrayList;

import com.google.gwt.user.client.rpc.AsyncCallback;
import pt.isep.nsheets.shared.lapr4.red.s1.core.n1161292.services.WorkbookDTO;

public interface UsersServiceAsync {
    void getUsers(AsyncCallback<ArrayList<UserDTO>> callback);
    
    void attemptLogin(String email, String password, AsyncCallback<UserDTO> callback);

    void editProfile(UserDTO userDTO, AsyncCallback<UserDTO> async);

    void deleteUser(String email, AsyncCallback<UserDTO> async);

//    void getWorkbook(UserDTO user, AsyncCallback<Iterable<WorkbookDTO>> callback);
//    
//    void addWorkbook(WorkbookDTO workbook, UserDTO user, AsyncCallback<Void> callback);
}
