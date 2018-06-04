package pt.isep.nsheets.shared.lapr4.blue.n1050475.s1.Formula;

import pt.isep.nsheets.shared.core.Value;
import pt.isep.nsheets.shared.core.formula.BinaryOperation;
import pt.isep.nsheets.shared.core.formula.Literal;
import pt.isep.nsheets.shared.core.formula.lang.LanguageManager;
import pt.isep.nsheets.shared.core.formula.lang.UnknownElementException;

public class BinaryOperationExtension extends BinaryOperation {

    /**
     * Creates a new binary operation.
     *
     * @param leftOperand  the left(first) operand
     * @param condOperator     the String operator
     * @param rightOperand the right(second) operand
     */
    public BinaryOperationExtension(Value leftOperand, String condOperator, Value rightOperand) throws UnknownElementException {
        super(new Literal(leftOperand), LanguageManager.getInstance().getLanguage("excel").getBinaryOperator(condOperator), new Literal(rightOperand));
    }
}
