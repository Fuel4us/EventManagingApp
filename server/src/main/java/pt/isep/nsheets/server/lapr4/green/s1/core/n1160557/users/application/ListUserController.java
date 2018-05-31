package pt.isep.nsheets.server.lapr4.green.s1.core.n1160557.users.application;

import eapli.framework.application.Controller;
import pt.isep.nsheets.server.lapr4.green.s1.core.n1160557.users.domain.User;

public class ListUserController implements Controller {

    public Iterable<User> listUsers() {
        return new UserService().allUsers();
    }
}
