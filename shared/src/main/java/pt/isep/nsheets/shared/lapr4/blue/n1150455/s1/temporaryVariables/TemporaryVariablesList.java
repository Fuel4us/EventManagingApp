/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package pt.isep.nsheets.shared.lapr4.blue.n1150455.s1.temporaryVariables;

import java.util.ArrayList;
import java.util.List;
import pt.isep.nsheets.shared.core.Cell;
import pt.isep.nsheets.shared.core.Spreadsheet;
import pt.isep.nsheets.shared.core.Value;

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
     * @param sheet sheet
     * @param var
     * @param value value
     */
    public static void addTempVariable(Spreadsheet sheet, String var, Value value) {
        TemporaryVariable tempVar = new TemporaryVariable(sheet, var, value);
        list.add(tempVar);
    }

    /**
     * This method can be useful to change the value of temporary variable
     *
     * @param tempVar tempVar
     * @param value value
     * @param pos
     */
    public static void update(TemporaryVariable tempVar, Value value, int pos) {
        if (list.contains(tempVar)) {
            int index = list.indexOf(tempVar);
            list.get(index).changeValue(value);
        }
    }

    /**
     * Method that returns the list of temporary variables
     *
     * @return list
     */
    public List<TemporaryVariable> getAll() {
        return list;
    }

    /**
     * Given a sheet, cell and a name, finds and returns the temporary variable
     *
     * @param sheet sheet
     * @param cell cell
     * @param var
     * @return stored temporary variable
     */
    public static TemporaryVariable getVariable(Spreadsheet sheet, Cell cell, String var) {
        for (TemporaryVariable variable : list) {
            if (variable.getName().equals(var) && variable.getSheet().equals(sheet)) {
                return variable;
            } else {
            }
        }
        return null;
    }
}
