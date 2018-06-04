/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package pt.isep.nsheets.server.lapr4.green.s1.core.n1140572.workbooks.application;

import eapli.framework.application.Controller;
import eapli.framework.persistence.DataConcurrencyException;
import eapli.framework.persistence.DataIntegrityViolationException;
import java.util.logging.Level;
import java.util.logging.Logger;
import pt.isep.nsheets.server.lapr4.white.s1.core.n4567890.workbooks.persistence.PersistenceContext;
import pt.isep.nsheets.server.lapr4.white.s1.core.n4567890.workbooks.persistence.WorkbookRepository;
import pt.isep.nsheets.shared.core.Workbook;
import pt.isep.nsheets.shared.lapr4.red.s1.core.n1161292.services.WorkbookDTO;

/**
 *
 * @author Pedro Rodrigues (1140572)
 */
public class RenameWorkbookController implements Controller {

    WorkbookRepository repo = PersistenceContext.repositories().workbooks();

    public void renameWorkbook(String name, WorkbookDTO workbookDTO) {
        Workbook workbook = repo.findByName(workbookDTO.name);
        workbook.setName(name);
        try {
            repo.save(workbook);
        } catch (DataConcurrencyException | DataIntegrityViolationException ex) {
            Logger.getLogger(RenameWorkbookController.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

}
