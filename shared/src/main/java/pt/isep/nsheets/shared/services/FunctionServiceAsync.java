/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package pt.isep.nsheets.shared.services;

import com.google.gwt.user.client.rpc.AsyncCallback;
import java.util.List;
import pt.isep.nsheets.shared.core.js_complex.Function;

/**
 *
 * @author pedromonteiro
 */
public interface FunctionServiceAsync {
    void getFunctions(AsyncCallback<List<Function>> callback);
    void addFunction(Function function, AsyncCallback<Function> callback) throws DataException;
    void removeFunction(Function function, AsyncCallback<Function> callback);
//    void removeFunction(Function function, AsyncCallback<Function> callback);
}
