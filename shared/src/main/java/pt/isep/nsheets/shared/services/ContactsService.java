package pt.isep.nsheets.shared.services;

import com.google.gwt.user.client.rpc.RemoteService;
import com.google.gwt.user.client.rpc.RemoteServiceRelativePath;

@RemoteServiceRelativePath("contactsService")
public interface ContactsService extends RemoteService {

    public Iterable<ContactDTO> allContactsFromUser(UserDTO currentUser);

    public Iterable<ContactDTO> allInvitations(UserDTO currentUser);

    public Iterable<ContactDTO> allAvailableContacts(UserDTO currentUser);

    public void acceptInvitation(Long id, ContactDTO contact, UserDTO currentUser);

    public void denyInvitation(Long id, ContactDTO contact, UserDTO currentUser);

    public void blockUser(UserDTO user, Long id);

    public void unblockUser(UserDTO user, Long id);

    public void sendInvitation(UserDTO userDTO, UserDTO currentUser, Long id);

    public UserDTO getUserByEmail(String email);

}
