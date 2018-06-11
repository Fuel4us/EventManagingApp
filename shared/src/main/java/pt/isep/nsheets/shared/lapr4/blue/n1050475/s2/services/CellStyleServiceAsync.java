package pt.isep.nsheets.shared.lapr4.blue.n1050475.s2.services;

import com.google.gwt.user.client.rpc.AsyncCallback;

import java.util.ArrayList;

public interface CellStyleServiceAsync {
    void getListCellStyle(AsyncCallback<ArrayList<CellStyleDTO>> async);

    void saveCellStyle(CellStyleDTO cellStyleDTO, AsyncCallback<CellStyleDTO> async);
}
