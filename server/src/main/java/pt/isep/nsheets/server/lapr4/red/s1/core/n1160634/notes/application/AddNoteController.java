package pt.isep.nsheets.server.lapr4.red.s1.core.n1160634.notes.application;

import eapli.framework.application.Controller;
import eapli.framework.persistence.DataConcurrencyException;
import eapli.framework.persistence.DataIntegrityViolationException;

import pt.isep.nsheets.server.lapr4.red.s1.core.n1160634.notes.domain.Note;
import pt.isep.nsheets.shared.services.NoteDTO;

/**
 *
 * @author Pedro Marques Vieira
 */
public class AddNoteController implements Controller {

    /**
     *
     * @param noteDTO
     * @return
     * @throws DataConcurrencyException
     * @throws DataIntegrityViolationException
     */
    public Note addNote(NoteDTO noteDTO) throws DataConcurrencyException, DataIntegrityViolationException {

        return new NoteService().addNote(noteDTO);
    }
}
