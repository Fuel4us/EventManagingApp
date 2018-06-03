package pt.isep.nsheets.server.lapr4.green.s1.core.n1160832.spreadsheets.application;

import eapli.framework.application.Controller;
import pt.isep.nsheets.shared.core.Spreadsheet;

/**
 *
 * @author Mário Vaz
 */
public class ListSpreadsheetController implements Controller {

    /**
     *
     * @return
     */
    public Iterable<Spreadsheet> listSpreadsheets() {
        return new SpreadsheetService().allSpreadsheets();
    }
}
