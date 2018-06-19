package pt.isep.nsheets.client.lapr4.red.s2.ipc.n1161292.signup;

import com.google.gwt.core.client.GWT;
import com.google.gwt.event.dom.client.ClickHandler;
import com.google.gwt.uibinder.client.UiBinder;
import com.google.gwt.uibinder.client.UiField;
import com.google.gwt.user.client.ui.Widget;
import com.gwtplatform.mvp.client.ViewImpl;
import gwt.material.design.addins.client.fileuploader.MaterialFileUploader;
import gwt.material.design.addins.client.fileuploader.base.UploadFile;
import gwt.material.design.addins.client.fileuploader.events.SuccessEvent;
import gwt.material.design.client.base.validator.RegExValidator;
import gwt.material.design.client.ui.MaterialButton;
import gwt.material.design.client.ui.MaterialTextBox;
import javax.inject.Inject;

/**
 *
 * @author Tiago João Santos Rios, 1161292@isep.ipp.pt
 */
public class SignupView extends ViewImpl implements SignupPresenter.MyView {
    
    protected static String URL = null;
    public static String MODULEBASEURL = GWT.getModuleBaseURL();
    
    interface Binder extends UiBinder<Widget, SignupView> {
    }
    
    @UiField
    MaterialTextBox username, password, name, email;
    
    @UiField
    MaterialButton submitBtn;
    
    @UiField
    MaterialFileUploader uploader;
    
    @Inject
    SignupView(Binder uiBinder) {
        initWidget(uiBinder.createAndBindUi(this));
        uploader.setUrl(GWT.getModuleBaseURL() + "uploadServlet");
        
        validateInput();
        
        uploader.addSuccessHandler(new SuccessEvent.SuccessHandler<UploadFile> (){ 
            @Override
            public void onSuccess(SuccessEvent<UploadFile> event) {
                URL = GWT.getHostPageBaseURL() + "uploadedFiles/" + event.getTarget().getName();
            }
        });
    }
    
    public void validateInput(){
        email.addValidator(new RegExValidator("^([a-zA-Z0-9_\\.\\-])+\\@(([a-zA-Z0-9\\-])+\\.)+([a-zA-Z0-9]{2,6})+$", "Email Address is not correct"));
        password.addValidator(new RegExValidator("^(?=.*[A-Z])(?=.*[0-9]).{6,}$", "Password doesn't fill the requirements"));
        username.addValidator(new RegExValidator("^.+$", "Username is empty"));
        name.addValidator(new RegExValidator("^.+$", "Name is empty"));
    }
    
    @Override
    public void submitButtonClickHandler(ClickHandler ch){
        submitBtn.addClickHandler(ch);
    }
    
    @Override
    public String username(){
        return this.username.getText();
    }
    
    @Override
    public String password(){
        return this.password.getText();
    }
    
    @Override
    public String email(){
        return this.email.getText();
    }
    
    @Override
    public String name(){
        return this.name.getText();
    }
    
    @Override
    public MaterialTextBox txtUsername() {
        return username;
    }

    @Override
    public MaterialTextBox txtPassword() {
        return password;
    }

    @Override
    public MaterialTextBox txtEmail() {
        return email;
    }

    @Override
    public MaterialTextBox txtName() {
        return name;
    }
    
    @Override
    public void clearFields() {
        this.email.clear();
        this.username.clear();
        this.name.clear();
        this.password.clear();
    }
}
