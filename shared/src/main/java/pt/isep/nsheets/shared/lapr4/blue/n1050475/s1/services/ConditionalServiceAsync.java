package pt.isep.nsheets.shared.lapr4.blue.n1050475.s1.services;

import com.google.gwt.user.client.rpc.AsyncCallback;
import pt.isep.nsheets.shared.lapr4.blue.n1050475.s1.services.ConditionalDTO;

import java.util.ArrayList;

public interface ConditionalServiceAsync {
    void getListConditional(AsyncCallback<ArrayList<ConditionalDTO>> async);

    void saveConditional(ConditionalDTO conditionalDTO, AsyncCallback<ConditionalDTO> async);
}
