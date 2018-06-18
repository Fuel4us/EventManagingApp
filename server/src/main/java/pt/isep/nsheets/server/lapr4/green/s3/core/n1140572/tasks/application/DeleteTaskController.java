/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package pt.isep.nsheets.server.lapr4.green.s3.core.n1140572.tasks.application;

import eapli.framework.application.Controller;
import eapli.framework.persistence.DataConcurrencyException;
import eapli.framework.persistence.DataIntegrityViolationException;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.persistence.TransactionRequiredException;
import pt.isep.nsheets.server.lapr4.green.s3.core.n1140572.tasks.domain.Tasks;
import pt.isep.nsheets.server.lapr4.green.s3.core.n1140572.tasks.persistence.TasksRepository;
import pt.isep.nsheets.server.lapr4.white.s1.core.n4567890.workbooks.persistence.PersistenceContext;
import pt.isep.nsheets.shared.services.TasksDTO;

/**
 *
 * @author Pedro Rodrigues - (1140572)
 */
public class DeleteTaskController implements Controller {

    TasksRepository repo = PersistenceContext.repositories().tasks();

    public Tasks findByName(String name) throws DataConcurrencyException, DataIntegrityViolationException {
        return new TasksCallerService().findByName(name);
    }

    public void deleteWorkbook(TasksDTO taskDTO) {
        Tasks task = repo.findByName(taskDTO.getName());
        try {
            repo.deleteTask(task);
        } catch (TransactionRequiredException ex) {
            Logger.getLogger(DeleteTaskController.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

}
