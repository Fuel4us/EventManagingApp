package pt.isep.nsheets.shared.lapr4.blue.n1050475.s1.services;


import com.google.gwt.user.client.rpc.RemoteService;
import com.google.gwt.user.client.rpc.RemoteServiceRelativePath;
import pt.isep.nsheets.shared.services.DataException;

import java.util.ArrayList;
import java.util.List;
import pt.isep.nsheets.shared.lapr4.green.n1160557.s2.services.ConditionalRangeDTO;

@RemoteServiceRelativePath("conditionalService")
public interface ConditionalService extends RemoteService {
    ArrayList<ConditionalDTO> getListConditional();

    ConditionalDTO saveConditional(ConditionalDTO conditionalDTO) throws DataException;
    
    List<ConditionalDTO> saveRangeConditional(ConditionalRangeDTO conditionalRangeDTO) throws DataException;
}
