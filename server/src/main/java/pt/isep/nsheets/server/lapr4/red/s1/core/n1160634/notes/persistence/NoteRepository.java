package pt.isep.nsheets.server.lapr4.red.s1.core.n1160634.notes.persistence;

import eapli.framework.persistence.repositories.Repository;
import pt.isep.nsheets.server.lapr4.red.s1.core.n1160634.notes.domain.Note;

/**
 *
 * @author Pedro Marques Vieira
 */
public interface NoteRepository extends Repository<Note, Long> {

    public void deleteNote(Long id);
    
}
