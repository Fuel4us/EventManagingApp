package pt.isep.nsheets.server.lapr4.red.s1.core.n1160634.notes.persistence;

/**
 *
 * @author alexandrebraganca
 */
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 * provides easy access to the persistence layer. works as a factory of
 * factories
 *
 * @author Paulo Gandra Sousa
 */
public class PersistenceContext {

    private static PersistenceSettings settings = null;

    /**
     *
     * @param settings
     */
    public PersistenceContext(PersistenceSettings settings) {
        this.settings = settings;
    }

    /**
     *
     * @param settings
     */
    public static void setSettings(PersistenceSettings settings) {
        PersistenceContext.settings = settings;
    }

    /**
     *
     * @return
     */
    public static PersistenceSettings getSettings() {
        if (PersistenceContext.settings == null) {
            PersistenceContext.settings = new PersistenceSettings();
        }
        return PersistenceContext.settings;
    }

    /**
     *
     * @return
     */
    public static RepositoryFactory repositories() {
        // return new InMemoryRepositoryFactory();
        // return new JpaRepositoryFactory();

        final String factoryClassName = settings.getRepositoryFactory();
        try {
            RepositoryFactory repFactory = (RepositoryFactory) Class.forName(factoryClassName).newInstance();
            repFactory.setSettings(settings);
            return repFactory;
        } catch (ClassNotFoundException | IllegalAccessException | InstantiationException ex) {
            // FIXME handle exception properly
            Logger.getLogger(PersistenceContext.class.getName()).log(Level.SEVERE, null, ex);
            return null;
        }
    }
}
