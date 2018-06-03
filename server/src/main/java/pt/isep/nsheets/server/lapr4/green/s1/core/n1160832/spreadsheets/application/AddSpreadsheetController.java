package pt.isep.nsheets.server.lapr4.green.s1.core.n1160832.spreadsheets.application;

import eapli.framework.application.Controller;
import eapli.framework.persistence.DataConcurrencyException;
import eapli.framework.persistence.DataIntegrityViolationException;
import pt.isep.nsheets.server.lapr4.red.s1.core.n1160634.notes.application.NoteService;
import pt.isep.nsheets.server.lapr4.red.s1.core.n1160634.notes.domain.Note;
import pt.isep.nsheets.shared.core.Spreadsheet;
import pt.isep.nsheets.shared.core.formula.compiler.FormulaCompilationException;
import pt.isep.nsheets.shared.services.DataException;
import pt.isep.nsheets.shared.services.NoteDTO;
import pt.isep.nsheets.shared.services.SpreadsheetDTO;

/**
 *
 * @author Mário Vaz
 */
public class AddSpreadsheetController implements Controller {

    /**
     *
     * @param spreadsheetDTO
     * @return
     * @throws DataConcurrencyException
     * @throws DataIntegrityViolationException
     */
    public Spreadsheet addSpreadsheet(SpreadsheetDTO spreadsheetDTO) throws DataConcurrencyException, DataIntegrityViolationException, FormulaCompilationException, DataException {

        return new SpreadsheetService().addSpreadsheet(spreadsheetDTO);
    }
}
