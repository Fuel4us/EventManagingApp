package pt.isep.nsheets.shared.lapr4.red.n1160600.services;

import com.google.gwt.user.client.rpc.RemoteService;
import com.google.gwt.user.client.rpc.RemoteServiceRelativePath;
import pt.isep.nsheets.shared.core.Spreadsheet;

@RemoteServiceRelativePath("spreadsheetService")
public interface SpreadsheetService extends RemoteService{
    public void sortCells(String stringCell1, String stringCell2, Spreadsheet spreadSheet, boolean ascendant);
}
