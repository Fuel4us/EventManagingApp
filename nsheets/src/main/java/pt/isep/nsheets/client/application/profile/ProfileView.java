package pt.isep.nsheets.client.application.profile;

import com.google.gwt.core.client.GWT;
import com.google.gwt.dom.client.Style;
import com.google.gwt.event.dom.client.ClickHandler;
import com.google.gwt.uibinder.client.UiBinder;
import com.google.gwt.uibinder.client.UiField;
import com.google.gwt.user.client.rpc.AsyncCallback;
import com.google.gwt.user.client.ui.Widget;
import com.gwtplatform.mvp.client.ViewImpl;
import com.gwtplatform.mvp.client.proxy.PlaceManager;
import com.gwtplatform.mvp.shared.proxy.PlaceRequest;
import eapli.framework.presentation.console.Menu;
import gwt.material.design.addins.client.fileuploader.MaterialFileUploader;
import gwt.material.design.client.base.validator.RegExValidator;
import gwt.material.design.client.constants.Color;
import gwt.material.design.client.ui.*;
import org.apache.commons.codec.digest.DigestUtils;
import org.apache.xpath.operations.Bool;
import pt.isep.nsheets.client.application.home.HomeModule;
import pt.isep.nsheets.client.application.menu.MenuView;
import pt.isep.nsheets.client.lapr4.red.s2.ipc.n1161292.signup.SignupModule;
import pt.isep.nsheets.client.lapr4.red.s2.ipc.n1161292.signup.SignupView;
import pt.isep.nsheets.client.place.NameTokens;
import pt.isep.nsheets.client.place.ParameterTokens;
import pt.isep.nsheets.client.security.CurrentUser;
import gwt.material.design.addins.client.fileuploader.base.UploadFile;
import gwt.material.design.addins.client.fileuploader.events.SuccessEvent;
import pt.isep.nsheets.server.lapr4.green.s1.core.n1160557.users.application.UserService;
import pt.isep.nsheets.server.lapr4.green.s1.core.n1160557.users.domain.User;
import pt.isep.nsheets.shared.lapr4.red.s2.ipc.n1161292.services.SignupService;
import pt.isep.nsheets.shared.lapr4.red.s2.ipc.n1161292.services.SignupServiceAsync;
import pt.isep.nsheets.shared.services.UserDTO;
import pt.isep.nsheets.shared.services.UsersService;
import pt.isep.nsheets.shared.services.UsersServiceAsync;


import javax.inject.Inject;
import java.util.ArrayList;

class ProfileView extends ViewImpl implements ProfilePresenter.MyView {
    private final PlaceManager placeManager;

    protected static String URL = null;
    @UiField
    MaterialImage image;
    @UiField
    MaterialButton editImageBtn;
    @UiField
    MaterialTextBox username;
    @UiField
    MaterialTextBox name;
    @UiField
    MaterialButton editNameBtn;
    @UiField
    MaterialTextBox email;
    @UiField
    MaterialButton editUsernameBtn;
    @UiField
    MaterialButton editPasswordBtn;
    @UiField
    MaterialTextBox oldpassword;
    @UiField
    MaterialTextBox newpassword;
    @UiField
    MaterialButton editBtn;
    @UiField
    MaterialButton deleteBtn;@UiField
    MaterialIcon userinfoBTN;
    @UiField
    MaterialImage userImage;
    @UiField
    MaterialTextBox userEmail;
    @UiField
    MaterialTextBox userName;
    @UiField
    MaterialTextBox userUsername;
    @UiField
    MaterialIcon closeUserProfileModalBTN;
    @UiField
    MaterialButton usersBtn;
    @UiField
    MaterialFileUploader uploader;
    @UiField
    MaterialModal modal;
    @UiField
    MaterialModal usersModal;
    @UiField
    MaterialLabel userState;
    @UiField
    MaterialListValueBox<UserDTO> usersList;
    @UiField
    MaterialIcon activateModalBTN;
    @UiField
    MaterialIcon deactivateModalBTN;
    @UiField
    MaterialIcon closeModalBTN;
    @UiField
    MaterialIcon deleteUserUserProfileModalBTN;
    @UiField
    MaterialModal userProfileModal;




    @Override
    public void editButtonClickHandler(ClickHandler ch) {
        editBtn.addClickHandler(ch);
    }

