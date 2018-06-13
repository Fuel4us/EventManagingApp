package pt.isep.nsheets.shared.core.formula.lang;

import pt.isep.nsheets.shared.core.IllegalValueTypeException;
import pt.isep.nsheets.shared.core.Value;
import pt.isep.nsheets.shared.core.formula.*;

public class Eval implements Function {

    public static final FunctionParameter[] parameters = new FunctionParameter[]{
            new FunctionParameter(Value.Type.UNDEFINED, "Formula to evaluate", false,
                    "A text expression to evaluate")
    };

    @Override
    public String getIdentifier() {
        return "EVAL";
    }

    @Override
    public Value applyTo(Expression[] args) throws IllegalValueTypeException {
        return args[0].evaluate();
    }

    @Override
    public FunctionParameter[] getParameters() {
        return parameters;
    }

    @Override
    public String getInformativeText() {
        return "Evaluates the argument expression and returns its result";
    }

    @Override
    public boolean isVarArg() {
        return false;
    }

}
