/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package pt.isep.nsheets.server.lapr4.green.s3.core.n1140572.tasks.application;

import eapli.framework.persistence.DataConcurrencyException;
import eapli.framework.persistence.DataIntegrityViolationException;
import pt.isep.nsheets.server.lapr4.green.s3.core.n1140572.tasks.domain.Tasks;
import pt.isep.nsheets.server.lapr4.green.s3.core.n1140572.tasks.persistence.TasksRepository;
import pt.isep.nsheets.server.lapr4.white.s1.core.n4567890.workbooks.persistence.PersistenceContext;

/**
 *
 * @author Pedro Rodrigues
 */
public class TasksCallerService {

    public Tasks findByName(String name) throws DataConcurrencyException, DataIntegrityViolationException {
        final TasksRepository tasksRepository = PersistenceContext.repositories().tasks();

        return tasksRepository.findByName(name);
    }
}
