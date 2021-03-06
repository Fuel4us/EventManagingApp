/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package pt.isep.nsheets.server.lapr4.white.s1.core.n4567890.workbooks.persistence;

import pt.isep.nsheets.server.lapr4.blue.n1050475.s1.persistence.ConditionalRepository;
import pt.isep.nsheets.server.lapr4.blue.n1050475.s2.persistence.CellStyleRepository;
import pt.isep.nsheets.server.lapr4.blue.n1150372.s2.persistence.AgendaRepository;
import pt.isep.nsheets.server.lapr4.blue.s2.core.n1160713.contacts.persistence.ContactsRepository;
import pt.isep.nsheets.server.lapr4.blue.s2.n1140403.persistence.ListNotesRepository;
import pt.isep.nsheets.server.lapr4.green.s1.core.n1160557.users.persistence.UserRepository;
import pt.isep.nsheets.server.lapr4.green.s1.ipc.n1160815.users.persistence.MessagesRepository;
import pt.isep.nsheets.server.lapr4.green.s1.ipc.n1160815.users.persistence.NotificationRepository;
import pt.isep.nsheets.server.lapr4.green.s3.core.n1140572.tasks.persistence.TasksRepository;
//import pt.isep.nsheets.server.lapr4.green.s1.core.n1160832.spreadsheets.persistence.jpa.SpreadsheetRepository;
import pt.isep.nsheets.server.lapr4.red.s1.core.n1160629.extensions.persistence.ConfigurationRepository;
import pt.isep.nsheets.server.lapr4.red.s1.core.n1160630.chart.persistence.ChartRepository;
import pt.isep.nsheets.server.lapr4.red.s1.core.n1160634.notes.persistence.NoteRepository;
import pt.isep.nsheets.server.lapr4.red.s1.core.n1161140.calendar.persistence.CalendarEventRepository;
import pt.isep.nsheets.server.lapr4.red.s2.ipc.n1160634.users.persistance.PrivateChatsRepository;
import pt.isep.nsheets.server.lapr4.red.s3.lang.n1160630.Js.FunctionRepository;

/**
 * @author Paulo Gandra Sousa
 *
 */
public interface RepositoryFactory {

    PersistenceSettings setSettings(PersistenceSettings settings);

    WorkbookRepository workbooks();

    UserRepository users();

    NoteRepository notes();

    ListNotesRepository listNotes();

    ContactsRepository contacts();

    CalendarEventRepository calendarEvents();

    AgendaRepository agenda();
//    SpreadsheetRepository spreadsheets();

    ChartRepository charts();

    MessagesRepository messages();

    ConfigurationRepository configuration();

    ConditionalRepository conditional();

    CellStyleRepository cellstyle();

    PrivateChatsRepository privateChats();

    NotificationRepository notifications();
    
    FunctionRepository functions();
    
    TasksRepository tasks();
}
