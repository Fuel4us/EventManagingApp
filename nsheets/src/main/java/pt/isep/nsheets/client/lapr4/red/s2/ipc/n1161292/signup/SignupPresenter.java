package pt.isep.nsheets.client.lapr4.red.s2.ipc.n1161292.signup;

import com.google.inject.Inject;
import com.google.web.bindery.event.shared.EventBus;
import com.gwtplatform.mvp.client.Presenter;
import com.gwtplatform.mvp.client.View;
import com.gwtplatform.mvp.client.annotations.NameToken;
import com.gwtplatform.mvp.client.proxy.PlaceManager;
import com.gwtplatform.mvp.client.proxy.ProxyPlace;
import pt.isep.nsheets.client.application.ApplicationPresenter;
import pt.isep.nsheets.client.event.SetPageTitleEvent;
import pt.isep.nsheets.client.place.NameTokens;

/**
 *
 * @author Tiago João Santos Rios, 1161292@isep.ipp.pt
 */
public class SignupPresenter extends Presenter<SignupPresenter.MyView, SignupPresenter.MyProxy>{
    
    interface MyView extends View {
    }
    
    @NameToken(NameTokens.SIGNUP)
    interface MyProxy extends ProxyPlace<SignupPresenter> {
    }
    
    @Inject
    SignupPresenter(EventBus eventBus, SignupPresenter.MyView view, SignupPresenter.MyProxy proxy, PlaceManager placeManager) {
        super(eventBus, view, proxy, ApplicationPresenter.SLOT_CONTENT);
    }
    
    
    @Override
    protected void onReveal() {
        super.onReveal();

        SetPageTitleEvent.fire("Signup", "Signup on NSheets", "", "", this);
    }
}
