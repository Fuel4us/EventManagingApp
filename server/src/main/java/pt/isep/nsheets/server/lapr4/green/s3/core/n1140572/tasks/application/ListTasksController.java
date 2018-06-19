/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package pt.isep.nsheets.server.lapr4.green.s3.core.n1140572.tasks.application;

import eapli.framework.application.Controller;
import java.util.ArrayList;
import java.util.Iterator;
import pt.isep.nsheets.server.lapr4.green.s1.core.n1160557.users.application.UserService;
import pt.isep.nsheets.server.lapr4.green.s1.core.n1160557.users.domain.User;
import pt.isep.nsheets.server.lapr4.green.s3.core.n1140572.tasks.domain.Tasks;

/**
 *
 * @author Pedro Rodrigues
 */
public class ListTasksController implements Controller {

    public Iterable<Tasks> listTasks(String name) {
        Iterable<Tasks> tasks = new TasksCallerService().listTasksNotCompleted(name);
        User user = new UserService().findByName(name);

        Iterator it = tasks.iterator();
        while (it.hasNext()) {
            boolean flag = false;
            Tasks task = (Tasks) it.next();
            if (task.isTaskCompleted()) {
                it.remove();
            }
//            for (Contact contact : task.getContacts()) {
//                if (contact.getContactOwnerEmail().equals(user.getEmail())) {
//                    flag = true;
//                }
//            }
//            if (flag = true) {
//                it.remove();
//            }
        }

        return tasks;
    }

}
