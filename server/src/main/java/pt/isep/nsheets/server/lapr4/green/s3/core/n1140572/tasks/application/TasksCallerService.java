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
import pt.isep.nsheets.shared.services.DataException;
import pt.isep.nsheets.shared.services.TasksDTO;

/**
 *
 * @author Pedro Rodrigues - (1140572)
 */
public class TasksCallerService {

    public Tasks findByName(String name) throws DataException {
        final TasksRepository tasksRepository = PersistenceContext.repositories().tasks();

        return tasksRepository.findByName(name);
    }

    public Tasks deleteTask(Tasks tasks) {
        final TasksRepository tasksRepository = PersistenceContext.repositories().tasks();
        tasksRepository.deleteTask(tasks);

        return tasks;
    }

    public Iterable<Tasks> listTasksNotCompleted(String user) {
        final TasksRepository tasksRepository = PersistenceContext.repositories().tasks();

        return tasksRepository.findTasksNotCompleted(user);
    }

    public Tasks addTask(TasksDTO tasksDTO) throws DataConcurrencyException, DataIntegrityViolationException {
        final TasksRepository tasksRepository = PersistenceContext.repositories().tasks();

        Tasks task = Tasks.fromDTO(tasksDTO);
        tasksRepository.save(task);
        return task;
    }

    public Iterable<Tasks> searchTasks(String name) {
        final TasksRepository tasksRepository = PersistenceContext.repositories().tasks();

        return tasksRepository.findByAnyAttribute(name);
    }

    public Tasks editTask(Tasks tasks) throws DataConcurrencyException, DataIntegrityViolationException {
        final TasksRepository tasksRepository = PersistenceContext.repositories().tasks();

        tasksRepository.save(tasks);
        return tasks;
    }

}
