package pt.isep.nsheets.server.lapr4.blue.s2.core.n1160713.contacts.application;

import eapli.framework.persistence.DataConcurrencyException;
import eapli.framework.persistence.DataIntegrityViolationException;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import pt.isep.nsheets.server.lapr4.blue.s2.core.n1160713.contacts.domain.Contact;
import pt.isep.nsheets.server.lapr4.blue.s2.core.n1160713.contacts.persistence.ContactsRepository;
import pt.isep.nsheets.server.lapr4.green.s1.core.n1160557.users.domain.User;
import pt.isep.nsheets.server.lapr4.green.s1.core.n1160557.users.persistence.UserRepository;
import pt.isep.nsheets.server.lapr4.white.s1.core.n4567890.workbooks.persistence.PersistenceContext;
import pt.isep.nsheets.shared.services.UserDTO;

public class ContactsService {

    /**
     *
     * @param currentUserEmail
     * @return
     */
    //Only for usage in other methods
    public Iterable<Contact> allContactsFromUser(String currentUserEmail) {

        final ContactsRepository contactsRepository = PersistenceContext.repositories().contacts();
        return contactsRepository.findAllFromUser(currentUserEmail);
        //return contactsRepository.findAll();
    }

    public Iterable<Contact> allInvitations(String email) {
        List<Contact> list = new ArrayList<>();
        for (Contact c : allContactsFromUser(email)) {
            if (c.isWaitingAcception()) {
                list.add(c);
            }
        }
        return list;
    }

    public Iterable<Contact> allAvailableContacts(String email) {
        List<Contact> list = new ArrayList<>();
        for (Contact c : allContactsFromUser(email)) {
            if (!c.isWaitingAcception() && c.isAccepted()) {
                list.add(c);
            }
        }
        return list;
    }

    public void acceptInvitation(String currentUserEmail, String otherUserEmail) {
        final ContactsRepository contactsRepository = PersistenceContext.repositories().contacts();
        Contact foundContact = contactsRepository.findContactFromDTO(otherUserEmail, currentUserEmail);
        foundContact.accept();
        try {
            contactsRepository.save(foundContact);
        } catch (DataConcurrencyException ex) {
            Logger.getLogger(ContactsService.class.getName()).log(Level.SEVERE, null, ex);
        } catch (DataIntegrityViolationException ex) {
            Logger.getLogger(ContactsService.class.getName()).log(Level.SEVERE, null, ex);
        }

        //adds contact for the user who sent the invite
        Contact newContact = new Contact(currentUserEmail, otherUserEmail, false, true);
        try {
            contactsRepository.save(newContact);
        } catch (DataConcurrencyException ex) {
            Logger.getLogger(ContactsService.class.getName()).log(Level.SEVERE, null, ex);
        } catch (DataIntegrityViolationException ex) {
            Logger.getLogger(ContactsService.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    public void denyInvitation(String currentUserEmail, String otherUserEmail) {
        final ContactsRepository contactsRepository = PersistenceContext.repositories().contacts();
        Contact foundContact = contactsRepository.findContactFromDTO(otherUserEmail, currentUserEmail);
        foundContact.deny();
        try {
            contactsRepository.save(foundContact);
        } catch (DataConcurrencyException ex) {
            Logger.getLogger(ContactsService.class.getName()).log(Level.SEVERE, null, ex);
        } catch (DataIntegrityViolationException ex) {
            Logger.getLogger(ContactsService.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    public void blockUser(String currentUser, String userToBlock) {
        final UserRepository userRepo = PersistenceContext.repositories().users();

        User foundUser = userRepo.findByEmail(currentUser);
        foundUser.getBlacklist().add(userToBlock);

        try {
            userRepo.save(foundUser);
        } catch (DataConcurrencyException ex) {
            Logger.getLogger(ContactsService.class.getName()).log(Level.SEVERE, null, ex);
        } catch (DataIntegrityViolationException ex) {
            Logger.getLogger(ContactsService.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    public void unblockUser(String currentUser, String userToUnlock) {
        final UserRepository userRepo = PersistenceContext.repositories().users();

        User foundUser = userRepo.findByEmail(currentUser);
        foundUser.getBlacklist().remove(userToUnlock);

        try {
            userRepo.save(foundUser);
        } catch (DataConcurrencyException ex) {
            Logger.getLogger(ContactsService.class.getName()).log(Level.SEVERE, null, ex);
        } catch (DataIntegrityViolationException ex) {
            Logger.getLogger(ContactsService.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    /**
     *
     * @param emailReceiver
     * @param emailSender
     * @throws DataConcurrencyException
     * @throws DataIntegrityViolationException
     */
    public void sendInvitation(String emailReceiver, String emailSender) throws DataConcurrencyException, DataIntegrityViolationException {

        final ContactsRepository contactsRepository = PersistenceContext.repositories().contacts();
        final UserRepository userRepo = PersistenceContext.repositories().users();

        if (userRepo.findByEmail(emailReceiver).getBlacklist().contains(emailSender)) {
            return;
        }
        Contact contact = new Contact(emailSender, emailReceiver, true, false);
        contactsRepository.save(contact);
    }

    public UserDTO findUserByEmail(String email) {
        final UserRepository userRepo = PersistenceContext.repositories().users();
        for (User u : userRepo.findAll()) {
            if (u.getEmail().equals(email)) {
                return u.toDTO();
            }
        }
        return null;
    }
}
