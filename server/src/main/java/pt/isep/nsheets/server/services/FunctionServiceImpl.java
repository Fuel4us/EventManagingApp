/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package pt.isep.nsheets.server.services;

import com.google.gwt.user.server.rpc.RemoteServiceServlet;
import java.util.ArrayList;
import java.util.List;
import java.util.Properties;
import pt.isep.nsheets.server.lapr4.red.s3.lang.n1160630.Js.Js_controller;
import pt.isep.nsheets.server.lapr4.white.s1.core.n4567890.workbooks.persistence.PersistenceContext;
import pt.isep.nsheets.server.lapr4.white.s1.core.n4567890.workbooks.persistence.PersistenceSettings;
import pt.isep.nsheets.shared.core.js_complex.Function;
import pt.isep.nsheets.shared.services.DataException;
import pt.isep.nsheets.shared.services.FunctionService;

/**
 *
 * @author pedromonteiro
 */
public class FunctionServiceImpl extends RemoteServiceServlet implements FunctionService {

    private PersistenceSettings getPersistenceSettings() {

        Properties props = new Properties();

        props.put("persistence.repositoryFactory",
                "pt.isep.nsheets.server.lapr4.white.s1.core.n4567890.workbooks.persistence.jpa.JpaRepositoryFactory");
        props.put("persistence.persistenceUnit", "lapr4.NSheetsPU");

        return new PersistenceSettings(props);
    }

    @Override
    public List<Function> getFunctions() {
        PersistenceContext.setSettings(this.getPersistenceSettings());

        ArrayList<Function> functions = new ArrayList<>();

        Js_controller ctrl = new Js_controller();

        Iterable<Function> it_functions = ctrl.getFunctions();

        it_functions.forEach(function -> functions.add(function));

        return functions;
    }

    @Override
    public Function addFunction(Function function) throws DataException {
        PersistenceContext.setSettings(this.getPersistenceSettings());
        return new Js_controller().addFunction(function);
    }

//    @Override
//    public boolean removeFunction(Function function) {
//        PersistenceContext.setSettings(this.getPersistenceSettings());
//        return new Js_controller().removeFunction(function);
//    }

    @Override
    public Function removeFunction(Function function) {
        PersistenceContext.setSettings(this.getPersistenceSettings());
        return new Js_controller().removeFunction(function);
    }

}
