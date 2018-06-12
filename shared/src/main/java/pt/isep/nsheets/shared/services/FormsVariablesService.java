package pt.isep.nsheets.shared.services;

import com.google.gwt.user.client.rpc.RemoteService;
import com.google.gwt.user.client.rpc.RemoteServiceRelativePath;

@RemoteServiceRelativePath("formsVariablesService")
public interface FormsVariablesService extends RemoteService {


    String getContentFromVariableByName(String name, int choice);

    void addTemporaryVariable(String name, String value, int choice);
}
