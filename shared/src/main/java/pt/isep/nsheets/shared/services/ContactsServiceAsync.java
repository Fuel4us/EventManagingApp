package pt.isep.nsheets.shared.services;

import java.util.ArrayList;

import com.google.gwt.user.client.rpc.AsyncCallback;
import org.eclipse.jetty.server.Authentication.User;

public interface ContactsServiceAsync {

    void allContactsFromUser(UserDTO currentUser, AsyncCallback<ArrayList<ContactDTO>> callback);

    void allInvitations(UserDTO currentUser, AsyncCallback<ArrayList<ContactDTO>> callback);

    void allAvailableContacts(UserDTO currentUser, AsyncCallback<ArrayList<ContactDTO>> callback);

    void acceptInvitation(Long id, ContactDTO contact, UserDTO currentUser, AsyncCallback<Void> callback);

    void denyInvitation(Long id, ContactDTO contact, UserDTO currentUser, AsyncCallback<Void> callback);

    void blockUser(UserDTO user, Long id, AsyncCallback<Void> callback);

    void unblockUser(UserDTO user, Long id, AsyncCallback<Void> callback);

    void sendInvitation(UserDTO userDTO, UserDTO currentUser, Long id, AsyncCallback<Void> callback);

    void getUserByEmail(String email, AsyncCallback<UserDTO> callback);

}
