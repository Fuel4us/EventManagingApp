package pt.isep.nsheets.shared.core.formula.lang;

import pt.isep.nsheets.shared.core.IllegalValueTypeException;
import pt.isep.nsheets.shared.core.Value;
import pt.isep.nsheets.shared.core.formula.Expression;
import pt.isep.nsheets.shared.core.formula.Function;
import pt.isep.nsheets.shared.core.formula.FunctionParameter;

public class DoWhile implements Function{

    public static final FunctionParameter[] parameters = new FunctionParameter[]{
            new FunctionParameter(Value.Type.UNDEFINED, "Instruction", false, "An instruction to execute"),
            new FunctionParameter(Value.Type.BOOLEAN, "Condition", false, "The condition on which to execute the instruction")
    };

    @Override
    public String getIdentifier() {
        return "DOWHILE";
    }

    @Override
    public Value applyTo(Expression[] args) throws IllegalValueTypeException {
        Value value = null;

        do{
            value = args[0].evaluate();
        } while (args[1].evaluate().toBoolean());

        return value;
    }

    @Override
    public FunctionParameter[] getParameters() {
        return parameters;
    }

    @Override
    public String getInformativeText() {
        return "Executes the instruction, and then keeps executing based on if the condition evaluates to true";
    }

    @Override
    public boolean isVarArg() {
        return false;
    }
}
