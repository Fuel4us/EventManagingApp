/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package pt.isep.nsheets.server.lapr4.blue.s2.n1140403.application;

import eapli.framework.application.Controller;
import eapli.framework.persistence.DataConcurrencyException;
import eapli.framework.persistence.DataIntegrityViolationException;
import pt.isep.nsheets.server.lapr4.blue.s2.n1140403.domain.ListNotes;
import pt.isep.nsheets.shared.services.ListNotesDTO;
import pt.isep.nsheets.server.lapr4.blue.s2.n1140403.application.ListNotesService;

/**
 *
 * @author Tiago Correia
 */
public class AddListNotesController implements Controller{
    
    /**
     *
     * @param listNotesDTO
     * @return
     * @throws DataConcurrencyException
     * @throws DataIntegrityViolationException
     */
    public ListNotes addNotes(ListNotesDTO listNotesDTO) throws DataConcurrencyException, DataIntegrityViolationException {

        return new ListNotesService().addListNotes(listNotesDTO);
    }
}
