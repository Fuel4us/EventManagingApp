package pt.isep.nsheets.shared.services;

import com.google.gwt.user.client.rpc.RemoteService;
import com.google.gwt.user.client.rpc.RemoteServiceRelativePath;

@RemoteServiceRelativePath("contactsService")
public interface ContactsService extends RemoteService {

    public Iterable<ContactDTO> allContactsFromUser(UserDTO currentUser);

    public Iterable<ContactDTO> allInvitations(UserDTO currentUser);

    public Iterable<ContactDTO> allAvailableContacts(UserDTO currentUser);

    public void acceptInvitation(ContactDTO contact, UserDTO currentUser);

    public void denyInvitation(ContactDTO contact, UserDTO currentUser);

    public void blockUser(UserDTO user);

    public void unblockUser(UserDTO user);

    public void sendInvitation(String email, UserDTO currentUser);

    public UserDTO getUserByEmail(String email);
}
