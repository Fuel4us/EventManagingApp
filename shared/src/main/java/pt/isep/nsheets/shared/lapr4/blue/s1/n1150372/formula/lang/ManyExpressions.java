package pt.isep.nsheets.shared.lapr4.blue.s1.n1150372.formula.lang;

import pt.isep.nsheets.shared.core.IllegalValueTypeException;
import pt.isep.nsheets.shared.core.Value;
import pt.isep.nsheets.shared.core.formula.Expression;
import pt.isep.nsheets.shared.core.formula.Function;
import pt.isep.nsheets.shared.core.formula.FunctionParameter;

/**
 * @author Pedro Alves 1150372@isep.ipp.pt
 */
public class ManyExpressions implements Function {

    Value value = null;

    public static final FunctionParameter[] parameters = new FunctionParameter[]{
        new FunctionParameter(Value.Type.UNDEFINED, "Many Expressions", false,
        "The block of many expressions")
    };

    public ManyExpressions() {
    }

    @Override
    public String getIdentifier() {
        return "{";
    }

    @Override
    public Value applyTo(Expression[] args) throws IllegalValueTypeException {
        for (int i = 0; i < args.length; i++) {
            if (i == args.length - 1) {
                value = args[i].evaluate();
            } else {
                args[i].evaluate();
            }
        }
        return value;
    }

    @Override
    public FunctionParameter[] getParameters() {
        return parameters;
    }

    @Override
    public boolean isVarArg() {
        return value.isOfType(Value.Type.UNDEFINED);
    }

    @Override
    public String getInformativeText() {
        return "Many Expressions function";
    }

}
