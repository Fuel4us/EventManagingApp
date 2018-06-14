package pt.isep.nsheets.shared.services;

import java.util.ArrayList;

import com.google.gwt.user.client.rpc.RemoteService;
import com.google.gwt.user.client.rpc.RemoteServiceRelativePath;
import pt.isep.nsheets.shared.lapr4.red.s1.core.n1161292.services.WorkbookDTO;

@RemoteServiceRelativePath("usersService")
public interface UsersService extends RemoteService {

    ArrayList<UserDTO> getUsers();
    
    UserDTO attemptLogin(String email, String password);
    
    Iterable<WorkbookDTO> getWorkbook(UserDTO user);
    
    void addWorkbook(WorkbookDTO workbook, UserDTO user);
}
