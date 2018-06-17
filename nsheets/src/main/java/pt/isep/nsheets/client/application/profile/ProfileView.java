package pt.isep.nsheets.client.application.profile;

import com.google.gwt.core.client.GWT;
import com.google.gwt.dom.client.Style;
import com.google.gwt.event.dom.client.ClickHandler;
import com.google.gwt.uibinder.client.UiBinder;
import com.google.gwt.uibinder.client.UiField;
import com.google.gwt.user.client.rpc.AsyncCallback;
import com.google.gwt.user.client.ui.Widget;
import com.gwtplatform.mvp.client.ViewImpl;
import gwt.material.design.addins.client.fileuploader.MaterialFileUploader;
import gwt.material.design.client.base.validator.RegExValidator;
import gwt.material.design.client.ui.*;
import pt.isep.nsheets.client.application.menu.MenuView;
import pt.isep.nsheets.client.security.CurrentUser;
import gwt.material.design.addins.client.fileuploader.base.UploadFile;
import gwt.material.design.addins.client.fileuploader.events.SuccessEvent;
import pt.isep.nsheets.server.lapr4.green.s1.core.n1160557.users.application.UserService;
import pt.isep.nsheets.shared.lapr4.red.s2.ipc.n1161292.services.SignupService;
import pt.isep.nsheets.shared.lapr4.red.s2.ipc.n1161292.services.SignupServiceAsync;
import pt.isep.nsheets.shared.services.UserDTO;
import pt.isep.nsheets.shared.services.UsersService;
import pt.isep.nsheets.shared.services.UsersServiceAsync;


import javax.inject.Inject;

class ProfileView extends ViewImpl implements ProfilePresenter.MyView {

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
    MaterialButton deleteBtn;
    @UiField
    MaterialFileUploader uploader;
    @UiField
    MaterialModal modal;

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
    ProfileView(Binder uiBinder, CurrentUser currentUser) {
        initWidget(uiBinder.createAndBindUi(this));


        uploader.setUrl(GWT.getModuleBaseURL() + "uploadServlet");

        validateInput();

        //submissionHandler();

        uploader.addSuccessHandler(new SuccessEvent.SuccessHandler<UploadFile> (){
            @Override
            public void onSuccess(SuccessEvent<UploadFile> event) {
                URL = GWT.getHostPageBaseURL() + "uploadedFiles/" + event.getTarget().getName();
            }
        });

        deleteBtn.addClickHandler(event ->{
                UsersServiceAsync userSvc = GWT.create(UsersService.class);
                AsyncCallback<UserDTO> callback = new AsyncCallback<UserDTO>() {
                    @Override
                    public void onFailure(Throwable caught) {
                        MaterialToast.fireToast("Error when deleting user.! " + caught.getMessage());
                    }

                    @Override
                    public void onSuccess(UserDTO result) {
                        MaterialToast.fireToast("User deleted!");
                        MenuView.getUsername().setText("Login");
                        currentUser.setLoggedIn(false);
                    }
                };

                userSvc.deleteUser(currentUser.getUser().getEmail(), callback);
        });


        editBtn.addClickHandler(e -> {
            UsersServiceAsync userSvc = GWT.create(UsersService.class);

            AsyncCallback<UserDTO> callback = new AsyncCallback<UserDTO>() {
                @Override
                public void onFailure(Throwable caught) {
                    MaterialToast.fireToast("Error when registering new user.! " + caught.getMessage());
                }

                @Override
                public void onSuccess(UserDTO result) {
                    MaterialToast.fireToast("Signup made with success! Welcome, " + result.getName());
                }
            };

            if(this.txtEmail().validate() && this.txtUsername().validate() &&
                    this.txtName().validate() && this.txtNewPassword().validate() && ProfileView.URL != null){
                UserDTO dto = new UserDTO(this.email(), this.name(), this.username(), this.newpassword(), ProfileView.URL, false);

                userSvc.editProfile(dto, callback);
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
            }
        });

        editUsernameBtn.addClickHandler(event -> {
            if(!username.isEnabled()){
                username.setEnabled(true);
            }else {
                username.setEnabled(false);
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
    }


    public void validateInput(){
        email.addValidator(new RegExValidator("^([a-zA-Z0-9_\\.\\-])+\\@(([a-zA-Z0-9\\-])+\\.)+([a-zA-Z0-9]{2,6})+$", "Email Address is not correct"));
        oldpassword.addValidator(new RegExValidator("^(?=.*[A-Z])(?=.*[0-9]).{6,}$", "Password doesn't fill the requirements"));
        newpassword.addValidator(new RegExValidator("^(?=.*[A-Z])(?=.*[0-9]).{6,}$", "Password doesn't fill the requirements"));
        username.addValidator(new RegExValidator("^.+$", "Username is empty"));
        name.addValidator(new RegExValidator("^.+$", "Name is empty"));
    }



}
