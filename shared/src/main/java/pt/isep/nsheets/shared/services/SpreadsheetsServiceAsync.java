package pt.isep.nsheets.shared.services;

import com.google.gwt.user.client.rpc.AsyncCallback;

import java.util.ArrayList;

public interface SpreadsheetsServiceAsync {
    void addSpreadsheet(SpreadsheetDTO spreadsheetDTO, AsyncCallback<ArrayList<SpreadsheetDTO>> callback);
    void listSpreadsheets(AsyncCallback<SpreadsheetDTO> callback);
}
