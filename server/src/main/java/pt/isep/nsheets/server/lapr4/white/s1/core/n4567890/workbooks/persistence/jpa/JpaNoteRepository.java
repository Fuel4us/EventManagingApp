package pt.isep.nsheets.server.lapr4.white.s1.core.n4567890.workbooks.persistence.jpa;

import eapli.framework.persistence.DataConcurrencyException;
import eapli.framework.persistence.DataIntegrityViolationException;
import java.util.Optional;
import pt.isep.nsheets.server.lapr4.red.s1.core.n1160634.notes.domain.Note;
import pt.isep.nsheets.server.lapr4.white.s1.core.n4567890.workbooks.persistence.PersistenceSettings;
import pt.isep.nsheets.server.lapr4.red.s1.core.n1160634.notes.persistence.NoteRepository;

/**
 *
 * @author Pedro Marques Vieira
 */
public class JpaNoteRepository implements NoteRepository {

    JpaNoteRepository(PersistenceSettings settings) {
        //super(settings);
    }

    @Override
    public Note save(Note entity) throws DataConcurrencyException, DataIntegrityViolationException {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public Iterable<Note> findAll() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public Optional<Note> findOne(Long id) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public long count() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
}
