package pt.isep.nsheets.client.application.code_js;

import com.google.gwt.core.client.GWT;
import com.google.gwt.dom.client.Style;
import com.google.gwt.event.dom.client.ClickEvent;
import com.google.gwt.uibinder.client.UiBinder;
import com.google.gwt.uibinder.client.UiField;
import com.google.gwt.uibinder.client.UiHandler;
import com.google.gwt.user.client.rpc.AsyncCallback;
import com.google.gwt.user.client.ui.HasText;
import com.google.gwt.user.client.ui.Widget;
import com.gwtplatform.mvp.client.ViewImpl;
import gwt.material.design.client.constants.ButtonType;
import gwt.material.design.client.constants.Color;
import gwt.material.design.client.constants.IconPosition;
import gwt.material.design.client.constants.IconType;
import gwt.material.design.client.constants.WavesType;
import gwt.material.design.client.ui.MaterialButton;
import gwt.material.design.client.ui.MaterialCard;
import gwt.material.design.client.ui.MaterialCardContent;
import gwt.material.design.client.ui.MaterialCollapsible;
import gwt.material.design.client.ui.MaterialCollapsibleBody;
import gwt.material.design.client.ui.MaterialCollapsibleHeader;
import gwt.material.design.client.ui.MaterialCollapsibleItem;
import gwt.material.design.client.ui.MaterialIcon;
import gwt.material.design.client.ui.MaterialLabel;
import gwt.material.design.client.ui.MaterialLink;
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
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;
import java.util.logging.Level;
import java.util.logging.Logger;

import pt.isep.nsheets.shared.core.formula.compiler.FormulaCompilationException;
import pt.isep.nsheets.shared.core.js_complex.EvalVisitor;
import pt.isep.nsheets.shared.core.js_complex.Function;
import pt.isep.nsheets.shared.core.js_complex.compiler.Js_complexLexer;
import pt.isep.nsheets.shared.core.js_complex.compiler.Js_complexParser;
import pt.isep.nsheets.shared.core.vb.Value;
import pt.isep.nsheets.shared.services.DataException;
import pt.isep.nsheets.shared.services.FunctionService;
import pt.isep.nsheets.shared.services.FunctionServiceAsync;

class Code_JavaScriptView extends ViewImpl implements Code_JavaScriptPresenter.MyView {

    @UiField
    MaterialButton compile_btn;
    @UiField
    MaterialTextArea text_area;
    @UiField
    MaterialCardContent cardContent;
    @UiField
    MaterialCard card;


    @UiField
    MaterialCollapsible functions_area;

    @UiHandler("compile_btn")
    void click_chart(ClickEvent e) {
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
//        tab.addSelectionHandler(selectionEvent -> {
//            if (selectionEvent.getSelectedItem() == 1) {
                animateCards();
//            }
//        });
        initialize();
        runHandler(null, text_area);
    }

    private void initialize() {

//        CodeArea.setText("var x = 10;\n"
//                + "console.log(\"The variable x has the value \" + x);\n"
//                + "console.log(\"x + 1 = \" + (x + 1));\n"
//                + "x = \"teste\";\n"
//                + "console.log(\"x is now 'teste': \" + x);\n"
//                + "x = 1;\n"
//                + "console.log(\"x is now '1' = \" + x);\n"
//                + "while(x < 10){\n"
//                + "x = x * 2;\n"
//                + "}\n"
//                + "console.log(\"The variable x has the value \" + x);");
//
//        runButton.addClickHandler(event -> {
//            runHandler(OutputText, CodeArea);
//        });
//
    }

