package pt.isep.nsheets.client.application.form;

import com.google.gwt.event.dom.client.ClickEvent;
import com.google.gwt.uibinder.client.UiBinder;
import com.google.gwt.uibinder.client.UiField;
import com.google.gwt.uibinder.client.UiHandler;
import com.google.gwt.user.client.ui.Widget;
import com.gwtplatform.mvp.client.ViewImpl;
import gwt.material.design.addins.client.window.MaterialWindow;
import javax.inject.Inject;

/**
 *
 * @author João Pereira <1150478@isep.ipp.pt>
 */
class FormView extends ViewImpl implements FormPresenter.MyView {

    interface Binder extends UiBinder<Widget, FormView> {
    }

    @UiField
    MaterialWindow window, windowTab;

    @Inject
    FormView(Binder uiBinder) {
        initWidget(uiBinder.createAndBindUi(this));
    }

    @UiHandler("btnOpenWindow")
    void onOpenWindow(ClickEvent e) {
        window.open();
    }
    
    @UiHandler("btnOpenWindowEditor")
    void onOpenWindowWithTab(ClickEvent e) {
        windowTab.open();
    }
    
     /**
    @UiField
    MaterialTextArea formArea;

    @UiField
    MaterialButton addRow;

    @UiHandler("addRow")
    void onClick(ClickEvent e) {
        //myAddFunction();
        setFormAreaText("Botão está a funcionar");
    }

    public void setFormAreaText(String text) {
        formArea.setText(text);
    }*/

}
