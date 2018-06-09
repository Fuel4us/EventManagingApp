package pt.isep.nsheets.server.lapr4.white.s1.core.n4567890.workbooks.persistence.jpa;

import java.util.HashMap;
import java.util.Map;
import pt.isep.nsheets.server.lapr4.blue.s2.core.n1160713.contacts.domain.Contact;
import pt.isep.nsheets.server.lapr4.blue.s2.core.n1160713.contacts.persistence.ContactsRepository;
import pt.isep.nsheets.server.lapr4.white.s1.core.n4567890.workbooks.persistence.PersistenceSettings;
import pt.isep.nsheets.shared.services.UserDTO;

public class JpaContactsRepository extends NSheetsJpaRepositoryBase<Contact, Long> implements ContactsRepository {

    JpaContactsRepository(PersistenceSettings settings) {
        super(settings);
    }

    @Override
    public Iterable<Contact> findAllFromUser(UserDTO user) {
        final Map<String, Object> params = new HashMap<>();
        params.put("user", user);

        return match("e.contactOwner =: user", params);
    }

}
