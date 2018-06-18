package pt.isep.nsheets.shared.core.formula;

import pt.isep.nsheets.shared.core.IllegalValueTypeException;
import pt.isep.nsheets.shared.core.Value;
import pt.isep.nsheets.shared.core.formula.util.ExpressionVisitor;

/**
 *
 * @author Pedro Marques Vieira
 */
public class NaryOperation extends Operation<NaryOperator>{
    
    /** operands */
    private Expression[] operands;
    
    //private NaryOperator operator;
        
    public NaryOperation(NaryOperator operator, Expression[] operands) {
        super(operator);      
        this.operands=operands;
    }

    @Override
    public Value evaluate() throws IllegalValueTypeException {
        return operator.applyTo(operands);
    }

    @Override
    public Object accept(ExpressionVisitor visitor) {
        return visitor.visitNaryOperation(this);
    }
 
    public Expression[] getOperands() {
        return this.operands;
    }
}
