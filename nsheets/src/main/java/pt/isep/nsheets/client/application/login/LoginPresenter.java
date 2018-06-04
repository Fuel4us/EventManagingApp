package pt.isep.nsheets.client.application.login;

import com.google.gwt.core.client.GWT;
import com.google.gwt.event.dom.client.ClickHandler;
import com.google.gwt.user.client.rpc.AsyncCallback;
import com.google.inject.Inject;
import com.google.web.bindery.event.shared.EventBus;
import com.gwtplatform.mvp.client.Presenter;
import com.gwtplatform.mvp.client.View;
import com.gwtplatform.mvp.client.annotations.ProxyStandard;
import com.gwtplatform.mvp.client.proxy.ProxyPlace;

import com.gwtplatform.mvp.client.annotations.NameToken;
import com.gwtplatform.mvp.client.annotations.NoGatekeeper;
import com.gwtplatform.mvp.client.proxy.PlaceManager;
import com.gwtplatform.mvp.shared.proxy.PlaceRequest;
import gwt.material.design.client.ui.MaterialToast;
import pt.isep.nsheets.client.application.ApplicationPresenter;
import pt.isep.nsheets.client.event.SetPageTitleEvent;
import pt.isep.nsheets.client.place.NameTokens;
import pt.isep.nsheets.client.place.ParameterTokens;
import pt.isep.nsheets.client.security.CurrentUser;
import pt.isep.nsheets.shared.services.UserDTO;
import pt.isep.nsheets.shared.services.UsersService;
import pt.isep.nsheets.shared.services.UsersServiceAsync;

public class LoginPresenter extends Presenter<LoginPresenter.MyView, LoginPresenter.MyProxy> {

    private MyView view;

    private final PlaceManager placeManager;

    interface MyView extends View {

        void addLoginHandler(ClickHandler ch);

        String getEmail();
        String getPassword();
    }

    @NameToken(NameTokens.login)
    @ProxyStandard
    @NoGatekeeper
    interface MyProxy extends ProxyPlace<LoginPresenter> {
    }

    @Inject
    LoginPresenter(EventBus eventBus, MyView view, MyProxy proxy, PlaceManager placeManager, CurrentUser currentUser) {
        super(eventBus, view, proxy, ApplicationPresenter.SLOT_CONTENT);

        this.placeManager = placeManager;
        this.view = view;

        this.view.addLoginHandler(event -> {
            String email = this.view.getEmail();
            String password = this.view.getPassword();

            UsersServiceAsync usersSvc = GWT.create(UsersService.class);

            // Set up the callback object.
            AsyncCallback<UserDTO> callback = new AsyncCallback<UserDTO>() {
                public void onFailure(Throwable caught) {
                    MaterialToast.fireToast("Error! " + caught.getMessage());
                }

                public void onSuccess(UserDTO result) {
                    if(result != null) {
                        currentUser.setLoggedIn(true);
                        currentUser.setUser(result);
                        
                        MaterialToast.fireToast("Successfuly Logged In", "rounded");
                        
                        redirectToHomePage();
                    } else
                        MaterialToast.fireToast("Failed to log in");

                    refreshView();
                }
            };

            usersSvc.attemptLogin(email, password, callback);
        });
    }

    private void refreshView() {
    }

    private void redirectToHomePage() {
        String token = placeManager
                .getCurrentPlaceRequest()
                .getParameter(ParameterTokens.REDIRECT, NameTokens.getHome());
        PlaceRequest placeRequest = new PlaceRequest.Builder().nameToken(token).build();

        placeManager.revealPlace(placeRequest);
    }

    @Override
    protected void onReveal() {
        super.onReveal();

        SetPageTitleEvent.fire("Login", "Login on NSheets", "", "", this);

        refreshView();
    }
}
