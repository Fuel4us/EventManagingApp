package pt.isep.nsheets.client.application.form;

import com.google.gwt.event.dom.client.ClickEvent;
import com.google.gwt.uibinder.client.UiBinder;
import com.google.gwt.uibinder.client.UiField;
import com.google.gwt.uibinder.client.UiHandler;
import com.google.gwt.user.client.ui.Widget;
import com.gwtplatform.mvp.client.ViewImpl;
import gwt.material.design.client.ui.MaterialButton;
import gwt.material.design.client.ui.MaterialTextArea;
import javax.inject.Inject;

/**
 *
 * @author João Pereira <1150478@isep.ipp.pt>
 */
class FormView extends ViewImpl implements FormPresenter.MyView {

    interface Binder extends UiBinder<Widget, FormView> {
    }

    @Inject
    FormView(Binder uiBinder) {
        initWidget(uiBinder.createAndBindUi(this));
    }

    @UiField
    MaterialTextArea formArea;

    @UiField
    MaterialButton addRow;

    /*@UiHandler("addRow")
    void onClick(ClickEvent e) {
        //myAddFunction();
        setFormAreaText("Botão está a funcionar");
    }*/

    public void setFormAreaText(String text) {
        formArea.setText(text);
    }
}
