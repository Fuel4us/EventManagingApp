/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package pt.isep.nsheets.shared.core.formula.compiler;

import gwt.material.design.client.ui.MaterialToast;
import org.antlr.v4.runtime.tree.ParseTree;
import pt.isep.nsheets.shared.core.Cell;
import pt.isep.nsheets.shared.core.formula.BinaryOperation;
import pt.isep.nsheets.shared.core.formula.BinaryOperator;
import pt.isep.nsheets.shared.core.formula.Expression;
import pt.isep.nsheets.shared.core.formula.lang.Language;
import pt.isep.nsheets.shared.core.formula.lang.UnknownElementException;

/**
 *
 * @author Pedro Rodrigues - (1140572)
 */
public class MonetaryEvalVisitor extends MonetaryBaseVisitor<Expression> {

    private Cell cell = null;
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
    public Expression visitMonetary(MonetaryParser.MonetaryContext ctx) {
        if (ctx.getChildCount() == 4) {
            try {
                ParseTree account = ctx.getChild(2);
                BinaryOperator operator = this.language.getBinaryOperator(account.getChild(2).getText());
                MaterialToast.fireToast("Child 0: " + account.getChild(0).getText());
                MaterialToast.fireToast("Child 3: " + account.getChild(3).getText());
                return new BinaryOperation(
                        visit(account.getChild(0)),
                        operator,
                        visit(account.getChild(3))
                );
            } catch (UnknownElementException ex) {
                MaterialToast.fireToast(ex.toString());
            }
        }
        MaterialToast.fireToast("ESTÁ A RETORNAR NULL!!!");
        return null;
    }

}
