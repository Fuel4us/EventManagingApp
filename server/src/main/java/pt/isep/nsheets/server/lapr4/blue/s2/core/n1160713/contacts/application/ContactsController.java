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

    public void acceptInvitation( ContactDTO contact, UserDTO currentUser) {
        new ContactsService().acceptInvitation(contact, currentUser);
    }

    public void denyInvitation(ContactDTO contact, UserDTO currentUser) {
        new ContactsService().denyInvitation(contact, currentUser);
    }

    public void blockUser(UserDTO user) {
        new ContactsService().blockUser(user);
    }

    public void unblockUser(UserDTO user) {
        new ContactsService().unblockUser(user);
    }

    public void sendInvitation(String email, UserDTO currentUser) throws DataConcurrencyException, DataIntegrityViolationException {
        new ContactsService().sendInvitation(email, currentUser);
    }

    public UserDTO findUserByEmail(String email) {
        return new ContactsService().findUserByEmail(email);
    }
}