    @Override
    public String username() {
        return username.getText();
    }

    @Override
    public String newpassword() {
        return newpassword.getText();
    }

    @Override
    public String oldpassword() {
        return oldpassword.getText();
    }

    @Override
    public String email() {
        return email.getText();
    }

    @Override
    public String name() {
        return name.getText();
    }

    @Override
    public MaterialTextBox txtUsername() {
        return this.username;
    }

    @Override
    public MaterialTextBox txtNewPassword() {
        return this.newpassword;
    }

    @Override
    public MaterialTextBox txtOldpassword() {
        return this.oldpassword;
    }

    @Override
    public MaterialTextBox txtEmail() {
        return this.email;
    }

    @Override
    public MaterialTextBox txtName() {
        return this.name;
    }

    interface Binder extends UiBinder<Widget, ProfileView> {
    }

    @Inject
    ProfileView(Binder uiBinder, CurrentUser currentUser, PlaceManager placeManager) {
        initWidget(uiBinder.createAndBindUi(this));
        this.placeManager = placeManager;

        uploader.setUrl(GWT.getModuleBaseURL() + "uploadServlet");

        validateInput();

        uploader.addSuccessHandler(new SuccessEvent.SuccessHandler<UploadFile> (){
            @Override
            public void onSuccess(SuccessEvent<UploadFile> event) {
                URL = GWT.getHostPageBaseURL() + "uploadedFiles/" + event.getTarget().getName();
                image.setUrl(URL);
                changeUserProfile(currentUser.getUser().getEmail(), currentUser.getUser().getName(), currentUser.getUser().getNickname(), ProfileView.URL, currentUser);
            }
        });

        usersBtn.addClickHandler(event->{
            if(currentUser.getUser().isSuperuser()) {
                usersList.clear();
                UsersServiceAsync userSvc = GWT.create(UsersService.class);
                AsyncCallback<ArrayList<UserDTO>> callback = new AsyncCallback<ArrayList<UserDTO>>() {
                    @Override
                    public void onFailure(Throwable caught) {
                        MaterialToast.fireToast("Error getting users! " + caught.getMessage());
                    }

                    @Override
                    public void onSuccess(ArrayList<UserDTO> result) {
                        for (UserDTO u : result) {
                            usersList.addItem(u, u.getEmail());
                        }

                        userState.setText("state");
                        userState.setBackgroundColor(Color.BLUE_GREY_DARKEN_4);
                    }
                };

                userSvc.getUsers(callback);

                usersModal.open();
            }
        });

        usersList.addValueChangeHandler(event->{
            if(usersList.getSelectedValue().isActivate()){
                userState.setText("enable");
                userState.setBackgroundColor(Color.GREEN);
            }else{
                userState.setText("disable");
                userState.setBackgroundColor(Color.RED);
            }
        });

        activateModalBTN.addClickHandler(clickEvent -> {
            UserDTO u = usersList.getSelectedValue();
            u.setState(true);
            changeState(u, currentUser);
        });

        deactivateModalBTN.addClickHandler(event->{
            UserDTO u = usersList.getSelectedValue();
            u.setState(false);
            changeState(u, currentUser);
        });

        closeModalBTN.addClickHandler(event->{
            usersList.clear();
            usersModal.close();
        });


        deleteBtn.addClickHandler(event ->{
                UsersServiceAsync userSvc = GWT.create(UsersService.class);
                AsyncCallback<Boolean> callback = new AsyncCallback<Boolean>() {
                    @Override
                    public void onFailure(Throwable caught) {
                        MaterialToast.fireToast("Error when deleting user.! " + caught.getMessage());
                    }

                    @Override
                    public void onSuccess(Boolean result) {
                        MaterialToast.fireToast("User deleted!");
                        MenuView.getImage().setVisible(false);
                        MenuView.getUsername().setText("Login");
                        MenuView.getLogout().setText("Signup");
                        currentUser.setLoggedIn(false);
                        redirectToLoginPage();
                    }
                };

                userSvc.deleteUser(currentUser.getUser().getEmail(), callback);
        });
        MenuView.getUsername().addClickHandler(event->{
            if(currentUser.isLoggedIn()){
                clearfields();
                image.setUrl(currentUser.getUser().getPictureName());

                username.setText(currentUser.getUser().getNickname());

                name.setText(currentUser.getUser().getName());

                email.setText(currentUser.getUser().getEmail());

                oldpassword.setEnabled(false);
                oldpassword.setVisibility(Style.Visibility.HIDDEN);
                newpassword.setEnabled(false);
                newpassword.setVisibility(Style.Visibility.HIDDEN);
            }
        });

        MenuView.getLogout().addClickHandler(event ->{
                clearfields();
                currentUser.setLoggedIn(false);

            oldpassword.setEnabled(false);
            oldpassword.setVisibility(Style.Visibility.HIDDEN);
            newpassword.setEnabled(false);
            newpassword.setVisibility(Style.Visibility.HIDDEN);
        });


        editBtn.addClickHandler(e -> {
            if(oldpassword.isEnabled() && newpassword.isEnabled() && txtNewPassword().validate()){
                this.changePassword(currentUser, txtOldpassword().getText(), txtNewPassword().getText());
            }

            if(username.isEnabled() || name.isEnabled()){
                if(this.txtEmail().validate() && this.txtUsername().validate() && this.txtName().validate()){
                    if(ProfileView.URL == null){
                        ProfileView.URL = currentUser.getUser().getPictureName();
                    }
                    this.changeUserProfile(txtEmail().getText(), txtName().getText(), txtUsername().getText(), ProfileView.URL, currentUser);
                }
            }
        });


        image.setUrl(currentUser.getUser().getPictureName());

        username.setText(currentUser.getUser().getNickname());

        name.setText(currentUser.getUser().getName());

        email.setText(currentUser.getUser().getEmail());

        editImageBtn.addClickHandler(event -> {
            modal.open();
        });

        editNameBtn.addClickHandler(event -> {
            if(!name.isEnabled()){
                name.setEnabled(true);
            }else {
                name.setEnabled(false);
                name.setText(currentUser.getUser().getName());
            }
        });

        editUsernameBtn.addClickHandler(event -> {
            if(!username.isEnabled()){
                username.setEnabled(true);
            }else {
                username.setEnabled(false);
                username.setText(currentUser.getUser().getNickname());
            }
        });

        editPasswordBtn.addClickHandler(event -> {
            if(!oldpassword.isEnabled()){
                oldpassword.setEnabled(true);
                oldpassword.setVisibility(Style.Visibility.VISIBLE);
                newpassword.setEnabled(true);
                newpassword.setVisibility(Style.Visibility.VISIBLE);
            }else {
                oldpassword.setEnabled(false);
                oldpassword.setVisibility(Style.Visibility.HIDDEN);
                newpassword.setEnabled(false);
                newpassword.setVisibility(Style.Visibility.HIDDEN);
            }
        });

        userinfoBTN.addClickHandler(event->{
            if(usersList.getItemCount()>0){
                userProfileModal.open();
                userImage.setUrl(usersList.getSelectedValue().getPictureName());
                userEmail.setText(usersList.getSelectedValue().getEmail());
                userName.setText(usersList.getSelectedValue().getName());
                userUsername.setText(usersList.getSelectedValue().getNickname());
            }
        });

        closeUserProfileModalBTN.addClickHandler(clickEvent -> {
            userProfileModal.close();
        });

        deleteUserUserProfileModalBTN.addClickHandler(event->{
            UserDTO u = usersList.getSelectedValue();

            if(u.getEmail().equals(currentUser.getUser().getEmail())){
                MaterialToast.fireToast("Can't delete currentUser here");
            }else{
                UsersServiceAsync userSvc = GWT.create(UsersService.class);
                AsyncCallback<Boolean> callback = new AsyncCallback<Boolean>() {
                    @Override
                    public void onFailure(Throwable caught) {
                        MaterialToast.fireToast("Error when deleting user.! " + caught.getMessage());
                    }

                    @Override
                    public void onSuccess(Boolean result) {
                        MaterialToast.fireToast("User deleted!");
                    }
                };

                userSvc.deleteUser(u.getEmail(), callback);

                userProfileModal.close();
                usersList.removeValue(u);
            }
        });
    }


