package pt.isep.nsheets.server.lapr4.red.s1.core.n1160634.notes.application;

import static org.junit.Assert.assertTrue;

import java.util.Properties;

import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.FixMethodOrder;
import org.junit.Test;
import org.junit.runners.MethodSorters;

import pt.isep.nsheets.server.lapr4.red.s1.core.n1160634.notes.domain.Note;
import pt.isep.nsheets.server.lapr4.white.s1.core.n4567890.workbooks.persistence.PersistenceContext;
import pt.isep.nsheets.server.lapr4.white.s1.core.n4567890.workbooks.persistence.PersistenceSettings;

/**
 *
 * @author Pedro Marques Vieira
 */
@FixMethodOrder(MethodSorters.NAME_ASCENDING)
public class ListNoteControllerTest {

    public ListNoteControllerTest() {
    }

    @BeforeClass
    public static void setUpClass() {
        System.out.println("ListNoteControllerTest");

        // Setup the context to use a memory database for testing
        Properties props = new Properties();
        props.put("persistence.repositoryFactory", "pt.isep.nsheets.server.lapr4.white.s1.core.n4567890.workbooks.persistence.jpa.JpaRepositoryFactory");
        props.put("persistence.persistenceUnit", "lapr4.NSheetsPU-test");

        // Other JPA properties that one might want to override from the ones in persistence.xml 
        // props.put("javax.persistence.jdbc.url", "jdbc:h2:mem:");
        props.put("javax.persistence.jdbc.url", "jdbc:h2:mem:ListNoteControllerTest");
        props.put("javax.persistence.schema-generation.database.action", "create");
        // appProps.put("javax.persistence.jdbc.password", "");
        // appProps.put("javax.persistence.jdbc.driver", "org.h2.Driver");
        // appProps.put("javax.persistence.jdbc.user", "");
        // appProps.put("eclipselink.logging.level", "FINE");

        PersistenceSettings extensionSettings = new PersistenceSettings(props);

        PersistenceContext.setSettings(extensionSettings);
    }

    @AfterClass
    public static void tearDownClass() {
    }

    @Before
    public void setUp() {

    }

    @After
    public void tearDown() {
    }

//    @Test
//    public void testAensureGetNotesEmpty() {
//        System.out.println("testAensureGetNotesEmpty");
//
//        ListNoteController ctrl = new ListNoteController();
//
//        Iterable<Note> notes = ctrl.listNotes();
//
//        assertTrue("the list of Notes is not empty", !notes.iterator().hasNext());
//    }

//    @Test
//    public void testBtestDatabaseInsertion() throws Exception {
//        System.out.println("testBtestDatabaseInsertion");
//
//        final String titleNote = "Title Note 1";
//        final String textNote = "Text of Note 1";
//
//        final Note expected = new Note(titleNote, textNote);
//
//        AddNoteController ctrlAdd = new AddNoteController();
//
//        Note result = ctrlAdd.addNote(expected.toDTO());
//
//        ListNoteController ctrlList = new ListNoteController();
//
//        Iterable<Note> notes = ctrlList.listNotes();
//
//        assertTrue("the added Note is not in the database", notes.iterator().hasNext());
//    }

}
