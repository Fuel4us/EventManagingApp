package pt.isep.nsheets.server.lapr4.blue.s2.core.n1160713.contacts.persistence;

import eapli.framework.persistence.repositories.Repository;
import pt.isep.nsheets.server.lapr4.blue.s2.core.n1160713.contacts.domain.Contact;
import pt.isep.nsheets.shared.services.ContactDTO;
import pt.isep.nsheets.shared.services.UserDTO;

public interface ContactsRepository extends Repository<Contact, Long> {

    public Iterable<Contact> findAllFromUser(UserDTO user);

    public Contact findContactFromDTO(ContactDTO contact);
}
