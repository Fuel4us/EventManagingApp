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
import com.gwtplatform.mvp.client.proxy.PlaceManager;
import com.gwtplatform.mvp.client.proxy.ProxyPlace;

import com.gwtplatform.mvp.shared.proxy.PlaceRequest;
import gwt.material.design.client.ui.MaterialToast;

import com.gwtplatform.mvp.client.annotations.NameToken;
import gwt.material.design.client.ui.MaterialButton;
import java.util.logging.Level;
import java.util.logging.Logger;
import pt.isep.nsheets.client.application.ApplicationPresenter;
import pt.isep.nsheets.client.application.menu.MenuView;
import pt.isep.nsheets.client.event.SetPageTitleEvent;
import pt.isep.nsheets.client.place.NameTokens;
import pt.isep.nsheets.client.place.ParameterTokens;
import pt.isep.nsheets.client.security.CurrentUser;
import pt.isep.nsheets.shared.core.Workbook;
import pt.isep.nsheets.shared.lapr4.red.s1.core.n1161292.services.WorkbookDTO;
import pt.isep.nsheets.shared.application.Settings;
import pt.isep.nsheets.shared.services.WorkbooksServiceAsync;
import pt.isep.nsheets.shared.services.WorkbooksService;

public class HomePresenter extends Presenter<HomePresenter.MyView, HomePresenter.MyProxy> {

    private MyView view;
    private final PlaceManager placeManager;

    interface MyView extends View {

        void setContents(ArrayList<WorkbookDTO> contents);

        void searchClickHandler(ClickHandler ch);

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

        MaterialButton getSwitchStateButton();

        void switchClickHandler(ClickHandler ch);
    }

    @NameToken(NameTokens.home)
    @ProxyStandard
    interface MyProxy extends ProxyPlace<HomePresenter> {
    }

    @Inject
    HomePresenter(EventBus eventBus, MyView view, MyProxy proxy, PlaceManager placeManager, CurrentUser currentUser) {
        super(eventBus, view, proxy, ApplicationPresenter.SLOT_CONTENT);

        this.view = view;
        this.placeManager = placeManager;

        this.view.addClickHandler(event -> {
            this.view.openModal();
        });

        MenuView.getUsername().addClickHandler(event -> {
            if(currentUser.isLoggedIn()){
                this.redirectToProfilePage();
            }else{
                redirectToLoginPage();
            }
        });

        this.view.buttonClickHandler(e -> {
            WorkbooksServiceAsync workbooksSvc = GWT.create(WorkbooksService.class);
            boolean publicState = false;
            String userName = MenuView.getUsername().toString();
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

            WorkbookDTO wdDto = new Workbook(this.view.title(), this.view.description(), publicState, userName, Settings.SPREADSHEET_DEFAULT).toDTO();
            workbooksSvc.addWorkbookDescription(wdDto, callback);

            this.view.closeModal();
        });

        this.view.searchClickHandler(e -> {
            WorkbooksServiceAsync workbooksSvc = GWT.create(WorkbooksService.class);
            String workbookName = this.view.search();

            // Set up the callback object.
            AsyncCallback<ArrayList<WorkbookDTO>> callback = new AsyncCallback<ArrayList<WorkbookDTO>>() {

                @Override
                public void onFailure(Throwable caught) {
                    MaterialToast.fireToast("Workbooks with that name not found!");
                }

                @Override
                public void onSuccess(ArrayList<WorkbookDTO> result) {
                    try {
                        MaterialToast.fireToast("Workbooks filtered by name!");
                    } catch (IllegalArgumentException ex) {
                        Logger.getLogger(HomeView.class.getName()).log(Level.SEVERE, null, ex);
                    }
                }
            };
            if(workbookName.equals("all")) {
                refreshView();
            } 
            refreshViewAfterSearch(workbookName);
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

        // ### SWITCH ### 
        this.view.switchClickHandler(e -> {
            WorkbooksServiceAsync workbooksSvc = GWT.create(WorkbooksService.class);
            WorkbookDTO wdto = this.view.focusedWorkbookDTO();
            boolean state;
            if (wdto.publicState==true) {
                state = false;
            } else {
                state = true;
            }

            // Set up the callback object.
            AsyncCallback<WorkbookDTO> callback = new AsyncCallback<WorkbookDTO>() {
                @Override
                public void onFailure(Throwable caught) {
                    MaterialToast.fireToast("Error in switching!");
                }

                @Override
                public void onSuccess(WorkbookDTO result) {
                    try {
                        MaterialToast.fireToast("Workbook state switched successfully!");
                        refreshView();
                    } catch (IllegalArgumentException ex) {
                        Logger.getLogger(HomeView.class.getName()).log(Level.SEVERE, null, ex);
                    }
                }
            };
            workbooksSvc.changeState(state, wdto, callback);
            this.view.closeOptionModal();
        });

        this.view.deleteClickHandler(e -> {
            WorkbooksServiceAsync workbooksSvc = GWT.create(WorkbooksService.class);
            WorkbookDTO wdto = this.view.focusedWorkbookDTO();
            // Set up the callback object.
            AsyncCallback<WorkbookDTO> callback = new AsyncCallback<WorkbookDTO>() {
                @Override
                public void onFailure(Throwable caught) {
                    MaterialToast.fireToast("Workbook cannot be deleted!");
                }

                @Override
                public void onSuccess(WorkbookDTO result) {
                    try {
                        MaterialToast.fireToast("Workbook deleted successfully!");
                        refreshView();
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

        workbooksSvc.listWorkbooksPerUser(MenuView.getUsername().toString(), callback);
    }

    public void refreshViewAfterSearch(String workbookName) {
        WorkbooksServiceAsync workbooksSvc = GWT.create(WorkbooksService.class);

        // Set up the callback object.
        AsyncCallback<ArrayList<WorkbookDTO>> callback = new AsyncCallback<ArrayList<WorkbookDTO>>() {
            @Override
            public void onFailure(Throwable caught) {
                MaterialToast.fireToast("error in searching");
            }

            @Override
            public void onSuccess(ArrayList<WorkbookDTO> result) {
                view.setContents(result);
            }
        };

        workbooksSvc.searchWorkbooks(workbookName, callback);
    }

    @Override
    protected void onReveal() {
        super.onReveal();

        SetPageTitleEvent.fire("Home", "The most recent Workbooks", "", "", this);

        refreshView();
    }

    private void redirectToProfilePage(){
        String token = placeManager
                .getCurrentPlaceRequest()
                .getParameter(ParameterTokens.REDIRECT, NameTokens.profile);
        PlaceRequest placeRequest = new PlaceRequest.Builder().nameToken(token).build();

        placeManager.revealPlace(placeRequest);
    }

    private void redirectToLoginPage(){
        String token = placeManager
                .getCurrentPlaceRequest()
                .getParameter(ParameterTokens.REDIRECT, NameTokens.login);
        PlaceRequest placeRequest = new PlaceRequest.Builder().nameToken(token).build();


        placeManager.revealPlace(placeRequest);
    }

}
