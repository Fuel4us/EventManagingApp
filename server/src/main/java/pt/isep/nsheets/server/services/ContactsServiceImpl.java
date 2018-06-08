package pt.isep.nsheets.server.services;

import java.util.ArrayList;
import java.util.Properties;

import com.google.gwt.user.server.rpc.RemoteServiceServlet;

import eapli.framework.persistence.DataConcurrencyException;
import eapli.framework.persistence.DataIntegrityViolationException;
import pt.isep.nsheets.server.lapr4.blue.s2.core.n1160713.contacts.application.AddContactController;
import pt.isep.nsheets.server.lapr4.blue.s2.core.n1160713.contacts.application.ListContactsController;
import pt.isep.nsheets.server.lapr4.blue.s2.core.n1160713.contacts.domain.Contact;
import pt.isep.nsheets.shared.services.NotesService;
import pt.isep.nsheets.server.lapr4.red.s1.core.n1160634.notes.application.AddNoteController;
import pt.isep.nsheets.server.lapr4.red.s1.core.n1160634.notes.application.ListNoteController;
import pt.isep.nsheets.server.lapr4.red.s1.core.n1160634.notes.domain.Note;
import pt.isep.nsheets.server.lapr4.white.s1.core.n4567890.workbooks.persistence.PersistenceContext;
import pt.isep.nsheets.server.lapr4.white.s1.core.n4567890.workbooks.persistence.PersistenceSettings;
import pt.isep.nsheets.shared.services.ContactDTO;
import pt.isep.nsheets.shared.services.ContactsService;
import pt.isep.nsheets.shared.services.DataException;
import pt.isep.nsheets.shared.services.NoteDTO;

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
    public ArrayList<ContactDTO> getContacts() {
        // Setup the persistence settings
        PersistenceContext.setSettings(this.getPersistenceSettings());
        
        ArrayList<ContactDTO> contacts = new ArrayList<>();
        
        ListContactsController ctrl = new ListContactsController();
        
        Iterable<Contact> contactsAux = ctrl.listContacts();
        
        contactsAux.forEach(n -> contacts.add(n.toDTO()));
        
        return contacts;
    }

    @Override
    public ContactDTO addContact(ContactDTO contactDTO) throws DataException {
        // Setup the persistence settings
        PersistenceContext.setSettings(this.getPersistenceSettings());
        
        AddContactController ctrl = new AddContactController();
        
        Contact contact = null;        
        
        try {
            contact = ctrl.addContact(contactDTO);
        } catch (DataConcurrencyException | DataIntegrityViolationException ex) {
            throw new DataException((Throwable) ex);
        }
        
        return contact.toDTO();
    }

}
