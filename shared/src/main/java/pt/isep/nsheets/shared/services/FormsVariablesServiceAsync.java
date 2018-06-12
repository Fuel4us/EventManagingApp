package pt.isep.nsheets.shared.services;

import com.google.gwt.user.client.rpc.AsyncCallback;

public interface FormsVariablesServiceAsync {

    void getContentFromVariableByName(String name, int choice, AsyncCallback<String> callback);

    void addTemporaryVariable(String name, String value, int choice, AsyncCallback<Void> callback);
}
