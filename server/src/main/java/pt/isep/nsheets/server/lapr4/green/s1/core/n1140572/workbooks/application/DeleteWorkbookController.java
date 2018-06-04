/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package pt.isep.nsheets.server.lapr4.green.s1.core.n1140572.workbooks.application;

import pt.isep.nsheets.server.lapr4.white.s1.core.n4567890.workbooks.persistence.PersistenceContext;
import pt.isep.nsheets.server.lapr4.white.s1.core.n4567890.workbooks.persistence.WorkbookRepository;
import pt.isep.nsheets.shared.core.Workbook;
import pt.isep.nsheets.shared.lapr4.red.s1.core.n1161292.services.WorkbookDTO;

/**
 *
 * @author Pedro Rodrigues (1140572)
 */
public class DeleteWorkbookController {
    
    WorkbookRepository repo = PersistenceContext.repositories().workbooks();
    
    public void deleteWorkbook(WorkbookDTO wdto) {
        Workbook workbook = repo.findByName(wdto.name);
        repo.deleteWorkbook(workbook.name());
    }
    
}
