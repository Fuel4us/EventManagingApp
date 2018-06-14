/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package pt.isep.nsheets.server.lapr4.white.s1.core.n4567890.workbooks.persistence.jpa;

import java.util.HashMap;
import java.util.Map;
import pt.isep.nsheets.server.lapr4.green.s1.ipc.n1160815.users.domain.Notification;
import pt.isep.nsheets.server.lapr4.white.s1.core.n4567890.workbooks.persistence.PersistenceSettings;
import pt.isep.nsheets.server.lapr4.green.s1.ipc.n1160815.users.persistence.NotificationRepository;

public class JpaNotificationRepository extends NSheetsJpaRepositoryBase<Notification, Long> implements NotificationRepository {

    JpaNotificationRepository(PersistenceSettings settings) {
        super(settings);
    }

    @Override
    public Iterable<Notification> findAllFromUser(String username) {
        final Map<String, Object> params = new HashMap<>();
        params.put("username", username);

        return match("e.username=:username", params);
    }

    @Override
    public void removeNotificationsFromUser(String username) {
        entityManager().getTransaction().begin();
        entityManager().createQuery("delete from Notification n where n.username=:username")
                .setParameter("username", username)
                .executeUpdate();
        entityManager().getTransaction().commit();
    }

}
