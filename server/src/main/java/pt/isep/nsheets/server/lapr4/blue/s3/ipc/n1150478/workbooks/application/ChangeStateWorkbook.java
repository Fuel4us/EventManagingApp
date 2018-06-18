package pt.isep.nsheets.server.lapr4.blue.s3.ipc.n1150478.workbooks.application;

import eapli.framework.persistence.DataConcurrencyException;
import eapli.framework.persistence.DataIntegrityViolationException;
import java.util.logging.Level;
import java.util.logging.Logger;
import pt.isep.nsheets.server.lapr4.green.s1.core.n1140572.workbooks.application.RenameWorkbookController;
import pt.isep.nsheets.server.lapr4.white.s1.core.n4567890.workbooks.persistence.PersistenceContext;
import pt.isep.nsheets.server.lapr4.white.s1.core.n4567890.workbooks.persistence.WorkbookRepository;
import pt.isep.nsheets.shared.core.Workbook;
import pt.isep.nsheets.shared.lapr4.red.s1.core.n1161292.services.WorkbookDTO;

/**
 *
 * @author João Pereira <1150478@isep.ipp.pt>
 */
public class ChangeStateWorkbook {
    WorkbookRepository repo = PersistenceContext.repositories().workbooks();
    
    public ChangeStateWorkbook(){
        
    }

    public void changeStateWorkbook(boolean state, WorkbookDTO workbookDTO) {
        Workbook workbook = repo.findByName(workbookDTO.name);
        workbook.setPublicState(state);
        try {
            repo.save(workbook);
        } catch (DataConcurrencyException | DataIntegrityViolationException ex) {
            Logger.getLogger(RenameWorkbookController.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
}
