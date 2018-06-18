package pt.isep.nsheets.client.application.code;

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
import pt.isep.nsheets.shared.core.vb.EvalVisitor;
import pt.isep.nsheets.shared.core.vb.Value;
import pt.isep.nsheets.shared.core.vb.compiler.VbLexer;
import pt.isep.nsheets.shared.core.vb.compiler.VbParser;

import javax.inject.Inject;
import java.util.HashMap;
import java.util.Map;
import java.util.Map.Entry;
import java.util.logging.Level;
import java.util.logging.Logger;

class CodeView extends ViewImpl implements CodePresenter.MyView {

    @UiField
    MaterialTextArea codeTextArea;
    @UiField
    MaterialButton runButton;
    @UiField
    MaterialTextArea outputTextArea;

    interface Binder extends UiBinder<Widget, CodeView> {
    }

    @Inject
    CodeView(Binder uiBinder) {
        initWidget(uiBinder.createAndBindUi(this));

        codeTextArea.setText("Function f1() As Integer\n"
                + "Dim x As Integer\n"
                + "x = 1\n"
                + "Log \"The variable x has the value \" + x\n"
                + "Return x\n"
                + "End Function\n"
                + "\n"
                + "f1()"
        );

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
                VbLexer lexer = new VbLexer(new ANTLRInputStream(codeTextArea.getText()));
                VbParser parser = new VbParser(new CommonTokenStream(lexer));
                ParseTree tree = parser.parse();
                EvalVisitor visitor = new EvalVisitor(cells);
                visitor.visit(tree);

                for (Entry<String, Value> c : cells.entrySet()) {
                    try {
                        Settings.getInstance().getWorkbook().getSpreadsheet(0).getCell(new Address(c.getKey())).setContent(c.getValue().toString());
                    } catch (FormulaCompilationException e) {
                        Logger.getLogger(CodeView.class.getName()).log(Level.SEVERE, null, e);
                    }
                }

                outputTextArea.setText(visitor.getOutput());
            } catch (IndexOutOfBoundsException | RecognitionException | ClassCastException e) {
                outputTextArea.setText("Syntax Error");
            }
        });
    }
}
