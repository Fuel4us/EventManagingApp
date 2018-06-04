package pt.isep.nsheets.shared.lapr4.blue.n1050475.s1.services;

import com.google.gwt.user.client.rpc.RemoteService;
import com.google.gwt.user.client.rpc.RemoteServiceRelativePath;
import pt.isep.nsheets.shared.services.DataException;

@RemoteServiceRelativePath("conditionalService")
public interface ConditionalService extends RemoteService {
    ConditionalDTO getConditional();

    ConditionalDTO saveConditional(ConditionalDTO conditionalDTO) throws DataException;
}