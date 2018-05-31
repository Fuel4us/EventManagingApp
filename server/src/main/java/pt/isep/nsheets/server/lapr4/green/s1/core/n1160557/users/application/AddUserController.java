package pt.isep.nsheets.server.lapr4.green.s1.core.n1160557.users.application;

import pt.isep.nsheets.server.lapr4.white.s1.core.n4567890.workbooks.application.*;
import eapli.framework.application.Controller;
import eapli.framework.persistence.DataConcurrencyException;
import eapli.framework.persistence.DataIntegrityViolationException;
import pt.isep.nsheets.server.lapr4.green.s1.core.n1160557.users.domain.User;
import pt.isep.nsheets.server.lapr4.white.s1.core.n4567890.workbooks.domain.WorkbookDescription;
import pt.isep.nsheets.shared.services.UserDTO;
import pt.isep.nsheets.shared.services.WorkbookDescriptionDTO;

public class AddUserController implements Controller {

    public User addUser(UserDTO dto) throws DataConcurrencyException, DataIntegrityViolationException {
        
    	return new UserService().addUser(dto);
    }
}
