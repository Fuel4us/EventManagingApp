package pt.isep.nsheets.shared.services;

import java.util.ArrayList;

import com.google.gwt.user.client.rpc.AsyncCallback;
import org.apache.xpath.operations.Bool;
import pt.isep.nsheets.shared.lapr4.red.s1.core.n1161292.services.WorkbookDTO;

public interface UsersServiceAsync {
    void getUsers(AsyncCallback<ArrayList<UserDTO>> callback);
    
    void attemptLogin(String email, String password, AsyncCallback<UserDTO> callback);

    void deleteUser(String email, AsyncCallback<Boolean> async);

    void changeState(String email, boolean state, String superUserEmail, String superUserPassword, AsyncCallback<Boolean> async);

    void changePassword(String email, String oldPassword, String newPassword, AsyncCallback<UserDTO> async);

    void editUser(String email, String name, String nickname, String URL, AsyncCallback<UserDTO> callback);

//    void getWorkbook(UserDTO user, AsyncCallback<Iterable<WorkbookDTO>> callback);
//    
//    void addWorkbook(WorkbookDTO workbook, UserDTO user, AsyncCallback<Void> callback);
}