    public void validateInput(){
        email.addValidator(new RegExValidator("^([a-zA-Z0-9_\\.\\-])+\\@(([a-zA-Z0-9\\-])+\\.)+([a-zA-Z0-9]{2,6})+$", "Email Address is not correct"));
        oldpassword.addValidator(new RegExValidator("^(?=.*[A-Z])(?=.*[0-9]).{6,}$", "Password doesn't fill the requirements"));
        newpassword.addValidator(new RegExValidator("^(?=.*[A-Z])(?=.*[0-9]).{6,}$", "Password doesn't fill the requirements"));
        username.addValidator(new RegExValidator("^.+$", "Username is empty"));
        name.addValidator(new RegExValidator("^.+$", "Name is empty"));
    }

    public void clearfields(){
        email.clear();
        name.clear();;
        newpassword.clear();
        oldpassword.clear();
        username.clear();
    }
    public void updatefields(CurrentUser c){
        email.setText(c.getUser().getEmail());
        name.setText(c.getUser().getName());
        newpassword.clear();
        oldpassword.clear();
        username.setText(c.getUser().getNickname());
        MenuView.getUsername().setText("Welcome, "+ c.getUser().getNickname());
    }

    private void redirectToLoginPage(){
        String token = placeManager
                .getCurrentPlaceRequest()
                .getParameter(ParameterTokens.REDIRECT, NameTokens.login);
        PlaceRequest placeRequest = new PlaceRequest.Builder().nameToken(token).build();


        placeManager.revealPlace(placeRequest);
    }

