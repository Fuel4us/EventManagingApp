package pt.isep.nsheets.server.lapr4.red.s1.core.n1160634.notes.application;

import static org.junit.Assert.assertTrue;

import java.util.Properties;

import org.junit.BeforeClass;
import org.junit.Test;

import pt.isep.nsheets.server.lapr4.red.s1.core.n1160634.notes.domain.Note;
import pt.isep.nsheets.server.lapr4.white.s1.core.n4567890.workbooks.persistence.PersistenceContext;
import pt.isep.nsheets.server.lapr4.white.s1.core.n4567890.workbooks.persistence.PersistenceSettings;

/**
 *
 * @author Pedro Marques Vieira
 */
public class AddNoteControllerTest {

    public AddNoteControllerTest() {
    }

    @BeforeClass
    public static void setUpClass() {
        System.out.println("AddNoteControllerTest");

        // Setup the context to use a memory database for testing
        Properties props = new Properties();
        props.put("persistence.repositoryFactory",
                "pt.isep.nsheets.server.lapr4.white.s1.core.n4567890.workbooks.persistence.jpa.JpaRepositoryFactory");
        props.put("persistence.persistenceUnit", "lapr4.NSheetsPU-test");

        // Other JPA properties that one might want to override from the ones in
        // persistence.xml
        // props.put("javax.persistence.jdbc.url", "jdbc:h2:mem:");
        props.put("javax.persistence.jdbc.url", "jdbc:h2:mem:AddNoteControllerTest");
        props.put("javax.persistence.schema-generation.database.action", "create");
        // appProps.put("javax.persistence.jdbc.password", "");
        // appProps.put("javax.persistence.jdbc.driver", "org.h2.Driver");
        // appProps.put("javax.persistence.jdbc.user", "");
        // appProps.put("eclipselink.logging.level", "FINE");

        PersistenceSettings extensionSettings = new PersistenceSettings(props);

        PersistenceContext.setSettings(extensionSettings);
    }

//    @Test
//    public void testNormalBehaviour() throws Exception {
//        System.out.println("testNormalBehaviour");
//
//        final String titleNote = "Title";
//        final String textNote = "Text";
//
//        final Note expected = new Note(titleNote, textNote);
//
//        AddSpreadsheetController ctrl = new AddSpreadsheetController();
//
//        Note result = ctrl.addNote(expected.toDTO());
//
//        assertTrue("the added Note does not have the same data as input", expected.sameAs(result));
//    }

}
