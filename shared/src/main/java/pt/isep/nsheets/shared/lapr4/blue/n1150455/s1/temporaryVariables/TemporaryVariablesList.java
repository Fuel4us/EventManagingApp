/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package pt.isep.nsheets.shared.lapr4.blue.n1150455.s1.temporaryVariables;

import gwt.material.design.client.ui.MaterialToast;
import java.util.ArrayList;
import java.util.List;
import pt.isep.nsheets.shared.core.Cell;
import pt.isep.nsheets.shared.core.Spreadsheet;
import pt.isep.nsheets.shared.core.Value;
import pt.isep.nsheets.shared.core.formula.Expression;

/**
 *
 * @author João Pires <1150455@isep.ipp.pt>
 */
public class TemporaryVariablesList {

    /**
     * List with temporary variables
     */
    private static final List<TemporaryVariable> list = new ArrayList<TemporaryVariable>();

    /**
     * Adds variable to list
     *
     * @param tempVar
     */
    public static void addTempVariable(TemporaryVariable tempVar) {
        if (!exists(tempVar)) {
            list.add(tempVar);
        } else {
            MaterialToast.fireToast("Temporary variable already exists.");
        }
    }

    private static boolean exists(TemporaryVariable tempVar) {
        for (TemporaryVariable tempVariable : list) {
            if (tempVariable.getValue().equals(tempVar.getValue())) {
                return false;
            }
        }
        return true;
    }

    /**
     * Method that returns the list of temporary variables
     *
     * @return list
     */
    public List<TemporaryVariable> getAll() {
        return list;
    }

    public Expression getExpressionByTemporary(Value value) {
        for (TemporaryVariable temporaryVariable : list) {
            if (temporaryVariable.getValue().equals(value)) {
                return temporaryVariable.getExpression();
            }
        }
        return null;
    }
}
