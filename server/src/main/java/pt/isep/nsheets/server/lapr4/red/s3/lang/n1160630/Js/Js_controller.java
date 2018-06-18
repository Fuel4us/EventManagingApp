/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package pt.isep.nsheets.server.lapr4.red.s3.lang.n1160630.Js;

import eapli.framework.application.Controller;
import pt.isep.nsheets.shared.core.js_complex.Function;

/**
 *
 * @author pedromonteiro
 */
public class Js_controller implements Controller {

    public Function addFunction(Function function) {

        Function f = new FunctionService().addFunction(function);

        return f;
    }

    public Iterable<Function> getFunctions() {
        return new FunctionService().allFunctions();
    }


}
