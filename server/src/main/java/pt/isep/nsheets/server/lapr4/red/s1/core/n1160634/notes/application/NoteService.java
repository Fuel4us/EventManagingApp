package pt.isep.nsheets.server.lapr4.red.s1.core.n1160634.notes.application;

import eapli.framework.persistence.DataConcurrencyException;
import eapli.framework.persistence.DataIntegrityViolationException;
import pt.isep.nsheets.server.lapr4.red.s1.core.n1160634.notes.domain.Note;
import pt.isep.nsheets.server.lapr4.white.s1.core.n4567890.workbooks.persistence.PersistenceContext;
import pt.isep.nsheets.server.lapr4.red.s1.core.n1160634.notes.persistence.NoteRepository;
import pt.isep.nsheets.shared.services.NoteDTO;

/**
 *
 * @author Pedro Marques Vieira
 */
public class NoteService {

    /**
     *
     * @return
     */
    public Iterable<Note> allNotes() {

        final NoteRepository noteRepository = PersistenceContext.repositories().notes();
        return noteRepository.findAll();
    }

    /**
     *
     * @param noteDTO
     * @return
     * @throws DataConcurrencyException
     * @throws DataIntegrityViolationException
     */
    public Note addNote(NoteDTO noteDTO) throws DataConcurrencyException, DataIntegrityViolationException {

        final NoteRepository noteRepository = PersistenceContext.repositories().notes();

        Note note = Note.fromDTO(noteDTO);
        noteRepository.save(note);

        return note;
    }
}
