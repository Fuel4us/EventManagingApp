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
        int cont = 0;

        for (Workbook workbook : repo.findAll()) {
            for (int i = 0; i < workbookName.length(); i++) {
                if (workbook.name().charAt(i) == workbookName.charAt(i)) {
                    cont++;
                }
            }
            if (cont == workbookName.length()) {
                searchedWorkbooks.add(workbook);
                cont=0;
            }
        }
        return searchedWorkbooks;
    }
}
