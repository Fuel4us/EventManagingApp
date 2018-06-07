package pt.isep.nsheets.client.application.imports;

import com.google.gwt.event.dom.client.ClickEvent;
import com.google.gwt.uibinder.client.UiBinder;
import com.google.gwt.uibinder.client.UiField;
import com.google.gwt.uibinder.client.UiHandler;
import com.google.gwt.user.client.ui.Widget;
import com.gwtplatform.mvp.client.ViewImpl;
import gwt.material.design.addins.client.fileuploader.MaterialFileUploader;

import javax.inject.Inject;

class ImportView extends ViewImpl implements ImportPresenter.MyView {

    interface Binder extends UiBinder<Widget, ImportView> {
    }

    @Inject
    ImportView(Binder uiBinder) {
        initWidget(uiBinder.createAndBindUi(this));
    }

    @UiField
    MaterialFileUploader uploader;

    @UiHandler("uploader")
    public void uploadXmlFile(ClickEvent e) {
    }
}