package pt.isep.nsheets.client.lapr4.red.s2.ipc.n1161292.signup;

import com.google.gwt.event.dom.client.ClickHandler;
import com.google.gwt.uibinder.client.UiBinder;
import com.google.gwt.uibinder.client.UiField;
import com.google.gwt.user.client.ui.Widget;
import com.gwtplatform.mvp.client.ViewImpl;
import gwt.material.design.client.ui.MaterialButton;
import gwt.material.design.client.ui.MaterialTextBox;
import javax.inject.Inject;

/**
 *
 * @author Tiago João Santos Rios, 1161292@isep.ipp.pt
 */
public class SignupView extends ViewImpl implements SignupPresenter.MyView {
    
    interface Binder extends UiBinder<Widget, SignupView> {
    }
    
    @UiField
    MaterialTextBox username, password, name, email;
    
    @UiField
    MaterialButton submitBtn;
    
    @Inject
    SignupView(Binder uiBinder) {
        initWidget(uiBinder.createAndBindUi(this));		
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
}
