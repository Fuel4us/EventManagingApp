package pt.isep.nsheets.server.lapr4.blue.n1050475.s3.application;

import eapli.framework.application.Controller;
import eapli.framework.persistence.DataConcurrencyException;
import eapli.framework.persistence.DataIntegrityViolationException;
import pt.isep.nsheets.server.lapr4.green.s1.core.n1160557.users.domain.User;
import pt.isep.nsheets.server.lapr4.green.s1.core.n1160557.users.persistence.UserRepository;
import pt.isep.nsheets.server.lapr4.white.s1.core.n4567890.workbooks.persistence.PersistenceContext;
import pt.isep.nsheets.shared.services.UserDTO;

public class EditProfileController implements Controller {
    public EditProfileController() {
    }

    public UserDTO editProfile(UserDTO userDTO) throws DataConcurrencyException, DataIntegrityViolationException {

        final UserRepository userRepository = PersistenceContext.repositories().users();

        User user = userRepository.findByEmail(userDTO.getEmail());

        userRepository.removeUser(user);

        User newUser = User.fromDTOHashPassword(userDTO); //comparar old passowrd com nova password
        //newUser.logout();

        return userRepository.save(newUser).toDTO();
    }

    public void deleteProfile(String email) {

        final UserRepository userRepository = PersistenceContext.repositories().users();

        User user = userRepository.findByEmail(email);

        userRepository.removeUser(user);
    }
}
