package pt.isep.nsheets.client.application.macro;

import com.google.gwt.uibinder.client.UiBinder;
import com.google.gwt.uibinder.client.UiField;
import com.google.gwt.user.client.ui.Widget;
import com.gwtplatform.mvp.client.ViewImpl;
import gwt.material.design.client.ui.MaterialButton;
import gwt.material.design.client.ui.MaterialTextArea;
import gwt.material.design.client.ui.MaterialTextBox;
import java.util.HashMap;
import java.util.Map;
import java.util.Map.Entry;
import java.util.logging.Level;
import java.util.logging.Logger;

import javax.inject.Inject;
import org.antlr.v4.runtime.ANTLRInputStream;
import org.antlr.v4.runtime.CommonTokenStream;
import org.antlr.v4.runtime.RecognitionException;
import org.antlr.v4.runtime.tree.ParseTree;
import pt.isep.nsheets.client.application.Settings;
import pt.isep.nsheets.shared.core.Address;
import pt.isep.nsheets.shared.core.Cell;
import pt.isep.nsheets.shared.core.formula.compiler.FormulaCompilationException;
import pt.isep.nsheets.shared.core.vb.EvalVisitor;
import pt.isep.nsheets.shared.core.vb.Value;
import pt.isep.nsheets.shared.core.vb.VbLexer;
import pt.isep.nsheets.shared.core.vb.VbParser;

class MacroView extends ViewImpl implements MacroPresenter.MyView {

    @UiField
    MaterialTextArea MacroArea;
    @UiField
    MaterialButton runButton;
    @UiField
    MaterialTextArea Output;

    interface Binder extends UiBinder<Widget, MacroView> {
    }

    @Inject
    MacroView(Binder uiBinder) {
        initWidget(uiBinder.createAndBindUi(this));
        initialize();
    }

    private void initialize() {

        MacroArea.setText("Dim x As Integer\n"
                + "\n"
                + "x = 1\n"
                + "\n"
                + "While x <> 10\n"
                + "\n"
                + "x = x + 1\n"
                + "\n"
                + "End While\n"
                + "\n"
                + "Log \"The variable x has the value \" + x");

        runButton.addClickHandler(event -> {

            Map<String, Value> cells = new HashMap<>();

//            String cn = "";
//
            for (Cell c : Settings.getInstance().getWorkbook().getSpreadsheet(0)) {
                try {
                    cells.put(c.toString(), new Value(Double.valueOf(c.getValue().toString())));
                } catch (NumberFormatException ex) {
                    cells.put(c.toString(), new Value(c.getValue().toString()));
                }
            }

            try {
                //OutputText.setText(cn);
                VbLexer lexer = new VbLexer(new ANTLRInputStream(MacroArea.getText()));
                VbParser parser = new VbParser(new CommonTokenStream(lexer));
                ParseTree tree = parser.parse();
                EvalVisitor visitor = new EvalVisitor(cells);
                visitor.visit(tree);

//            //teste
//            try {
//                OutputText.setText(Settings.getInstance().getWorkbook().getSpreadsheet(0).getCell(0, 0).toString() + ": "+ Settings.getInstance().getWorkbook().getSpreadsheet(0).getCell(0, 0).getContent().toString());
//            } catch (Exception e) {
//                OutputText.setText("Failed");
//            }
//            String codeAread = CodeArea.getText();
                //String output = "";

                for (Entry<String, Value> c : cells.entrySet()) {
                    try {
                        Settings.getInstance().getWorkbook().getSpreadsheet(0).getCell(new Address(c.getKey())).setContent(c.getValue().toString());
                        //output += c.getKey() + ": " + c.getValue().toString() + "\n";
                    } catch (FormulaCompilationException ex) {
                        Logger.getLogger(MacroView.class.getName()).log(Level.SEVERE, null, ex);
                    }
                }

                Output.setText(visitor.getOutput());
                //OutputText.setText(output);
                //teste
                //OutputText.setText(Settings.getInstance().getWorkbook().getSpreadsheet(0).getCell(new Address("A1")).getContent());
//            System.out.println("Valor $A1: " + cells.entrySet().iterator().next().getValue().asDouble());
//
//            System.out.println("Output:\n");
//
//            System.out.println(visitor.getOutput());
            } catch (IndexOutOfBoundsException | RecognitionException | ClassCastException ex) {
                Output.setText("Syntax Error");
            }
        });
    }
}
