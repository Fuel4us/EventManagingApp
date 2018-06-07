package pt.isep.nsheets.shared.lapr4.blue.s1.n1150372.formula.lang;

import gwt.material.design.client.ui.MaterialToast;
import pt.isep.nsheets.shared.application.Settings;
import pt.isep.nsheets.shared.core.IllegalValueTypeException;
import pt.isep.nsheets.shared.core.Value;
import static pt.isep.nsheets.shared.core.Value.Type.*;
import pt.isep.nsheets.shared.core.formula.BinaryOperator;
import pt.isep.nsheets.shared.core.formula.Expression;
import pt.isep.nsheets.shared.core.formula.Literal;
import pt.isep.nsheets.shared.core.formula.compiler.FormulaCompilationException;
import pt.isep.nsheets.shared.core.formula.lang.CellReference;
import pt.isep.nsheets.shared.lapr4.blue.n1150455.s1.temporaryVariables.TemporaryVariable;
import pt.isep.nsheets.shared.lapr4.blue.n1150455.s1.temporaryVariables.TemporaryVariablesList;
import pt.isep.nsheets.shared.lapr4.green.n1160815.formula.lang.GlobalVariable;

/**
 * @author Pedro Alves 1150372@isep.ipp.pt s1
 */
public class Assignment implements BinaryOperator {

    public Assignment() {
    }

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
                MaterialToast.fireToast("Erro na classe Assigment.");
            }
            return new Value(content);
        } else {
            if (leftOperand instanceof TemporaryVariable) {
                Value value = rightOperand.evaluate();
                TemporaryVariable leftOp = (TemporaryVariable) leftOperand;

                leftOp.setContent(new Literal(value));
                TemporaryVariablesList.addTempVariable(leftOp);
                return value;
            } else if (leftOperand instanceof GlobalVariable) {
                Value value = rightOperand.evaluate();
                GlobalVariable leftOp = (GlobalVariable) leftOperand;

                leftOp.setContent(new Literal(value));
                Settings.getInstance().getWorkbook().addGlobalVariable(leftOp);
                return value;
            }
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
