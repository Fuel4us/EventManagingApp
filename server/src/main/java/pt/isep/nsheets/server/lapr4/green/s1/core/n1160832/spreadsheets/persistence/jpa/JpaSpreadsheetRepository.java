package pt.isep.nsheets.server.lapr4.green.s1.core.n1160832.spreadsheets.persistence.jpa;

import pt.isep.nsheets.server.lapr4.white.s1.core.n4567890.workbooks.persistence.PersistenceSettings;
import pt.isep.nsheets.shared.core.Spreadsheet;
import pt.isep.nsheets.shared.core.SpreadsheetImpl;

/**
 *
 * @author Mário Vaz
 */
public class JpaSpreadsheetRepository extends NSheetsJpaRepositoryBase<Spreadsheet, Long> implements SpreadsheetRepository {

    public JpaSpreadsheetRepository(PersistenceSettings settings) {
        super(settings);
    }
}

