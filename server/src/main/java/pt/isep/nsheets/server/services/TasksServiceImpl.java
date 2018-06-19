/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package pt.isep.nsheets.server.services;

import com.google.gwt.user.server.rpc.RemoteServiceServlet;
import eapli.framework.persistence.DataConcurrencyException;
import eapli.framework.persistence.DataIntegrityViolationException;
import java.util.Properties;
import java.util.logging.Level;
import java.util.logging.Logger;
import pt.isep.nsheets.server.lapr4.green.s3.core.n1140572.tasks.application.DeleteTaskController;
import pt.isep.nsheets.server.lapr4.green.s3.core.n1140572.tasks.application.EditTaskController;
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
    public TasksDTO findByName(String name) throws DataException {
        PersistenceContext.setSettings(this.getPersistenceSettings());

        EditTaskController ctrl = new EditTaskController();

        Tasks task = null;

        try {
            task = ctrl.findByName(name);
        } catch (DataConcurrencyException | DataIntegrityViolationException e) {
            throw new DataException((Throwable) e);
        }

        return task.toDTO();
    }

    @Override
    public void deleteTask(String name) {
        PersistenceContext.setSettings(this.getPersistenceSettings());

        DeleteTaskController ctrl = new DeleteTaskController();

        Tasks task = null;
        try {
            task = ctrl.findByName(name);
            ctrl.deleteWorkbook(task.toDTO());
        } catch (DataConcurrencyException | DataIntegrityViolationException ex) {
            Logger.getLogger(TasksServiceImpl.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

}
