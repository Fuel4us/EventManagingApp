package pt.isep.nsheets.shared.lapr4.red.n1160600.services;

import com.google.gwt.user.client.rpc.AsyncCallback;
import pt.isep.nsheets.shared.core.Spreadsheet;
import pt.isep.nsheets.shared.lapr4.red.s1.core.n1161292.services.SpreadsheetDTO;

public interface SpreadsheetServiceAsync {
    void sortCells(String stringCell1, String stringCell2, SpreadsheetDTO spreadSheet, boolean ascendant, AsyncCallback<SpreadsheetDTO> callback);
}
