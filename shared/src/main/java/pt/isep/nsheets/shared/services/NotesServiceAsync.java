package pt.isep.nsheets.shared.services;

import java.util.ArrayList;

import com.google.gwt.user.client.rpc.AsyncCallback;

/**
 *
 * @author Pedro Marques Vieira
 */
public interface NotesServiceAsync {

    /**
     *
     * @param callback
     */
    void getNotes(AsyncCallback<ArrayList<NoteDTO>> callback);

    /**
     *
     * @param notesDTO
     * @param callback
     */
    void addNote(NoteDTO notesDTO, AsyncCallback<NoteDTO> callback);

    
    void saveNote(NoteDTO noteDTO, Long id, AsyncCallback<NoteDTO> callback);
    
    void deleteNote(Long id, AsyncCallback<Void> callback);
}
