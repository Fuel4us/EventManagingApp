/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package pt.isep.nsheets.server.services;

import com.google.gwt.user.server.rpc.RemoteServiceServlet;
import eapli.framework.persistence.DataConcurrencyException;
import eapli.framework.persistence.DataIntegrityViolationException;
import java.util.ArrayList;
import java.util.Properties;
import java.util.logging.Level;
import java.util.logging.Logger;
import pt.isep.nsheets.server.lapr4.green.s3.core.n1140572.tasks.application.AddTaskController;
import pt.isep.nsheets.server.lapr4.green.s3.core.n1140572.tasks.application.DeleteTaskController;
import pt.isep.nsheets.server.lapr4.green.s3.core.n1140572.tasks.application.EditTaskController;
import pt.isep.nsheets.server.lapr4.green.s3.core.n1140572.tasks.application.ListTasksController;
import pt.isep.nsheets.server.lapr4.green.s3.core.n1140572.tasks.application.SearchTasksController;
import pt.isep.nsheets.server.lapr4.green.s3.core.n1140572.tasks.domain.Tasks;
import pt.isep.nsheets.server.lapr4.white.s1.core.n4567890.workbooks.persistence.PersistenceContext;
import pt.isep.nsheets.server.lapr4.white.s1.core.n4567890.workbooks.persistence.PersistenceSettings;
import pt.isep.nsheets.shared.services.DataException;
import pt.isep.nsheets.shared.services.TasksDTO;
import pt.isep.nsheets.shared.services.TasksService;

/**
 *
 * @author Pedro Rodrigues - (1140572)
 */
public class TasksServiceImpl extends RemoteServiceServlet implements TasksService {
    
    private PersistenceSettings getPersistenceSettings() {
        
        Properties props = new Properties();
        
        props.put("persistence.repositoryFactory",
                "pt.isep.nsheets.server.lapr4.white.s1.core.n4567890.workbooks.persistence.jpa.JpaRepositoryFactory");
        props.put("persistence.persistenceUnit", "lapr4.NSheetsPU");
        
        return new PersistenceSettings(props);
    }
    
    @Override
    public void deleteTask(TasksDTO tasksDTO) {
        PersistenceContext.setSettings(this.getPersistenceSettings());
        
        DeleteTaskController ctrl = new DeleteTaskController();
        
        Tasks task = null;
        try {
            task = ctrl.deleteTask(tasksDTO);
        } catch (DataException ex) {
            Logger.getLogger(TasksServiceImpl.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    
    @Override
    public Iterable<TasksDTO> listTasksNotCompleted(String user) {
        PersistenceContext.setSettings(this.getPersistenceSettings());
        
        ArrayList<TasksDTO> task = new ArrayList<>();
        ListTasksController ctrl = new ListTasksController();
        
        Iterable<Tasks> tasks = ctrl.listTasks(user);
        
        tasks.forEach(aux -> task.add(aux.toDTO()));
        
        return task;
    }
    
    @Override
    public TasksDTO addTask(TasksDTO tasksDTO) {
        // Setup the persistence settings
        PersistenceContext.setSettings(this.getPersistenceSettings());
        
        AddTaskController ctrl = new AddTaskController();
        
        Tasks task = null;
        
        try {
            task = ctrl.addTask(tasksDTO);
        } catch (DataConcurrencyException | DataIntegrityViolationException ex) {
            Logger.getLogger(TasksServiceImpl.class.getName()).log(Level.SEVERE, null, ex);
        }
        
        return task.toDTO();
    }
    
    @Override
    public Iterable<TasksDTO> searchTasks(String name) {
        PersistenceContext.setSettings(this.getPersistenceSettings());
        SearchTasksController ctrl = new SearchTasksController();
        ArrayList<TasksDTO> tasksDTO = new ArrayList<>();
        Iterable<Tasks> tasks = ctrl.getTasks(name);
        
        tasks.forEach(aux -> tasksDTO.add(aux.toDTO()));
        
        return tasksDTO;
    }
    
    @Override
    public TasksDTO findByName(String name) {
        PersistenceContext.setSettings(this.getPersistenceSettings());
        
        EditTaskController ctrl = new EditTaskController();
        
        Tasks task = null;
        try {
            task = ctrl.findByName(name);
        } catch (DataConcurrencyException | DataIntegrityViolationException | DataException ex) {
            Logger.getLogger(TasksServiceImpl.class.getName()).log(Level.SEVERE, null, ex);
        }
        return task.toDTO();
    }
    
    @Override
    public TasksDTO editTask(String name, String description, String priority, String progress, TasksDTO tasksDTO) {
        PersistenceContext.setSettings(this.getPersistenceSettings());
        
        EditTaskController ctrl = new EditTaskController();
        Tasks task = null;
        
        try {
            task = ctrl.findByName(tasksDTO.name);
            task.setName(name);
            task.setDescription(description);
            if (Integer.parseInt(priority) > 5 || Integer.parseInt(progress) < 0) {
                task.setPriorityLevel(tasksDTO.priorityLevel);
            } else {
                task.setPriorityLevel(priority);
            }
            if (Integer.parseInt(progress) > 100 || Integer.parseInt(progress) < 0) {
                task.setProgress(tasksDTO.progress);
            } else {
                task.setProgress(progress);
            }
            if (progress.equals("100")) {
                task.setTaskCompleted(true);
            }
            ctrl.editTask(task);
        } catch (DataConcurrencyException | DataIntegrityViolationException | DataException ex) {
            Logger.getLogger(TasksServiceImpl.class.getName()).log(Level.SEVERE, null, ex);
        }
        return task.toDTO();
    }
    
}
