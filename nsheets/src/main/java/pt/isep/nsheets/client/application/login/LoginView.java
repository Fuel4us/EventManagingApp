package pt.isep.nsheets.client.application.login;


import com.google.gwt.event.dom.client.ClickHandler;
import com.google.gwt.uibinder.client.UiBinder;
import com.google.gwt.uibinder.client.UiField;
import com.google.gwt.user.client.ui.Widget;
import com.gwtplatform.mvp.client.ViewImpl;

import gwt.material.design.client.ui.MaterialButton;
import gwt.material.design.client.ui.MaterialTextBox;
import javax.inject.Inject;

class LoginView extends ViewImpl implements LoginPresenter.MyView {
    interface Binder extends UiBinder<Widget, LoginView> {
    }

    @UiField
    MaterialTextBox txtEmail;

    @UiField
    MaterialTextBox txtPassword;

    @UiField
    MaterialButton btnLogin;

    @Inject
    LoginView(Binder uiBinder) {
        initWidget(uiBinder.createAndBindUi(this));		
    }
    
    @Override
    public void addLoginHandler(ClickHandler ch) {
        btnLogin.addClickHandler(ch);
    }
    
    @Override
    public String getEmail() {
        return txtEmail.getText();
    }
    
    @Override
    public String getPassword() {
        return txtPassword.getText();
    }
}