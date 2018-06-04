package pt.isep.nsheets.client.application.code;

import com.google.gwt.uibinder.client.UiBinder;
import com.google.gwt.uibinder.client.UiField;
import com.google.gwt.user.client.ui.Widget;
import com.gwtplatform.mvp.client.ViewImpl;
import gwt.material.design.client.ui.MaterialButton;
import gwt.material.design.client.ui.MaterialTextArea;
import gwt.material.design.client.ui.MaterialTextBox;
import java.util.HashMap;
import java.util.Map;

import javax.inject.Inject;
import org.antlr.v4.runtime.ANTLRInputStream;
import org.antlr.v4.runtime.CommonTokenStream;
import org.antlr.v4.runtime.tree.ParseTree;
import pt.isep.nsheets.shared.core.vb.EvalVisitor;
import pt.isep.nsheets.shared.core.vb.Value;
import pt.isep.nsheets.shared.core.vb.VbLexer;
import pt.isep.nsheets.shared.core.vb.VbParser;

class CodeView extends ViewImpl implements CodePresenter.MyView {

    @UiField
    MaterialTextArea CodeArea;
    @UiField
    MaterialButton runButton;
    @UiField
    MaterialTextArea OutputText;

    interface Binder extends UiBinder<Widget, CodeView> {
    }

    @Inject
    CodeView(Binder uiBinder) {
        initWidget(uiBinder.createAndBindUi(this));
        initialize();
    }

    private void initialize() {
        runButton.addClickHandler(event -> {

            //teste
            Map<String, Value> cells = new HashMap<>();

            cells.put("A1", new Value(Double.valueOf(0)));

            VbLexer lexer = new VbLexer(new ANTLRInputStream(CodeArea.getText()));
            VbParser parser = new VbParser(new CommonTokenStream(lexer));
            ParseTree tree = parser.parse();
            EvalVisitor visitor = new EvalVisitor(cells);
            visitor.visit(tree);

            //String codeAread = CodeArea.getText();
            OutputText.setText(visitor.getOutput());

            //teste
            System.out.println("Valor $A1: " + cells.entrySet().iterator().next().getValue().asDouble());

            System.out.println("Output:\n");

            System.out.println(visitor.getOutput());
        });
    }
}
