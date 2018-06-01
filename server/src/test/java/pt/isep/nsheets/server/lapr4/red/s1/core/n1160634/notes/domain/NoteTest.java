package pt.isep.nsheets.server.lapr4.red.s1.core.n1160634.notes.domain;

import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;

/**
 *
 * @author Pedro Marques Vieira
 */
public class NoteTest {

    public NoteTest() {
    }

    @BeforeClass
    public static void setUpClass() {
        System.out.println("Note");
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

    @Test(expected = IllegalArgumentException.class)
    public void ensureNullIsNotAllowed() {
        System.out.println("ensureNullIsNotAllowed");

        Note instance = new Note(null, null);
    }

}
