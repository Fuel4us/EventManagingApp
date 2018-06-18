package pt.isep.nsheets.shared.core.formula.lang;

import pt.isep.nsheets.shared.core.IllegalValueTypeException;
import pt.isep.nsheets.shared.core.Value;
import pt.isep.nsheets.shared.core.formula.Expression;
import pt.isep.nsheets.shared.core.formula.NaryOperator;

/**
 *
 * @author Pedro Marques Vieira
 */
public class Block implements NaryOperator{
    
    @Override
    public Value applyTo(Expression[] operands) throws IllegalValueTypeException {
        Value value = null;
        
        for (Expression expr : operands) {
            value = expr.evaluate();
        }

        return value;
    }

    @Override
    public String getIdentifier() {
        return "{";
    }

    @Override
    public Value.Type getOperandValueType() {
        return Value.Type.NUMERIC;
    }
}
