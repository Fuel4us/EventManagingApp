/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package pt.isep.nsheets.shared.core.js_complex;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import org.antlr.v4.runtime.ANTLRInputStream;
import org.antlr.v4.runtime.CommonTokenStream;
import org.antlr.v4.runtime.tree.ParseTree;
import pt.isep.nsheets.shared.core.js_complex.compiler.Js_complexLexer;
import pt.isep.nsheets.shared.core.js_complex.compiler.Js_complexParser;
import pt.isep.nsheets.shared.core.vb.Value;

/**
 *
 * @author pedromonteiro
 */
public class Main {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        Map<String, Value> cells = new HashMap<>();
        cells.put("A1", new Value(Double.valueOf("10")));
        Map<String, Value> teste = new HashMap<>();
        teste.put(cells.entrySet().iterator().next().getKey(), cells.entrySet().iterator().next().getValue());
        System.out.println("Valor $A1: " + cells.entrySet().iterator().next().getValue());
        List<Function> function = new ArrayList<>();
        function.add(new Function("func1", "console.log(\"olá\");"));

//        String output1 = "console.log(\"$A1 + 1 = \" + ($A1 + 1)); $A1 = \"teste\"; console.log(\"$A1 is now 'teste': \" + $A1); $A1 = 1; console.log(\"$A1 is now '1' = \" + $A1); while($A1 < 10){ $A1 = $A1 * 2; } console.log(\"The variable $A1 has the value \" + $A1);";
        String output2 = "var j = 7; "
                + "function test2(){console.log(\"olá\");}\n"
                + "function test(){";
        Js_complexLexer lexer = new Js_complexLexer(new ANTLRInputStream("var x = \"José\";\n"
                + "console.log(\"O meu nome é\": + x);\n"
                + "\n"
                + "function gonc(){\n"
                + "x = \"Gonçalo\";\n"
                + "console.log(\"O meu novo nome é\": + x);\n"
                + "}\n"
                + "\n"
                + "console.log(\"O meu novo nome é\": + x);"));

        Js_complexParser parser = new Js_complexParser(new CommonTokenStream(lexer));
        ParseTree tree = parser.parse();
        pt.isep.nsheets.shared.core.js_complex.EvalVisitor visitor = new pt.isep.nsheets.shared.core.js_complex.EvalVisitor(cells, function);
        visitor.visit(tree);

        System.out.println("Output:\n");

        System.out.println(visitor.getOutput());
    }

//    var exec = 0;
//$B1 = 0;
//
//function f4(){
//$B1 = $B1 + 6;
//return 3;
//}
//while(exec < 2){
//f4();
//exec = exec + 1;
//}
//
////var j = f4();
//
////console.log($B1+" e j ="+j);
}
