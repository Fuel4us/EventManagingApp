package pt.isep.nsheets.shared.services;

import com.google.gwt.user.client.rpc.AsyncCallback;
import java.util.ArrayList;

/**
 *
 * @author Pedro Marques Vieira
 */
public interface PrivateChatsServiceAsync {
    
    void addPrivateChat(PrivateChatDTO pcDTO, AsyncCallback<PrivateChatDTO> callback);
    
    void getPrivateChats(AsyncCallback<ArrayList<PrivateChatDTO>> callback);
}
