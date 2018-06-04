package pt.isep.nsheets.shared.core.formula.lang;

import java.util.logging.Level;
import java.util.logging.Logger;
import pt.isep.nsheets.shared.core.IllegalValueTypeException;
import pt.isep.nsheets.shared.core.Value;
import static pt.isep.nsheets.shared.core.Value.Type.*;
import pt.isep.nsheets.shared.core.formula.BinaryOperator;
import pt.isep.nsheets.shared.core.formula.Expression;
import pt.isep.nsheets.shared.core.formula.compiler.FormulaCompilationException;

/**
 * @author Pedro Alves 1150372@isep.ipp.pt s1
 */
public class Assignment implements BinaryOperator {

    @Override
    public Value applyTo(Expression leftOperand, Expression rightOperand) throws IllegalValueTypeException {
        if (leftOperand instanceof CellReference) {
            Value value = rightOperand.evaluate();
            CellReference leftOp = (CellReference) leftOperand;
            String content = "";
            switch (value.getType()) {
                case NUMERIC:
                    content = value.toString();
                    break;
                case TEXT:
                    content = value.toText();
                    break;
                case BOOLEAN:
                    content = value.toBoolean().toString();
                    break;
                case DATE:
                    content = value.toDate().toString();
                    break;
                default:
                    throw new UnsupportedOperationException("The Rigth Operand are not a numeric,text,boolean or date.");
            }
            try {
                leftOp.getCell().setContent(content);
            } catch (FormulaCompilationException ex) {
                Logger.getLogger(Assignment.class.getName()).log(Level.SEVERE, null, ex);
            }
            return value;
        } else {
            throw new UnsupportedOperationException("The Left Operand are not a cellreference.");
        }
    }

    @Override
    public String getIdentifier() {
        return ":=";
    }

    @Override
    public Value.Type getOperandValueType() {
        return Value.Type.UNDEFINED;
    }

    @Override
    public String toString() {
        return getIdentifier();
    }

}
