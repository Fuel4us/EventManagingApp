/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package pt.isep.nsheets.shared.lapr4.blue.n1150455.s1.temporaryVariables;

import pt.isep.nsheets.shared.core.Cell;
import pt.isep.nsheets.shared.core.IllegalValueTypeException;
import pt.isep.nsheets.shared.core.Spreadsheet;
import pt.isep.nsheets.shared.core.Value;
import pt.isep.nsheets.shared.core.formula.Expression;
import pt.isep.nsheets.shared.core.formula.Function;
import pt.isep.nsheets.shared.core.formula.FunctionParameter;
import pt.isep.nsheets.shared.core.formula.Literal;
import pt.isep.nsheets.shared.core.formula.UnaryOperation;
import pt.isep.nsheets.shared.core.formula.util.ExpressionVisitor;

/**
 *
 * @author João Pires 1150455@isep.ipp.pt>
 */
public class TemporaryVariable extends Literal {

    private Expression expression;

    public TemporaryVariable(Value value) {
        super(value);
    }

    public TemporaryVariable(Value value, Expression expression) throws IllegalValueTypeException {
        super(value);
        this.expression = expression;
    }

    public Expression getExpression() {
        return expression;
    }

    public void setContent(Expression expression) {
        this.expression = expression;
    }

    @Override
    public Value getValue() {
        return super.getValue();
    }

}
