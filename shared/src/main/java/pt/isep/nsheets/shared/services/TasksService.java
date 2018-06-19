/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package pt.isep.nsheets.shared.services;

import com.google.gwt.user.client.rpc.RemoteService;
import com.google.gwt.user.client.rpc.RemoteServiceRelativePath;

/**
 *
 * @author Pedro Rodrigues - (1140572)
 */
@RemoteServiceRelativePath("tasksService")
public interface TasksService extends RemoteService {
    
    TasksDTO findByName(String name);
    
    Iterable<TasksDTO> searchTasks(String name);

    Iterable<TasksDTO> listTasksNotCompleted(String user);

    TasksDTO addTask(TasksDTO tasksDTO);

    TasksDTO deleteTask(TasksDTO tasksDTO);
    
    TasksDTO editTask(TasksDTO tasksDTO);

}
