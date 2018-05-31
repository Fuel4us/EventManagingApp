package pt.isep.nsheets.server.lapr4.red.s1.core.n1161140.calendar.persistence;

import java.util.Properties;

public class PersistenceSettings {

    private static final String REPOSITORY_FACTORY_KEY = "persistence.repositoryFactory";
    private static final String PERSISTENCE_UNIT_KEY = "persistence.persistenceUnit";
    private Properties properties = null;

    public PersistenceSettings(Properties props) {
        this.properties = props;
    }

    public PersistenceSettings() {
        setDefaultProperties();
    }

    private void setDefaultProperties() {
        this.properties.setProperty(REPOSITORY_FACTORY_KEY, "JpaRepositoryFactory");
        this.properties.setProperty(PERSISTENCE_UNIT_KEY, "lapr4.NSheetsPU");
    }

    public String getPersistenceUnitName() {
        return this.properties.getProperty(PERSISTENCE_UNIT_KEY);
    }

    public String getRepositoryFactory() {
        return this.properties.getProperty(REPOSITORY_FACTORY_KEY);
    }

    public Properties properties() {
        return this.properties;
    }
}