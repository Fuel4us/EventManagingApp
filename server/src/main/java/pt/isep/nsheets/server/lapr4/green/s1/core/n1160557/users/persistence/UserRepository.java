package pt.isep.nsheets.server.lapr4.green.s1.core.n1160557.users.persistence;

import eapli.framework.persistence.DataConcurrencyException;
import eapli.framework.persistence.DataIntegrityViolationException;
import eapli.framework.persistence.repositories.Repository;
import pt.isep.nsheets.server.lapr4.green.s1.core.n1160557.users.domain.User;

public interface UserRepository extends Repository<User, Long> {

    public User findByEmail(String email);

    public User findByUsername(String nickname);

    public void removeUser(User user);

    public User updateUser(User user, User newUser) throws DataConcurrencyException, DataIntegrityViolationException;
}
