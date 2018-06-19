/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package pt.isep.nsheets.shared.services;

import com.google.gwt.user.client.rpc.AsyncCallback;
import java.util.ArrayList;

/**
 *
 * @author Pedro Rodrigues - (1140572)
 */
public interface TasksServiceAsync {

    void findByName(String name, AsyncCallback<TasksDTO> callback);

    void searchTasks(String name, AsyncCallback<ArrayList<TasksDTO>> callback);

    void listTasksNotCompleted(String user, AsyncCallback<ArrayList<TasksDTO>> callback);

    void addTask(TasksDTO tasksDTO, AsyncCallback<TasksDTO> callback);

    void deleteTask(TasksDTO tasksDTO, AsyncCallback<TasksDTO> callback);
}