    private void changeState(UserDTO userDTO, CurrentUser currentUser){
        UsersServiceAsync userSvc = GWT.create(UsersService.class);

        AsyncCallback<Boolean> callback = new AsyncCallback<Boolean>() {
            @Override
            public void onFailure(Throwable caught) {
                MaterialToast.fireToast("Error editing user state! " + caught.getMessage());
            }

            @Override
            public void onSuccess(Boolean result) {
                String s = "disable";

                if(result){
                    s = "enable";
                    userState.setText(s);
                    userState.setBackgroundColor(Color.GREEN);
                }else{
                    userState.setText(s);
                    userState.setBackgroundColor(Color.RED);
                }
                MaterialToast.fireToast("User state changed to "+ s);
            }
        };
        userSvc.changeState(userDTO.getEmail(), userDTO.isActivate(), currentUser.getUser().getEmail(), currentUser.getUser().getPassword(),callback);
    }

    private void changePassword(CurrentUser currentUser, String oldPassword, String newPassword){
        UsersServiceAsync userSvc = GWT.create(UsersService.class);

        AsyncCallback<UserDTO> callback = new AsyncCallback<UserDTO>() {
            @Override
            public void onFailure(Throwable caught) {
                MaterialToast.fireToast("Error changing user password! " + caught.getMessage());
            }

            @Override
            public void onSuccess(UserDTO result) {
                try{
                    if(result.getEmail().equals(currentUser.getUser().getEmail())){
                        currentUser.setUser(result);
                        MaterialToast.fireToast("Password changed with success");
                    }
                }catch (Exception e){
                    MaterialToast.fireToast("Current Password doesn't match");
                }
            }
        };
        userSvc.changePassword(currentUser.getUser().getEmail(), oldPassword, newPassword,callback);

        newpassword.clear();
        oldpassword.clear();
        newpassword.setVisibility(Style.Visibility.HIDDEN);
        newpassword.setEnabled(false);
        oldpassword.setVisibility(Style.Visibility.HIDDEN);
        oldpassword.setEnabled(false);
    }

    private void changeUserProfile(String email, String name, String nickname, String pictureName, CurrentUser currentUser){
        UsersServiceAsync userSvc = GWT.create(UsersService.class);

        AsyncCallback<UserDTO> callback = new AsyncCallback<UserDTO>() {
            @Override
            public void onFailure(Throwable caught) {
                MaterialToast.fireToast("Error editing user! " + caught.getMessage());
            }

            @Override
            public void onSuccess(UserDTO result) {

                if(result != null && currentUser.getUser().getEmail().equals(result.getEmail())){
                    currentUser.setUser(result);
                    MaterialToast.fireToast("Changes applied with success");
                    MenuView.getImage().setUrl(result.getPictureName());
                    MenuView.getImage().setBorder("2px solid #186AAB");
                    updatefields(currentUser);
                }
            }
        };
        userSvc.editUser(email, name, nickname, pictureName, callback);
    }


}
