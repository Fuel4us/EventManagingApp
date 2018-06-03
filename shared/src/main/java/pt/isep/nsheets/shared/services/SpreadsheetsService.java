package pt.isep.nsheets.shared.services;

import com.google.gwt.user.client.rpc.RemoteService;
import com.google.gwt.user.client.rpc.RemoteServiceRelativePath;

@RemoteServiceRelativePath("spreadsheetsService")
public interface SpreadsheetsService extends RemoteService {

    SpreadsheetDTO addSpreadsheet(SpreadsheetDTO spreadsheetDTO) throws DataException;
    Iterable<SpreadsheetDTO> getSpreadsheets();
}
