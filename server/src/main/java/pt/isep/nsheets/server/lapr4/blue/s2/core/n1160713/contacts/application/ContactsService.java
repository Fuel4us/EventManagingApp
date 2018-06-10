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
import pt.isep.nsheets.shared.services.ContactDTO;
import pt.isep.nsheets.shared.services.UserDTO;

public class ContactsService {

    /**
     *
     * @param currentUser
     * @return
     */
    //Only for usage in other methods
    public Iterable<Contact> allContactsFromUser(String email) {

        final ContactsRepository contactsRepository = PersistenceContext.repositories().contacts();
        return contactsRepository.findAllFromUser(email);
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

    public void acceptInvitation(ContactDTO contact, UserDTO currentUser) {
        final ContactsRepository contactsRepository = PersistenceContext.repositories().contacts();
        Contact foundContact = contactsRepository.findContactFromDTO(contact);
        foundContact.accept();
        try {
            contactsRepository.save(foundContact);
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

    public void denyInvitation(ContactDTO contact, UserDTO currentUser) {
        final ContactsRepository contactsRepository = PersistenceContext.repositories().contacts();
        Contact foundContact = contactsRepository.findContactFromDTO(contact);
        foundContact.deny();
        try {
            contactsRepository.save(foundContact);
        } catch (DataConcurrencyException ex) {
            Logger.getLogger(ContactsService.class.getName()).log(Level.SEVERE, null, ex);
        } catch (DataIntegrityViolationException ex) {
            Logger.getLogger(ContactsService.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    public void blockUser(UserDTO user) {
        final UserRepository userRepo = PersistenceContext.repositories().users();

        User foundUser = userRepo.findByEmail(user.getEmail());
        foundUser.getBlacklist().add(foundUser);

        try {
            userRepo.save(foundUser);
        } catch (DataConcurrencyException ex) {
            Logger.getLogger(ContactsService.class.getName()).log(Level.SEVERE, null, ex);
        } catch (DataIntegrityViolationException ex) {
            Logger.getLogger(ContactsService.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    public void unblockUser(UserDTO user) {
        final UserRepository userRepo = PersistenceContext.repositories().users();

        User foundUser = userRepo.findByEmail(user.getEmail());
        foundUser.getBlacklist().remove(foundUser);

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
        User receiver = userRepo.findByEmail(emailReceiver);
        User sender = userRepo.findByEmail(emailSender);

        if (sender.getBlacklist().contains(receiver)) {
            return;
        }
        Contact contact = new Contact(sender.toDTO(), receiver.toDTO(), true, false);
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
