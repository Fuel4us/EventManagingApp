package pt.isep.nsheets.server.lapr4.white.s1.core.n4567890.workbooks.persistence.jpa;

import pt.isep.nsheets.server.lapr4.red.s1.core.n1160634.notes.domain.Note;
import pt.isep.nsheets.server.lapr4.white.s1.core.n4567890.workbooks.persistence.PersistenceSettings;
import pt.isep.nsheets.server.lapr4.red.s1.core.n1160634.notes.persistence.NoteRepository;

/**
 *
 * @author Pedro Marques Vieira
 */
public class JpaNoteRepository extends NSheetsJpaRepositoryBase<Note, Long> implements NoteRepository {

    JpaNoteRepository(PersistenceSettings settings) {
        super(settings);
    }

}
