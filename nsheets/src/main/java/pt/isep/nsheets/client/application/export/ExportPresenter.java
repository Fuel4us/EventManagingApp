package pt.isep.nsheets.client.application.export;

import pt.isep.nsheets.shared.application.Settings;
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
import gwt.material.design.client.ui.MaterialModal;
import pt.isep.nsheets.client.application.ApplicationPresenter;
import pt.isep.nsheets.client.event.SetPageTitleEvent;
import pt.isep.nsheets.client.place.NameTokens;
import gwt.material.design.client.ui.MaterialToast;

/**
 * @author Gonçalo Fonseca <1150503@isep.ipp.pt>, Rubén André <1160998@isep.ipp.pt>
 */

public class ExportPresenter extends Presenter<ExportPresenter.MyView, ExportPresenter.MyProxy> {

    @Inject
    ExportPresenter(EventBus eventBus, MyView view, MyProxy proxy) {
        super(eventBus, view, proxy, ApplicationPresenter.SLOT_CONTENT);

        getView().csvButtonClickHandler(event -> {

            ExportServiceAsync exportSrv = GWT.create(ExportService.class);

            AsyncCallback<Boolean> callback = new AsyncCallback<Boolean>() {
                @Override
                public void onFailure(Throwable caught) {
                    MaterialToast.fireToast("Error:" + caught.getMessage(), "rounded");
                }

                @Override
                public void onSuccess(Boolean result) {

                    if (result.booleanValue()) {
                        MaterialToast.fireToast("CSV exported", "rounded");
                    } else {
                        MaterialToast.fireToast("Error exporting workbook", "rounded");
                    }
                }
            };

            WorkbookDTO workbookDTO = Settings.getInstance().getWorkbook().toDTO();

            exportSrv.exportWorkbookAsCSV(workbookDTO, callback);
        });

        getView().xmlButtonClickHandler(ev -> {

            ExportServiceAsync exportSrvAs = GWT.create(ExportService.class);

            AsyncCallback<Boolean> callback = new AsyncCallback<Boolean>() {
                @Override
                public void onFailure(Throwable caught) {
                    MaterialToast.fireToast("Error:" + caught.getMessage(), "rounded");
                }

                @Override
                public void onSuccess(Boolean result) {
                    if (result.booleanValue()) {
                        MaterialToast.fireToast("XML exported", "rounded");
                    } else {
                        MaterialToast.fireToast("Error exporting workbook", "rounded");
                    }
                }
            };

            WorkbookDTO workbookDTO = Settings.getInstance().getWorkbook().toDTO();

            exportSrvAs.exportWorkbookAsXML(workbookDTO, callback);
        });

        getView().pdfButtonClickHandler(e -> {
            ExportServiceAsync exportServiceAsync = GWT.create(ExportService.class);

            AsyncCallback<Boolean> callback = new AsyncCallback<Boolean>() {
                @Override
                public void onFailure(Throwable throwable) {
                    MaterialToast.fireToast("Error! " + throwable.getMessage(), "rounded");
                }

                @Override
                public void onSuccess(Boolean result) {
                    if (result.booleanValue()) {
                        MaterialToast.fireToast("PDF exported", "rounded");
                    } else {
                        MaterialToast.fireToast("Error exporting workbook");
                    }
                }
            };

            WorkbookDTO workbookDTO = Settings.getInstance().getWorkbook().toDTO();
            exportServiceAsync.exportWorkbookAsPDF(workbookDTO, callback);
        });

        getView().cslButtonClickHandler(e -> {
            ExportServiceAsync exportServiceAsync = GWT.create(ExportService.class);

            AsyncCallback<Boolean> callback = new AsyncCallback<Boolean>() {
                @Override
                public void onFailure(Throwable throwable) {
                    MaterialToast.fireToast("Error! " + throwable.getMessage(), "rounded");
                }

                @Override
                public void onSuccess(Boolean result) {
                    if (result.booleanValue()) {
                        MaterialToast.fireToast("CSL exported", "rounded");
                    } else {
                        MaterialToast.fireToast("Error exporting workbook");
                    }
                }
            };
            WorkbookDTO workbookDTO = Settings.getInstance().getWorkbook().toDTO();
            exportServiceAsync.exportWorkbookAsCSL(workbookDTO, callback);
        });
        
        getView().closeModal(e->{
            this.getView().getOverlay().close();
        });

    }

    @Override
    protected void onReveal() {
        super.onReveal();

        SetPageTitleEvent.fire("Export", "Export to PDF, CSV, XML, CSL", "", "", this);
    }

    interface MyView extends View {
        void csvButtonClickHandler(ClickHandler clickHandler);

        void xmlButtonClickHandler(ClickHandler clickHandler);

        void pdfButtonClickHandler(ClickHandler clickHandler);

        void cslButtonClickHandler(ClickHandler clickHandler);
        
        void closeModal(ClickHandler clickHandler);
        
        MaterialModal getOverlay();
    }


    @NameToken(NameTokens.export)
    @ProxyStandard
    interface MyProxy extends ProxyPlace<ExportPresenter> {
    }

}