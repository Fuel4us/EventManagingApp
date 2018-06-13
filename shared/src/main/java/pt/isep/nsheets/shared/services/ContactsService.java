package pt.isep.nsheets.shared.services;

import com.google.gwt.user.client.rpc.RemoteService;
import com.google.gwt.user.client.rpc.RemoteServiceRelativePath;

@RemoteServiceRelativePath("contactsService")
public interface ContactsService extends RemoteService {

    public Iterable<ContactDTO> allContactsFromUser(String email);

    public Iterable<ContactDTO> allInvitations(String email);

    public Iterable<ContactDTO> allAvailableContacts(String email);

    public void acceptInvitation(String currentUserEmail, String otherUserEmail);

    public void denyInvitation(String currentUserEmail, String otherUserEmail);

    public void blockUser(String currentUserEmail, String userToBlockEmail);

    public void unblockUser(String currentUserEmail, String userToBlockEmail);

    public void sendInvitation(String emailReceiver, String emailSender);

    public UserDTO getUserByEmail(String email);
}
