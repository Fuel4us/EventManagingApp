package pt.isep.nsheets.server.lapr4.green.s1.ipc.n1160815.users.persistence;

import eapli.framework.persistence.repositories.Repository;
import pt.isep.nsheets.server.lapr4.green.s1.ipc.n1160815.users.domain.Notification;

public interface NotificationRepository extends Repository<Notification, Long> {

    public Iterable<Notification> findAllFromUser(String email);

    public void removeNotificationsFromUser(String username);
}
