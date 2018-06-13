package pt.isep.nsheets.shared.core.formula.lang;

import pt.isep.nsheets.shared.core.IllegalValueTypeException;
import pt.isep.nsheets.shared.core.Value;
import pt.isep.nsheets.shared.core.formula.Expression;
import pt.isep.nsheets.shared.core.formula.Function;
import pt.isep.nsheets.shared.core.formula.FunctionParameter;

public class WhileDo implements Function {

    public static final FunctionParameter[] parameters = new FunctionParameter[]{
            new FunctionParameter(Value.Type.BOOLEAN, "Condition", false, "The condition on which to execute the instruction"),
            new FunctionParameter(Value.Type.UNDEFINED, "Instruction", false, "An instruction to execute")
    };

    @Override
    public String getIdentifier() {
        return "WHILEDO";
    }

    @Override
    public Value applyTo(Expression[] args) throws IllegalValueTypeException {
        Value value = null;

        while (args[1].evaluate().toBoolean()) {
            value = args[0].evaluate();
        }

        return value;
    }

    @Override
    public FunctionParameter[] getParameters() {
        return parameters;
    }

    @Override
    public String getInformativeText() {
        return "Evaluates the condition, and then executes the instruction based on if the condition evaluates to true, then looping until it is false";
    }

    @Override
    public boolean isVarArg() {
        return false;
    }
}
