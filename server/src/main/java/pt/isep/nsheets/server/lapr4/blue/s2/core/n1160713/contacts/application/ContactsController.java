package pt.isep.nsheets.server.lapr4.blue.s2.core.n1160713.contacts.application;

import eapli.framework.application.Controller;
import eapli.framework.persistence.DataConcurrencyException;
import eapli.framework.persistence.DataIntegrityViolationException;
import pt.isep.nsheets.server.lapr4.blue.s2.core.n1160713.contacts.domain.Contact;
import pt.isep.nsheets.shared.services.UserDTO;

public class ContactsController implements Controller {
    /**
     *
     * @param currentUserEmail
     * @return
     */
    public Iterable<Contact> allContactsFromUser(String currentUserEmail) {

        return new ContactsService().allContactsFromUser(currentUserEmail);
        //return contactsRepository.findAll();
    }

    public Iterable<Contact> allInvitations(String email) {
        return new ContactsService().allInvitations(email);
    }

    public Iterable<Contact> allAvailableContacts(String email) {
        return new ContactsService().allAvailableContacts(email);
    }

    public void acceptInvitation(String currentUserEmail, String otherUserEmail) {
        new ContactsService().acceptInvitation(currentUserEmail, otherUserEmail);
    }

    public void denyInvitation(String currentUserEmail, String otherUserEmail) {
        new ContactsService().denyInvitation(currentUserEmail, otherUserEmail);
    }

    public void blockUser(String currentUser, String userToBlock) {
        new ContactsService().blockUser(currentUser, userToBlock);
    }

    public void unblockUser(String currentUser, String userToBlock) {
        new ContactsService().unblockUser(currentUser, userToBlock);
    }

    public void sendInvitation(String emailReceiver, String emailSender) throws DataConcurrencyException, DataIntegrityViolationException {
        new ContactsService().sendInvitation(emailReceiver, emailSender);
    }

    public UserDTO findUserByEmail(String email) {
        return new ContactsService().findUserByEmailDTO(email);
    }
}
