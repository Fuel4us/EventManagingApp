package pt.isep.nsheets.server.lapr4.red.s1.core.n1160634.notes.persistence;


import javax.persistence.EntityManager;

/**
 * @author Paulo Gandra Sousa
 *
 */
public interface RepositoryFactory {

    /**
     *
     * @param settings
     * @return
     */
    PersistenceSettings setSettings(PersistenceSettings settings);
    
    /**
     *
     * @return
     */
    NoteRepository Notes();
}
