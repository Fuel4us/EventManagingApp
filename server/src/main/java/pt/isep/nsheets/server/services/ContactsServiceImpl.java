package pt.isep.nsheets.server.services;

import java.util.ArrayList;
import java.util.Properties;

import com.google.gwt.user.server.rpc.RemoteServiceServlet;
import eapli.framework.persistence.DataConcurrencyException;
import eapli.framework.persistence.DataIntegrityViolationException;
import java.util.logging.Level;
import java.util.logging.Logger;
import pt.isep.nsheets.server.lapr4.blue.s2.core.n1160713.contacts.application.ContactsController;
import pt.isep.nsheets.server.lapr4.blue.s2.core.n1160713.contacts.domain.Contact;
import pt.isep.nsheets.server.lapr4.white.s1.core.n4567890.workbooks.persistence.PersistenceContext;
import pt.isep.nsheets.server.lapr4.white.s1.core.n4567890.workbooks.persistence.PersistenceSettings;
import pt.isep.nsheets.shared.services.ContactDTO;
import pt.isep.nsheets.shared.services.ContactsService;
import pt.isep.nsheets.shared.services.UserDTO;

public class ContactsServiceImpl extends RemoteServiceServlet implements ContactsService {

    private PersistenceSettings getPersistenceSettings() {

        Properties props = new Properties();

        props.put("persistence.repositoryFactory",
                "pt.isep.nsheets.server.lapr4.white.s1.core.n4567890.workbooks.persistence.jpa.JpaRepositoryFactory");
        props.put("persistence.persistenceUnit", "lapr4.NSheetsPU");

        // Other JPA properties that one might want to override from the ones in
        // persistence.xml
        // props.put("javax.persistence.jdbc.url",
        // "jdbc:h2:../db/nsheets;MV_STORE=FALSE;MVCC=FALSE");
        // props.put("javax.persistence.jdbc.password", "");
        // props.put("javax.persistence.jdbc.driver", "org.h2.Driver");
        // props.put("javax.persistence.jdbc.user", "");
        // props.put("javax.persistence.schema-generation.database.action", "create");
        // props.put("eclipselink.logging.level", "FINE");
        return new PersistenceSettings(props);
    }

    @Override
    public Iterable<ContactDTO> allContactsFromUser(String email) {
        // Setup the persistence settings
        PersistenceContext.setSettings(this.getPersistenceSettings());

        ArrayList<ContactDTO> contacts = new ArrayList<>();

        ContactsController ctrl = new ContactsController();

        Iterable<Contact> contactsAux = ctrl.allContactsFromUser(email);

        contactsAux.forEach(n -> contacts.add(n.toDTO()));

        return contacts;
    }

    @Override
    public Iterable<ContactDTO> allInvitations(String email) {
        // Setup the persistence settings
        PersistenceContext.setSettings(this.getPersistenceSettings());

        ArrayList<ContactDTO> contacts = new ArrayList<>();

        ContactsController ctrl = new ContactsController();

        Iterable<Contact> contactsAux = ctrl.allInvitations(email);

        contactsAux.forEach(n -> contacts.add(n.toDTO()));

        return contacts;
    }

    @Override
    public Iterable<ContactDTO> allAvailableContacts(String email) {
        // Setup the persistence settings
        PersistenceContext.setSettings(this.getPersistenceSettings());

        ArrayList<ContactDTO> contacts = new ArrayList<>();

        ContactsController ctrl = new ContactsController();

        Iterable<Contact> contactsAux = ctrl.allAvailableContacts(email);

        contactsAux.forEach(n -> contacts.add(n.toDTO()));

        return contacts;
    }

    @Override
    public void acceptInvitation(String currentUserEmail, String otherUserEmail) {
        // Setup the persistence settings
        PersistenceContext.setSettings(this.getPersistenceSettings());
        ContactsController ctrl = new ContactsController();
        ctrl.acceptInvitation(currentUserEmail, otherUserEmail);

    }

    @Override
    public void denyInvitation(String currentUserEmail, String otherUserEmail) {
        // Setup the persistence settings
        PersistenceContext.setSettings(this.getPersistenceSettings());
        ContactsController ctrl = new ContactsController();
        ctrl.denyInvitation(currentUserEmail, otherUserEmail);
    }

    @Override
    public void blockUser(String currentUserEmail, String userToBlockEmail) {
        // Setup the persistence settings
        PersistenceContext.setSettings(this.getPersistenceSettings());
        ContactsController ctrl = new ContactsController();
        ctrl.blockUser(currentUserEmail, userToBlockEmail);
    }

    @Override
    public void unblockUser(String currentUserEmail, String userToBlockEmail) {
        // Setup the persistence settings
        PersistenceContext.setSettings(this.getPersistenceSettings());
        ContactsController ctrl = new ContactsController();
        ctrl.unblockUser(currentUserEmail, userToBlockEmail);
    }

    /**
     *
     * @param emailReceiver
     * @param emailSender
     */
    @Override
    public void sendInvitation(String emailReceiver, String emailSender) {
        // Setup the persistence settings
        PersistenceContext.setSettings(this.getPersistenceSettings());
        ContactsController ctrl = new ContactsController();
        try {
            ctrl.sendInvitation(emailReceiver, emailSender);
        } catch (DataConcurrencyException ex) {
            Logger.getLogger(ContactsServiceImpl.class.getName()).log(Level.SEVERE, null, ex);
        } catch (DataIntegrityViolationException ex) {
            Logger.getLogger(ContactsServiceImpl.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    @Override
    public UserDTO getUserByEmail(String email) {
        // Setup the persistence settings
        PersistenceContext.setSettings(this.getPersistenceSettings());
        ContactsController ctrl = new ContactsController();
        return ctrl.findUserByEmail(email);
    }
}
