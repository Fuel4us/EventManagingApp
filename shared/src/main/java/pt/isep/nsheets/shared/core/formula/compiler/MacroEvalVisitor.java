package pt.isep.nsheets.shared.core.formula.compiler;

import org.antlr.v4.runtime.Token;
import pt.isep.nsheets.shared.core.Cell;
import pt.isep.nsheets.shared.core.Value;
import pt.isep.nsheets.shared.core.formula.*;
import pt.isep.nsheets.shared.core.formula.lang.*;
//import pt.isep.nsheets.shared.lapr4.blue.n1150455.s1.temporaryVariables.TemporaryVariable;
//import pt.isep.nsheets.shared.lapr4.green.n1160815.formula.lang.GlobalVariable;

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
    public Expression visitMacro_c(MacroParser.Macro_cContext ctx) {
        if (ctx.MACRO() != null) {
            return new MacroCall(ctx.STRING(), cell);
        }

        return null;
    }
    
    @Override
    public Expression visitLine(MacroParser.LineContext ctx) {
        return visit(ctx.expression());
    }

    @Override
    public Expression visitExpression(MacroParser.ExpressionContext ctx) {
        return visit(ctx.comparison());
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
                addVisitError(ex.getMessage());
            }
        }

        return visit(ctx.concatenation(0));
    }

    @Override
    public Expression visitConcatenation(MacroParser.ConcatenationContext ctx) {
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
                BinaryOperator operator = this.language.getBinaryOperator(ctx.getChild(1).getText());
                return new BinaryOperation(
                        visit(ctx.getChild(0)),
                        operator,
                        visit(ctx.getChild(2))
                );
            }

        } catch (FormulaCompilationException ex) {
            addVisitError(ex.getMessage());
        }

        return visitChildren(ctx);
    }

    @Override
    public Expression visitAttribution(MacroParser.AttributionContext ctx) {
        if (ctx.ATTRIB() != null) {
            try {
                BinaryOperator operator = this.language.getBinaryOperator(ctx.getChild(1).getText());
                return new BinaryOperation(visit(ctx.getChild(0)), operator, visit(ctx.getChild(2)));
            } catch (FormulaCompilationException ex) {
                Logger.getLogger(MacroEvalVisitor.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
        return visitChildren(ctx);
    }

    @Override
    public Expression visitBlock(MacroParser.BlockContext ctx) {
        if (ctx.LBRACKET() != null) {
            try {
                Expression expressions[] = new Expression[ctx.getChildCount() / 2];

                for (int i = 1; i < ctx.getChildCount(); i += 2) {
                    expressions[i / 2] = visit(ctx.getChild(i));
                }

                NaryOperator operator = this.language.getNaryOperator(ctx.getChild(0).getText());
                return new NaryOperation(operator, expressions);
            } catch (UnknownElementException ex) {
                Logger.getLogger(MacroEvalVisitor.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
        return visitChildren(ctx);
    }

    @Override
    public Expression visitAtom(MacroParser.AtomContext ctx) {
        if (ctx.getChildCount() == 3) {
            return visit(ctx.getChild(1));
        }

        return visitChildren(ctx);
    }

    @Override
    public Expression visitFunction_call(MacroParser.Function_callContext ctx) {
        // Convert function call
        Function function = null;
        try {
            function = this.language.getFunction(ctx.getChild(0).getText().substring(1));
        } catch (UnknownElementException ex) {
            addVisitError(ex.getMessage());
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
            }
        }
        return null;
    }

    @Override
    public Expression visitReference(MacroParser.ReferenceContext ctx) {
        try {
            if (ctx.getChildCount() == 3) {
                BinaryOperator operator = this.language.getBinaryOperator(ctx.getChild(1).getText());

                return new ReferenceOperation(
                        new CellReference(cell.getSpreadsheet(), ctx.getChild(0).getText()),
                        (RangeReference) operator,
                        new CellReference(cell.getSpreadsheet(), ctx.getChild(2).getText())
                );
            } else {
                return new CellReference(cell.getSpreadsheet(), ctx.getText());
            }
        } catch (ParseException | UnknownElementException ex) {
            addVisitError(ex.getMessage());
        }
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
            }
        }

        return null;
    }

    private void addVisitError(String msg) {
        errorBuffer.append(msg).append("\n");
        numberOfErrors++;
    }
    
}
