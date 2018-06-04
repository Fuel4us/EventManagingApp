package pt.isep.nsheets.client.application.extensions;

import com.google.gwt.event.dom.client.ClickHandler;
import com.google.gwt.uibinder.client.UiBinder;
import com.google.gwt.uibinder.client.UiField;
import com.google.gwt.user.client.ui.Widget;
import com.gwtplatform.mvp.client.ViewImpl;
import gwt.material.design.client.ui.MaterialButton;
import gwt.material.design.client.ui.MaterialInput;

import javax.inject.Inject;

class ExtensionsView extends ViewImpl implements ExtensionsPresenter.MyView {

    @UiField
    MaterialButton confirmButton;
    @UiField
    MaterialInput bgColorPos;
    @UiField
    MaterialInput fgColorPos;
    @UiField
    MaterialInput bgColorNeg;
    @UiField
    MaterialInput fgColorNeg;


    @Inject
    ExtensionsView(Binder uiBinder) {
        initWidget(uiBinder.createAndBindUi(this));


    }

    @Override
    public String getBgColorPosValue() {
        return bgColorPos.getValue();
    }

    @Override
    public String getFgColorPosValue() {
        return fgColorPos.getValue();
    }

    @Override
    public String getBgColorNegValue() {
        return bgColorNeg.getValue();
    }

    @Override
    public String getFgColorNegValue() {
        return fgColorNeg.getValue();
    }

    @Override
    public void setBgColorPosValue(String bgColorPosValue) {
        this.bgColorPos.setValue(bgColorPosValue);
    }

    @Override
    public void setFgColorPosValue(String fgColorPosValue) {
        this.fgColorPos.setValue(fgColorPosValue);
    }

    @Override
    public void setBgColorNegValue(String bgColorNegValue) {
        this.bgColorNeg.setValue(bgColorNegValue);
    }

    @Override
    public void setFgColorNegValue(String fgColorNegValue) {
        this.fgColorNeg.setValue(fgColorNegValue);
    }

    @Override
    public void addConfirmationHandler(ClickHandler ch) {
        confirmButton.addClickHandler(ch);
    }


    interface Binder extends UiBinder<Widget, ExtensionsView> {
    }

}
