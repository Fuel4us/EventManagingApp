/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package pt.isep.nsheets.server.lapr4.green.s1.core.n1140572.workbooks.application;

import java.util.ArrayList;
import pt.isep.nsheets.server.lapr4.white.s1.core.n4567890.workbooks.persistence.PersistenceContext;
import pt.isep.nsheets.server.lapr4.white.s1.core.n4567890.workbooks.persistence.WorkbookRepository;
import pt.isep.nsheets.shared.core.Workbook;

/**
 *
 * @author Pedro Rodrigues (1140572)
 */
public class SearchWorkbooksController {

    WorkbookRepository repo = PersistenceContext.repositories().workbooks();

    public ArrayList<Workbook> searchWorkbooks(String workbookName) {
        ArrayList<Workbook> searchedWorkbooks = new ArrayList<>();
        
        for (Workbook workbook : repo.findAll()) {
            if (workbook.name().toLowerCase().contains(workbookName.toLowerCase())) {
                searchedWorkbooks.add(workbook);
            }
        }
        return searchedWorkbooks;
    }
}
