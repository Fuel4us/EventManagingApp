package pt.isep.nsheets.client.application.profile;

import com.google.gwt.core.client.GWT;
import com.google.gwt.event.dom.client.ClickHandler;
import com.google.gwt.user.client.rpc.AsyncCallback;
import com.google.inject.Inject;
import com.google.web.bindery.event.shared.EventBus;
import com.gwtplatform.mvp.client.Presenter;
import com.gwtplatform.mvp.client.View;
import com.gwtplatform.mvp.client.annotations.NameToken;
import com.gwtplatform.mvp.client.annotations.ProxyStandard;
import com.gwtplatform.mvp.client.proxy.PlaceManager;
import com.gwtplatform.mvp.client.proxy.ProxyPlace;
import gwt.material.design.client.ui.MaterialButton;
import gwt.material.design.client.ui.MaterialTextBox;
import gwt.material.design.client.ui.MaterialToast;
import pt.isep.nsheets.client.application.ApplicationPresenter;
import pt.isep.nsheets.client.event.SetPageTitleEvent;
import pt.isep.nsheets.client.lapr4.red.s2.ipc.n1161292.signup.SignupPresenter;
import pt.isep.nsheets.client.lapr4.red.s2.ipc.n1161292.signup.SignupView;
import pt.isep.nsheets.client.place.NameTokens;
import pt.isep.nsheets.client.security.CurrentUser;
import pt.isep.nsheets.server.lapr4.green.s1.core.n1160557.users.application.UserService;
import pt.isep.nsheets.shared.lapr4.red.s2.ipc.n1161292.services.SignupService;
import pt.isep.nsheets.shared.lapr4.red.s2.ipc.n1161292.services.SignupServiceAsync;
import pt.isep.nsheets.shared.services.UserDTO;
import pt.isep.nsheets.shared.services.UsersService;
import pt.isep.nsheets.shared.services.UsersServiceAsync;

public class ProfilePresenter extends Presenter<ProfilePresenter.MyView, ProfilePresenter.MyProxy> {

    private MyView view;

    interface MyView extends View {
        void editButtonClickHandler(ClickHandler ch);

        String username();
        String newpassword();
        String oldpassword();
        String email();
        String name();

        MaterialTextBox txtUsername();
        MaterialTextBox txtNewPassword();
        MaterialTextBox txtOldpassword();
        MaterialTextBox txtEmail();
        MaterialTextBox txtName();
    }

    @NameToken(NameTokens.profile)
    @ProxyStandard
    interface MyProxy extends ProxyPlace<ProfilePresenter> {
    }

    @Inject
    ProfilePresenter(EventBus eventBus, MyView view, MyProxy proxy) {
        super(eventBus, view, proxy, ApplicationPresenter.SLOT_CONTENT);



        /*this.view.editButtonClickHandler(e -> {
            UsersServiceAsync userService = GWT.create(UsersService.class);

            AsyncCallback<UserDTO> callback = new AsyncCallback<UserDTO>() {
                @Override
                public void onFailure(Throwable caught) {
                    MaterialToast.fireToast("Error when editing user.! " + caught.getMessage());
                }

                @Override
                public void onSuccess(UserDTO result) {
                    MaterialToast.fireToast("Profile edited with success! Welcome, " + result.getName());
                }
            };

            if(this.view.txtEmail().validate() && this.view.txtUsername().validate() &&
                    this.view.txtName().validate() && this.view.txtOldpassword().validate() && this.view.txtNewPassword().validate() && ProfileView.URL != null){
                UserDTO dto = new UserDTO(this.view.email(), this.view.name(), this.view.username(), this.view.newpassword(), ProfileView.URL, false);

                userService.editProfile(dto, callback);
            }
        });*/

        //submissionHandler();
    }

    @Override
    protected void onReveal() {
        super.onReveal();

        SetPageTitleEvent.fire("Profile", "Edit Profile ", "", "", this);
    }
/*
    public void submissionHandler() {
        this.view.submitButtonClickHandler(e -> {
            UsersServiceAsync userService = GWT.create(UserService.class);

            AsyncCallback<UserDTO> callback = new AsyncCallback<UserDTO>() {
                @Override
                public void onFailure(Throwable caught) {
                    MaterialToast.fireToast("Error when editing user.! " + caught.getMessage());
                }

                @Override
                public void onSuccess(UserDTO result) {
                    MaterialToast.fireToast("Profile edited with success! Welcome, " + result.getName());
                }
            };

            if(this.view.txtEmail().validate() && this.view.txtUsername().validate() &&
                    this.view.txtName().validate() && this.view.txtOldpassword().validate() && this.view.txtNewPassword().validate() && ProfileView.URL != null){
                UserDTO dto = new UserDTO(this.view.email(), this.view.name(), this.view.username(), this.view.newpassword(), ProfileView.URL, false);

                userService.editProfile(dto, callback);
            }
        });
    } */


}

