package pt.isep.nsheets.server.lapr4.white.s1.core.n4567890.workbooks.persistence.jpa;

import java.util.HashMap;
import java.util.Map;
import pt.isep.nsheets.server.lapr4.white.s1.core.n4567890.workbooks.persistence.PersistenceSettings;
import pt.isep.nsheets.server.lapr4.white.s1.core.n4567890.workbooks.persistence.WorkbookRepository;
import pt.isep.nsheets.shared.core.Workbook;

public class JpaWorkbookRepository extends NSheetsJpaRepositoryBase<Workbook, Long> implements WorkbookRepository {

    JpaWorkbookRepository(PersistenceSettings settings) {
        super(settings);
    }

    @Override
    public Workbook findByName(String name) {
        final Map<String, Object> params = new HashMap<>();
        params.put("name", name);
        
        return matchOne("e.name=:name", params);
    }

    @Override
    public void deleteWorkbook(String workbookName) {
        entityManager().createQuery("delete from Workbook w where w.name=:workbookName")
                .setParameter("workbookName", workbookName)
                .executeUpdate();
    }
    
    
}
