package pt.isep.nsheets.shared.lapr4.blue.n1050475.s1.services;

import com.google.gwt.user.client.rpc.AsyncCallback;
import pt.isep.nsheets.shared.lapr4.blue.n1050475.s1.services.ConditionalDTO;

import java.util.List;

public interface ConditionalServiceAsync {
    void getListConditional(AsyncCallback<List<ConditionalDTO>> async);

    void saveConditional(ConditionalDTO conditionalDTO, AsyncCallback<ConditionalDTO> async);
}
