package pt.isep.nsheets.server.services;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.util.Properties;

import com.google.gwt.user.server.rpc.RemoteServiceServlet;

import eapli.framework.persistence.DataConcurrencyException;
import eapli.framework.persistence.DataIntegrityViolationException;

import pt.isep.nsheets.shared.services.NotesService;
import pt.isep.nsheets.server.lapr4.red.s1.core.n1160634.notes.application.AddNoteController;
import pt.isep.nsheets.server.lapr4.red.s1.core.n1160634.notes.application.ListNoteController;
import pt.isep.nsheets.server.lapr4.red.s1.core.n1160634.notes.domain.Note;
import pt.isep.nsheets.server.lapr4.red.s1.core.n1160634.notes.persistence.PersistenceContext;
import pt.isep.nsheets.server.lapr4.red.s1.core.n1160634.notes.persistence.PersistenceSettings;
import pt.isep.nsheets.server.lapr4.red.s1.core.n1160634.notes.persistence.NoteRepository;
import pt.isep.nsheets.shared.services.NoteDTO;
import pt.isep.nsheets.shared.services.DataException;
import pt.isep.nsheets.shared.services.NoteDTO;

public class NotesServiceImpl extends RemoteServiceServlet implements NotesService {
    
    private PersistenceSettings getPersistenceSettings() {
        
        Properties props = new Properties();
        
        props.put("persistence.repositoryFactory",
                "pt.isep.nsheets.server.lapr4.red.s1.core.n1160634.notes.persistence.jpa.JpaRepositoryFactory");
        props.put("persistence.persistenceUnit", "lapr4.NSheetsPU");

        // Other JPA properties that one might want to override from the ones in
        // persistence.xml
        // props.put("javax.persistence.jdbc.url",
        // "jdbc:h2:../db/nsheets;MV_STORE=FALSE;MVCC=FALSE");
        // props.put("javax.persistence.jdbc.password", "");
        // props.put("javax.persistence.jdbc.driver", "org.h2.Driver");
        // props.put("javax.persistence.jdbc.user", "");
        // props.put("javax.persistence.schema-generation.database.action", "create");
        // props.put("eclipselink.logging.level", "FINE");
        return new PersistenceSettings(props);
    }
    
    @Override
    public ArrayList<NoteDTO> getNotes() {
        // Setup the persistence settings
        PersistenceContext.setSettings(this.getPersistenceSettings());
        
        ArrayList<NoteDTO> notes = new ArrayList<>();
        
        ListNoteController ctrl = new ListNoteController();
        
        Iterable<Note> notesAux = ctrl.listNotes();
        
        notesAux.forEach(wb -> notes.add(wb.toDTO()));
        
        return notes;
    }
    
    @Override
    public NoteDTO addNote(NoteDTO noteDTO)
            throws DataException {
        // Setup the persistence settings
        PersistenceContext.setSettings(this.getPersistenceSettings());
        
        AddNoteController ctrl = new AddNoteController();
        
        Note note = null;        
        
        try {
            note = ctrl.addNote(noteDTO);
        } catch (DataConcurrencyException | DataIntegrityViolationException ex) {
            throw new DataException((Throwable) ex);
        }
        
        return note.toDTO();
    }
    
}
