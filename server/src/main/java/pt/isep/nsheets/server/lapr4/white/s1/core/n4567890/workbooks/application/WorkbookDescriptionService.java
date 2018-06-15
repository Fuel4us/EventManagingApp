package pt.isep.nsheets.server.lapr4.white.s1.core.n4567890.workbooks.application;

import com.google.gwt.dev.util.collect.HashSet;
import eapli.framework.persistence.DataConcurrencyException;
import eapli.framework.persistence.DataIntegrityViolationException;
import java.util.LinkedList;
import java.util.List;
import pt.isep.nsheets.server.lapr4.white.s1.core.n4567890.workbooks.persistence.PersistenceContext;
import pt.isep.nsheets.shared.core.Workbook;
import pt.isep.nsheets.shared.lapr4.red.s1.core.n1161292.services.WorkbookDTO;
import pt.isep.nsheets.server.lapr4.white.s1.core.n4567890.workbooks.persistence.WorkbookRepository;
import pt.isep.nsheets.shared.core.formula.compiler.FormulaCompilationException;

public class WorkbookDescriptionService {

    public Iterable<Workbook> allWorkbooks() {

        final WorkbookRepository workbookRepository = PersistenceContext.repositories().workbooks();
        return workbookRepository.findAll();
    }
    
    public Iterable<Workbook> allWorkbooksFromUser(String user) {

        final WorkbookRepository workbookRepository = PersistenceContext.repositories().workbooks();
        Iterable<Workbook> list = workbookRepository.findAll();
        List<Workbook> returned = new LinkedList<>();
        
        for (Workbook w : list) {
            if(w.getUserName().equals(user) || w.isPublicState()) {
                returned.add(w);
            }
        }
        
        return returned;
    }
    

    public Workbook addWorkbook(WorkbookDTO dto) throws DataConcurrencyException, DataIntegrityViolationException, IllegalArgumentException, FormulaCompilationException {

        final WorkbookRepository workbookRepository = PersistenceContext.repositories().workbooks();
        
        Workbook wb=Workbook.fromDTO(dto);
        workbookRepository.save(wb);
        
        return wb;
    }
    
    public Workbook findByName(String name) throws DataConcurrencyException, DataIntegrityViolationException {
        final WorkbookRepository workbookRepository = PersistenceContext.repositories().workbooks();
        
        return workbookRepository.findByName(name);
    }
    
    public Workbook saveWorkbook(WorkbookDTO wb) throws DataConcurrencyException, DataIntegrityViolationException, IllegalArgumentException, FormulaCompilationException {
        final WorkbookRepository workbookRepository = PersistenceContext.repositories().workbooks();
        
        return workbookRepository.save(Workbook.fromDTO(wb));
    }
}
