package pt.isep.nsheets.shared.services;

import java.util.ArrayList;

import com.google.gwt.user.client.rpc.AsyncCallback;

public interface ContactsServiceAsync {

    void allContactsFromUser(String email, AsyncCallback<ArrayList<ContactDTO>> callback);

    void allInvitations(String email, AsyncCallback<ArrayList<ContactDTO>> callback);

    void allAvailableContacts(String email, AsyncCallback<ArrayList<ContactDTO>> callback);

    void acceptInvitation(String currentUserEmail, String otherUserEmail, AsyncCallback<Void> callback);

    void denyInvitation(String currentUserEmail, String otherUserEmail, AsyncCallback<Void> callback);

    void blockUser(String currentUserEmail, String userToBlockEmail, AsyncCallback<Void> callback);

    void unblockUser(String currentUserEmail, String userToBlockEmail, AsyncCallback<Void> callback);

    void sendInvitation(String emailReceiver, String emailSender, AsyncCallback<Void> callback);

    void getUserByEmail(String email, AsyncCallback<UserDTO> callback);
}
