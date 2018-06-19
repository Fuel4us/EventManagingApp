/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package pt.isep.nsheets.server.lapr4.red.s3.lang.n1160630.Js;

import eapli.framework.persistence.DataConcurrencyException;
import eapli.framework.persistence.DataIntegrityViolationException;
import java.util.logging.Level;
import java.util.logging.Logger;
import pt.isep.nsheets.server.lapr4.white.s1.core.n4567890.workbooks.persistence.PersistenceContext;
import pt.isep.nsheets.shared.core.js_complex.Function;

/**
 *
 * @author pedromonteiro
 */
public class FunctionService {

    public Iterable<Function> allFunctions() {
        final FunctionRepository functionRepo = PersistenceContext.repositories().functions();
        return functionRepo.findAll();
    }

    public Function addFunction(Function function) {

        final FunctionRepository functionRepo = PersistenceContext.repositories().functions();

        if (addFunction(functionRepo, function)) {
            try {
                functionRepo.save(function);
                return function;
            } catch (DataConcurrencyException | DataIntegrityViolationException ex) {
                Logger.getLogger(FunctionService.class.getName()).log(Level.SEVERE, null, ex);
            }
        }

        return null;

    }

    private boolean addFunction(FunctionRepository repo, Function function) {

        for (Function f : repo.findAll()) {
            if (f.equals(function)) {
                return false;
            }
        }

        return true;
    }
    
    public void removeFunction(Function function){
        final FunctionRepository functionRepo = PersistenceContext.repositories().functions();
        functionRepo.delete(function);
    }
    
}
