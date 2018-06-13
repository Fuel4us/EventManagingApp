package pt.isep.nsheets.shared.core.formula.compiler;

import org.antlr.v4.runtime.*;
import org.antlr.v4.runtime.tree.ParseTree;
import pt.isep.nsheets.shared.core.Cell;
import pt.isep.nsheets.shared.core.formula.Expression;
import pt.isep.nsheets.shared.core.formula.Formula;
import pt.isep.nsheets.shared.core.formula.lang.Language;
import pt.isep.nsheets.shared.core.formula.lang.LanguageManager;

import java.util.Collections;
import java.util.List;

public class MacroExpressionCompiler {

    private Language language = null;

    /**
     * Creates the Excel expression compiler.
     */
    public MacroExpressionCompiler() {
        language = LanguageManager.getInstance().getLanguage("macro");
    }


    public Formula compile(Cell cell, String source) throws FormulaCompilationException {
        // Creates the lexer and parser
        ANTLRInputStream input = new ANTLRInputStream(source);

        // create the buffer of tokens between the lexer and parser
        MacroLexer lexer = new MacroLexer(input);
        CommonTokenStream tokens = new CommonTokenStream(lexer);

        MacroParser parser = new MacroParser(tokens);

        MacroExpressionCompiler.MacroErrorListener formulaErrorListener = new MacroExpressionCompiler.MacroErrorListener();
        parser.removeErrorListeners(); // remove default ConsoleErrorListener
        parser.addErrorListener(formulaErrorListener); // add ours

        // Attempts to match an expression
        ParseTree tree = parser.expression();
        if (parser.getNumberOfSyntaxErrors() > 0) {
            throw new FormulaCompilationException(formulaErrorListener.getErrorMessage());
        }

        // Visit the expression and returns it
        MacroEvalVisitor eval = new MacroEvalVisitor(cell, language);
        Expression result = eval.visit(tree);
        if (eval.getNumberOfErrors() > 0) {
            throw new FormulaCompilationException(eval.getErrorsMessage());
        }

        return new Formula(cell, result);
    }

    public static class MacroErrorListener extends BaseErrorListener {

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
