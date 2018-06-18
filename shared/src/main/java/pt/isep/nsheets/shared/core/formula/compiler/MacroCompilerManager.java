package pt.isep.nsheets.shared.core.formula.compiler;

import java.util.ArrayList;
import java.util.List;
import java.util.NoSuchElementException;
import pt.isep.nsheets.shared.core.formula.lang.MacroLanguage;

/**
 *
 * @author Pedro Marques Vieira
 */
public class MacroCompilerManager {
    
    private static final MacroCompilerManager instance = new MacroCompilerManager();

    private List<ExpressionCompiler> compilers = new ArrayList<>();

    private MacroCompilerManager() {
        initCompilers();
    }

    private void initCompilers() {
//        compilers.add(new VisualBasicExpressionCompiler());
//        compilers.add(new JavascriptExpressionCompiler());
        compilers.add(new MacroExpressionCompiler());
    }

    public static MacroCompilerManager getInstance() {
        return instance;
    }

    public ExpressionCompiler getCompiler(final String language) {
        for (ExpressionCompiler c : compilers) {
            if (c.compilerName().equalsIgnoreCase(language)) {
                return c;
            }
        }
        throw new NoSuchElementException(language + " doesn't exist.");
    }

    public ExpressionCompiler getCompiler(final MacroLanguage lang) {
        return getCompiler(lang.getName());
    }
}
