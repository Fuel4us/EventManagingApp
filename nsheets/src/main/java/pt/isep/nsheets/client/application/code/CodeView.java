package pt.isep.nsheets.client.application.code;

import com.google.gwt.uibinder.client.UiBinder;
import com.google.gwt.uibinder.client.UiField;
import com.google.gwt.user.client.ui.Widget;
import com.gwtplatform.mvp.client.ViewImpl;
import gwt.material.design.client.ui.MaterialButton;
import gwt.material.design.client.ui.MaterialTextArea;
import gwt.material.design.client.ui.MaterialTextBox;

import javax.inject.Inject;

class CodeView extends ViewImpl implements CodePresenter.MyView {

    @UiField
    MaterialTextArea CodeArea;
    @UiField
    MaterialButton runButton;
    @UiField
    MaterialTextBox OutputTextBox;

    interface Binder extends UiBinder<Widget, CodeView> {
    }

    @Inject
    CodeView(Binder uiBinder) {
        initWidget(uiBinder.createAndBindUi(this));
        initialize();
    }

    private void initialize() {
        runButton.addClickHandler(event -> {
            //String codeAread = CodeArea.getText();
            OutputTextBox.setText(CodeArea.getText()); //test
        });
    }
}
