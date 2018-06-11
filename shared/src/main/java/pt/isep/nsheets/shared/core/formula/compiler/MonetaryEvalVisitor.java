/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package pt.isep.nsheets.shared.core.formula.compiler;

import gwt.material.design.client.ui.MaterialToast;
import java.util.logging.Level;
import java.util.logging.Logger;
import org.antlr.v4.runtime.Token;
import org.antlr.v4.runtime.tree.ParseTree;
import pt.isep.nsheets.shared.core.Cell;
import pt.isep.nsheets.shared.core.IllegalValueTypeException;
import pt.isep.nsheets.shared.core.Value;
import pt.isep.nsheets.shared.core.formula.BinaryOperation;
import pt.isep.nsheets.shared.core.formula.BinaryOperator;
import pt.isep.nsheets.shared.core.formula.Expression;
import pt.isep.nsheets.shared.core.formula.Literal;
import pt.isep.nsheets.shared.core.formula.UnaryOperation;
import pt.isep.nsheets.shared.core.formula.lang.Language;
import pt.isep.nsheets.shared.core.formula.lang.UnknownElementException;
import pt.isep.nsheets.shared.core.formula.util.ExpressionVisitor;
import pt.isep.nsheets.shared.lapr4.blue.n1150455.s1.temporaryVariables.TemporaryVariable;
import pt.isep.nsheets.shared.lapr4.green.s2.n1140572.MonetaryConversion.MonetaryConversion;

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

        if (ctx.getChildCount() > 2) {
            try {
                BinaryOperator operator = this.language.getBinaryOperator(ctx.getChild(2).getText());
                return new BinaryOperation(
                        visit(ctx.getChild(0)),
                        operator,
                        visit(ctx.getChild(3))
                );

            } catch (UnknownElementException ex) {
                MaterialToast.fireToast("ERRO NO RETURN!!!");
                Logger.getLogger(MonetaryEvalVisitor.class.getName()).log(Level.SEVERE, null, ex);
            }
        } else {
            MaterialToast.fireToast("Tamanho < 2: " + ctx.getChild(0).getText());
            return visit(ctx.getChild(0));
        }

        return null;
    }

    @Override
    public Expression visitNumber(MonetaryParser.NumberContext ctx) {
        MaterialToast.fireToast("Entrou no visit number!");
        MaterialToast.fireToast("CTX VALUE: " + ctx.getText());
        return new Literal(Value.parseValue(ctx.getText()));
    }

}
