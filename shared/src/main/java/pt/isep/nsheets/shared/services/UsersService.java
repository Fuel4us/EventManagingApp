package pt.isep.nsheets.shared.services;

import java.util.ArrayList;

import com.google.gwt.user.client.rpc.RemoteService;
import com.google.gwt.user.client.rpc.RemoteServiceRelativePath;
import pt.isep.nsheets.shared.lapr4.red.s1.core.n1161292.services.WorkbookDTO;

@RemoteServiceRelativePath("usersService")
public interface UsersService extends RemoteService {

    ArrayList<UserDTO> getUsers();
    
    UserDTO attemptLogin(String email, String password);

    boolean deleteUser(String email);

    boolean changeState(String email, boolean state, String superUserEmail, String superUserPassword);

    UserDTO changePassword(String email, String oldPassword, String newPassword);

    UserDTO editUser(String email, String name, String nickname, String URL);
    
//    Iterable<WorkbookDTO> getWorkbook(UserDTO user);
//    
//    void addWorkbook(WorkbookDTO workbook, UserDTO user);
}
