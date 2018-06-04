package pt.isep.nsheets.shared.core.formula.lang;

import pt.isep.nsheets.shared.core.IllegalValueTypeException;
import pt.isep.nsheets.shared.core.Value;
import pt.isep.nsheets.shared.core.formula.Expression;
import pt.isep.nsheets.shared.core.formula.Function;
import pt.isep.nsheets.shared.core.formula.FunctionParameter;

/**
 * @author Pedro Alves 1150372@isep.ipp.pt
 */
public class For implements Function {

    /**
     * Parameters: Assignment, Expressions, Cell Reference & signal compartion
     * and final assigmnment.
     */
    public static final FunctionParameter[] parameters = new FunctionParameter[]{
        new FunctionParameter(Value.Type.TEXT, "Assignment", true,
        "The assignment binary operation"),
        new FunctionParameter(Value.Type.MATRIX, "Expressions", true,
        "Expressions."),
        new FunctionParameter(Value.Type.TEXT, "CELL REF", true,
        "Reference and comparation."),
        new FunctionParameter(Value.Type.TEXT, "Assignment", true,
        "The assignment binary operation")
    };

    public For() {
    }

    @Override
    public String getIdentifier() {
        return "FOR";
    }

    @Override
    public Value applyTo(Expression[] args) throws IllegalValueTypeException {
        //throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
        return new Value();
    }

    @Override
    public FunctionParameter[] getParameters() {
        return parameters;
    }

    @Override
    public boolean isVarArg() {
        return false;
    }

}
