/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package pt.isep.nsheets.server.lapr4.white.s1.core.n4567890.workbooks.persistence;

import pt.isep.nsheets.server.lapr4.green.s1.core.n1160557.users.persistence.UserRepository;
import pt.isep.nsheets.server.lapr4.green.s1.core.n1160815.users.persistence.MessagesRepository;
import pt.isep.nsheets.server.lapr4.green.s1.core.n1160832.spreadsheets.persistence.jpa.SpreadsheetRepository;
import pt.isep.nsheets.server.lapr4.red.s1.core.n1160630.chart.persistence.ChartRepository;
import pt.isep.nsheets.server.lapr4.red.s1.core.n1160634.notes.persistence.NoteRepository;

/**
 * @author Paulo Gandra Sousa
 *
 */
public interface RepositoryFactory {

    PersistenceSettings setSettings(PersistenceSettings settings);
    
    WorkbookDescriptionRepository workbookDescriptions();
    UserRepository users();
    NoteRepository notes();
    SpreadsheetRepository spreadsheets();
    ChartRepository charts();
    MessagesRepository messages();
}
