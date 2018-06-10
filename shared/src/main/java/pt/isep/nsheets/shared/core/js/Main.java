package pt.isep.nsheets.shared.core.js;

import java.util.HashMap;
import java.util.Map;

import org.antlr.v4.runtime.ANTLRInputStream;
import org.antlr.v4.runtime.CommonTokenStream;
import org.antlr.v4.runtime.tree.ParseTree;
import pt.isep.nsheets.shared.core.vb.Value;

//for test purposes only
public class Main {

    public static void main(String[] args) throws Exception {

        Map<String, Value> cells = new HashMap<>();
        cells.put("A1", new Value(Double.valueOf("10")));
        Map<String, Value> teste = new HashMap<>();
        teste.put(cells.entrySet().iterator().next().getKey(), cells.entrySet().iterator().next().getValue());
        System.out.println("Valor $A1: " + cells.entrySet().iterator().next().getValue());

        JsLexer lexer = new JsLexer(new ANTLRInputStream("console.log(\"$A1 + 1 = \" + ($A1 + 1)); $A1 = \"teste\"; console.log(\"$A1 is now 'teste': \" + $A1); $A1 = 1; console.log(\"$A1 is now '1' = \" + $A1); while($A1 < 10){ $A1 = $A1 * 2; } console.log(\"The variable $A1 has the value \" + $A1);"));
        JsParser parser = new JsParser(new CommonTokenStream(lexer));
        ParseTree tree = parser.parse();
        EvalVisitor visitor = new EvalVisitor(cells);
        visitor.visit(tree);

        System.out.println("Output:\n");

        System.out.println(visitor.getOutput());

    }
}
