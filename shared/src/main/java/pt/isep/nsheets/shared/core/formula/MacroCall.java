package pt.isep.nsheets.shared.core.formula;

import org.antlr.v4.runtime.tree.TerminalNode;
import pt.isep.nsheets.shared.core.Cell;
import pt.isep.nsheets.shared.core.IllegalValueTypeException;
import pt.isep.nsheets.shared.core.Value;
import pt.isep.nsheets.shared.core.Workbook;
import pt.isep.nsheets.shared.core.formula.compiler.ExpressionCompiler;
import pt.isep.nsheets.shared.core.formula.compiler.FormulaCompilationException;
import pt.isep.nsheets.shared.core.formula.compiler.MacroCompilerManager;
import pt.isep.nsheets.shared.core.formula.util.ExpressionVisitor;
import pt.isep.nsheets.shared.lapr4.red.s3.lang.n1160634.macro.domain.Macro;

/**
 *
 * @author Pedro Marques Vieira
 */
public class MacroCall implements Expression{
    
    private TerminalNode name;
    private Cell cell;

    public MacroCall(TerminalNode name, Cell cell) {
        this.name = name;
        this.cell = cell;
    }

    protected MacroCall() {
    }

    @Override
    public Value evaluate() throws IllegalValueTypeException {
        Workbook wb = cell.getSpreadsheet().getWorkbook();

        String macroName = name.toString();

        for (Macro m : wb.macros()) {

            String savedMacroName = "\"" + m.name() + "\"";

            if (savedMacroName.equalsIgnoreCase(macroName)) {

                try {
                    ExpressionCompiler compiler = MacroCompilerManager.getInstance().getCompiler("macro");
                    Expression expression = compiler.compile(cell, m.commands());
                    return expression.evaluate();
                } catch (FormulaCompilationException ex) {
                    return null;
                }

            }
        }

        return null;
    }

    @Override
    public Object accept(ExpressionVisitor visitor) {
        return null;
    }
}
