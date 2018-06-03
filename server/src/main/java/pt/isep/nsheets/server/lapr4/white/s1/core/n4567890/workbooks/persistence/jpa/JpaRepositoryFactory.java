/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package pt.isep.nsheets.server.lapr4.white.s1.core.n4567890.workbooks.persistence.jpa;

import pt.isep.nsheets.server.lapr4.green.s1.core.n1160557.users.persistence.UserRepository;
import pt.isep.nsheets.server.lapr4.green.s1.core.n1160832.spreadsheets.persistence.jpa.JpaSpreadsheetRepository;
import pt.isep.nsheets.server.lapr4.green.s1.core.n1160832.spreadsheets.persistence.jpa.SpreadsheetRepository;
import pt.isep.nsheets.server.lapr4.red.s1.core.n1160634.notes.persistence.NoteRepository;

import pt.isep.nsheets.server.lapr4.white.s1.core.n4567890.workbooks.persistence.PersistenceSettings;
import pt.isep.nsheets.server.lapr4.white.s1.core.n4567890.workbooks.persistence.RepositoryFactory;
import pt.isep.nsheets.server.lapr4.white.s1.core.n4567890.workbooks.persistence.WorkbookDescriptionRepository;

/**
 *
 * Created by nuno on 21/03/16.
 */
public class JpaRepositoryFactory implements RepositoryFactory {

    private PersistenceSettings settings=null;
    
    public PersistenceSettings setSettings(PersistenceSettings settings) {
        return this.settings=settings;
    }

    @Override
    public WorkbookDescriptionRepository workbookDescriptions() {
        return new JpaWorkbookDescriptionRepository(this.settings);
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
    public SpreadsheetRepository spreadsheets() {
        return new JpaSpreadsheetRepository(this.settings);
    }

    @Override
    public JpaSpreadsheetRepository charts() {
        return new JpaSpreadsheetRepository(this.settings);
    }
}
