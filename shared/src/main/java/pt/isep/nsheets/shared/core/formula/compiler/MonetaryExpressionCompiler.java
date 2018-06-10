/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package pt.isep.nsheets.shared.core.formula.compiler;

import gwt.material.design.client.ui.MaterialToast;
import java.util.Collections;
import java.util.List;
import org.antlr.v4.runtime.ANTLRInputStream;
import org.antlr.v4.runtime.BaseErrorListener;
import org.antlr.v4.runtime.CommonTokenStream;
import org.antlr.v4.runtime.Parser;
import org.antlr.v4.runtime.RecognitionException;
import org.antlr.v4.runtime.Recognizer;
import org.antlr.v4.runtime.tree.ParseTree;
import pt.isep.nsheets.shared.core.Cell;
import pt.isep.nsheets.shared.core.formula.Expression;
import pt.isep.nsheets.shared.core.formula.lang.Language;
import pt.isep.nsheets.shared.core.formula.lang.LanguageManager;
import pt.isep.nsheets.shared.lapr4.green.s2.n1140572.MonetaryConversion.MonetaryConversion;

/**
 *
 * @author Pedro Rodrigues - (1140572)
 */
public class MonetaryExpressionCompiler implements ExpressionCompiler {

    /**
     * The character that signals that a cell's content is a formula ('=')
     */
    public static final char FORMULA_STARTER = '#';

    private Language language = null;

    public MonetaryExpressionCompiler() {
        language = LanguageManager.getInstance().getLanguage("monetary");
    }

    @Override
    public char getStarter() {
        return FORMULA_STARTER;
    }

    @Override
    public Expression compile(Cell cell, String source) throws FormulaCompilationException {
        String number = "";
        String sourceResult = "";

        if (source.toLowerCase().contains("dollar")) {

            double total;
            for (int i = 0; i < source.length(); i++) {

                if (source.charAt(i) == '\u20AC' || source.charAt(i) == '\u00A3' || source.charAt(i) == '\u0024') {
                    total = Double.parseDouble(number);
                    double rValue = 0;

                    switch (source.charAt(i)) {
                        case '\u00A3':
                            rValue = MonetaryConversion.PoundToDollar * total;
                            sourceResult += Double.toString(rValue) + '\u00A3';
                            break;
                        case '\u20AC':
                            rValue = MonetaryConversion.EuroToDollar * total;
                            sourceResult += Double.toString(rValue) + '\u20AC';
                            break;
                        default:
                            rValue = total;
                            sourceResult += Double.toString(rValue) + '\u0024';
                            break;
                    }
                    number = "";

                } else if (Character.isDigit(source.charAt(i))) {
                    number += source.charAt(i);
                } else if (source.charAt(i) == '.') {
                    number += '.';
                } else {
                    sourceResult += source.charAt(i);
                }
            }
        } else if (source.toLowerCase().contains("pound")) {
            double total;

            for (int i = 0; i < source.length(); i++) {
                if (source.charAt(i) == '\u20AC' || source.charAt(i) == '\u00A3' || source.charAt(i) == '\u0024') {
                    total = Double.parseDouble(number);
                    double rValue = 0;

                    switch (source.charAt(i)) {
                        case '\u20AC':
                            rValue = MonetaryConversion.EuroToPound * total;
                            sourceResult += Double.toString(rValue) + '\u20AC';
                            break;
                        case '\u0024':
                            rValue = MonetaryConversion.DollarToPound * total;
                            sourceResult += Double.toString(rValue) + '\u0024';
                            break;
                        default:
                            rValue = total;
                            sourceResult += Double.toString(rValue) + '\u00A3';
                            break;
                    }
                    number = "";

                } else if (Character.isDigit(source.charAt(i))) {
                    number += source.charAt(i);
                } else if (source.charAt(i) == '.') {
                    number += '.';
                } else {
                    sourceResult += source.charAt(i);
                }
            }
        } else if (source.toLowerCase().contains("euro")) {
            double total;
            for (int i = 0; i < source.length(); i++) {
                if (source.charAt(i) == '\u20AC' || source.charAt(i) == '\u00A3' || source.charAt(i) == '\u0024') {
                    total = Double.parseDouble(number);
                    double rValue = 0;

                    switch (source.charAt(i)) {
                        case '\u0024':
                            rValue = MonetaryConversion.DollarToEuro * total;
                            sourceResult += Double.toString(rValue) + '\u0024';
                            break;
                        case '\u00A3':
                            rValue = MonetaryConversion.PoundToEuro * total;
                            sourceResult += Double.toString(rValue) + '\u00A3';
                            break;
                        default:
                            rValue = total;
                            sourceResult += Double.toString(rValue) + '\u20AC';
                            break;
                    }
                    number = "";

                } else if (Character.isDigit(source.charAt(i))) {
                    number += source.charAt(i);
                } else if (source.charAt(i) == '.') {
                    number += '.';
                } else {
                    sourceResult += source.charAt(i);
                }
            }
        }

        //Creates the lexer and parser
        ANTLRInputStream input = new ANTLRInputStream(sourceResult);
        
        //Create the buffer of tokens between the lexer and parser
        MonetaryLexer lexer = new MonetaryLexer(input);
        CommonTokenStream tokens = new CommonTokenStream(lexer);
        MonetaryParser parser = new MonetaryParser(tokens);

        MonetaryErrorListener monetaryErrorListener = new MonetaryErrorListener();
        parser.removeErrorListeners(); //Remove default ConsoleErrorListener
        parser.addErrorListener(monetaryErrorListener); //Add ours    

        //Attempts to match an expression
        ParseTree tree = parser.expression();
        if (parser.getNumberOfSyntaxErrors() > 0) {
            MaterialToast.fireToast("Syntax Error: " + monetaryErrorListener.getErrorMessage());
            throw new FormulaCompilationException(monetaryErrorListener.getErrorMessage());
        }

        //Visit the expression and returns it
        MonetaryEvalVisitor eval = new MonetaryEvalVisitor(cell, language);
        Expression result = eval.visit(tree);

        if (eval.getNumberOfErrors() > 0) {
            MaterialToast.fireToast("FormulaCompilationException: " + eval.getErrorsMessage());
            throw new FormulaCompilationException(eval.getErrorsMessage());
        }
        MaterialToast.fireToast("RESULT:" + result.toString());
        return result;
    }

    public static class MonetaryErrorListener extends BaseErrorListener {

        private StringBuilder buf;

        public String getErrorMessage() {
            return buf.toString();
        }

        @Override
        public void syntaxError(Recognizer<?, ?> recognizer,
                Object offendingSymbol,
                int line, int charPositionInLine,
                String msg,
                RecognitionException e) {
            List<String> stack = ((Parser) recognizer).getRuleInvocationStack();
            Collections.reverse(stack);

            buf = new StringBuilder();
            buf.append("line ").append(line).append(":").append(charPositionInLine).append(": ").append(msg);
        }
    }
}
