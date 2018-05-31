package pt.isep.nsheets.server.lapr4.red.s1.core.n1161140.calendar.persistence;

import java.util.logging.Level;
import java.util.logging.Logger;

public class PersistenceContext {

    private static PersistenceSettings settings = null;

    public PersistenceContext(PersistenceSettings settings) {
        this.settings = settings;
    }

    public static void setSettings(PersistenceSettings settings) {
        PersistenceContext.settings = settings;
    }

    public static PersistenceSettings getSettings() {
        if (PersistenceContext.settings == null) {
            PersistenceContext.settings = new PersistenceSettings();
        }
        return PersistenceContext.settings;
    }

    public static RepositoryFactory repositories() {
        // return new InMemoryRepositoryFactory();
        // return new JpaRepositoryFactory();

        final String factoryClassName = settings.getRepositoryFactory();
        try {
            RepositoryFactory repFactory = (RepositoryFactory) Class.forName(factoryClassName).newInstance();
            repFactory.setSettings(settings);
            return repFactory;
        } catch (ClassNotFoundException | IllegalAccessException | InstantiationException ex) {
            Logger.getLogger(PersistenceContext.class.getName()).log(Level.SEVERE, null, ex);
            return null;
        }
    }
}
