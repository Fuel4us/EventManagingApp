package pt.isep.nsheets.server.lapr4.white.s1.core.n4567890.workbooks.persistence.jpa;

import java.util.HashMap;
import java.util.Map;
import pt.isep.nsheets.server.lapr4.white.s1.core.n4567890.workbooks.domain.WorkbookDescription;
import pt.isep.nsheets.server.lapr4.white.s1.core.n4567890.workbooks.persistence.PersistenceSettings;
import pt.isep.nsheets.server.lapr4.white.s1.core.n4567890.workbooks.persistence.WorkbookDescriptionRepository;

public class JpaWorkbookDescriptionRepository extends NSheetsJpaRepositoryBase<WorkbookDescription, Long> implements WorkbookDescriptionRepository {

    JpaWorkbookDescriptionRepository(PersistenceSettings settings) {
        super(settings);
    }

    @Override
    public WorkbookDescription findByName(String name) {
        final Map<String, Object> params = new HashMap<>();
        params.put("name", name);
        
        return matchOne("e.name=:name", params);
    }
}
