package pt.isep.nsheets.server.lapr4.white.s1.core.n4567890.workbooks.persistence.jpa;

import java.util.HashMap;
import java.util.Map;
import pt.isep.nsheets.server.lapr4.blue.s2.core.n1160713.contacts.domain.Contact;
import pt.isep.nsheets.server.lapr4.blue.s2.core.n1160713.contacts.persistence.ContactsRepository;
import pt.isep.nsheets.server.lapr4.white.s1.core.n4567890.workbooks.persistence.PersistenceSettings;

public class JpaContactsRepository extends NSheetsJpaRepositoryBase<Contact, Long> implements ContactsRepository {

    JpaContactsRepository(PersistenceSettings settings) {
        super(settings);
    }

    @Override
    public Iterable<Contact> findAllFromUser(String email) {
        final Map<String, Object> params = new HashMap<>();
        params.put("email", email);

        return match("e.contactOwnerEmail=:email", params);
    }

    @Override
    public Contact findContactFromDTO(String contactEmail, String contactOwnerEmail) {
        final Map<String, Object> params = new HashMap<>();
        params.put("contactEmail", contactEmail);
        params.put("contactOwnerEmail", contactOwnerEmail);

        return matchOne("e.contactEmail=:contactEmail and e.contactOwnerEmail=:contactOwnerEmail", params);
    }

    @Override
    public void removeContact(String contactEmail, String contactOwnerEmail) {
        entityManager().getTransaction().begin();
        entityManager().createQuery("delete from Contact c where c.contactEmail=:contactEmail and c.contactOwnerEmail=:contactOwnerEmail")
                .setParameter("contactEmail", contactEmail)
                .setParameter("contactOwnerEmail", contactOwnerEmail)
                .executeUpdate();
        entityManager().getTransaction().commit();
    }
}
