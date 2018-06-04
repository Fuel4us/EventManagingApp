package pt.isep.nsheets.server.lapr4.white.s1.core.n4567890.workbooks.persistence.jpa;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import pt.isep.nsheets.server.lapr4.white.s1.core.n4567890.workbooks.persistence.PersistenceSettings;
import pt.isep.nsheets.server.lapr4.white.s1.core.n4567890.workbooks.persistence.WorkbookRepository;
import pt.isep.nsheets.shared.core.SpreadsheetImpl;
import pt.isep.nsheets.shared.core.Workbook;

import javax.persistence.Query;

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
    public void deleteWorkbook(Workbook workbook) {
        entityManager().createQuery("delete from Workbook w where w.id=:workbookid")
                .setParameter("workbookid", workbook.getId())
                .executeUpdate();
    }

    @Override
    public List<SpreadsheetImpl> getSpreadSheetByWorkbookName(String name) {
        Query query = entityManager().createQuery("SELECT s FROM Workbook w, SpreadsheetImpl s WHERE w.name=:name and s.workbook=w");
        query.setParameter("name",name);
        return query.getResultList();
    }

    
    
}
