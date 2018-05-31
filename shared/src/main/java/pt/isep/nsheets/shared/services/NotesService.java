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
	ArrayList<NoteDTO> getNotes();
	NoteDTO addNotes(NoteDTO notesDTO) throws DataException;
}
