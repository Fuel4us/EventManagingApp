/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package pt.isep.nsheets.server.lapr4.blue.s2.n1140403.application;

import eapli.framework.persistence.DataConcurrencyException;
import eapli.framework.persistence.DataIntegrityViolationException;
import pt.isep.nsheets.server.lapr4.blue.s2.n1140403.domain.ListNotes;
import pt.isep.nsheets.server.lapr4.blue.s2.n1140403.persistence.ListNotesRepository;
import pt.isep.nsheets.server.lapr4.white.s1.core.n4567890.workbooks.persistence.PersistenceContext;
import pt.isep.nsheets.shared.services.ListNotesDTO;

/**
 *
 * @author Tiago Correia
 */
public class ListNotesService {

    /**
     *
     * @return
     */
    public Iterable<ListNotes> allListNotes() {

        final ListNotesRepository noteRepository = PersistenceContext.repositories().listNotes();
        return noteRepository.findAll();
    }

    /**
     *
     * @param noteDTO
     * @return
     * @throws DataConcurrencyException
     * @throws DataIntegrityViolationException
     */
    public ListNotes addListNotes(ListNotesDTO listNotesDTO) throws DataConcurrencyException, DataIntegrityViolationException {

        final ListNotesRepository listNotesRepository = PersistenceContext.repositories().listNotes();

        ListNotes listNotes = ListNotes.fromDTO(listNotesDTO);
        listNotesRepository.save(listNotes);

        return listNotes;
    }

}
