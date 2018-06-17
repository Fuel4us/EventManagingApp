package pt.isep.nsheets.shared.core.formula.compiler;

import gwt.material.design.client.ui.MaterialToast;
import org.antlr.v4.runtime.Token;
import pt.isep.nsheets.shared.application.Settings;
import pt.isep.nsheets.shared.core.Cell;
import pt.isep.nsheets.shared.core.IllegalValueTypeException;
import pt.isep.nsheets.shared.core.Value;
import pt.isep.nsheets.shared.core.Workbook;
import pt.isep.nsheets.shared.core.formula.*;
import pt.isep.nsheets.shared.core.formula.lang.*;
import pt.isep.nsheets.shared.lapr4.blue.n1150455.s1.temporaryVariables.TemporaryVariable;
import pt.isep.nsheets.shared.lapr4.green.n1160815.formula.lang.GlobalVariable;

import java.text.ParseException;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;

public class MacroEvalVisitor extends MacroBaseVisitor<Expression>  {

    private Cell cell = null;
    int numberOfErrors;
    private final StringBuilder errorBuffer;

    final private Language language;

    public MacroEvalVisitor(Cell cell, Language lang) {
        this.cell = cell;
        numberOfErrors = 0;
        errorBuffer = new StringBuilder();
        this.language = lang;
    }

    public int getNumberOfErrors() {
        return numberOfErrors;
    }

    public String getErrorsMessage() {
        return errorBuffer.toString();
    }

    @Override
    public Expression visitExpression(MacroParser.ExpressionContext ctx) {
        ArrayList<Expression> list = new ArrayList<>();
        for(int i = 0; i < ctx.getChildCount(); i++){
            list.add(visit(ctx.getChild(i)));
        }
        return list.get(list.size() - 1);
    }

    @Override
    public Expression visitComparison(MacroParser.ComparisonContext ctx) {
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
    public Expression visitConcatenation(MacroParser.ConcatenationContext ctx
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
    public Expression visitAtom(MacroParser.AtomContext ctx
    ) {
        if (ctx.getChildCount() == 3) {
            return visit(ctx.getChild(1));
        }

        return visitChildren(ctx);
    }
    
    @Override
    public Expression visitBlock(MacroParser.BlockContext ctx) {
        if (ctx.getChildCount() == 1) {
            return visit(ctx.manyexpressions());
        } else {
            return visit(ctx.forexpression());
        }
    }
    
    @Override
    public Expression visitManyexpressions(MacroParser.ManyexpressionsContext ctx) {
        Function function = null;
        try {
            // function = Language.getInstance().getFunction(ctx.getChild(0).getText());
            function = this.language.getFunction(ctx.getChild(0).getText());
        } catch (UnknownElementException ex) {
            Logger.getLogger(MacroEvalVisitor.class.getName()).log(Level.SEVERE, null, ex);
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
                Logger.getLogger(MacroEvalVisitor.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
        MaterialToast.fireToast("RETURN NULL_Many expressions");
        return null;
    }
    
    @Override
    public Expression visitForexpression(MacroParser.ForexpressionContext ctx) {
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
            Logger.getLogger(MacroEvalVisitor.class.getName()).log(Level.SEVERE, null, ex);
        }

        MaterialToast.fireToast("RETURN NULL FOREXPRESSION");
        return new Literal(new Value());
    }

    @Override
    public Expression visitFunction_call(MacroParser.Function_callContext ctx) {
        // Convert function call
        Function function = null;
        try {
            // function = Language.getInstance().getFunction(ctx.getChild(0).getText());
            function = this.language.getFunction(ctx.getChild(0).getText());
        } catch (UnknownElementException ex) {
            Logger.getLogger(MacroEvalVisitor.class.getName()).log(Level.SEVERE, null, ex);
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
    public Expression visitReference(MacroParser.ReferenceContext ctx) {
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
                    case MacroParser.CELL_REF:
                        return new CellReference(cell.getSpreadsheet(), ctx.getText());
                    case MacroParser.NAMEGLOBAL:
                        Workbook currentWorkbook = Settings.getInstance().getWorkbook();
                        String gvName = ctx.getChild(0).getText();
                        Integer position = 0;
                        
                        if(ctx.getChildCount() == 2)
                            position = Integer.parseInt(ctx.getChild(1).getText().split("\\[")[1].split("\\]")[0]);
                        
                        if (currentWorkbook.checkIfGVExists(gvName, position))
                            return currentWorkbook.getGlobalVariable(gvName, position);
                        else 
                            return currentWorkbook.addGlobalVariable(gvName, position);
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
    public Expression visitAssignment(MacroParser.AssignmentContext ctx) {
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
    public Expression visitLiteral(MacroParser.LiteralContext ctx) {
        Token t = (Token) ctx.getChild(0).getPayload();

        if (t.getType() == MacroParser.NUMBER) {
            return new Literal(Value.parseValue(ctx.getText()));
        } else {
            if (t.getType() == MacroParser.STRING) {
                String value = ctx.getText().substring(1, ctx.getText().length() - 1);
                return new Literal(Value.parseValue(value, Value.Type.BOOLEAN, Value.Type.DATE));
            } else if (t.getType() == MacroParser.RULE_nameTemporary) {
                TemporaryVariable tempVariable = (TemporaryVariable) ctx.getChild(0);
                return new Literal(tempVariable.getValue());
            }
        }
        MaterialToast.fireToast("RETURN NULL Literal");
        return null;
    }

    @Override
    public Expression visitTemporaryreference(MacroParser.TemporaryreferenceContext ctx) {
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
        numberOfErrors++;
    }
}
