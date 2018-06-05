package pt.isep.nsheets.client.application.export;

import pt.isep.nsheets.client.application.Settings;
import pt.isep.nsheets.shared.lapr4.red.s1.core.n1161292.services.WorkbookDTO;
import pt.isep.nsheets.shared.services.ExportService;
import pt.isep.nsheets.shared.services.ExportServiceAsync;
import com.google.gwt.core.client.GWT;
import com.google.gwt.event.dom.client.ClickHandler;
import com.google.gwt.user.client.rpc.AsyncCallback;
import com.google.inject.Inject;
import com.google.web.bindery.event.shared.EventBus;
import com.gwtplatform.mvp.client.Presenter;
import com.gwtplatform.mvp.client.View;
import com.gwtplatform.mvp.client.annotations.NameToken;
import com.gwtplatform.mvp.client.annotations.ProxyStandard;
import com.gwtplatform.mvp.client.proxy.ProxyPlace;
import pt.isep.nsheets.client.application.ApplicationPresenter;
import pt.isep.nsheets.client.event.SetPageTitleEvent;
import pt.isep.nsheets.client.place.NameTokens;
import gwt.material.design.client.ui.MaterialToast;

public class ExportPresenter extends Presenter<ExportPresenter.MyView, ExportPresenter.MyProxy>  {

    interface MyView extends View  {
        void csvButtonClickHandler(ClickHandler ch);
        void pdfButtonClickHandler(ClickHandler clickHandler);
    }

    @NameToken(NameTokens.export)
    @ProxyStandard
    interface MyProxy extends ProxyPlace<ExportPresenter> {
    }

    @Inject
    ExportPresenter(EventBus eventBus, MyView view, MyProxy proxy) {
        super(eventBus, view, proxy, ApplicationPresenter.SLOT_CONTENT);

        getView().csvButtonClickHandler(event -> {

            ExportServiceAsync exportSrv = GWT.create(ExportService.class);

            AsyncCallback<WorkbookDTO> callback = new AsyncCallback<WorkbookDTO>() {
                @Override
                public void onFailure(Throwable caught) { MaterialToast.fireToast("Error:" + caught.getMessage(), "rounded"); }

                @Override
                public void onSuccess(WorkbookDTO result) {
                    MaterialToast.fireToast("Exporting file...", "rounded");
                }
            };

            WorkbookDTO workbookDTO = Settings.getInstance().getWorkbook().toDTO();

            exportSrv.exportWorkbook(workbookDTO,"CSV", callback);
        });

        getView().pdfButtonClickHandler(e -> {
            ExportServiceAsync exportServiceAsync = GWT.create(ExportService.class);

            AsyncCallback<WorkbookDTO> callback = new AsyncCallback<WorkbookDTO>() {
                @Override
                public void onFailure(Throwable throwable) {
                    MaterialToast.fireToast("Error! " + throwable.getMessage(), "rounded");
                }
                @Override
                public void onSuccess(WorkbookDTO exportDTO) {
                    MaterialToast.fireToast("Created PDF of workbook", "rounded");
                }
            };

            WorkbookDTO workbookDTO = Settings.getInstance().getWorkbook().toDTO();
            exportServiceAsync.exportWorkbook(workbookDTO, "PDF", callback);
        });
    }

    @Override
    protected void onReveal() {
        super.onReveal();

        SetPageTitleEvent.fire("Export", "Export to PDF, CSV or XML", "", "", this);
    }

}