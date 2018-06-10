package pt.isep.nsheets.server.lapr4.white.s1.core.n4567890.workbooks.persistence.jpa;

import pt.isep.nsheets.server.lapr4.blue.n1050475.s1.persistence.ConditionalRepository;
import pt.isep.nsheets.shared.lapr4.blue.n1050475.s1.extensions.Conditional;
import pt.isep.nsheets.server.lapr4.white.s1.core.n4567890.workbooks.persistence.PersistenceSettings;

public class JpaConditionalRepository extends NSheetsJpaRepositoryBase<Conditional, Long> implements ConditionalRepository {

    JpaConditionalRepository(PersistenceSettings settings) {
        super(settings);
    }

}