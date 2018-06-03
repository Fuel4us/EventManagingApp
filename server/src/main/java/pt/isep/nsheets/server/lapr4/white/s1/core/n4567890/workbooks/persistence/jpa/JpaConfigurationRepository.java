package pt.isep.nsheets.server.lapr4.white.s1.core.n4567890.workbooks.persistence.jpa;

import eapli.framework.persistence.DataConcurrencyException;
import eapli.framework.persistence.DataIntegrityViolationException;
import pt.isep.nsheets.server.lapr4.red.s1.core.n1160629.extensions.persistence.ConfigurationRepository;
import pt.isep.nsheets.server.lapr4.white.s1.core.n4567890.workbooks.persistence.PersistenceSettings;
import pt.isep.nsheets.shared.ext.extensions.lapr4.red.s1.core.n1160629.Configuration;

public class JpaConfigurationRepository extends NSheetsJpaRepositoryBase<Configuration, Long> implements ConfigurationRepository {

    JpaConfigurationRepository(PersistenceSettings settings) {
        super(settings);
    }

}