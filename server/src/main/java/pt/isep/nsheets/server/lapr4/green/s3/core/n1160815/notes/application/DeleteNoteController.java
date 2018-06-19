/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package pt.isep.nsheets.server.lapr4.green.s3.core.n1160815.notes.application;

import eapli.framework.application.Controller;
import eapli.framework.persistence.DataConcurrencyException;
import eapli.framework.persistence.DataIntegrityViolationException;
import pt.isep.nsheets.server.lapr4.red.s1.core.n1160634.notes.application.NoteService;

/**
 *
 * @author Leandro
 */
public class DeleteNoteController implements Controller{
 
    public Void deleteNote(Long id) throws DataConcurrencyException, DataIntegrityViolationException {
        new NoteService().deleteNote(id);
        return null;
    }
    
}
