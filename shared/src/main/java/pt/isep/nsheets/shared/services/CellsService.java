package pt.isep.nsheets.shared.services;

import com.google.gwt.user.client.rpc.RemoteService;
import com.google.gwt.user.client.rpc.RemoteServiceRelativePath;

@RemoteServiceRelativePath("cellsService")
public interface CellsService extends RemoteService {
    void getResult(String name,String expression,String result);
}
