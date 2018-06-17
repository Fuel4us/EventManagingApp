package pt.isep.nsheets.client.application.code_js;

import com.google.gwt.event.dom.client.ClickEvent;
import com.google.gwt.uibinder.client.UiBinder;
import com.google.gwt.uibinder.client.UiField;
import com.google.gwt.uibinder.client.UiHandler;
import com.google.gwt.user.client.ui.HasText;
import com.google.gwt.user.client.ui.Widget;
import com.gwtplatform.mvp.client.ViewImpl;
import gwt.material.design.client.constants.Color;
import gwt.material.design.client.ui.MaterialButton;
import gwt.material.design.client.ui.MaterialCard;
import gwt.material.design.client.ui.MaterialCardContent;
import gwt.material.design.client.ui.MaterialRow;
import gwt.material.design.client.ui.MaterialTab;
import gwt.material.design.client.ui.MaterialTextArea;
import gwt.material.design.client.ui.MaterialToast;
import gwt.material.design.client.ui.animate.MaterialAnimation;
import gwt.material.design.client.ui.animate.Transition;
import org.antlr.v4.runtime.ANTLRInputStream;
import org.antlr.v4.runtime.CommonTokenStream;
import org.antlr.v4.runtime.RecognitionException;
import org.antlr.v4.runtime.tree.ParseTree;
import pt.isep.nsheets.shared.application.Settings;
import pt.isep.nsheets.shared.core.Address;
import pt.isep.nsheets.shared.core.Cell;
//import pt.isep.nsheets.shared.core.formula.compiler.FormulaCompilationException;
//import pt.isep.nsheets.shared.core.js.EvalVisitor;
//import pt.isep.nsheets.shared.core.vb.Value;
//import pt.isep.nsheets.shared.core.js_complex.compiler.;
//import pt.isep.nsheets.shared.core.js.JsParser;

import javax.inject.Inject;
import java.util.HashMap;
import java.util.Map;
import java.util.Map.Entry;
import java.util.logging.Level;
import java.util.logging.Logger;

import pt.isep.nsheets.shared.core.formula.compiler.FormulaCompilationException;
import pt.isep.nsheets.shared.core.js_complex.EvalVisitor;
import pt.isep.nsheets.shared.core.js_complex.compiler.Js_complexLexer;
import pt.isep.nsheets.shared.core.js_complex.compiler.Js_complexParser;
import pt.isep.nsheets.shared.core.vb.Value;

class Code_JavaScriptView extends ViewImpl implements Code_JavaScriptPresenter.MyView {

    @UiField
    MaterialTextArea CodeArea;
    @UiField
    MaterialButton runButton, compile_btn;
    @UiField
    MaterialTextArea OutputText;
    @UiField
    MaterialRow tabbar;
    @UiField
    MaterialTextArea text_area;
    @UiField
    MaterialCardContent cardContent;
    @UiField
    MaterialCard card;

    @UiField
    MaterialTab tab;

    @UiHandler("compile_btn")
    void click_chart(ClickEvent e) {
//        MaterialToast.fireToast(text_area.getValue());
//        cardContent.add(new MaterialLabel(text_area.getText()));

        cardContent.clear();
        MaterialTextArea result = new MaterialTextArea();
        result.setTextColor(Color.BLACK);
        result.setEnabled(false);
        runHandler(result, text_area);
        cardContent.add(result);
    }

    interface Binder extends UiBinder<Widget, Code_JavaScriptView> {
    }

    @Inject
    Code_JavaScriptView(Binder uiBinder) {
        initWidget(uiBinder.createAndBindUi(this));
        tab.addSelectionHandler(selectionEvent -> {
            if (selectionEvent.getSelectedItem() == 1) {
                animateCards();
            }
        });
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
            runHandler(OutputText, CodeArea);
        });
    }

    private void animateCards() {
        animate(text_area, Transition.SLIDEINUP, 1500, 0);
        animate(card, Transition.SLIDEINRIGHT, 1500, 200);
        animate(compile_btn, Transition.SLIDEINDOWN, 1500, 0);
    }

    private void animate(Widget widget, Transition transition, int time, int delay) {
        MaterialAnimation animation = new MaterialAnimation();
        animation.setTransition(transition);
        animation.setDelay(delay);
        animation.setDuration(time);
        animation.setInfinite(false);

        animation.animate(widget);
    }

    private void runHandler(HasText outputArea, HasText codeArea) {
        
        Map<String, Value> cells = new HashMap<>();

        for (Cell c : Settings.getInstance().getWorkbook().getSpreadsheet(0)) {
            try {
                cells.put(c.toString(), new Value(Double.valueOf(c.getValue().toString())));
            } catch (NumberFormatException ex) {
                cells.put(c.toString(), new Value(c.getValue().toString()));
            }
        }

        try {

            Js_complexLexer lexer = new Js_complexLexer(new ANTLRInputStream(codeArea.getText()));
            
            Js_complexParser parser = new Js_complexParser(new CommonTokenStream(lexer));
            ParseTree tree = parser.parse();
            //TODO add function block as parameter
            EvalVisitor visitor = new EvalVisitor(cells, null);
            visitor.visit(tree);

            for (Entry<String, Value> c : cells.entrySet()) {
                try {
                    Settings.getInstance().getWorkbook().getSpreadsheet(0).getCell(new Address(c.getKey())).setContent(c.getValue().toString());
                } catch (FormulaCompilationException ex) {
                    Logger.getLogger(Code_JavaScriptView.class.getName()).log(Level.SEVERE, null, ex);
                }
            }

            outputArea.setText(visitor.getOutput());
            MaterialToast.fireToast(codeArea.getText());

        } catch (IndexOutOfBoundsException | RecognitionException | ClassCastException ex) {
            outputArea.setText("Syntax Error: "+ex);
        }
    }

}
