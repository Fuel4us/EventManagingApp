package pt.isep.nsheets.server.lapr4.blue.s2.core.n1160713.contacts.application;

import eapli.framework.application.Controller;
import eapli.framework.persistence.DataConcurrencyException;
import eapli.framework.persistence.DataIntegrityViolationException;
import pt.isep.nsheets.server.lapr4.blue.s2.core.n1160713.contacts.domain.Contact;
import pt.isep.nsheets.server.lapr4.green.s1.core.n1160557.users.domain.User;
import pt.isep.nsheets.shared.services.ContactDTO;
import pt.isep.nsheets.shared.services.UserDTO;

public class ContactsController implements Controller {

    /**
     *
     * @param currentUser
     * @return
     */
    public Iterable<Contact> allContactsFromUser(UserDTO currentUser) {

        return new ContactsService().allContactsFromUser(currentUser);
        //return contactsRepository.findAll();
    }

    public Iterable<Contact> allInvitations(UserDTO currentUser) {
        return new ContactsService().allInvitations(currentUser);
    }

    public Iterable<Contact> allAvailableContacts(UserDTO currentUser) {
        return new ContactsService().allAvailableContacts(currentUser);
    }

    public void acceptInvitation(Long id, ContactDTO contact, UserDTO currentUser) {
        new ContactsService().acceptInvitation(id, contact, currentUser);
    }

    public void denyInvitation(Long id, ContactDTO contact, UserDTO currentUser) {
        new ContactsService().denyInvitation(id, contact, currentUser);
    }

    public void blockUser(UserDTO user, Long id) {
        new ContactsService().blockUser(user, id);
    }

    public void unblockUser(UserDTO user, Long id) {
        new ContactsService().unblockUser(user, id);
    }

    public void sendInvitation(UserDTO userDTO, UserDTO currentUser, Long id) throws DataConcurrencyException, DataIntegrityViolationException {
        new ContactsService().sendInvitation(userDTO, currentUser, id);
    }

    public UserDTO findUserByEmail(String email) {
        return new ContactsService().findUserByEmail(email);
    }

}
