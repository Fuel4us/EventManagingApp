package pt.isep.nsheets.client.application.imports;

import com.google.gwt.core.client.GWT;
import com.google.gwt.uibinder.client.UiBinder;
import com.google.gwt.uibinder.client.UiField;
import com.google.gwt.user.client.rpc.AsyncCallback;
import com.google.gwt.user.client.ui.Widget;
import com.gwtplatform.mvp.client.ViewImpl;
import gwt.material.design.addins.client.fileuploader.MaterialFileUploader;
import gwt.material.design.client.ui.MaterialToast;
import pt.isep.nsheets.shared.services.ImportService;
import pt.isep.nsheets.shared.services.ImportServiceAsync;

import javax.inject.Inject;

class ImportView extends ViewImpl implements ImportPresenter.MyView {

    @UiField
    MaterialFileUploader uploader;

    String fileLocation;

    interface Binder extends UiBinder<Widget, ImportView> {
    }

    @Inject
    ImportView(Binder uiBinder) {
        initWidget(uiBinder.createAndBindUi(this));

        uploader.setUrl(GWT.getModuleBaseURL() + "uploadServlet");

        uploader.addSuccessHandler(event -> fileLocation = GWT.getHostPageBaseURL() + "uploadedFiles/" + event.getTarget().getName());

        uploader.addCompleteHandler(event -> {
            ImportServiceAsync service = GWT.create(ImportService.class);

            AsyncCallback<Void> callback = new AsyncCallback<Void>() {
                public void onSuccess(Void aVoid) {
                    MaterialToast.fireToast("File read successfully", "rounded");
                }

                public void onFailure(Throwable caught) {
                    MaterialToast.fireToast("There was an error reading the file", "rounded");
                }
            };

            service.importXmlFile(fileLocation, callback);
        });
    }
}