package pt.isep.nsheets.server.lapr4.blue.s2.core.n1160713.contacts.persistence;

import eapli.framework.persistence.repositories.Repository;
import pt.isep.nsheets.server.lapr4.blue.s2.core.n1160713.contacts.domain.Contact;

public interface ContactsRepository extends Repository<Contact, Long> {

    public Iterable<Contact> findAllFromUser(String email);

    public Contact findContactFromDTO(String contactEmail, String contactOwnerEmail);
    
    public void removeContact(String contactEmail, String contactOwnerEmail);
}
