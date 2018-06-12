/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package pt.isep.nsheets.shared.core.formula.compiler;

import gwt.material.design.client.ui.MaterialToast;
import pt.isep.nsheets.shared.core.Cell;
import pt.isep.nsheets.shared.core.Value;
import pt.isep.nsheets.shared.core.formula.BinaryOperation;
import pt.isep.nsheets.shared.core.formula.BinaryOperator;
import pt.isep.nsheets.shared.core.formula.Expression;
import pt.isep.nsheets.shared.core.formula.Function;
import pt.isep.nsheets.shared.core.formula.FunctionCall;
import pt.isep.nsheets.shared.core.formula.Literal;
import pt.isep.nsheets.shared.core.formula.UnaryOperation;
import pt.isep.nsheets.shared.core.formula.lang.CellReference;
import pt.isep.nsheets.shared.core.formula.lang.Language;
import pt.isep.nsheets.shared.core.formula.lang.RangeReference;
import pt.isep.nsheets.shared.core.formula.lang.ReferenceOperation;
import pt.isep.nsheets.shared.core.formula.lang.UnknownElementException;
import java.text.ParseException;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import org.antlr.v4.runtime.Token;
import pt.isep.nsheets.shared.application.Settings;
import pt.isep.nsheets.shared.core.IllegalValueTypeException;
import pt.isep.nsheets.shared.core.Workbook;
import pt.isep.nsheets.shared.lapr4.blue.n1150455.s1.temporaryVariables.TemporaryVariable;
import pt.isep.nsheets.shared.lapr4.green.n1160815.formula.lang.GlobalVariable;

/**
 *
 * @author jrt
 */
public class FormulaEvalVisitor extends FormulaBaseVisitor<Expression> {

    private Cell cell = null;
    int numberOfErros;
    private final StringBuilder errorBuffer;

    final private Language language;

    public FormulaEvalVisitor(Cell cell, Language lang) {
        this.cell = cell;
        numberOfErros = 0;
        errorBuffer = new StringBuilder();
        this.language = lang;
    }

    public int getNumberOfErrors() {
        return numberOfErros;
    }

    public String getErrorsMessage() {
        return errorBuffer.toString();
    }

    @Override
    public Expression visitExpression(FormulaParser.ExpressionContext ctx) {
        return visit(ctx.comparison());
    }

    @Override
    public Expression visitComparison(FormulaParser.ComparisonContext ctx) {
        if (ctx.getChildCount() == 3) {
            try {
                BinaryOperator operator = this.language.getBinaryOperator(ctx.getChild(1).getText());

                return new BinaryOperation(
                        visit(ctx.getChild(0)),
                        operator,
                        visit(ctx.getChild(2))
                );
            } catch (UnknownElementException ex) {
                MaterialToast.fireToast("ERRO Comparison getBinaryOperator");
                addVisitError(ex.getMessage());
            }
        }
        return visit(ctx.getChild(0));
    }

    @Override
    public Expression visitBlock(FormulaParser.BlockContext ctx) {
        if (ctx.getChildCount() == 1) {
            return visit(ctx.manyexpressions());
        } else {
            return visit(ctx.forexpression());
        }
    }

    @Override
    public Expression visitConcatenation(FormulaParser.ConcatenationContext ctx
    ) {
        try {
            if (ctx.getChildCount() == 2) { // Convert unary operation
                int operatorid = 0, operand = 1;  // Assume operator on the left

//                if (ctx.getChild(1).getChildCount() == 0) { // Conclude that operator is on the right
                if (ctx.PERCENT() != null) { // Conclude that operator is on the right
                    operatorid = 1;
                    operand = 0;
                }

                return new UnaryOperation(
                        // Language.getInstance().getUnaryOperator(ctx.getChild(operatorid).getText()),
                        this.language.getUnaryOperator(ctx.getChild(operatorid).getText()),
                        visit(ctx.getChild(operand))
                );

            } else if (ctx.getChildCount() == 3) {
                // Convert binary operation
                // BinaryOperator operator = Language.getInstance().getBinaryOperator(ctx.getChild(1).getText());
                BinaryOperator operator = this.language.getBinaryOperator(ctx.getChild(1).getText());
                return new BinaryOperation(
                        visit(ctx.getChild(0)),
                        operator,
                        visit(ctx.getChild(2))
                );
            }

        } catch (FormulaCompilationException ex) {
            MaterialToast.fireToast("ERRO Concatenation");
            addVisitError(ex.getMessage());
        }

        return visit(ctx.getChild(0));
    }

