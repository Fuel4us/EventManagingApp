package pt.isep.nsheets.server.lapr4.white.s1.core.n4567890.workbooks.persistence.jpa;

import pt.isep.nsheets.server.lapr4.blue.s1.n1050475.persistence.ConditionalRepository;
import pt.isep.nsheets.shared.lapr4.blue.n1050475.s1.extensions.Conditional;
import pt.isep.nsheets.server.lapr4.red.s1.core.n1160629.extensions.persistence.ConfigurationRepository;
import pt.isep.nsheets.server.lapr4.white.s1.core.n4567890.workbooks.persistence.PersistenceSettings;

public class JpaConditionalRepository extends NSheetsJpaRepositoryBase<Conditional, Long> implements ConditionalRepository {

    JpaConditionalRepository(PersistenceSettings settings) {
        super(settings);
    }

}