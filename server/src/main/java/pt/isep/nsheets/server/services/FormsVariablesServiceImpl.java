package pt.isep.nsheets.server.services;

import com.google.gwt.user.server.rpc.RemoteServiceServlet;
import pt.isep.nsheets.shared.lapr4.green.n1140302.s2.Forms.FormsAndVariablesController;
import pt.isep.nsheets.shared.services.FormsVariablesService;

public class FormsVariablesServiceImpl extends RemoteServiceServlet implements FormsVariablesService {
    @Override
    public String getContentFromVariableByName(String name,int choice) {
        FormsAndVariablesController controller = new FormsAndVariablesController();
        return controller.getTemporaryVariableByName(name,choice);
    }

    @Override
    public void addTemporaryVariable(String name, String value,int choice) {
        FormsAndVariablesController controller = new FormsAndVariablesController();
        controller.addTemporaryVariable(name,value,choice);
    }
}