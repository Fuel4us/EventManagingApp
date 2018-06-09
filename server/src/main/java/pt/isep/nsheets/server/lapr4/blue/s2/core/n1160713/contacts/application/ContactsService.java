package pt.isep.nsheets.server.lapr4.blue.s2.core.n1160713.contacts.application;

import eapli.framework.persistence.DataConcurrencyException;
import eapli.framework.persistence.DataIntegrityViolationException;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.util.logging.Level;
import java.util.logging.Logger;
import pt.isep.nsheets.server.lapr4.blue.s2.core.n1160713.contacts.domain.Contact;
import pt.isep.nsheets.server.lapr4.blue.s2.core.n1160713.contacts.persistence.ContactsRepository;
import pt.isep.nsheets.server.lapr4.green.s1.core.n1160557.users.domain.User;
import pt.isep.nsheets.server.lapr4.green.s1.core.n1160557.users.persistence.UserRepository;
import pt.isep.nsheets.server.lapr4.white.s1.core.n4567890.workbooks.persistence.PersistenceContext;
import pt.isep.nsheets.shared.services.ContactDTO;
import pt.isep.nsheets.shared.services.UserDTO;

public class ContactsService {


    /**
     *
     * @param currentUser
     * @return
     */
    public Iterable<Contact> allContactsFromUser(UserDTO currentUser) {

        final ContactsRepository contactsRepository = PersistenceContext.repositories().contacts();
        return contactsRepository.findAllFromUser(currentUser);
        //return contactsRepository.findAll();
    }

    public Iterable<Contact> allInvitations(UserDTO currentUser) {
        List<Contact> list = new ArrayList<>();
        for (Contact c : allContactsFromUser(currentUser)) {
            if (c.isWaitingAcception()) {
                list.add(c);
            }
        }
        return list;
    }

    public Iterable<Contact> allAvailableContacts(UserDTO currentUser) {
        List<Contact> list = new ArrayList<>();
        for (Contact c : allContactsFromUser(currentUser)) {
            if (!c.isWaitingAcception() && c.isAccepted()) {
                list.add(c);
            }
        }
        return list;
    }

    public void acceptInvitation(Long contactID, ContactDTO contact, UserDTO currentUser) {
        final ContactsRepository contactsRepository = PersistenceContext.repositories().contacts();
        Optional<Contact> foundContact = contactsRepository.findOne(contactID);
        foundContact.get().accept();
        try {
            contactsRepository.save(foundContact.get());
        } catch (DataConcurrencyException ex) {
            Logger.getLogger(ContactsService.class.getName()).log(Level.SEVERE, null, ex);
        } catch (DataIntegrityViolationException ex) {
            Logger.getLogger(ContactsService.class.getName()).log(Level.SEVERE, null, ex);
        }

        //adds contact for the user who sent the invite
        Contact newContact = new Contact(currentUser, contact.getContact(), false, true);
        try {
            contactsRepository.save(newContact);
        } catch (DataConcurrencyException ex) {
            Logger.getLogger(ContactsService.class.getName()).log(Level.SEVERE, null, ex);
        } catch (DataIntegrityViolationException ex) {
            Logger.getLogger(ContactsService.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    public void denyInvitation(Long contactID, ContactDTO contact, UserDTO currentUser) {
        final ContactsRepository contactsRepository = PersistenceContext.repositories().contacts();
        Optional<Contact> foundContact = contactsRepository.findOne(contactID);
        foundContact.get().deny();
        try {
            contactsRepository.save(foundContact.get());
        } catch (DataConcurrencyException ex) {
            Logger.getLogger(ContactsService.class.getName()).log(Level.SEVERE, null, ex);
        } catch (DataIntegrityViolationException ex) {
            Logger.getLogger(ContactsService.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    public void blockUser(UserDTO user, Long userID) {
        final UserRepository userRepo = PersistenceContext.repositories().users();

        User foundUser = userRepo.findOne(userID).get();
        foundUser.getBlacklist().add(user);

        try {
            userRepo.save(foundUser);
        } catch (DataConcurrencyException ex) {
            Logger.getLogger(ContactsService.class.getName()).log(Level.SEVERE, null, ex);
        } catch (DataIntegrityViolationException ex) {
            Logger.getLogger(ContactsService.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    public void unblockUser(UserDTO user, Long userId) {
        final UserRepository userRepo = PersistenceContext.repositories().users();

        User foundUser = userRepo.findOne(userId).get();
        foundUser.getBlacklist().remove(user);

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
     * @param userDTO
     * @param currentUser
     * @param userID
     * @throws DataConcurrencyException
     * @throws DataIntegrityViolationException
     */
    public void sendInvitation(UserDTO userDTO, UserDTO currentUser, Long userID) throws DataConcurrencyException, DataIntegrityViolationException {

        final ContactsRepository contactsRepository = PersistenceContext.repositories().contacts();
        final UserRepository userRepo = PersistenceContext.repositories().users();

        if (userRepo.findOne(userID).get().getBlacklist().contains(userDTO)) {
            return;
        }
        Contact contact = new Contact(currentUser, userDTO, true, false);
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
