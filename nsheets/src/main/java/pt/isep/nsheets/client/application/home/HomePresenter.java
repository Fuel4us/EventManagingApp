package pt.isep.nsheets.client.application.home;

import java.util.ArrayList;

import com.google.gwt.core.client.GWT;
import com.google.gwt.event.dom.client.ClickHandler;
import com.google.gwt.user.client.rpc.AsyncCallback;
import com.google.inject.Inject;
import com.google.web.bindery.event.shared.EventBus;
import com.gwtplatform.mvp.client.Presenter;
import com.gwtplatform.mvp.client.View;
import com.gwtplatform.mvp.client.annotations.ProxyStandard;
import com.gwtplatform.mvp.client.proxy.ProxyPlace;

import gwt.material.design.client.ui.MaterialToast;

import com.gwtplatform.mvp.client.annotations.NameToken;
import java.util.logging.Level;
import java.util.logging.Logger;
import pt.isep.nsheets.client.application.ApplicationPresenter;
import pt.isep.nsheets.client.event.SetPageTitleEvent;
import pt.isep.nsheets.client.place.NameTokens;
import pt.isep.nsheets.shared.core.Workbook;
import pt.isep.nsheets.shared.lapr4.red.s1.core.n1161292.services.WorkbookDTO;
import pt.isep.nsheets.client.application.Settings;
import pt.isep.nsheets.shared.services.WorkbooksServiceAsync;
import pt.isep.nsheets.shared.services.WorkbooksService;

public class HomePresenter extends Presenter<HomePresenter.MyView, HomePresenter.MyProxy> {

    private MyView view;

    interface MyView extends View {

        void setContents(ArrayList<WorkbookDTO> contents);

        void addClickHandler(ClickHandler ch);

        void renameClickHandler(ClickHandler ch);

        void deleteClickHandler(ClickHandler ch);

        void cancelClickHandler(ClickHandler ch);

        void openOptionModal();

        void closeOptionModal();

        void openModal();

        void closeModal();

        void buttonClickHandler(ClickHandler ch);

        WorkbookDTO focusedWorkbookDTO();
        
        String search();
        
        String rename();

        String title();

        String description();
    }

    @NameToken(NameTokens.home)
    @ProxyStandard
    interface MyProxy extends ProxyPlace<HomePresenter> {
    }

    @Inject
    HomePresenter(EventBus eventBus, MyView view, MyProxy proxy) {
        super(eventBus, view, proxy, ApplicationPresenter.SLOT_CONTENT);

        this.view = view;

        this.view.addClickHandler(event -> {
            this.view.openModal();
        });

        this.view.buttonClickHandler(e -> {
            WorkbooksServiceAsync workbooksSvc = GWT.create(WorkbooksService.class);

            // Set up the callback object.
            AsyncCallback<WorkbookDTO> callback = new AsyncCallback<WorkbookDTO>() {
                @Override
                public void onFailure(Throwable caught) {
                    MaterialToast.fireToast("Error! " + caught.getMessage());
                }

                @Override
                public void onSuccess(WorkbookDTO result) {
                    MaterialToast.fireToast("New Workbook Created", "rounded");

                    refreshView();
                }
            };

            WorkbookDTO wdDto = new Workbook(this.view.title(), this.view.description(), Settings.SPREADSHEET_DEFAULT).toDTO();
            workbooksSvc.addWorkbookDescription(wdDto, callback);

            this.view.closeModal();
        });

        this.view.renameClickHandler(e -> {
            WorkbooksServiceAsync workbooksSvc = GWT.create(WorkbooksService.class);
            String rename = this.view.rename();
            WorkbookDTO wdto = this.view.focusedWorkbookDTO();
            // Set up the callback object.
            AsyncCallback<WorkbookDTO> callback = new AsyncCallback<WorkbookDTO>() {
                @Override
                public void onFailure(Throwable caught) {
                    MaterialToast.fireToast("Error in renaming!");
                }

                @Override
                public void onSuccess(WorkbookDTO result) {
                    try {
                        MaterialToast.fireToast("Workbook renamed successfully!");
                        refreshView();
                    } catch (IllegalArgumentException ex) {
                        Logger.getLogger(HomeView.class.getName()).log(Level.SEVERE, null, ex);
                    }
                }
            };
            workbooksSvc.renameWorkbook(rename, wdto, callback);
            this.view.closeOptionModal();
        });

        
        this.view.deleteClickHandler(e -> {
            WorkbooksServiceAsync workbooksSvc = GWT.create(WorkbooksService.class);
            WorkbookDTO wdto = this.view.focusedWorkbookDTO();
            // Set up the callback object.
            AsyncCallback<WorkbookDTO> callback = new AsyncCallback<WorkbookDTO>() {
                @Override
                public void onFailure(Throwable caught) {
                    
                }

                @Override
                public void onSuccess(WorkbookDTO result) {
                    try {
                        MaterialToast.fireToast("Workbook deleted successfully!");
                    } catch (IllegalArgumentException ex) {
                        Logger.getLogger(HomeView.class.getName()).log(Level.SEVERE, null, ex);
                    }
                }
            };
            workbooksSvc.deleteWorkbook(wdto, callback);
            this.view.closeOptionModal();
        });
         
        this.view.cancelClickHandler(e -> {
            this.view.closeOptionModal();
        });
    }

    private void refreshView() {
        WorkbooksServiceAsync workbooksSvc = GWT.create(WorkbooksService.class);

        // Set up the callback object.
        AsyncCallback<ArrayList<WorkbookDTO>> callback = new AsyncCallback<ArrayList<WorkbookDTO>>() {
            @Override
            public void onFailure(Throwable caught) {
                // TODO: Do something with errors.
            }

            @Override
            public void onSuccess(ArrayList<WorkbookDTO> result) {
                view.setContents(result);
            }
        };

        workbooksSvc.getWorkbooks(callback);
    }

    @Override
    protected void onReveal() {
        super.onReveal();

        SetPageTitleEvent.fire("Home", "The most recent Workbooks", "", "", this);

        refreshView();
    }

}
