package pt.isep.nsheets.server.lapr4.blue.s2.core.n1160713.contacts.application;

import eapli.framework.persistence.DataConcurrencyException;
import eapli.framework.persistence.DataIntegrityViolationException;
import pt.isep.nsheets.server.lapr4.blue.s2.core.n1160713.contacts.domain.Contact;
import pt.isep.nsheets.server.lapr4.blue.s2.core.n1160713.contacts.persistence.ContactsRepository;
import pt.isep.nsheets.server.lapr4.white.s1.core.n4567890.workbooks.persistence.PersistenceContext;
import pt.isep.nsheets.shared.services.ContactDTO;

public class ContactsService {

    /**
     *
     * @return
     */
    public Iterable<Contact> allContacts() {

        final ContactsRepository contactsRepository = PersistenceContext.repositories().contacts();
        return contactsRepository.findAll();
    }

    /**
     *
     * @param contactDTO
     * @return
     * @throws DataConcurrencyException
     * @throws DataIntegrityViolationException
     */
    public Contact addContact(ContactDTO contactDTO) throws DataConcurrencyException, DataIntegrityViolationException {

        final ContactsRepository contactsRepository = PersistenceContext.repositories().contacts();

        Contact contact = Contact.fromDTO(contactDTO);
        contactsRepository.save(contact);

        return contact;
    }

}
