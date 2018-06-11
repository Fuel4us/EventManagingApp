package pt.isep.nsheets.server.lapr4.green.s1.core.n1160557.users.application;

import java.util.Arrays;
import java.util.List;
import pt.isep.nsheets.server.lapr4.green.s1.core.n1160557.users.domain.User;
import pt.isep.nsheets.shared.services.UserDTO;

/**
 *
 * @author Hilario Coelho, Pedro Vieira
 */
public class LoginUserController {

    private List<User> users = Arrays.asList(
            new User("1160557@isep.ipp.pt", "Hilário", "coelho98", "123Asd", true),
            new User("1160634@isep.ipp.pt", "Pedro", "vieira98", "123Asd", false),
            new User("1161140@isep.ipp.pt", "Gonçalo", "silva97", "123Asd", false),
            new User("1160630@isep.ipp.pt", "José Pedro", "monteiro98", "123Asd", false),
            new User("1160600@isep.ipp.pt", "João", "reis98", "123Asd", false),
            new User("1160629@isep.ipp.pt", "José Pedro", "espirito_santo97", "123Asd", false)
    );

    public LoginUserController() {
    }

    public UserDTO attemptLogin(String email, String password) {
        for (User u : users) {
            if (u.getEmail().equals(email) && u.verifyPassword(password)) {
                return u.toDTO();
            }
        }
        return null;
    }
}
