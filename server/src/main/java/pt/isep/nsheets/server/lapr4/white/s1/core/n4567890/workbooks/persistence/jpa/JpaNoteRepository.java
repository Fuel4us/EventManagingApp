package pt.isep.nsheets.server.lapr4.white.s1.core.n4567890.workbooks.persistence.jpa;

import javax.persistence.EntityManager;
import javax.persistence.EntityTransaction;
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

    @Override
    public void deleteNote(Long id) {
        if (id == null) {
            throw new IllegalArgumentException();
        }

        final EntityManager em = entityManager();

        Note note = em.find(Note.class, id);
        
        
        final EntityTransaction tx = em.getTransaction();
        
        tx.begin();
        em.remove(note);
        tx.commit();

        em.close();
    }

}
