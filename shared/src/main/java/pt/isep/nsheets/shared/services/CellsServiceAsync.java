package pt.isep.nsheets.shared.services;

import com.google.gwt.user.client.rpc.AsyncCallback;

public interface CellsServiceAsync {


    void getResult(String name, String expression, String result, AsyncCallback<Void> async);
}
