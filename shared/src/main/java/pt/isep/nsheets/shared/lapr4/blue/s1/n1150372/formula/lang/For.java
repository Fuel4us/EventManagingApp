package pt.isep.nsheets.shared.lapr4.blue.s1.n1150372.formula.lang;

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

    public static final FunctionParameter[] parameters = new FunctionParameter[]{
        new FunctionParameter(Value.Type.UNDEFINED, "ForExpression", false,
        "The for expressions")
    };

    public For() {
    }

    @Override
    public String getIdentifier() {
        return "FOR{";
    }

    @Override
    public Value applyTo(Expression[] args) throws IllegalValueTypeException {
        args[0].evaluate();
        int i;
        do {
            i = 2;
            while (i < args.length) {
                if (i == args.length - 1) {
                    value = args[i].evaluate();
                } else {
                    args[i].evaluate();
                }
                i++;
            }
            boundary = args[1].evaluate();
        } while (boundary.toBoolean());
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

}
