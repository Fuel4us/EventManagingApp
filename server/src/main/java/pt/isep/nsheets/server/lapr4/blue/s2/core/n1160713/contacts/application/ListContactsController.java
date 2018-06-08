package pt.isep.nsheets.server.lapr4.blue.s2.core.n1160713.contacts.application;

import eapli.framework.application.Controller;
import pt.isep.nsheets.server.lapr4.blue.s2.core.n1160713.contacts.domain.Contact;

public class ListContactsController implements Controller {

    /**
     *
     * @return
     */
    public Iterable<Contact> listContacts() {
        return new ContactsService().allContacts();
    }
}
