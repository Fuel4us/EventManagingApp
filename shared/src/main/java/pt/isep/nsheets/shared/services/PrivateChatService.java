package pt.isep.nsheets.shared.services;

import com.google.gwt.user.client.rpc.RemoteService;
import com.google.gwt.user.client.rpc.RemoteServiceRelativePath;
import java.util.ArrayList;

/**
 *
 * @author Pedro Marques Vieira
 */
@RemoteServiceRelativePath("privateChatService")
public interface PrivateChatService extends RemoteService{
    
    PrivateChatDTO addPrivateChat(PrivateChatDTO pcDto) throws DataException;
    
    ArrayList<PrivateChatDTO> getPrivateChats();
}
