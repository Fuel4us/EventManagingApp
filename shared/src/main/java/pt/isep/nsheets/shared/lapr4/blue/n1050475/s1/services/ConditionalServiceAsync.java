package pt.isep.nsheets.shared.lapr4.blue.n1050475.s1.services;

import com.google.gwt.user.client.rpc.AsyncCallback;

public interface ConditionalServiceAsync {

    void getConditional(AsyncCallback<ConditionalDTO> async);

    void saveConditional(ConditionalDTO conditionalDTO, AsyncCallback<ConditionalDTO> async);
}