    @Override
    public Expression visitAtom(FormulaParser.AtomContext ctx
    ) {
        if (ctx.getChildCount() == 3) {
            return visit(ctx.getChild(1));
        }

        return visitChildren(ctx);
    }

    public Expression visitFunction_call(FormulaParser.Function_callContext ctx) {
        // Convert function call
        Function function = null;
        try {
            // function = Language.getInstance().getFunction(ctx.getChild(0).getText());
            function = this.language.getFunction(ctx.getChild(0).getText());
        } catch (UnknownElementException ex) {
            Logger.getLogger(FormulaEvalVisitor.class.getName()).log(Level.SEVERE, null, ex);
        }

        if (function != null) {
            try {
                List<Expression> args = new ArrayList<>();
                if (ctx.getChildCount() > 3) {
                    for (int nChild = 2; nChild < ctx.getChildCount() - 1; nChild += 2) {
                        args.add(visit(ctx.getChild(nChild)));
                    }
                }
                Expression[] argArray = args.toArray(new Expression[args.size()]);
                return new FunctionCall(function, argArray);
            } catch (IllegalFunctionCallException ex) {
                addVisitError(ex.getMessage());
                MaterialToast.fireToast("ERRO FUNCTION_CALLL visit childs");
            }
        }
        MaterialToast.fireToast("RETURN NULL_FUNCTION_CALL");
        return null;
    }

    @Override
    public Expression visitReference(FormulaParser.ReferenceContext ctx) {
        try {
            if (ctx.getChildCount() == 3) {
                //BinaryOperator operator = Language.getInstance().getBinaryOperator(ctx.getChild(1).getText());
                BinaryOperator operator = this.language.getBinaryOperator(ctx.getChild(1).getText());

                return new ReferenceOperation(
                        new CellReference(cell.getSpreadsheet(), ctx.getChild(0).getText()),
                        (RangeReference) operator,
                        new CellReference(cell.getSpreadsheet(), ctx.getChild(2).getText())
                );
            } else {
                Token t = (Token) ctx.getChild(0).getPayload();
                switch (t.getType()) {
                    case FormulaParser.CELL_REF:
                        return new CellReference(cell.getSpreadsheet(), ctx.getText());
                    case FormulaParser.NAMEGLOBAL:
                        Workbook currentWorkbook = Settings.getInstance().getWorkbook();

                        String gvName = ctx.getChild(0).getText();
                        if (currentWorkbook.checkIfGVExists(gvName)) {
                            //Global variable already exits
                            return currentWorkbook.getGlobalVariable(gvName);
                        } else {
                            GlobalVariable gv = new GlobalVariable(new Value(), gvName);
                            currentWorkbook.addGlobalVariable(gvName);
                            return gv;
                        }
                    default:
                        return visit(ctx.getChild(0));
                }

            }
            // return visitChildren(ctx); 
        } catch (ParseException | UnknownElementException ex) {
            addVisitError(ex.getMessage());
            MaterialToast.fireToast("ERRO REFERENCE");
        }
        MaterialToast.fireToast("RETURN NULL Reference");
        return null;
    }

