package pt.isep.nsheets.server.lapr4.white.s1.core.n4567890.workbooks.application;

import eapli.framework.application.Controller;
import pt.isep.nsheets.shared.core.Workbook;

public class ListWorkbookDescriptionController implements Controller {

    public Iterable<Workbook> listWorkbookDescriptions() {
        return new WorkbookDescriptionService().allWorkbooks();
    }
}
