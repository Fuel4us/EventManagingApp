/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package pt.isep.nsheets.server.lapr4.green.s3.core.n1140572.tasks.application;

import eapli.framework.application.Controller;
import eapli.framework.persistence.DataConcurrencyException;
import eapli.framework.persistence.DataIntegrityViolationException;
import pt.isep.nsheets.server.lapr4.green.s3.core.n1140572.tasks.domain.Tasks;
import pt.isep.nsheets.shared.services.DataException;
import pt.isep.nsheets.shared.services.TasksDTO;

/**
 *
 * @author Pedro Rodrigues - (1140572)
 */
public class EditTaskController implements Controller {

    public Tasks editTask(TasksDTO dto) throws DataConcurrencyException, DataIntegrityViolationException {
        return new TasksCallerService().addTask(dto);
    }

    public Tasks findByName(String name) throws DataConcurrencyException, DataIntegrityViolationException, DataException {
        return new TasksCallerService().findByName(name);
    }

}
