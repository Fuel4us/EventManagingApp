package pt.isep.nsheets.server.lapr4.green.s1.core.n1160557.users.application;

import eapli.framework.application.Controller;
import eapli.framework.persistence.DataConcurrencyException;
import eapli.framework.persistence.DataIntegrityViolationException;
import pt.isep.nsheets.server.lapr4.green.s1.core.n1160557.users.domain.User;
import pt.isep.nsheets.shared.services.UserDTO;

public class AddUserController implements Controller {

    public User addUser(UserDTO dto) throws DataConcurrencyException, DataIntegrityViolationException {
        
    	return new UserService().addUser(dto);
    }
}
