package pt.isep.nsheets.client.application.form;

import com.google.gwt.event.dom.client.ClickEvent;
import com.google.gwt.event.dom.client.KeyPressEvent;
import com.google.gwt.uibinder.client.UiBinder;
import com.google.gwt.uibinder.client.UiField;
import com.google.gwt.uibinder.client.UiHandler;
import com.google.gwt.user.client.ui.FlexTable;
import com.google.gwt.user.client.ui.HTMLTable;
import com.google.gwt.user.client.ui.RootPanel;
import com.google.gwt.user.client.ui.Widget;
import com.googlecode.gwt.charts.client.ColumnType;
import com.googlecode.gwt.charts.client.DataTable;
import com.gwtplatform.mvp.client.ViewImpl;
import gwt.material.design.addins.client.window.MaterialWindow;
import gwt.material.design.client.constants.FlexAlignItems;
import gwt.material.design.client.constants.TextAlign;
import gwt.material.design.client.ui.MaterialButton;
import gwt.material.design.client.ui.MaterialPanel;
import gwt.material.design.client.ui.MaterialRow;
import gwt.material.design.client.ui.MaterialTextArea;
import gwt.material.design.client.ui.MaterialTextBox;
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

    @UiField
    MaterialButton btnAddRow, btnRemoveRow, btnEditRow, btnPlayForm1, btnPlayForm2, btnPlayForm3;
    
    @UiField
    MaterialTextBox txtArea;

    FlexTable table;
    int i = 0;
    
    @Inject
    FormView(Binder uiBinder) {
        table = new FlexTable();
        table.setBorderWidth(3);
        table.setWidget(0, 0, null);
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

    @UiHandler("btnAddRow")
    void addRowButton(ClickEvent e) {
        MaterialButton resolveButton = new MaterialButton("Resolve");
        MaterialTextBox writeLabel = new MaterialTextBox();
        writeLabel.setPlaceholder("Write here:");
        writeLabel.setEnabled(false);
        writeLabel.setGrid("s12");
        i++;
        table.setWidget(i, 1, resolveButton);
        table.setWidget(i, 2, writeLabel);
        window.add(table);
    }

    @UiHandler("btnRemoveRow")
    void removeRowButton(ClickEvent e) {
        int index = Integer.parseInt(txtArea.getValue());
        table.removeRow(index-1);
    }
    
    @UiHandler("txtArea")
    void getText(KeyPressEvent e) {
        txtArea.validate();
    }
    
    @UiHandler("btnEditRow")
    void editRowButton(ClickEvent e) {
        window.open();
    }

    @UiHandler("btnPlayForm1")
    void playFormButton1(ClickEvent e) {
        window.open();
    }

    @UiHandler("btnPlayForm2")
    void playFormButton2(ClickEvent e) {
        window.open();
    }

    @UiHandler("btnPlayForm3")
    void playFormButton3(ClickEvent e) {
        window.open();
    }

}
