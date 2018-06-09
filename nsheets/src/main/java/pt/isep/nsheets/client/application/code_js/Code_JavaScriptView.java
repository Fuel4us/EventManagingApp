package pt.isep.nsheets.client.application.code_js;

import com.google.gwt.uibinder.client.UiBinder;
import com.google.gwt.uibinder.client.UiField;
import com.google.gwt.user.client.ui.Widget;
import com.gwtplatform.mvp.client.ViewImpl;
import gwt.material.design.client.ui.MaterialButton;
import gwt.material.design.client.ui.MaterialTextArea;
import org.antlr.v4.runtime.ANTLRInputStream;
import org.antlr.v4.runtime.CommonTokenStream;
import org.antlr.v4.runtime.RecognitionException;
import org.antlr.v4.runtime.tree.ParseTree;
import pt.isep.nsheets.shared.application.Settings;
import pt.isep.nsheets.shared.core.Address;
import pt.isep.nsheets.shared.core.Cell;
import pt.isep.nsheets.shared.core.formula.compiler.FormulaCompilationException;
import pt.isep.nsheets.shared.core.js.EvalVisitor;
import pt.isep.nsheets.shared.core.vb.Value;
import pt.isep.nsheets.shared.core.js.JsLexer;
import pt.isep.nsheets.shared.core.js.JsParser;

import javax.inject.Inject;
import java.util.HashMap;
import java.util.Map;
import java.util.Map.Entry;
import java.util.logging.Level;
import java.util.logging.Logger;

class Code_JavaScriptView extends ViewImpl implements Code_JavaScriptPresenter.MyView {

    @UiField
    MaterialTextArea CodeArea;
    @UiField
    MaterialButton runButton;
    @UiField
    MaterialTextArea OutputText;

    interface Binder extends UiBinder<Widget, Code_JavaScriptView> {
    }

    @Inject
    Code_JavaScriptView(Binder uiBinder) {
        initWidget(uiBinder.createAndBindUi(this));
        initialize();
    }

    private void initialize() {

        CodeArea.setText("var x = 10;\n"
                + "console.log(\"The variable x has the value \" + x);\n"
                + "console.log(\"x + 1 = \" + (x + 1));\n"
                + "x = \"teste\";\n"
                + "console.log(\"x is now 'teste': \" + x);\n"
                + "x = 1;\n"
                + "console.log(\"x is now '1' = \" + x);\n"
                + "while(x < 10){\n"
                + "x = x * 2;\n"
                + "}\n"
                + "console.log(\"The variable x has the value \" + x);");

        runButton.addClickHandler(event -> {

            Map<String, Value> cells = new HashMap<>();

            for (Cell c : Settings.getInstance().getWorkbook().getSpreadsheet(0)) {
                try {
                    cells.put(c.toString(), new Value(Double.valueOf(c.getValue().toString())));
                } catch (NumberFormatException ex) {
                    cells.put(c.toString(), new Value(c.getValue().toString()));
                }
            }

            try {

                JsLexer lexer = new JsLexer(new ANTLRInputStream(CodeArea.getText()));
                JsParser parser = new JsParser(new CommonTokenStream(lexer));
                ParseTree tree = parser.parse();
                EvalVisitor visitor = new EvalVisitor(cells);
                visitor.visit(tree);

                for (Entry<String, Value> c : cells.entrySet()) {
                    try {
                        Settings.getInstance().getWorkbook().getSpreadsheet(0).getCell(new Address(c.getKey())).setContent(c.getValue().toString());
                    } catch (FormulaCompilationException ex) {
                        Logger.getLogger(Code_JavaScriptView.class.getName()).log(Level.SEVERE, null, ex);
                    }
                }

                OutputText.setText(visitor.getOutput());

            } catch (IndexOutOfBoundsException | RecognitionException | ClassCastException ex) {
                OutputText.setText("Syntax Error");
            }
        });
    }
}
