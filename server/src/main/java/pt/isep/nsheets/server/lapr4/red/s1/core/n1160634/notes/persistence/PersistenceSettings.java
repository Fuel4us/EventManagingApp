package pt.isep.nsheets.server.lapr4.red.s1.core.n1160634.notes.persistence;

/**
 *
 * @author alexandrebraganca
 */
import java.util.Properties;

/**
 *
 * @author Pedro Marques Vieira
 */
public class PersistenceSettings {

	private static final String REPOSITORY_FACTORY_KEY = "persistence.repositoryFactory";
	private static final String PERSISTENCE_UNIT_KEY = "persistence.persistenceUnit";
	private Properties properties = null;
    
    /**
     *
     * @param props
     */
    public PersistenceSettings(Properties props) {
		this.properties=props;
	}

    /**
     *
     */
    public PersistenceSettings() {
		setDefaultProperties();
	}
	
	private void setDefaultProperties() {
		this.properties.setProperty(REPOSITORY_FACTORY_KEY, "JpaRepositoryFactory");
		this.properties.setProperty(PERSISTENCE_UNIT_KEY, "lapr4.NSheetsPU");
	}

    /**
     *
     * @return
     */
    public String getPersistenceUnitName() {
		return this.properties.getProperty(PERSISTENCE_UNIT_KEY);
	}

    /**
     *
     * @return
     */
    public String getRepositoryFactory() {
		return this.properties.getProperty(REPOSITORY_FACTORY_KEY);
	}

	// Test if this will work in acceptance tests...

    /**
     *
     * @return
     */
	public Properties properties() {
		return this.properties;
	}
}