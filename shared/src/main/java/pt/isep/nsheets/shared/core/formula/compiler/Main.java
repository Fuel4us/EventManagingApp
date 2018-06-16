/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package pt.isep.nsheets.shared.core.formula.compiler;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import org.antlr.v4.runtime.ANTLRInputStream;
import org.antlr.v4.runtime.CommonTokenStream;
import org.antlr.v4.runtime.tree.ParseTree;
import pt.isep.nsheets.shared.core.Address;
import pt.isep.nsheets.shared.core.CellImpl;
import pt.isep.nsheets.shared.core.SpreadsheetImpl;
import pt.isep.nsheets.shared.core.formula.lang.Language;
import pt.isep.nsheets.shared.core.vb.Value;

/**
 *
 * @author joaotiagow
 */
public class Main {
    
    public static String[][][] SPREADSHEET_DEFAULT = {{
                {"1", "2", "3", "4", "5", "6", "7"},
                {"a", "b", "c", "d", "e", "f", "g"},
                {"h", "i", "j", "k", "l", "m", "n"},
                {"o", "p", "8", "9", "10", "0", "23"},
                {"44", "67", "89", "q", "r", "s", "t"},
                {"u", "v", "x", "y", "z", "55", "66"},
            }};
    
    public static void main(String[] args) throws FormulaCompilationException {
        
        Map<String, Value> cells = new HashMap<>();
        cells.put("A1", new Value(Double.valueOf("10")));

        FormulaLexer lexer = new FormulaLexer(new ANTLRInputStream("@abc:=123"));
        FormulaParser parser = new FormulaParser(new CommonTokenStream(lexer));
        ParseTree tree = parser.reference();
        //FormulaEvalVisitor visitor = new FormulaEvalVisitor(new CellImpl(new SpreadsheetImpl(), new Address(1,1)), new Language("asd"));
//        visitor.visit(tree);

        System.out.println("Output:\n");
    }
}
