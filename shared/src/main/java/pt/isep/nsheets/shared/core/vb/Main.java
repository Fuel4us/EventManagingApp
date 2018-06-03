package pt.isep.nsheets.shared.core.vb;

import java.util.HashMap;
import java.util.Map;
import org.antlr.v4.runtime.ANTLRInputStream;
import org.antlr.v4.runtime.CommonTokenStream;
import org.antlr.v4.runtime.tree.ParseTree;


//for test purposes only
public class Main {
    public static void main(String[] args) throws Exception {
        
        //teste
        Map<String, Value> cells = new HashMap<>();
        cells.put("A1", new Value(Double.valueOf(0)));
        
        VbLexer lexer = new VbLexer(new ANTLRInputStream("Dim A As Integer A = 2 Log A $A1 = A + 1 Log $A1"));
        VbParser parser = new VbParser(new CommonTokenStream(lexer));
        ParseTree tree = parser.parse();
        EvalVisitor visitor = new EvalVisitor(cells);
        visitor.visit(tree);
        
        //teste
        System.out.println("Valor $A1: " + cells.entrySet().iterator().next().getValue().asDouble());
    }
}