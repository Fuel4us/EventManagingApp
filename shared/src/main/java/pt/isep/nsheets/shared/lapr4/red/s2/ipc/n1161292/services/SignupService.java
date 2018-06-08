package pt.isep.nsheets.shared.lapr4.red.s2.ipc.n1161292.services;

import com.google.gwt.user.client.rpc.RemoteService;
import com.google.gwt.user.client.rpc.RemoteServiceRelativePath;
import pt.isep.nsheets.shared.services.UserDTO;

/**
 *
 * @author Tiago João Santos Rios, 1161292@isep.ipp.pt
 */
@RemoteServiceRelativePath("signupService")
public interface SignupService extends RemoteService {
    
    UserDTO signupUser(UserDTO dto);
    
}
