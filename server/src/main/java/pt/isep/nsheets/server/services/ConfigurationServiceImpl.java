package pt.isep.nsheets.server.services;

import com.google.gwt.user.server.rpc.RemoteServiceServlet;
import pt.isep.nsheets.server.lapr4.red.s1.core.n1160629.extensions.application.ConfigureValueColorExtensionController;
import pt.isep.nsheets.server.lapr4.white.s1.core.n4567890.workbooks.persistence.PersistenceContext;
import pt.isep.nsheets.server.lapr4.white.s1.core.n4567890.workbooks.persistence.PersistenceSettings;
import pt.isep.nsheets.shared.ext.extensions.lapr4.red.s1.core.n1160629.Configuration;
import pt.isep.nsheets.shared.services.ConfigurationDTO;
import pt.isep.nsheets.shared.services.ConfigurationService;
import pt.isep.nsheets.shared.services.DataException;

import java.util.Properties;

public class ConfigurationServiceImpl extends RemoteServiceServlet implements ConfigurationService{

    private PersistenceSettings getPersistenceSettings(){
        Properties props = new Properties();

        props.put("persistence.repositoryFactory",
                "pt.isep.nsheets.server.lapr4.white.s1.core.n4567890.workbooks.persistence.jpa.JpaRepositoryFactory");
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
    public ConfigurationDTO getConfiguration() {
        PersistenceContext.setSettings(this.getPersistenceSettings());

        ConfigurationDTO configurationDTO;

        ConfigureValueColorExtensionController ctrl = new ConfigureValueColorExtensionController();

        Configuration configuration = ctrl.loadConfigurationFromDatabase();

        return configuration.toDTO();
    }



    @Override
    public ConfigurationDTO saveConfiguration(ConfigurationDTO configurationDTO) throws DataException {
        ConfigureValueColorExtensionController ctrl = new ConfigureValueColorExtensionController();
        return ctrl.configureExtension(configurationDTO.getBgColorPos(), configurationDTO.getFgColorPos(), configurationDTO.getBgColorNeg(), configurationDTO.getFgColorNeg()).toDTO();
    }
}
