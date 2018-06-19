/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package pt.isep.nsheets.server.lapr4.green.s3.core.n1140572.tasks.application;

import eapli.framework.application.Controller;
import pt.isep.nsheets.server.lapr4.green.s1.core.n1160557.users.application.UserService;
import pt.isep.nsheets.server.lapr4.green.s1.core.n1160557.users.domain.User;
import pt.isep.nsheets.server.lapr4.green.s3.core.n1140572.tasks.domain.Tasks;

/**
 *
 * @author Pedro Rodrigues - (1140572)
 */
public class SearchTasksController implements Controller {

    public User getCurrentUser(String name) {
        return new UserService().findByName(name);
    }

    public Iterable<Tasks> getTasks() {
        return null;
    }

}
