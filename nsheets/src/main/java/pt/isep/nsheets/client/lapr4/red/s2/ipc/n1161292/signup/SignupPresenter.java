package pt.isep.nsheets.client.lapr4.red.s2.ipc.n1161292.signup;

import com.google.gwt.event.dom.client.ClickHandler;
import com.google.inject.Inject;
import com.google.web.bindery.event.shared.EventBus;
import com.gwtplatform.mvp.client.Presenter;
import com.gwtplatform.mvp.client.View;
import com.gwtplatform.mvp.client.annotations.NameToken;
import com.gwtplatform.mvp.client.annotations.NoGatekeeper;
import com.gwtplatform.mvp.client.annotations.ProxyStandard;
import com.gwtplatform.mvp.client.proxy.PlaceManager;
import com.gwtplatform.mvp.client.proxy.ProxyPlace;
import gwt.material.design.client.ui.MaterialToast;
import pt.isep.nsheets.client.application.ApplicationPresenter;
import pt.isep.nsheets.client.event.SetPageTitleEvent;
import pt.isep.nsheets.client.place.NameTokens;

/**
 *
 * @author Tiago João Santos Rios, 1161292@isep.ipp.pt
 */
public class SignupPresenter extends Presenter<SignupPresenter.MyView, SignupPresenter.MyProxy>{
    
    private MyView view;
    
    interface MyView extends View {
        void submitButtonClickHandler(ClickHandler ch);
        
        String username();
        String password();
        String email();
        String name();
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
        
        createSubmitButtonHandler();
    }
    
    public void createSubmitButtonHandler(){
        this.view.submitButtonClickHandler(e -> {
            if(this.view.username().trim().isEmpty() || this.view.name().trim().isEmpty() || 
                    this.view.password().trim().isEmpty() || this.view.email().trim().isEmpty())
                MaterialToast.fireToast("All data is required! Please fill the form.");
            else {
//                MaterialToast.fireToast("CHEGUEI AQUI FILHOS!");
                
            }
        });
    }
    
    @Override
    protected void onReveal() {
        super.onReveal();

        SetPageTitleEvent.fire("Signup", "Signup on NSheets", "", "", this);
    }
}
