package pt.isep.nsheets.server.lapr4.blue.s2.core.n1160713.contacts.application;

import eapli.framework.application.Controller;
import eapli.framework.persistence.DataConcurrencyException;
import eapli.framework.persistence.DataIntegrityViolationException;
import pt.isep.nsheets.server.lapr4.blue.s2.core.n1160713.contacts.domain.Contact;
import pt.isep.nsheets.shared.services.ContactDTO;


public class AddContactController implements Controller {

    /**
     *
     * @param contactDTO
     * @return
     * @throws DataConcurrencyException
     * @throws DataIntegrityViolationException
     */
    public Contact addContact(ContactDTO contactDTO) throws DataConcurrencyException, DataIntegrityViolationException {

        return new ContactsService().addContact(contactDTO);
    }
}
