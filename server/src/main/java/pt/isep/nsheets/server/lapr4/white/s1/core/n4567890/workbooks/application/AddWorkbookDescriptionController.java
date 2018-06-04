package pt.isep.nsheets.server.lapr4.white.s1.core.n4567890.workbooks.application;

import eapli.framework.application.Controller;
import eapli.framework.persistence.DataConcurrencyException;
import eapli.framework.persistence.DataIntegrityViolationException;
import pt.isep.nsheets.shared.core.Workbook;
import pt.isep.nsheets.shared.core.formula.compiler.FormulaCompilationException;
import pt.isep.nsheets.shared.lapr4.red.s1.core.n1161292.services.WorkbookDTO;

public class AddWorkbookDescriptionController implements Controller {

    public Workbook addWorkbook(WorkbookDTO dto) throws DataConcurrencyException, DataIntegrityViolationException, IllegalArgumentException, FormulaCompilationException {
    	return new WorkbookDescriptionService().addWorkbook(dto);
    }
    
    public Workbook findByName(String name) throws DataConcurrencyException, DataIntegrityViolationException {
        return new WorkbookDescriptionService().findByName(name);
    }
    
    public Workbook saveWorkbook(WorkbookDTO wb) throws DataConcurrencyException, DataIntegrityViolationException, IllegalArgumentException, FormulaCompilationException {
        return new WorkbookDescriptionService().saveWorkbook(wb);
    }
}
