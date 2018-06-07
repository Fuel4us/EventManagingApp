package pt.isep.nsheets.client.application.form;

import com.google.inject.Inject;
import com.google.web.bindery.event.shared.EventBus;
import com.gwtplatform.mvp.client.Presenter;
import com.gwtplatform.mvp.client.View;
import com.gwtplatform.mvp.client.annotations.NameToken;
import com.gwtplatform.mvp.client.annotations.ProxyStandard;
import com.gwtplatform.mvp.client.proxy.ProxyPlace;
import gwt.material.design.addins.client.window.MaterialWindow;
import pt.isep.nsheets.client.application.ApplicationPresenter;
import pt.isep.nsheets.client.event.SetPageTitleEvent;
import pt.isep.nsheets.client.place.NameTokens;

/**
 *
 * @author João Pereira <1150478@isep.ipp.pt>
 */
public class FormPresenter extends Presenter<FormPresenter.MyView, FormPresenter.MyProxy> {

    interface MyView extends View {
    }

    @NameToken(NameTokens.form)
    @ProxyStandard
    interface MyProxy extends ProxyPlace<FormPresenter> {
    }

    @Inject
    FormPresenter(EventBus eventBus, MyView view, MyProxy proxy) {
        super(eventBus, view, proxy, ApplicationPresenter.SLOT_CONTENT);
    }

    @Override
    protected void onReveal() {
        super.onReveal();

        SetPageTitleEvent.fire("Form", "Edit Form", "", "", this);
    }
}

