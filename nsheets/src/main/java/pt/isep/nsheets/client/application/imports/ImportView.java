package pt.isep.nsheets.client.application.imports;

import com.google.gwt.core.client.GWT;
import com.google.gwt.uibinder.client.UiBinder;
import com.google.gwt.uibinder.client.UiField;
import com.google.gwt.user.client.rpc.AsyncCallback;
import com.google.gwt.user.client.ui.Widget;
import com.gwtplatform.mvp.client.ViewImpl;
import gwt.material.design.addins.client.fileuploader.MaterialFileUploader;
import gwt.material.design.client.ui.MaterialToast;
import pt.isep.nsheets.shared.application.Settings;
import pt.isep.nsheets.shared.lapr4.red.s1.core.n1161292.services.WorkbookDTO;
import pt.isep.nsheets.shared.services.ImportService;
import pt.isep.nsheets.shared.services.ImportServiceAsync;

import javax.inject.Inject;

class ImportView extends ViewImpl implements ImportPresenter.MyView {

    @UiField
    MaterialFileUploader uploader;

    interface Binder extends UiBinder<Widget, ImportView> {
    }

    @Inject
    ImportView(Binder uiBinder) {
        initWidget(uiBinder.createAndBindUi(this));

        uploader.setUrl(GWT.getModuleBaseURL() + "uploadServlet");

        uploader.addSuccessHandler(event -> {
            String fileName = event.getTarget().getName();

            ImportServiceAsync service = GWT.create(ImportService.class);

            AsyncCallback<WorkbookDTO> callback = new AsyncCallback<WorkbookDTO>() {
                @Override
                public void onSuccess(WorkbookDTO workbook) {
                    MaterialToast.fireToast("Workbook imported successfully", "rounded");
                    Settings.getInstance().updateWorkbook(workbook);
                }

                @Override
                public void onFailure(Throwable caught) {
                    MaterialToast.fireToast("There was a problem importing the workbook", "rounded");
                }
            };

            service.importXmlFile(fileName, callback);
        });
    }
}