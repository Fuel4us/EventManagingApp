package pt.isep.nsheets.shared.lapr4.blue.n1050475.s1.services;

import com.google.gwt.user.client.rpc.AsyncCallback;

import java.util.ArrayList;
import java.util.List;
import pt.isep.nsheets.shared.lapr4.green.n1160557.s2.services.CellRangeDTO;
import pt.isep.nsheets.shared.lapr4.green.n1160557.s2.services.ConditionalRangeDTO;
import pt.isep.nsheets.shared.lapr4.red.s1.core.n1161292.services.CellDTO;

public interface ConditionalServiceAsync {
    void getListConditional(AsyncCallback<ArrayList<ConditionalDTO>> async);

    void saveConditional(ConditionalDTO conditionalDTO, AsyncCallback<ConditionalDTO> async);
    
    void saveRangeConditional(ConditionalRangeDTO conditionalRangeDTO, AsyncCallback<List<ConditionalDTO>> async);
    
    void deleteConditional(CellDTO cell, AsyncCallback<CellDTO> async);
    
    void deleteRangeConditional(CellRangeDTO range, AsyncCallback<CellRangeDTO> async);
}
