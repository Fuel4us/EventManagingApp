package pt.isep.nsheets.server.lapr4.red.s1.core.n1160634.notes.application;

import eapli.framework.application.Controller;
import pt.isep.nsheets.server.lapr4.red.s1.core.n1160634.notes.domain.Note;

/**
 *
 * @author Pedro Marques Vieira
 */
public class ListNoteController implements Controller {

    /**
     *
     * @return
     */
    public Iterable<Note> listNotes() {
        return new NoteService().allNotes();
    }
}
