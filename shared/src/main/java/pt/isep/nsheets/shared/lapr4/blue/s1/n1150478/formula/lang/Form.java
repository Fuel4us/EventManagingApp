package pt.isep.nsheets.shared.lapr4.blue.s1.n1150478.formula.lang;

import pt.isep.nsheets.shared.core.IllegalValueTypeException;
import pt.isep.nsheets.shared.core.Value;
import pt.isep.nsheets.shared.core.formula.Expression;
import pt.isep.nsheets.shared.core.formula.Function;
import pt.isep.nsheets.shared.core.formula.FunctionParameter;

/**
 * @author Pedro Alves 1150372@isep.ipp.pt
 */
public class Form implements Function {

    public boolean initialized = false;
    Value value = null;
    Value boundary = new Value(true);

    public static final FunctionParameter[] parameters = new FunctionParameter[]{
        new FunctionParameter(Value.Type.UNDEFINED, "FORM EXPRESSION", false,
        "The form expressions")
    };

    public Form() {
    }

    @Override
    public String getIdentifier() {
        return "FORM";
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
        return false;
    }

    @Override
    public String getInformativeText() {
        return "form function";
    }

}
