package pt.isep.nsheets.shared.core.vb;

import org.antlr.v4.runtime.ANTLRInputStream;
import org.antlr.v4.runtime.CommonTokenStream;
import org.antlr.v4.runtime.tree.ParseTree;
import pt.isep.nsheets.shared.core.vb.compiler.VbLexer;
import pt.isep.nsheets.shared.core.vb.compiler.VbParser;

import java.util.HashMap;
import java.util.Map;

public class Main {

    public static void main(String[] args) {
        Map<String, Value> cells = new HashMap<>();
        cells.put("A1", new Value(Double.valueOf("10")));
        Map<String, Value> map = new HashMap<>();
        map.put(cells.entrySet().iterator().next().getKey(), cells.entrySet().iterator().next().getValue());

        VbLexer lexer = new VbLexer(new ANTLRInputStream("Function f1() As Integer\n"
                + "Dim x As Integer\n"
                + "x=1\n"
                + "Log x\n"
                + "Return x\n"
                + "End Function\n "
                + "\n"
                + "f1()"));

        VbParser parser = new VbParser(new CommonTokenStream(lexer));
        ParseTree tree = parser.parse();
        EvalVisitor visitor = new EvalVisitor(cells);
        visitor.visit(tree);

        System.out.println(visitor.getOutput());
    }
}
