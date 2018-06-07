package pt.isep.nsheets.client.application.extensions;

import com.google.gwt.event.dom.client.ClickEvent;
import com.google.gwt.event.dom.client.ClickHandler;
import com.google.gwt.event.dom.client.KeyPressEvent;
import com.google.gwt.uibinder.client.UiBinder;
import com.google.gwt.uibinder.client.UiField;
import com.google.gwt.uibinder.client.UiHandler;
import com.google.gwt.user.client.ui.Widget;
import com.gwtplatform.mvp.client.ViewImpl;
import gwt.material.design.client.constants.Color;
import gwt.material.design.client.ui.MaterialButton;
import gwt.material.design.client.ui.MaterialListValueBox;
import gwt.material.design.client.ui.MaterialTextBox;

import javax.inject.Inject;

class ExtensionsView extends ViewImpl implements ExtensionsPresenter.MyView {

    @UiField
    MaterialButton confirmButton;
    @UiField
    MaterialListValueBox<Color> bgColorPos;
    @UiField
    MaterialListValueBox<Color> fgColorPos;
    @UiField
    MaterialListValueBox<Color> bgColorNeg;
    @UiField
    MaterialListValueBox<Color> fgColorNeg;
    @UiField
    MaterialButton menuButton;
    @UiField
    MaterialTextBox menuName;

    interface Binder extends UiBinder<Widget, ExtensionsView> {
    }

    @Inject
    ExtensionsView(Binder uiBinder) {
        initWidget(uiBinder.createAndBindUi(this));

        populateColours();

    }

    @Override
    public int getBgColorPosValue() {
        return bgColorPos.getSelectedIndex();
    }

    @Override
    public int getFgColorPosValue() {
        return fgColorPos.getSelectedIndex();
    }

    @Override
    public int getBgColorNegValue() {
        return bgColorNeg.getSelectedIndex();
    }

    @Override
    public int getFgColorNegValue() {
        return fgColorNeg.getSelectedIndex();
    }

    @Override
    public void setBgColorPosValue(int index) {
        bgColorPos.setItemSelected(index, true);
    }

    @Override
    public void setFgColorPosValue(int index) {
        fgColorPos.setItemSelected(index, true);
    }

    @Override
    public void setBgColorNegValue(int index) {
        bgColorNeg.setItemSelected(index, true);
    }

    @Override
    public void setFgColorNegValue(int index) {
        fgColorNeg.setItemSelected(index, true);
    }

    @Override
    public void addConfirmationHandler(ClickHandler ch) {
        confirmButton.addClickHandler(ch);
    }

    private void populateColours() {
        for (Color c : Color.values()) {
            bgColorPos.addItem(c);
            fgColorPos.addItem(c);
            bgColorNeg.addItem(c);
            fgColorNeg.addItem(c);
        }
    }

    /**
     * Text area of the add row button.
     *
     * @param e
     */
    @UiHandler("menuName")
    void getTextAdd(KeyPressEvent e) {
        menuName.validate();
    }

    @UiHandler("menuButton")
    void removeRowButton(ClickEvent e) {
        String name = menuName.getText();

    }

}
