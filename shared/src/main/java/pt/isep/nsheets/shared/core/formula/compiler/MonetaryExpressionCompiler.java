/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package pt.isep.nsheets.shared.core.formula.compiler;

import com.google.gwt.i18n.client.NumberFormat;
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
    
    /**
     * Compiler name
     */
    public static final String compilerName = "MonetaryFormula";

    public MonetaryExpressionCompiler() {
        language = LanguageManager.getInstance().getLanguage("monetary");
    }

    @Override
    public char getStarter() {
        return FORMULA_STARTER;
    }

    @Override
    public Expression compile(Cell cell, String source) throws FormulaCompilationException {

        //Creates the lexer and parser
        ANTLRInputStream input = new ANTLRInputStream(source);

        //Create the buffer of tokens between the lexer and parser
        MonetaryLexer lexer = new MonetaryLexer(input);
        CommonTokenStream tokens = new CommonTokenStream(lexer);
        MonetaryParser parser = new MonetaryParser(tokens);

        MonetaryErrorListener monetaryErrorListener = new MonetaryErrorListener();
        parser.removeErrorListeners(); //Remove default ConsoleErrorListener
        parser.addErrorListener(monetaryErrorListener); //Add ours    

        //Attempts to match an expression
        ParseTree tree = parser.start();
        if (parser.getNumberOfSyntaxErrors() > 0) {
            MaterialToast.fireToast("Syntax Error: " + monetaryErrorListener.getErrorMessage());
            MaterialToast.fireToast("Syntax Error Number: " + parser.getNumberOfSyntaxErrors());
            throw new FormulaCompilationException(monetaryErrorListener.getErrorMessage());
        }

        //Visit the expression and returns it
        MonetaryEvalVisitor eval = new MonetaryEvalVisitor(cell, language);
        Expression result = eval.visit(tree);
        if (eval.getNumberOfErrors() > 0) {
            MaterialToast.fireToast("FormulaCompilationException: " + eval.getErrorsMessage());
            throw new FormulaCompilationException(eval.getErrorsMessage());
        }

        return result;
    }

    @Override
    public String compilerName() {
        return compilerName;
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
