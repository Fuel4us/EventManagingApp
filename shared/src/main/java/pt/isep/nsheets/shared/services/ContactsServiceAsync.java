package pt.isep.nsheets.shared.services;

import java.util.ArrayList;

import com.google.gwt.user.client.rpc.AsyncCallback;

public interface ContactsServiceAsync {

    void allContactsFromUser(UserDTO currentUser, AsyncCallback<ArrayList<ContactDTO>> callback);

    void allInvitations(UserDTO currentUser, AsyncCallback<ArrayList<ContactDTO>> callback);

    void allAvailableContacts(UserDTO currentUser, AsyncCallback<ArrayList<ContactDTO>> callback);

    void acceptInvitation(ContactDTO contact, UserDTO currentUser, AsyncCallback<Void> callback);

    void denyInvitation(ContactDTO contact, UserDTO currentUser, AsyncCallback<Void> callback);

    void blockUser(UserDTO user, AsyncCallback<Void> callback);

    void unblockUser(UserDTO user, AsyncCallback<Void> callback);

    void sendInvitation(String email, UserDTO currentUser, AsyncCallback<Void> callback);

    void getUserByEmail(String email, AsyncCallback<UserDTO> callback);
}
