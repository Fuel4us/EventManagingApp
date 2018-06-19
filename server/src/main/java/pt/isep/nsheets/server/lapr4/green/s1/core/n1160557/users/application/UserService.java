package pt.isep.nsheets.server.lapr4.green.s1.core.n1160557.users.application;

import eapli.framework.persistence.DataConcurrencyException;
import eapli.framework.persistence.DataIntegrityViolationException;
import pt.isep.nsheets.server.lapr4.green.s1.core.n1160557.users.domain.User;
import pt.isep.nsheets.server.lapr4.green.s1.core.n1160557.users.persistence.UserRepository;
import pt.isep.nsheets.server.lapr4.white.s1.core.n4567890.workbooks.persistence.PersistenceContext;
import pt.isep.nsheets.shared.services.UserDTO;

public class UserService {

    public Iterable<User> allUsers() {

        final UserRepository userRepository = PersistenceContext.repositories().users();
        return userRepository.findAll();
    }

    public User addUser(UserDTO dto) throws DataConcurrencyException, DataIntegrityViolationException {

        final UserRepository userRepository = PersistenceContext.repositories().users();

        User wb = User.fromDTO(dto);
        userRepository.save(wb);

        return wb;
    }

    public User findByName(String name) {
        final UserRepository userRepository = PersistenceContext.repositories().users();

        return userRepository.findByUsername(name);
    }

}
