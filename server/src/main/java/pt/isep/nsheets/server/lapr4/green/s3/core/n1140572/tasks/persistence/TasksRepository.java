/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package pt.isep.nsheets.server.lapr4.green.s3.core.n1140572.tasks.persistence;

import eapli.framework.persistence.repositories.Repository;
import pt.isep.nsheets.server.lapr4.green.s3.core.n1140572.tasks.domain.Tasks;

/**
 *
 * @author Pedro Rodrigues - (1140572)
 */
public interface TasksRepository extends Repository<Tasks, Long> {

    /**
     *
     * @param name
     * @return
     */
    Tasks findByName(String name);

    /**
     *
     * @param task
     * @return 
     */
    Tasks deleteTask(Tasks task);
    
    Iterable <Tasks> findByAnyAttribute(String name);

}
