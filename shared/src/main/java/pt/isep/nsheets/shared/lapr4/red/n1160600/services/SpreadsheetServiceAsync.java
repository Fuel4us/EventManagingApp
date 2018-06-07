package pt.isep.nsheets.shared.lapr4.red.n1160600.services;

import com.google.gwt.user.client.rpc.AsyncCallback;
import pt.isep.nsheets.shared.core.Spreadsheet;

public interface SpreadsheetServiceAsync {
    void sortCells(String stringCell1, String stringCell2, Spreadsheet spreadSheet, boolean ascendant, AsyncCallback<Void> callback);
}
