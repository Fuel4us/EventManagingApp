package pt.isep.nsheets.client.lapr4.red.s2.ipc.n1161292.signup;

import com.google.gwt.core.client.GWT;
import com.google.gwt.event.dom.client.ClickHandler;
import com.google.gwt.user.client.rpc.AsyncCallback;
import com.google.inject.Inject;
import com.google.web.bindery.event.shared.EventBus;
import com.gwtplatform.mvp.client.Presenter;
import com.gwtplatform.mvp.client.View;
import com.gwtplatform.mvp.client.annotations.NameToken;
import com.gwtplatform.mvp.client.annotations.NoGatekeeper;
import com.gwtplatform.mvp.client.annotations.ProxyStandard;
import com.gwtplatform.mvp.client.proxy.PlaceManager;
import com.gwtplatform.mvp.client.proxy.ProxyPlace;
import com.gwtplatform.mvp.shared.proxy.PlaceRequest;
import gwt.material.design.client.ui.MaterialTextBox;
import gwt.material.design.client.ui.MaterialToast;
import java.util.ArrayList;
import java.util.concurrent.TimeUnit;
import java.util.logging.Level;
import java.util.logging.Logger;
import pt.isep.nsheets.client.application.ApplicationPresenter;
import pt.isep.nsheets.client.event.SetPageTitleEvent;
import pt.isep.nsheets.client.place.NameTokens;
import pt.isep.nsheets.client.place.ParameterTokens;
import pt.isep.nsheets.shared.lapr4.red.s2.ipc.n1161292.services.SignupService;
import pt.isep.nsheets.shared.lapr4.red.s2.ipc.n1161292.services.SignupServiceAsync;
import pt.isep.nsheets.shared.services.UserDTO;

/**
 *
 * @author Tiago João Santos Rios, 1161292@isep.ipp.pt
 */
public class SignupPresenter extends Presenter<SignupPresenter.MyView, SignupPresenter.MyProxy> {

    private MyView view;
    private final PlaceManager placeManager;

    interface MyView extends View {
        void submitButtonClickHandler(ClickHandler ch);

        String username();
        String password();
        String email();
        String name();
        
        MaterialTextBox txtUsername();
        MaterialTextBox txtPassword();
        MaterialTextBox txtEmail();
        MaterialTextBox txtName();
        
        void clearFields();
    }

    @NameToken(NameTokens.SIGNUP)
    @ProxyStandard
    @NoGatekeeper
    interface MyProxy extends ProxyPlace<SignupPresenter> {
    }

    @Inject
    SignupPresenter(EventBus eventBus, SignupPresenter.MyView view, SignupPresenter.MyProxy proxy, PlaceManager placeManager) {
        super(eventBus, view, proxy, ApplicationPresenter.SLOT_CONTENT);
        this.view = view;
        this.placeManager = placeManager;

        createSubmitButtonHandler();
    }

    public void createSubmitButtonHandler() {
        this.view.submitButtonClickHandler(e -> {
            SignupServiceAsync signupSvc = GWT.create(SignupService.class);

            AsyncCallback<UserDTO> callback = new AsyncCallback<UserDTO>() {
                @Override
                public void onFailure(Throwable caught) {
                    MaterialToast.fireToast("Error when registering new user.! " + caught.getMessage());
                }

                @Override
                public void onSuccess(UserDTO result) {
                    MaterialToast.fireToast("Signup made with success! Welcome, " + result.getName());
                    SignupPresenter.this.view.clearFields();
                    redirectToLoginPage();
                }
            };
            
            boolean validation;
            
            validation = this.view.txtEmail().validate();
            validation = this.view.txtUsername().validate();
            validation = this.view.txtName().validate();
            validation = this.view.txtPassword().validate();
            
            if(validation){
                UserDTO dto = new UserDTO(this.view.email(), this.view.name(), this.view.username(), this.view.password(), false);

                signupSvc.signupUser(dto, callback);
            }
        });
    }
    
    private void redirectToLoginPage(){
        String token = placeManager
                .getCurrentPlaceRequest()
                .getParameter(ParameterTokens.REDIRECT, NameTokens.login);
        PlaceRequest placeRequest = new PlaceRequest.Builder().nameToken(token).build();

        placeManager.revealPlace(placeRequest);
    }
    
    @Override
    protected void onReveal() {
        super.onReveal();

        SetPageTitleEvent.fire("Signup", "Signup on NSheets", "", "", this);
    }
}
