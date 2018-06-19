package pt.isep.nsheets.server.lapr4.blue.n1050475.s3.application;

import eapli.framework.application.Controller;
import eapli.framework.persistence.DataConcurrencyException;
import eapli.framework.persistence.DataIntegrityViolationException;
import jdk.jfr.events.ThrowablesEvent;
import org.apache.commons.codec.digest.DigestUtils;
import pt.isep.nsheets.server.lapr4.green.s1.core.n1160557.users.domain.User;
import pt.isep.nsheets.server.lapr4.green.s1.core.n1160557.users.persistence.UserRepository;
import pt.isep.nsheets.server.lapr4.white.s1.core.n4567890.workbooks.persistence.PersistenceContext;
import pt.isep.nsheets.shared.services.UserDTO;

public class EditProfileController implements Controller {
    public EditProfileController() {
    }

    public UserDTO editProfile(UserDTO userDTO,String oldPassword, boolean passwordChanged) throws DataConcurrencyException, DataIntegrityViolationException {
        final UserRepository userRepository = PersistenceContext.repositories().users();

        User user = userRepository.findByEmail(userDTO.getEmail());

        User newUser;
        if(passwordChanged){
            if(user.verifyPassword(DigestUtils.sha256Hex(oldPassword))){
                userRepository.removeUser(user);
                newUser = User.fromDTOHashPassword(userDTO);
            }else{
                return null;
            }
        }else{
            userRepository.removeUser(user);
            newUser = User.fromDTO(userDTO);
        }

        return userRepository.save(newUser).toDTO();
    }

    public boolean deleteProfile(String email) {

        final UserRepository userRepository = PersistenceContext.repositories().users();

        User user = userRepository.findByEmail(email);

        userRepository.removeUser(user);

        return true;
    }

    public boolean changeState(String email, boolean state, String superUserEmail, String superUserPassword) throws DataConcurrencyException, DataIntegrityViolationException {
        final UserRepository userRepository = PersistenceContext.repositories().users();

        User superUser = userRepository.findByEmail(superUserEmail);

        if(superUser.verifyPassword(DigestUtils.sha256Hex(superUserPassword)) || superUser.verifyPassword(superUserPassword)){
            User userChanging = userRepository.findByEmail(email);
            if(state){
                userChanging.activate();
            }else{
                userChanging.deactivate();
            }

            User user = userRepository.save(userChanging);
            return user.isActivated();
        }

        return false;
    }

    public UserDTO changePassword(String email, String oldPassword, String newPassword) throws DataConcurrencyException, DataIntegrityViolationException {
        final UserRepository userRepository = PersistenceContext.repositories().users();

        User superUser = userRepository.findByEmail(email);

        if(superUser.verifyPassword(DigestUtils.sha256Hex(oldPassword)) || superUser.verifyPassword(oldPassword)){
            User userChanging = userRepository.findByEmail(email);
            userChanging.setPassword(DigestUtils.sha256Hex(newPassword));

            User user = userRepository.save(userChanging);
            return user.toDTO();
        }

        return null;
    }

    public UserDTO editUser(String email, String name, String nickname, String url) throws DataConcurrencyException, DataIntegrityViolationException {
        final UserRepository userRepository = PersistenceContext.repositories().users();

        User user = userRepository.findByEmail(email);

        user.setName(name);
        user.setNickname(nickname);
        user.setPictureName(url);

        User newUser = userRepository.save(user);
        return newUser.toDTO();
    }
}
