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

    interface Binder extends UiBinder<Widget, ImportView> {
    }

    @Inject
    ImportView(Binder uiBinder) {
        initWidget(uiBinder.createAndBindUi(this));

        uploader.addAddedFileHandler(event -> MaterialToast.fireToast("Event : Added File (" + event.getTarget().getName() + ")"));

        uploader.addRemovedFileHandler(event -> MaterialToast.fireToast("Event : Removed File (" + event.getTarget().getName() + ")"));

        uploader.addErrorHandler(event -> {
            MaterialToast.fireToast("Event : Error (" + event.getTarget().getName() + ")");
            MaterialToast.fireToast("Response Code : (" + event.getResponse().getCode() + ") - " + event.getResponse().getMessage());
        });

        uploader.addSendingHandler(event -> MaterialToast.fireToast("Event : Sending (" + event.getTarget().getName() + ")"));

        uploader.addSuccessHandler(event -> {
            MaterialToast.fireToast("Event : Success (" + event.getTarget().getName() + ")");

            ImportServiceAsync service = GWT.create(ImportService.class);

            AsyncCallback<Void> callback = new AsyncCallback<Void>() {
                public void onSuccess(Void aVoid) {
                    MaterialToast.fireToast("File read successfully", "rounded");
                }

                public void onFailure(Throwable caught) {
                    MaterialToast.fireToast("There was an error reading the file", "rounded");
                }
            };

            service.importXmlFile(callback);
        });

        uploader.addCompleteHandler(event -> {
            MaterialToast.fireToast("Event : Complete (" + event.getTarget().getName() + ")");

            ImportServiceAsync service = GWT.create(ImportService.class);

            AsyncCallback<Void> callback = new AsyncCallback<Void>() {
                public void onSuccess(Void aVoid) {
                    MaterialToast.fireToast("File read successfully", "rounded");
                }

                public void onFailure(Throwable caught) {
                    MaterialToast.fireToast("There was an error reading the file", "rounded");
                }
            };

            service.importXmlFile(callback);
        });

        uploader.addCancelHandler(event -> MaterialToast.fireToast("Event : Cancel (" + event.getTarget().getName() + ")"));

        uploader.addMaxFilesExceededHandler(event -> MaterialToast.fireToast("Event : Max Files Exceeded (" + event.getTarget().getName() + ")"));

        uploader.addMaxFilesReachHandler(event -> MaterialToast.fireToast("Event : Max Files Reached (" + event.getTarget().getName() + ")"));
    }

    @UiField
    MaterialFileUploader uploader;
}