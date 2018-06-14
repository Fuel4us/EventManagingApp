package pt.isep.nsheets.server.lapr4.red.s2.ipc.n1161292.services;

import eapli.framework.persistence.DataConcurrencyException;
import eapli.framework.persistence.DataIntegrityViolationException;
import pt.isep.nsheets.server.lapr4.green.s1.core.n1160557.users.domain.User;
import pt.isep.nsheets.server.lapr4.green.s1.core.n1160557.users.persistence.UserRepository;
import pt.isep.nsheets.server.lapr4.white.s1.core.n4567890.workbooks.persistence.PersistenceContext;
import pt.isep.nsheets.shared.services.UserDTO;

/**
 *
 * @author Tiago João Santos Rios, 1161292@isep.ipp.pt
 */
public class SignupService {

    public User signupUser(UserDTO dto) throws DataConcurrencyException, DataIntegrityViolationException {
        final UserRepository userRepository = PersistenceContext.repositories().users();

        User newUser = User.fromDTOHashPassword(dto);
        newUser.logout();

        return userRepository.save(newUser);
    }

}
