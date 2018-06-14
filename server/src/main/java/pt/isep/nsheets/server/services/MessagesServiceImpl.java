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
import pt.isep.nsheets.server.lapr4.green.s1.ipc.n1160815.users.application.AddMessageController;
import pt.isep.nsheets.server.lapr4.green.s1.ipc.n1160815.users.application.ListMessagesController;
import pt.isep.nsheets.server.lapr4.green.s1.ipc.n1160815.users.application.ListNotificationsController;
import pt.isep.nsheets.server.lapr4.green.s1.ipc.n1160815.users.domain.Message;
import pt.isep.nsheets.server.lapr4.green.s1.ipc.n1160815.users.domain.Notification;
import pt.isep.nsheets.server.lapr4.white.s1.core.n4567890.workbooks.persistence.PersistenceContext;
import pt.isep.nsheets.server.lapr4.white.s1.core.n4567890.workbooks.persistence.PersistenceSettings;
import pt.isep.nsheets.shared.services.DataException;
import pt.isep.nsheets.shared.services.MessagesDTO;
import pt.isep.nsheets.shared.services.MessagesService;
import pt.isep.nsheets.shared.services.NotificationDTO;

/**
 *
 * @author Leandro
 */
public class MessagesServiceImpl extends RemoteServiceServlet implements MessagesService {

    private PersistenceSettings getPersistenceSettings() {

        Properties props = new Properties();

        props.put("persistence.repositoryFactory",
                "pt.isep.nsheets.server.lapr4.white.s1.core.n4567890.workbooks.persistence.jpa.JpaRepositoryFactory");
        props.put("persistence.persistenceUnit", "lapr4.NSheetsPU");

        // Other JPA properties that one might want to override from the ones in
        // persistence.xml
        // props.put("javax.persistence.jdbc.url",
        // "jdbc:h2:../db/nsheets;MV_STORE=FALSE;MVCC=FALSE");
        // props.put("javax.persistence.jdbc.password", "");
        // props.put("javax.persistence.jdbc.driver", "org.h2.Driver");
        // props.put("javax.persistence.jdbc.user", "");
        // props.put("javax.persistence.schema-generation.database.action", "create");
        // props.put("eclipselink.logging.level", "FINE");
        return new PersistenceSettings(props);
    }

    @Override
    public MessagesDTO addMessage(MessagesDTO mDTO) throws DataException {
        PersistenceContext.setSettings(this.getPersistenceSettings());

        AddMessageController ctrl = new AddMessageController();

        Message m = null;

        try {
            m = ctrl.addMessage(mDTO);
        } catch (DataConcurrencyException | DataIntegrityViolationException ex) {
            throw new DataException((Throwable) ex);
        }

        return m.toDTO();
    }

    @Override
    public ArrayList<MessagesDTO> getMessages() {
        // Setup the persistence settings
        PersistenceContext.setSettings(this.getPersistenceSettings());

        ArrayList<MessagesDTO> messages = new ArrayList<MessagesDTO>();

        ListMessagesController ctrl = new ListMessagesController();

        Iterable<Message> ms = ctrl.listMessages();

        ms.forEach(wb -> messages.add(wb.toDTO()));

        return messages;

    }

    @Override
    public ArrayList<NotificationDTO> getNotifications(String username) {
        // Setup the persistence settings
        PersistenceContext.setSettings(this.getPersistenceSettings());

        ArrayList<NotificationDTO> notifications = new ArrayList<>();

        ListNotificationsController ctrl = new ListNotificationsController();

        Iterable<Notification> ns = ctrl.listNotifications(username);

        ns.forEach(wb -> notifications.add(wb.toDTO()));

        return notifications;
    }
}
