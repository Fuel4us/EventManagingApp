package pt.isep.nsheets.server.lapr4.white.s1.core.n4567890.workbooks.persistence.jpa;

import pt.isep.nsheets.server.lapr4.blue.s2.core.n1160713.contacts.domain.Contact;
import pt.isep.nsheets.server.lapr4.blue.s2.core.n1160713.contacts.persistence.ContactsRepository;
import pt.isep.nsheets.server.lapr4.white.s1.core.n4567890.workbooks.persistence.PersistenceSettings;

public class JpaContactsRepository extends NSheetsJpaRepositoryBase<Contact, Long> implements ContactsRepository {

    JpaContactsRepository(PersistenceSettings settings) {
        super(settings);
    }

}
