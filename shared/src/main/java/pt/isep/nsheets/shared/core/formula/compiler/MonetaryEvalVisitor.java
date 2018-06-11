/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package pt.isep.nsheets.shared.core.formula.compiler;

import java.util.logging.Level;
import java.util.logging.Logger;
import pt.isep.nsheets.shared.core.Cell;
import pt.isep.nsheets.shared.core.Value;
import pt.isep.nsheets.shared.core.formula.BinaryOperation;
import pt.isep.nsheets.shared.core.formula.BinaryOperator;
import pt.isep.nsheets.shared.core.formula.Expression;
import pt.isep.nsheets.shared.core.formula.Literal;
import pt.isep.nsheets.shared.core.formula.lang.Language;
import pt.isep.nsheets.shared.core.formula.lang.UnknownElementException;

/**
 *
 * @author Pedro Rodrigues - (1140572)
 */
public class MonetaryEvalVisitor extends MonetaryBaseVisitor<Expression> {

    private Cell cell = null;
    private static String currency;
    int numberOfErros;
    private final StringBuilder errorBuffer;
    final private Language language;

    public MonetaryEvalVisitor(Cell cell, Language lang) {
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
    public Expression visitStart(MonetaryParser.StartContext ctx) {
        return visit(ctx.expression());
    }

    @Override
    public Expression visitExpression(MonetaryParser.ExpressionContext ctx) {
    currency = ctx.getChild(1).getText();
        return visit(ctx.account());
    }

    @Override
    public Expression visitAccount(MonetaryParser.AccountContext ctx) {

        if (ctx.getChildCount() > 4) {
            try {
                for (int i = 4; i < ctx.getChildCount(); i = i + 3) {
                    BinaryOperator operator = this.language.getBinaryOperator(ctx.getChild(2).getText());
                    return new BinaryOperation(
                            visit(ctx.getChild(i-4)),
                            operator,
                            visit(ctx.getChild(i-1))
                    );
                }

            } catch (UnknownElementException ex) {
                Logger.getLogger(MonetaryEvalVisitor.class.getName()).log(Level.SEVERE, null, ex);
            }
        } else {
            return visit(ctx.getChild(0));
        }

        return null;
    }

    @Override
    public Expression visitNumber(MonetaryParser.NumberContext ctx) {
        return new Literal(Value.parseValue(ctx.getText()));
    }

}
