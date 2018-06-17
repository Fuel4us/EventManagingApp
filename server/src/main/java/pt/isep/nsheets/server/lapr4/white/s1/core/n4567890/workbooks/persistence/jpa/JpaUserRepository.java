package pt.isep.nsheets.server.lapr4.white.s1.core.n4567890.workbooks.persistence.jpa;

import java.util.HashMap;
import java.util.Map;

import eapli.framework.persistence.DataConcurrencyException;
import eapli.framework.persistence.DataIntegrityViolationException;
import pt.isep.nsheets.server.lapr4.green.s1.core.n1160557.users.domain.User;
import pt.isep.nsheets.server.lapr4.green.s1.core.n1160557.users.persistence.UserRepository;
import pt.isep.nsheets.server.lapr4.white.s1.core.n4567890.workbooks.persistence.PersistenceSettings;

public class JpaUserRepository extends NSheetsJpaRepositoryBase<User, Long> implements UserRepository {

    JpaUserRepository(PersistenceSettings settings) {
        super(settings);
    }

    @Override
    public User findByEmail(String email) {
        final Map<String, Object> params = new HashMap<>();
        params.put("email", email);

        return matchOne("e.email=:email", params);
    }

    @Override
    public User findByUsername(String nickname) {
        final Map<String, Object> params = new HashMap<>();
        params.put("nickname", nickname);

        return matchOne("e.nickname=:nickname", params);
    }

    @Override
    public void removeUser(User user) {
        this.entityManager().getTransaction().begin();
        entityManager().createQuery("delete from User u where u.email=:useremail")
                .setParameter("useremail", user.getEmail())
                .executeUpdate();
        this.entityManager().getTransaction().commit();
    }

    public User updateUser(User user, User newUser) throws DataConcurrencyException, DataIntegrityViolationException {
        this.entityManager().getTransaction().begin();
        entityManager().createQuery("delete from User u where u.email=:useremail")
                .setParameter("useremail", user.getEmail())
                .executeUpdate();
        this.entityManager().getTransaction().commit();
        return this.save(newUser);
    }
}