    @Override
    public Expression visitLiteral(FormulaParser.LiteralContext ctx) {
        Token t = (Token) ctx.getChild(0).getPayload();

        if (t.getType() == FormulaParser.NUMBER) {
            return new Literal(Value.parseValue(ctx.getText()));
        } else {
            if (t.getType() == FormulaParser.STRING) {
                String value = ctx.getText().substring(1, ctx.getText().length() - 1);
                return new Literal(Value.parseValue(value, Value.Type.BOOLEAN, Value.Type.DATE));
            } else if (t.getType() == FormulaParser.RULE_nameTemporary) {
                TemporaryVariable tempVariable = (TemporaryVariable) ctx.getChild(0);
                return new Literal(tempVariable.getValue());
            }
        }
        MaterialToast.fireToast("RETURN NULL Literal");
        return null;
    }

    @Override
    public Expression visitManyexpressions(FormulaParser.ManyexpressionsContext ctx) {
        Function function = null;
        try {
            // function = Language.getInstance().getFunction(ctx.getChild(0).getText());
            function = this.language.getFunction(ctx.getChild(0).getText());
        } catch (UnknownElementException ex) {
            Logger.getLogger(FormulaEvalVisitor.class.getName()).log(Level.SEVERE, null, ex);
        }

        if (function != null) {
            try {
                List<Expression> args = new ArrayList<>();
                if (ctx.getChildCount() > 2) {
                    for (int nChild = 1; nChild < ctx.getChildCount() - 1; nChild += 2) {
                        args.add(visit(ctx.getChild(nChild)));
                    }
                }
                Expression[] argArray = args.toArray(new Expression[args.size()]);
                // return new FunctionCall(function, argArray);
                return new Literal(function.applyTo(argArray));
            } catch (IllegalValueTypeException ex) {
                Logger.getLogger(FormulaEvalVisitor.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
        MaterialToast.fireToast("RETURN NULL_Many expressions");
        return null;
    }

    @Override
    public Expression visitAssignment(FormulaParser.AssignmentContext ctx) {
        try {
            BinaryOperator operator = this.language.getBinaryOperator(ctx.getChild(1).getText());
            return new BinaryOperation(
                    visit(ctx.getChild(0)),
                    operator,
                    visit(ctx.getChild(2)));
        } catch (UnknownElementException ex) {
            MaterialToast.fireToast("ERRO ASSIGNMENT");
        }
        MaterialToast.fireToast("RETURN NULL ASSIGNMENT");
        return null;
    }

    @Override
    public Expression visitForexpression(FormulaParser.ForexpressionContext ctx) {
        Function function = null;
        try {
            function = this.language.getFunction(ctx.getParent().getChild(0).getText());
        } catch (UnknownElementException ex) {
            MaterialToast.fireToast("ERROR getParent ForExpression.");
        }

        List<Expression> args = new ArrayList<>();

        for (int i = 0; i < ctx.getChildCount(); i += 2) {
            args.add(visit(ctx.getChild(i)));
        }

        Expression[] argArray = args.toArray(new Expression[args.size()]);
        try {
            if (function != null) {
                MaterialToast.fireToast("Apply To");
                //return new FunctionCall(function, argArray);  dava
                return new Literal(function.applyTo(argArray));
            } else {
                MaterialToast.fireToast("FUNCTION NULL");
            }
        } catch (IllegalValueTypeException ex) {
            Logger.getLogger(FormulaEvalVisitor.class.getName()).log(Level.SEVERE, null, ex);
        }

        MaterialToast.fireToast("RETURN NULL FOREXPRESSION");
        return new Literal(new Value());
    }

    @Override
    public Expression visitTemporaryreference(FormulaParser.TemporaryreferenceContext ctx) {
        if (ctx.getChildCount() == 3) {
            try {
                BinaryOperator operator = this.language.getBinaryOperator(ctx.getChild(1).getText());
                TemporaryVariable tempVariable = new TemporaryVariable(new Value(ctx.getChild(0).getText()));
                this.cell.addTempVariable(tempVariable);
                return new BinaryOperation(
                        tempVariable,
                        operator,
                        visit(ctx.getChild(2))
                );
            } catch (UnknownElementException ex) {
                MaterialToast.fireToast("Error in Temporary Reference");
            }
        }

        return null;
    }

    private void addVisitError(String msg) {
        errorBuffer.append(msg).append("\n");
        numberOfErros++;
    }
}
