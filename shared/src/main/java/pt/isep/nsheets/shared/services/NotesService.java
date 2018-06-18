package pt.isep.nsheets.shared.services;

import java.util.ArrayList;

import com.google.gwt.user.client.rpc.RemoteService;
import com.google.gwt.user.client.rpc.RemoteServiceRelativePath;

/**
 *
 * @author Pedro Marques Vieira
 */
@RemoteServiceRelativePath("notesService")
public interface NotesService extends RemoteService {

    /**
     *
     * @return
     */
    ArrayList<NoteDTO> getNotes();

    /**
     *
     * @param notesDTO
     * @return
     * @throws DataException
     */
    NoteDTO addNote(NoteDTO notesDTO) throws DataException;
    
    NoteDTO saveNote(NoteDTO noteDTO, long id);
}
