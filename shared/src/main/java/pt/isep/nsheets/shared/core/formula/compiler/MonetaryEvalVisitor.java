/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package pt.isep.nsheets.shared.core.formula.compiler;

import gwt.material.design.client.ui.MaterialToast;
import java.util.logging.Level;
import java.util.logging.Logger;
import pt.isep.nsheets.shared.core.Cell;
import pt.isep.nsheets.shared.core.IllegalValueTypeException;
import pt.isep.nsheets.shared.core.Value;
import pt.isep.nsheets.shared.core.formula.BinaryOperation;
import pt.isep.nsheets.shared.core.formula.BinaryOperator;
import pt.isep.nsheets.shared.core.formula.Expression;
import pt.isep.nsheets.shared.core.formula.Literal;
import pt.isep.nsheets.shared.core.formula.lang.Language;
import pt.isep.nsheets.shared.core.formula.lang.UnknownElementException;
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

        if (ctx.getChildCount() == 2) {
            Literal operand = (Literal) visit(ctx.getChild(0));
            double value = 0;
            char sign = ' ';
            try {
                value = operand.getValue().toDouble();
                sign = ctx.getChild(1).getText().charAt(0);
            } catch (IllegalValueTypeException ex) {
                Logger.getLogger(MonetaryEvalVisitor.class.getName()).log(Level.SEVERE, null, ex);
            }
            return conversion(value, sign);
        } else if (ctx.getChildCount() == 4) {
            Literal leftOperand = (Literal) visit(ctx.getChild(0));
            Literal rightOperand = (Literal) visit(ctx.getChild(3));
            double leftValue = 0;
            double rightValue = 0;
            char sign = ' ';
            try {

                BinaryOperator operator = this.language.getBinaryOperator(ctx.getChild(2).getText());
                leftValue = leftOperand.getValue().toDouble();
                sign = ctx.getChild(1).getText().charAt(0);
                rightValue = rightOperand.getValue().toDouble();
                return new BinaryOperation(conversion(leftValue, sign), operator, conversion(rightValue, ' '));

            } catch (UnknownElementException | IllegalValueTypeException ex) {
                Logger.getLogger(MonetaryEvalVisitor.class.getName()).log(Level.SEVERE, null, ex);
            }
        } else if (ctx.getChildCount() > 4) {
            Literal leftOperand = (Literal) visit(ctx.getChild(0));
            Literal rightOperand = (Literal) visit(ctx.getChild(3));
            double leftValue = 0;
            double rightValue = 0;
            char sign = ' ';
            char sign1 = ' ';
            try {

                BinaryOperator operator = this.language.getBinaryOperator(ctx.getChild(2).getText());
                leftValue = leftOperand.getValue().toDouble();
                sign = ctx.getChild(1).getText().charAt(0);
                sign1 = ctx.getChild(4).getText().charAt(0);
                rightValue = rightOperand.getValue().toDouble();
                return new BinaryOperation(conversion(leftValue, sign), operator, conversion(rightValue, sign1));

            } catch (UnknownElementException | IllegalValueTypeException ex) {
                Logger.getLogger(MonetaryEvalVisitor.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
        return null;
    }

    @Override
    public Expression visitNumber(MonetaryParser.NumberContext ctx) {
        return new Literal(Value.parseValue(ctx.getText()));
    }

    public Expression conversion(double value, char sign) {

        String number = "";

        if (sign == ' ') {
            number = Double.toString(value);
            return new Literal(Value.parseValue(number));
        }

        if (currency.equalsIgnoreCase("dollar")) {

            switch (sign) {
                case '\u20AC':
                    value = value * MonetaryConversion.EuroToDollar;
                    number = Double.toString(value);
                    return new Literal(Value.parseValue(number));
                case '\u00A3':
                    value *= MonetaryConversion.PoundToDollar;
                    number = Double.toString(value);
                    return new Literal(Value.parseValue(number));
                default:
                    number = Double.toString(value);
                    return new Literal(Value.parseValue(number));
            }

        } else if (currency.equals("pound")) {
            switch (sign) {
                case '\u20AC':
                    value = value * MonetaryConversion.EuroToPound;
                    number = Double.toString(value);
                    return new Literal(Value.parseValue(number));

                case '\u0024':
                    value *= MonetaryConversion.DollarToPound;
                    number = Double.toString(value);
                    return new Literal(Value.parseValue(number));

                default:
                    number = Double.toString(value);
                    return new Literal(Value.parseValue(number));
            }

        } else if (currency.equals("euro")) {

            switch (sign) {
                case '\u00A3':
                    value *= MonetaryConversion.PoundToEuro;
                    number = Double.toString(value);
                    return new Literal(Value.parseValue(number));

                case '\u0024':
                    value *= MonetaryConversion.DollarToEuro;
                    number = Double.toString(value);
                    return new Literal(Value.parseValue(number));

                default:
                    number = Double.toString(value);
                    return new Literal(Value.parseValue(number));
            }
        }
        return null;
    }
}
