/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package pt.isep.nsheets.shared.domain;

import pt.isep.nsheets.shared.core.Cell;
import pt.isep.nsheets.shared.core.Spreadsheet;
import pt.isep.nsheets.shared.core.Value;

/**
 *
 * @author João Pires 1150455@isep.ipp.pt>
 */
public class TemporaryVariable {

    private Spreadsheet sheet;

    private Cell cell;

    private String variableName;

    private Value[] variableValue;

    /**
     * Constructor with parameters
     *
     * @param sheet sheet
     * @param cell cell
     * @param varValue varValue
     * @param name name
     */
    public TemporaryVariable(Spreadsheet sheet, Cell cell, String name, Value[] varValue) {
        this.sheet = sheet;
        this.cell = cell;
        this.variableName = name;
        this.variableValue = varValue;
    }

    /**
     * Constructor with no parameters
     */
    public TemporaryVariable() {
    }

    /**
     * Returns the sheet where the temporary variable is being used
     *
     * @return sheet of the temporary variable
     */
    public Spreadsheet getSheet() {
        return sheet;
    }

    /**
     * Returns the cell where the temporary variable is being used
     *
     * @return the cell of the temporary variable
     */
    public Cell getCell() {
        return cell;
    }

    /**
     * Returns the name of the temporary variable
     *
     * @return name of temporary variable
     */
    public String getName() {
        return variableName;
    }

    /**
     * Returns the value of the temporary variable
     *
     * @return value of the temporary variable
     */
    public Value[] getValue() {
        return variableValue;
    }

    public void changeValue(Value value, int index) {
        this.variableValue[index] = value;
    }

    /**
     * @param value is the new value applied to the temporary variable
     */
    public void setValue(Value[] value) {
        this.variableValue = value;
    }

    /**
     * Method declaration to print
     *
     * @return name and value format
     */
    @Override
    public String toString() {
        return (this.getName());
    }

}
