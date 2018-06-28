/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package pt.isep.nsheets.server.lapr4.white.s1.core.n4567890.workbooks.persistence.jpa;

import java.util.HashMap;
import java.util.Map;
import pt.isep.nsheets.server.lapr4.green.s3.core.n1140572.tasks.domain.Tasks;
import pt.isep.nsheets.server.lapr4.green.s3.core.n1140572.tasks.persistence.TasksRepository;
import pt.isep.nsheets.server.lapr4.white.s1.core.n4567890.workbooks.persistence.PersistenceSettings;

/**
 *
 * @author Pedro Rodrigues - (1140572)
 */
public class JpaTasksRepository extends NSheetsJpaRepositoryBase<Tasks, Long> implements TasksRepository {

    public JpaTasksRepository(PersistenceSettings settings) {
        super(settings);
    }

    @Override
    public Tasks findByName(String name) {
        final Map<String, Object> params = new HashMap<>();
        params.put("name", name);

        return matchOne("e.name=:name", params);
    }

    @Override
    public void deleteTask(Tasks task) {
        entityManager().getTransaction().begin();
        entityManager().createQuery("delete from Tasks t where t.id=:taskid")
                .setParameter("taskid", task.id())
                .executeUpdate();
        entityManager().getTransaction().commit();
    }

    @Override
    public Iterable<Tasks> findByAnyAttribute(String name) {
        final Map<String, Object> params = new HashMap<>();
        params.put("name", name);
        params.put("description", name);
        params.put("priorityLevel", name);
        params.put("progress", name);

        return match("e.name=:name or e.description=:description or e.priorityLevel=:priorityLevel or e.progress=:progress", params);

    }

    @Override
    public Iterable<Tasks> findTasksNotCompleted(String name) {
        boolean check = false;
        final Map<String, Object> params = new HashMap<>();
        params.put("check", check);

        return match("e.taskCompleted=:check", params);
    }

}
