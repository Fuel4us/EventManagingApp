package pt.isep.nsheets.server.lapr4.red.s2.ipc.n1161292.users.application;

import eapli.framework.persistence.DataConcurrencyException;
import eapli.framework.persistence.DataIntegrityViolationException;
import pt.isep.nsheets.server.lapr4.green.s1.core.n1160557.users.domain.User;
import pt.isep.nsheets.server.lapr4.red.s2.ipc.n1161292.services.SignupService;
import pt.isep.nsheets.shared.services.UserDTO;

/**
 *
 * @author Tiago João Santos Rios, 1161292@isep.ipp.pt
 */
public class SignupController {
    
    public User signupUser(UserDTO dto) throws DataConcurrencyException, DataIntegrityViolationException {
        return new SignupService().signupUser(dto);
    }
    
}
