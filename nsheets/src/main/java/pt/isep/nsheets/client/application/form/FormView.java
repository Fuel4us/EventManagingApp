package pt.isep.nsheets.client.application.form;

import com.google.gwt.event.dom.client.ClickEvent;
import com.google.gwt.event.dom.client.KeyPressEvent;
import com.google.gwt.uibinder.client.UiBinder;
import com.google.gwt.uibinder.client.UiField;
import com.google.gwt.uibinder.client.UiHandler;
import com.google.gwt.user.client.ui.FlexTable;
import com.google.gwt.user.client.ui.Widget;
import com.gwtplatform.mvp.client.ViewImpl;
import gwt.material.design.addins.client.combobox.MaterialComboBox;
import gwt.material.design.addins.client.window.MaterialWindow;
import gwt.material.design.client.ui.MaterialButton;
import gwt.material.design.client.ui.MaterialTextBox;
import javax.inject.Inject;

/**
 *
 * @author João Pereira_1150478@isep.ipp.pt
 */
public class FormView extends ViewImpl implements FormPresenter.MyView {

    /**
     * Binder.
     */
    interface Binder extends UiBinder<Widget, FormView> {
    }

    /**
     * UI field declarations.
     */
    @UiField
    static MaterialWindow window, windowTab;

    @UiField
    MaterialButton btnAddRow, btnRemoveRow, btnEditRow, btnPlayForm1, btnPlayForm2, btnPlayForm3;

    @UiField
    MaterialTextBox txtAreaRemove, txtAreaEdit, txtAreaAdd;

    @UiField
    MaterialComboBox comboWidgets;

    FlexTable table;
    int i = 0;

    /**
     * Form view constructor.
     *
     * @param uiBinder
     */
    @Inject
    FormView(Binder uiBinder) {
        table = new FlexTable();
        table.setBorderWidth(3);
        table.setWidget(0, 0, null);
        initWidget(uiBinder.createAndBindUi(this));
    }

    public static MaterialWindow getWindow() {
        return window;
    }

    /**
     * Open window of the form button action.
     *
     * @param e
     */
    @UiHandler("btnOpenWindow")
    void onOpenWindow(ClickEvent e) {
        window.open();
    }

    /**
     * Open window of the form editor button action.
     *
     * @param e
     */
    @UiHandler("btnOpenWindowEditor")
    void onOpenWindowWithTab(ClickEvent e) {
        windowTab.open();
    }

    /**
     * Add Row button action.
     *
     * @param e
     */
    @UiHandler("btnAddRow")
    void addRowButton(ClickEvent e) {
        MaterialButton resolveButton = new MaterialButton("Resolve");
        MaterialTextBox writeLabel1 = new MaterialTextBox();
        MaterialTextBox writeLabel2 = new MaterialTextBox();
        i++;
        switch (comboWidgets.getSelectedIndex()) {
            case 0:
                writeLabel1.setEnabled(false);
                table.setWidget(i, 1, writeLabel1);
                break;
            case 1:
                table.setWidget(i, 1, resolveButton);
                break;
            case 2:
                writeLabel1.setEnabled(false);
                writeLabel1.setGrid("s12");
                if (txtAreaAdd.getText().isEmpty()) {
                    writeLabel1.setPlaceholder("Write here:");
                } else {
                    writeLabel1.setPlaceholder(txtAreaAdd.getText());
                }
                table.setWidget(i, 1, writeLabel1);
                break;
            case 3:
                writeLabel1.setEnabled(false);
                writeLabel1.setGrid("s12");
                if (txtAreaAdd.getText().isEmpty()) {
                    writeLabel1.setPlaceholder("Write here:");
                } else {
                    writeLabel1.setPlaceholder(txtAreaAdd.getText());
                }
                writeLabel2.setEnabled(false);
                writeLabel2.setGrid("s12");
                writeLabel2.setPlaceholder("Write here:");
                table.setWidget(i, 1, writeLabel1);
                table.setWidget(i, 2, writeLabel2);
                break;
            default:
                break;
        }

        window.add(table);

    }

    /**
     * Combo box with the name of the existing widgets.
     *
     * @param e
     */
    @UiHandler("comboWidgets")
    void comboWidgets(ClickEvent e) {
        comboWidgets.validate();
    }

    /**
     * Text area of the add row button.
     *
     * @param e
     */
    @UiHandler("txtAreaAdd")
    void getTextAdd(KeyPressEvent e) {
        txtAreaAdd.validate();
    }

    /**
     * Text area of the remove row button.
     *
     * @param e
     */
    @UiHandler("txtAreaRemove")
    void getTextRemove(KeyPressEvent e) {
        txtAreaRemove.validate();
    }

    @UiHandler("btnRemoveRow")
    void removeRowButton(ClickEvent e) {
        int index = Integer.parseInt(txtAreaRemove.getValue());
        table.removeRow(index);
    }

    /**
     * Actions of the edit row button.
     *
     * @param e
     */
    @UiHandler("btnEditRow")
    void editRowButton(ClickEvent e) {
        int index = Integer.parseInt(txtAreaEdit.getValue());
        MaterialTextBox writeLabel = new MaterialTextBox();
        writeLabel.setPlaceholder("Write here:");
        writeLabel.setEnabled(true);
        writeLabel.setGrid("s12");
        if (index > table.getRowCount()) {
            table.setWidget(table.getRowCount() - 1, 2, writeLabel);
        } else {
            table.setWidget(index, 2, writeLabel);
        }
    }

    /**
     * Text area of the edit row button.
     *
     * @param e
     */
    @UiHandler("txtAreaEdit")
    void getTextEdit(KeyPressEvent e) {
        txtAreaEdit.validate();
    }

    /**
     * Actions of the play form button on the add row tab.
     *
     * @param e
     */
    @UiHandler("btnPlayForm1")
    void playFormButton1(ClickEvent e) {
        window.open();
    }

    /**
     * Actions of the play form button on the add row tab.
     *
     * @param e
     */
    @UiHandler("btnPlayForm2")
    void playFormButton2(ClickEvent e) {
        window.open();
    }

    /**
     * Actions of the play form button on the add row tab.
     *
     * @param e
     */
    @UiHandler("btnPlayForm3")
    void playFormButton3(ClickEvent e) {
        window.open();
    }

}
