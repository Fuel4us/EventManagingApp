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

    TasksDTO findByName(String name) throws DataException;
    
    void deleteTask(String name);
}
