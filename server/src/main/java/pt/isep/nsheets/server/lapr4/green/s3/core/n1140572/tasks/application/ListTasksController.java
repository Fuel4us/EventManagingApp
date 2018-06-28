/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package pt.isep.nsheets.server.lapr4.green.s3.core.n1140572.tasks.application;

import eapli.framework.application.Controller;
import pt.isep.nsheets.server.lapr4.green.s3.core.n1140572.tasks.domain.Tasks;

/**
 *
 * @author Pedro Rodrigues
 */
public class ListTasksController implements Controller {

    public Iterable<Tasks> listTasks(String name) {
        return new TasksCallerService().listTasksNotCompleted(name);
    }

}
