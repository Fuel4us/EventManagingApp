package pt.isep.nsheets.client.lapr4.blue.s2.core.n1150478.application.extensions;

import com.google.gwt.event.dom.client.ClickHandler;
import com.google.gwt.event.logical.shared.ValueChangeEvent;
import com.google.gwt.uibinder.client.UiBinder;
import com.google.gwt.uibinder.client.UiField;
import com.google.gwt.uibinder.client.UiHandler;
import com.google.gwt.user.client.ui.Widget;
import com.gwtplatform.mvp.client.ViewImpl;
import gwt.material.design.addins.client.combobox.MaterialComboBox;
import gwt.material.design.client.constants.Color;
import gwt.material.design.client.constants.IconType;
import gwt.material.design.client.ui.*;

import javax.inject.Inject;

/**
 *
 * João Pereira_1150478@isep.ipp.pt
 */
class ExtensionsView extends ViewImpl implements ExtensionsPresenter.MyView {

    @UiField
    MaterialSwitch switch1;
    @UiField
    MaterialSwitch switch2;
    @UiField
    MaterialSwitch switch3;
    @UiField
    MaterialSwitch switch4;
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
    MaterialListValueBox<IconType> iconsMenu;
    @UiField
    MaterialListValueBox<IconType> iconsPop;
    @UiField
    MaterialButton menuButton;
    @UiField
    MaterialTextBox menuName;
    @UiField
    MaterialButton popButton;
    @UiField
    MaterialTextBox popName;
    @UiField
    MaterialButton btnSide;
    @UiField
    MaterialTextBox txtSide;
    @UiField
    MaterialButton btnSwitch;
    @UiField
    MaterialComboBox comboBars;
    @UiField
    MaterialCollapsibleItem switch1_item;
    @UiField
    MaterialCollapsibleItem switch2_item;
    @UiField
    MaterialCollapsibleItem switch3_item;
    @UiField
    MaterialCollapsibleItem switch4_item;

    interface Binder extends UiBinder<Widget, ExtensionsView> {
    }

    @Inject
    ExtensionsView(Binder uiBinder) {
        initWidget(uiBinder.createAndBindUi(this));

        populateColours();
        populateIcons();
    }

    @Override
    public MaterialComboBox getComboBars() {
        return comboBars;
    }

    @Override
    public MaterialSwitch getMaterialSwitch1() {
        return switch1;
    }

    @Override
    public MaterialSwitch getMaterialSwitch2() {
        return switch2;
    }

    @Override
    public MaterialSwitch getMaterialSwitch3() {
        return switch3;
    }

    @Override
    public MaterialSwitch getMaterialSwitch4() {
        return switch4;
    }

    @Override
    public MaterialTextBox getTxtSide() {
        return txtSide;
    }

    @Override
    public MaterialButton getBtnSwitch() {
        return btnSwitch;
    }

    @Override
    public MaterialButton getBtnSide() {
        return btnSide;
    }

    @Override
    public IconType getIconMenuChoosed() {
        return iconsMenu.getSelectedValue();
    }

    @Override
    public IconType getIconPopChoosed() {
        return iconsPop.getSelectedValue();
    }

    @Override
    public MaterialButton getPopButton() {
        return popButton;
    }

    @Override
    public MaterialTextBox getPopName() {
        return popName;
    }

    @Override
    public MaterialTextBox getMenuName() {
        return menuName;
    }

    @Override
    public MaterialButton getMenuButton() {
        return menuButton;
    }

    @Override
    public MaterialCollapsibleItem getSwitch1_Item() { return switch1_item; }

    @Override
    public MaterialCollapsibleItem getSwitch2_Item() { return switch2_item; }

    @Override
    public MaterialCollapsibleItem getSwitch3_Item() { return switch3_item; }

    @Override
    public MaterialCollapsibleItem getSwitch4_Item() { return switch4_item; }

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

    private void populateIcons() {
        for (IconType i : IconType.values()) {
            iconsMenu.add(i);
            iconsPop.add(i);
        }
    }

    @UiHandler({"switch1", "switch2", "switch3", "switch4"})
    void onValueChange(ValueChangeEvent<Boolean> e) {
        if (e.getValue() == true) {
            MaterialToast.fireToast("Extension is now Enabled");
        } else {
            MaterialToast.fireToast("Extension is now Disabled");
        }
    }


}
