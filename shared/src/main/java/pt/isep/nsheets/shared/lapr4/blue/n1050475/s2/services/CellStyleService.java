package pt.isep.nsheets.shared.lapr4.blue.n1050475.s2.services;


import com.google.gwt.user.client.rpc.RemoteService;
import com.google.gwt.user.client.rpc.RemoteServiceRelativePath;
import pt.isep.nsheets.shared.services.DataException;

import java.util.ArrayList;

@RemoteServiceRelativePath("cellStyleService")
public interface CellStyleService extends RemoteService {
    ArrayList<CellStyleDTO> getListCellStyle();

    CellStyleDTO saveCellStyle(CellStyleDTO cellStyleDTO) throws DataException;
}