/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package pt.isep.nsheets.server.lapr4.white.s1.core.n4567890.workbooks.persistence.jpa;

import pt.isep.nsheets.server.lapr4.blue.n1050475.s1.persistence.ConditionalRepository;
import pt.isep.nsheets.server.lapr4.blue.n1050475.s2.persistence.CellStyleRepository;
import pt.isep.nsheets.server.lapr4.blue.s2.n1140403.persistence.ListNotesRepository;
import pt.isep.nsheets.server.lapr4.green.s1.core.n1160557.users.persistence.UserRepository;
import pt.isep.nsheets.server.lapr4.green.s1.ipc.n1160815.users.persistence.MessagesRepository;
//import pt.isep.nsheets.server.lapr4.green.s1.core.n1160832.spreadsheets.persistence.jpa.JpaSpreadsheetRepository;
//import pt.isep.nsheets.server.lapr4.green.s1.core.n1160832.spreadsheets.persistence.jpa.SpreadsheetRepository;
import pt.isep.nsheets.server.lapr4.red.s1.core.n1160629.extensions.persistence.ConfigurationRepository;
import pt.isep.nsheets.server.lapr4.red.s1.core.n1160630.chart.persistence.ChartRepository;
import pt.isep.nsheets.server.lapr4.red.s1.core.n1160634.notes.persistence.NoteRepository;

import pt.isep.nsheets.server.lapr4.red.s1.core.n1161140.calendar.persistence.CalendarEventRepository;
import pt.isep.nsheets.server.lapr4.white.s1.core.n4567890.workbooks.persistence.PersistenceSettings;
import pt.isep.nsheets.server.lapr4.white.s1.core.n4567890.workbooks.persistence.RepositoryFactory;
import pt.isep.nsheets.server.lapr4.white.s1.core.n4567890.workbooks.persistence.WorkbookRepository;
import java.util.concurrent.locks.Condition;
import pt.isep.nsheets.server.lapr4.blue.n1150372.s2.persistence.AgendaRepository;
import pt.isep.nsheets.server.lapr4.blue.s2.core.n1160713.contacts.persistence.ContactsRepository;
import pt.isep.nsheets.server.lapr4.green.s1.ipc.n1160815.users.persistence.NotificationRepository;
import pt.isep.nsheets.server.lapr4.red.s2.ipc.n1160634.users.persistance.PrivateChatsRepository;

/**
 *
 * Created by nuno on 21/03/16.
 */
public class JpaRepositoryFactory implements RepositoryFactory {

    private PersistenceSettings settings = null;

    public PersistenceSettings setSettings(PersistenceSettings settings) {
        return this.settings = settings;
    }

    @Override
    public WorkbookRepository workbooks() {
        return new JpaWorkbookRepository(this.settings);
    }

    @Override
    public UserRepository users() {
        return new JpaUserRepository(this.settings);
    }

    @Override
    public NoteRepository notes() {
        return new JpaNoteRepository(this.settings);
    }

    @Override
    public ListNotesRepository listNotes() {
        return new JpaListNotesRepository(this.settings);

    }

    @Override
    public ContactsRepository contacts() {
        return new JpaContactsRepository(this.settings);
    }

    @Override
    public CalendarEventRepository calendarEvents() {
        return new JpaCalendarEventRepository(this.settings);
    }

    @Override
    public AgendaRepository agenda() {
        return new JpaAgendaRepository(this.settings);
    }

//    @Override
//    public SpreadsheetRepository spreadsheets() {
//        return new JpaSpreadsheetRepository(this.settings);
//    }
    @Override
    public ChartRepository charts() {
        return new JpaChartRepository(this.settings);
    }

    @Override
    public MessagesRepository messages() {
        return new JpaMessagesRepository(this.settings);
    }

    @Override
    public ConfigurationRepository configuration() {
        return new JpaConfigurationRepository(this.settings);
    }

    @Override
    public ConditionalRepository conditional() {
        return new JpaConditionalRepository(this.settings);
    }

    @Override
    public CellStyleRepository cellstyle() {
        return new JpaCellStyleRepository(this.settings);
    }

    @Override
    public PrivateChatsRepository privateChats() {
        return new JpaPrivateChatsRepository(this.settings);
    }

    @Override
    public NotificationRepository notifications() {
        return new JpaNotificationRepository(this.settings);
    }

}
