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
        cells.put("A1", new Value(Double.valueOf("10")));
        Map<String, Value> teste = new HashMap<>();
        teste.put(cells.entrySet().iterator().next().getKey(), cells.entrySet().iterator().next().getValue());
        System.out.println("Valor $A1: " + cells.entrySet().iterator().next().getValue());

        VbLexer lexer = new VbLexer(new ANTLRInputStream("Log $A1 + 1 $A1 = \"teste\" Log $A1"));
        VbParser parser = new VbParser(new CommonTokenStream(lexer));
        ParseTree tree = parser.parse();
        EvalVisitor visitor = new EvalVisitor(cells);
        visitor.visit(tree);

        //teste
//        System.out.println("Valor $A1: " + cells.entrySet().iterator().next().getValue());
        System.out.println("Output:\n");

        System.out.println(visitor.getOutput());

    }
}
