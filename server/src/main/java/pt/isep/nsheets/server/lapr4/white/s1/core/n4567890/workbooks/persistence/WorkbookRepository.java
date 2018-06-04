package pt.isep.nsheets.server.lapr4.white.s1.core.n4567890.workbooks.persistence;

import eapli.framework.persistence.repositories.Repository;
import pt.isep.nsheets.shared.core.SpreadsheetImpl;
import pt.isep.nsheets.shared.core.Workbook;

import java.util.List;

public interface WorkbookRepository extends Repository<Workbook, Long> {
    
    Workbook findByName(String name);
    
    void deleteWorkbook(Workbook workbook);

    List<SpreadsheetImpl> getSpreadSheetByWorkbookName(String name);
}
