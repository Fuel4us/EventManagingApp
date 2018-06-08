package pt.isep.nsheets.shared.lapr4.red.s2.ipc.n1161292.services;

import com.google.gwt.user.client.rpc.AsyncCallback;
import pt.isep.nsheets.shared.services.UserDTO;

/**
 *
 * @author Tiago João Santos Rios, 1161292@isep.ipp.pt
 */
public interface SignupServiceAsync {
    
    void signupUser(UserDTO dto, AsyncCallback<UserDTO> async);
    
}
