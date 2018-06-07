package pt.isep.nsheets.shared.lapr4.red.n1160600.services;

import com.google.gwt.user.client.rpc.RemoteService;
import com.google.gwt.user.client.rpc.RemoteServiceRelativePath;
import pt.isep.nsheets.shared.core.Spreadsheet;
import pt.isep.nsheets.shared.lapr4.red.s1.core.n1161292.services.SpreadsheetDTO;

@RemoteServiceRelativePath("spreadsheetService")
public interface SpreadsheetService extends RemoteService{
    public SpreadsheetDTO sortCells(String stringCell1, String stringCell2, SpreadsheetDTO spreadSheet, boolean ascendant);
}