    private void animateCards() {
        animate(text_area, Transition.SLIDEINUP, 1500, 0);
        animate(card, Transition.SLIDEINRIGHT, 1500, 200);
        animate(compile_btn, Transition.SLIDEINDOWN, 1500, 0);
        animate(functions_area, Transition.SLIDEINUP, 1500, 200);
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

            FunctionServiceAsync functionSrv = GWT.create(FunctionService.class);

            AsyncCallback<List<Function>> callback = new AsyncCallback<List<Function>>() {
                @Override
                public void onFailure(Throwable caught) {
                    throw new RuntimeException("Occured an error accessign the database");
                }

                @Override
                public void onSuccess(List<Function> result) {
                    EvalVisitor visitor = new EvalVisitor(cells, result);
                    visitor.visit(tree);

                    for (Entry<String, Value> c : cells.entrySet()) {
                        try {
                            Settings.getInstance().getWorkbook().getSpreadsheet(0).getCell(new Address(c.getKey())).setContent(c.getValue().toString());
                        } catch (FormulaCompilationException ex) {
                            Logger.getLogger(Code_JavaScriptView.class.getName()).log(Level.SEVERE, null, ex);
                        }
                    }
                    fillFunctions(result);
                    outputArea.setText(visitor.getOutput());
                    try {
                        AsyncCallback<Function> callback2 = new AsyncCallback<Function>() {
                            @Override
                            public void onFailure(Throwable caught) {
                                throw new RuntimeException("Occured an error accessign the database");
                            }

                            @Override
                            public void onSuccess(Function result) {

                                AsyncCallback<List<Function>> callback = new AsyncCallback<List<Function>>() {
                                    @Override
                                    public void onFailure(Throwable caught) {
                                        throw new RuntimeException("Occured an error accessign the database");
                                    }

                                    @Override
                                    public void onSuccess(List<Function> result) {
                                        MaterialToast.fireToast(result.size() + " Functions Loaded");
                                        fillFunctions(result);
                                    }
                                };
                                
                                functionSrv.getFunctions(callback);
                            }

                        };
                        for (Function function : visitor.newFunctions()) {
                            functionSrv.addFunction(function, callback2);
                        }
                    } catch (DataException ex) {
                        Logger.getLogger(EvalVisitor.class.getName()).log(Level.SEVERE, null, ex);
                    }

                }

            };

            functionSrv.getFunctions(callback);

        } catch (IndexOutOfBoundsException | RecognitionException | ClassCastException ex) {
            outputArea.setText("Syntax Error: " + ex);
        }
    }

    public void fillFunctions(List<Function> functions) {

        functions_area.clear();

        for (Function function : functions) {
            MaterialCollapsibleItem item = new MaterialCollapsibleItem();

            MaterialCollapsibleHeader header = new MaterialCollapsibleHeader();
            header.setWaves(WavesType.DEFAULT);
            header.setBackgroundColor(Color.BLUE_LIGHTEN_1);
            MaterialLink link = new MaterialLink();
            link.setText(function.getFunctionId());
            link.setIconType(IconType.FUNCTIONS);
            link.setIconPosition(IconPosition.LEFT);
            link.setTextColor(Color.WHITE);

            MaterialButton btn = new MaterialButton();
            btn.setIconType(IconType.DELETE);
            btn.setIconColor(Color.WHITE);
            btn.setWaves(WavesType.DEFAULT);
            btn.setType(ButtonType.FLAT);
            btn.setFloat(Style.Float.RIGHT);
            btn.setCircle(true);
            
            btn.addClickHandler(handler->{
                
                FunctionServiceAsync functionSrv = GWT.create(FunctionService.class);
                
                AsyncCallback<Function> callback = new AsyncCallback<Function>() {
                                    @Override
                                    public void onFailure(Throwable caught) {
                                        throw new RuntimeException("Occured an error accessign the database");
                                    }

                                    @Override
                                    public void onSuccess(Function result) {
                                        MaterialToast.fireToast("Function "+result.getFunctionId()+" removed!");
                                        functions.remove(result);
                                        fillFunctions(functions);
                                        
                                    }
                                };
                                
                                functionSrv.removeFunction(function,callback);
                                
            });
            header.add(link);
            header.add(btn);
            
            

            MaterialCollapsibleBody body = new MaterialCollapsibleBody();
            MaterialLabel body_func = getMultilineLabel(function.getFunctionBody());
            body.add(body_func);
            item.add(header);
            item.add(body);

            functions_area.add(item);

        }

        functions_area.reload();

    }
    
    private MaterialLabel getMultilineLabel(String text) {
    MaterialLabel label = new MaterialLabel(text.replaceAll(" +", "\u00a0").replaceAll("\n", " "));
    label.setWidth("1%");
    return label;
}
    

}
