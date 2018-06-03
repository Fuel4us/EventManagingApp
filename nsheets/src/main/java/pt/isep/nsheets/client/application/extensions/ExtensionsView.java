package pt.isep.nsheets.client.application.extensions;

import com.google.gwt.uibinder.client.UiBinder;
import com.google.gwt.uibinder.client.UiField;
import com.google.gwt.user.client.ui.Widget;
import com.gwtplatform.mvp.client.ViewImpl;
import gwt.material.design.client.ui.MaterialButton;
import gwt.material.design.client.ui.MaterialInput;
import gwt.material.design.client.ui.MaterialToast;

import javax.inject.Inject;

class ExtensionsView extends ViewImpl implements ExtensionsPresenter.MyView {

    @UiField
    MaterialButton confirmButton;
    @UiField
    MaterialInput BgColorPos;
    @UiField
    MaterialInput FgColorPos;
    @UiField
    MaterialInput BgColorNeg;
    @UiField
    MaterialInput FgColorNeg;

    @Inject
    ExtensionsView(Binder uiBinder) {
        initWidget(uiBinder.createAndBindUi(this));
        confirmButton.addClickHandler(event -> {
            MaterialToast.fireToast("Color picked for Positive Background Color " + BgColorPos.getValue());
        });
    }

    interface Binder extends UiBinder<Widget, ExtensionsView> {
    }
}
