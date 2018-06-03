package pt.isep.nsheets.server.lapr4.green.s1.core.n1160832.spreadsheets.application;

import com.google.gwt.user.client.rpc.RemoteService;
import eapli.framework.persistence.DataConcurrencyException;
import eapli.framework.persistence.DataIntegrityViolationException;
import pt.isep.nsheets.server.lapr4.green.s1.core.n1160832.spreadsheets.persistence.jpa.SpreadsheetRepository;
import pt.isep.nsheets.server.lapr4.white.s1.core.n4567890.workbooks.persistence.PersistenceContext;
import pt.isep.nsheets.shared.core.Spreadsheet;
import pt.isep.nsheets.shared.core.formula.compiler.FormulaCompilationException;
import pt.isep.nsheets.shared.services.SpreadsheetDTO;

/**
 *
 * @author Mário Vaz
 */
public class SpreadsheetService{

    public Iterable<Spreadsheet> allSpreadsheets() {

        final SpreadsheetRepository spreadsheetRepository = PersistenceContext.repositories().spreadsheets();
        return spreadsheetRepository.findAll();
    }



    public Spreadsheet addSpreadsheet(SpreadsheetDTO dto) throws DataIntegrityViolationException, FormulaCompilationException, DataConcurrencyException {

        final SpreadsheetRepository spreadsheetRepository = PersistenceContext.repositories().spreadsheets();

        Spreadsheet ss= dto.fromDTO();
        spreadsheetRepository.save(ss);

        return ss;
    }

}
