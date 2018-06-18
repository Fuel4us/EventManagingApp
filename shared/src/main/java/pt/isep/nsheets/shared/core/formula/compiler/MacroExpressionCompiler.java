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
import pt.isep.nsheets.shared.core.formula.lang.MacroLanguage;

public class MacroExpressionCompiler implements ExpressionCompiler{

    public static final char LINE_STARTER = '|';

    public final String compilerName = "MacroExcel";

    private MacroLanguage language = null;

    public MacroExpressionCompiler() {

        this.language = (MacroLanguage) LanguageManager.getInstance().getLanguage("MacroExcel");
    }

    @Override
    public Expression compile(Cell cell, String source) throws FormulaCompilationException {

        // Create the lexer and parser
        ANTLRInputStream input = new ANTLRInputStream(source);

        // create the buffer of the tokens between the lexer and parser
        MacroLexer lexer = new MacroLexer(input);
        CommonTokenStream tokens = new CommonTokenStream(lexer);

        MacroParser parser = new MacroParser(tokens);

        MacroExcelErrorListener excelErrorListener = new MacroExcelErrorListener();
        parser.removeErrorListeners();
        parser.addErrorListener(excelErrorListener);

        ParseTree tree = parser.macro();
        if (parser.getNumberOfSyntaxErrors() > 0) {
            throw new FormulaCompilationException(excelErrorListener.getErrorMessage());
        }

        // Visit the expression and returns it
        MacroEvalVisitor eval = new MacroEvalVisitor(cell, language);
        Expression result = eval.visit(tree);
        if (eval.getNumberOfErrors() > 0) {
            throw new FormulaCompilationException(eval.getErrorsMessage());
        }
        return result;
    }

    @Override
    public char getStarter() {
        return LINE_STARTER;
    }

    @Override
    public String compilerName() {
        return compilerName;
    }

    //
    public static class MacroExcelErrorListener extends BaseErrorListener {

        private StringBuilder buf;

        public String getErrorMessage() {
            return buf.toString();
        }

        @Override
        public void syntaxError(Recognizer<?, ?> recognizer, Object offendingSymbol, int line, int charPositionInLine,
                String msg, RecognitionException e) {
            List<String> stack = ((Parser) recognizer).getRuleInvocationStack();
            Collections.reverse(stack);

            buf = new StringBuilder();
            buf.append("line ").append(line).append(":").append(charPositionInLine).append(": ").append(msg);
        }
    }
}
