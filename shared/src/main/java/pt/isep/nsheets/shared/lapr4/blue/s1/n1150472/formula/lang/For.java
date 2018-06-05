package pt.isep.nsheets.shared.lapr4.blue.s1.n1150472.formula.lang;

import pt.isep.nsheets.shared.core.IllegalValueTypeException;
import pt.isep.nsheets.shared.core.Value;
import pt.isep.nsheets.shared.core.formula.Expression;
import pt.isep.nsheets.shared.core.formula.Function;
import pt.isep.nsheets.shared.core.formula.FunctionParameter;

/**
 * @author Pedro Alves 1150372@isep.ipp.pt
 */
public class For implements Function {

    public boolean initialized = false;
    Value value = null;
    Value boundary = new Value(true);
    private int nextBlock = 1;
    
    public static final FunctionParameter[] parameters = new FunctionParameter[]{
        new FunctionParameter(Value.Type.UNDEFINED, "ForExpression", false,
        "The for expressions")
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
        return value.isOfType(Value.Type.UNDEFINED);
    }

}
